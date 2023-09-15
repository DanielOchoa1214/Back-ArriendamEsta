package com.eci.ariendamesta.service;

import com.eci.ariendamesta.model.Review;
import com.eci.ariendamesta.model.dtos.ReviewDTO;

import java.util.Optional;

public interface EstateServiceInterface {
    Optional<Review> postReview(ReviewDTO reviewDTO, String landlordId, String estateId);
    Optional<Review> getReview(String reviewId, String landlordId, String estateId);
}
