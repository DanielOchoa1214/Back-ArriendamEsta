package com.eci.ariendamesta.service.impl;

import com.eci.ariendamesta.exceptions.AppExceptions;
import com.eci.ariendamesta.exceptions.EstateException;
import com.eci.ariendamesta.exceptions.ReviewException;
import com.eci.ariendamesta.model.estate.Estate;
import com.eci.ariendamesta.model.Review;
import com.eci.ariendamesta.model.dtos.ReviewDTO;
import com.eci.ariendamesta.model.estate.EstateDto;
import com.eci.ariendamesta.model.landlord.Landlord;
import com.eci.ariendamesta.model.tenant.Tenant;
import com.eci.ariendamesta.repository.LandlordRepositoryInterface;
import com.eci.ariendamesta.repository.TenantRepositoryInterface;
import com.eci.ariendamesta.service.EstateServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EstateServices implements EstateServiceInterface {

    private final LandlordRepositoryInterface landlordRepository;
    private final TenantRepositoryInterface tenantRepository;

    public EstateServices(@Autowired LandlordRepositoryInterface landlordRepository,
                          @Autowired TenantRepositoryInterface tenantRepository) {
        this.landlordRepository = landlordRepository;
        this.tenantRepository = tenantRepository;
    }


    @Override
    public Estate getEstate(String idEstate, Landlord landlord) throws AppExceptions {
        Optional<Estate> estate = landlord.getEstate(idEstate);
        if (estate.isPresent()) {
            return estate.get();
        }
        throw new EstateException(EstateException.NOT_FOUND);
    }

    @Override
    public Estate createEstate(Estate newEstate, Landlord landlord) throws AppExceptions {
        Optional<Estate> estateOptional = landlord.getEstate(newEstate.getId());
        if (estateOptional.isEmpty()) {
            Estate estate = landlord.addEstate(newEstate);
            landlordRepository.save(landlord);
            return estate;
        }
        throw new EstateException(EstateException.NOT_CREATED);
    }

    @Override
    public Estate updateEstate(String idEstate, EstateDto estateDto, Landlord landlord) throws AppExceptions {
        Optional<Estate> estateOptional = landlord.getEstate(idEstate);
        if (estateOptional.isPresent()) {
            Estate estate = estateOptional.get();
            estate.update(estateDto);
            landlord.addEstate(estate);
            landlordRepository.save(landlord);
            return estate;
        }
        throw new EstateException(EstateException.NOT_UPDATED);
    }

    @Override
    public void deleteEstate(String estateId, Landlord landlord) throws AppExceptions {
        Optional<Estate> estateOptional = landlord.getEstate(estateId);
        if (estateOptional.isPresent()) {
            landlord.deleteEstate(estateOptional.get());
            landlordRepository.save(landlord);
        } else {
            throw new EstateException(EstateException.NOT_DELETED);
        }
    }

    @Override
    public Optional<Review> postReview(ReviewDTO reviewDTO, Landlord landlord, String estateId) throws AppExceptions {
        Estate estate = getEstate(estateId, landlord);
        System.out.println(reviewDTO.getContent());
        Optional<Tenant> reviewer = tenantRepository.findById(reviewDTO.getAuthorId());
            if (reviewer.isPresent()) {
                Review review = new Review(reviewDTO, reviewer.get());
                estate.addReview(review);
                landlord.addEstate(estate);
                landlordRepository.save(landlord);
                return Optional.of(review);
            }
        throw new ReviewException(ReviewException.NOT_CREATED);
    }

    @Override
    public Optional<Review> getReview(String reviewId, Landlord landlord, String estateId) throws AppExceptions {
        Estate estate = getEstate(estateId, landlord);
        Optional<Review> review = estate.getReview(reviewId);
        if (review.isPresent()) {
            return review;
        }
        throw new ReviewException(ReviewException.NOT_FOUND);
    }
}