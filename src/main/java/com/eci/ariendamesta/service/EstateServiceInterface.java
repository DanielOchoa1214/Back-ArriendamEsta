package com.eci.ariendamesta.service;

import com.eci.ariendamesta.model.Review;
import com.eci.ariendamesta.model.dtos.ReviewDTO;

import java.util.Optional;


import com.eci.ariendamesta.model.Estate;

public interface EstateServiceInterface {
    Estate getEstate(String idEstate);

    void createEstate(Estate estate);

    Estate update(String idEstate, Estate estate);

    void delete(String idEstate);
    Optional<Review> postReview(ReviewDTO reviewDTO, String landlordId, String estateId);
    Optional<Review> getReview(String reviewId, String landlordId, String estateId);
}
