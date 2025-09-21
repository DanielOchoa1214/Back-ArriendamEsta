package com.eci.ariendamesta.service.servinterfaces;

import com.eci.ariendamesta.exceptions.AppExceptions;
import com.eci.ariendamesta.model.Review;
import com.eci.ariendamesta.model.dtos.ReviewDTO;

import java.util.ArrayList;
import java.util.List;

public interface ReviewServiceInterface {

    Review createReview(ReviewDTO reviewDTO) throws AppExceptions;
    Review getReview(String reviewId) throws AppExceptions;
    Review updateReview(String reviewId, ReviewDTO reviewDTO) throws AppExceptions;
    void deleteReview(String reviewId) throws AppExceptions;
    List<Review> getReviewsByUser(String userId) throws AppExceptions;
    List<Review> getReviewsByProperty(String propertyId) throws AppExceptions;
}
