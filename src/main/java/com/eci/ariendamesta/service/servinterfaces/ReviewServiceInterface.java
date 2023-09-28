package com.eci.ariendamesta.service.servinterfaces;

import com.eci.ariendamesta.exceptions.AppExceptions;
import com.eci.ariendamesta.model.Review;
import com.eci.ariendamesta.model.dtos.ReviewDTO;

import java.util.ArrayList;

public interface ReviewServiceInterface {

    Review createReview(ReviewDTO reviewDTO) throws AppExceptions;
    Review getReview(String reviewId) throws AppExceptions;
    Review updateReview(String reviewId, ReviewDTO reviewDTO) throws AppExceptions;
    void deleteReview(String reviewId) throws AppExceptions;
    ArrayList<Review> getReviewsByUser(String userId) throws AppExceptions;
}
