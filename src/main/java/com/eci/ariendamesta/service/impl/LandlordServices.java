package com.eci.ariendamesta.service.impl;

import com.eci.ariendamesta.exceptions.AppExceptions;
import com.eci.ariendamesta.exceptions.ReviewException;
import com.eci.ariendamesta.exceptions.UserException;
import com.eci.ariendamesta.model.Review;
import com.eci.ariendamesta.model.dtos.ReviewDTO;
import com.eci.ariendamesta.model.landlord.Landlord;
import com.eci.ariendamesta.model.landlord.LandlordDto;
import com.eci.ariendamesta.model.tenant.Tenant;
import com.eci.ariendamesta.repository.LandlordRepositoryInterface;
import com.eci.ariendamesta.repository.TenantRepositoryInterface;
import com.eci.ariendamesta.repository.mongorepo.TenantMongoRepositoryInterface;
import com.eci.ariendamesta.service.LandlordServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LandlordServices implements LandlordServiceInterface {

    LandlordRepositoryInterface landlordRepository;
    TenantRepositoryInterface tenantRepository;

    public LandlordServices(@Autowired LandlordRepositoryInterface landlordRepository) {
        this.landlordRepository = landlordRepository;
    }

    @Override
    public Landlord foundById(String idLandlord) throws AppExceptions {
        Optional<Landlord> landlord = landlordRepository.findById(idLandlord);
        if (landlord.isPresent()) {
            return landlord.get();
        }
        throw new UserException(UserException.NOT_FOUND);
    }


    @Override
    public Landlord createLandlord(Landlord landlord) throws AppExceptions {
        if(landlordRepository.findById(landlord.getId()).isEmpty()) {
            landlordRepository.save(landlord);
            return foundById(landlord.getId());
        }
        throw new UserException(UserException.NOT_CREATED);
    }

    @Override
    public Landlord updateLandlord(String idLandlord, LandlordDto landlordBody) throws AppExceptions {
        Landlord landlord = foundById(idLandlord);
        try {
            landlord.update(landlordBody);
            landlordRepository.save(landlord);
            return foundById(idLandlord);
        } catch (Exception e) {
            throw new UserException(UserException.NOT_UPDATED);
        }
    }

    @Override
    public void deleteLandlord(String idLandlord) throws AppExceptions {
        Landlord landlord = foundById(idLandlord);
        try {
            landlordRepository.deleteEntity(landlord);
        } catch (Exception e) {
            throw new UserException(UserException.NOT_DELETED);
        }
    }

    @Override
    public Optional<Review> getReview(String landlordId, String reviewId) throws AppExceptions {
        try{
            Landlord landlord = foundById(landlordId);
            Optional<Review> review = landlord.getReview(reviewId);
            return review;
        } catch (Exception e){
            throw new ReviewException(ReviewException.NOT_FOUND);
        }
    }

    @Override
    public Optional<Review> postReview(ReviewDTO reviewDTO, String landlordId) throws AppExceptions {
        Landlord landlord = foundById(landlordId);
        Optional<Tenant> tenant = tenantRepository.findById(reviewDTO.getAuthorId());
        if (tenant.isPresent()){
            Review review = new Review(reviewDTO, tenant.get());
            landlord.addReview(review);
            landlordRepository.save(landlord);
            return Optional.of(review);
        }
        throw new ReviewException(ReviewException.NOT_CREATED);
    }

}
