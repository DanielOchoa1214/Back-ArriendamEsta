package com.eci.ariendamesta.service.impl;

import com.eci.ariendamesta.model.Estate;
import com.eci.ariendamesta.model.Landlord;
import com.eci.ariendamesta.model.Review;
import com.eci.ariendamesta.model.Tenant;
import com.eci.ariendamesta.model.dtos.ReviewDTO;
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

    public EstateServices(@Autowired LandlordRepositoryInterface landlordRepository, @Autowired TenantRepositoryInterface tenantRepository) {
        this.landlordRepository = landlordRepository;
        this.tenantRepository = tenantRepository;
    }

    @Override
    public Optional<Review> postReview(ReviewDTO reviewDTO, String landlordId, String estateId) {
        Optional<Landlord> landlord = landlordRepository.get(landlordId);
        if (landlord.isPresent()){
            Optional<Estate> estate = landlord.get().getEstate(estateId);
            if (estate.isPresent()){
                Optional<Tenant> reviewer = tenantRepository.get(reviewDTO.getAuthorId());
                if(reviewer.isPresent()){
                    Review review = new Review(reviewDTO, reviewer.get());
                    estate.get().addReview(review);
                    return Optional.of(review);
                }
            }
        }
        return Optional.empty();
    }

    @Override
    public Optional<Review> getReview(String reviewId, String landlordId, String estateId) {
        Optional<Landlord> landlord = landlordRepository.get(landlordId);
        if (landlord.isPresent()){
            Optional<Estate> estate = landlord.get().getEstate(estateId);
            if (estate.isPresent()){
                Optional<Review> review = estate.get().getReview(reviewId);
                if(review.isPresent()){
                    return review;
                }
            }
        }
        return Optional.empty();
    }
}
