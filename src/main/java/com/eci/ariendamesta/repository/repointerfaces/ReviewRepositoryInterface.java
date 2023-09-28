package com.eci.ariendamesta.repository.repointerfaces;

import com.eci.ariendamesta.model.Review;

import java.util.ArrayList;
import java.util.Optional;

public interface ReviewRepositoryInterface {
    Review save(Review review);
    Optional<Review> findById(String reviewId);
    void delete(Review review);

    ArrayList<Review> getReviewsByUser(String userid);
}
