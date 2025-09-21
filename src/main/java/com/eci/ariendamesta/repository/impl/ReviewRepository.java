package com.eci.ariendamesta.repository.impl;

import com.eci.ariendamesta.model.Review;
import com.eci.ariendamesta.repository.repointerfaces.ReviewRepositoryInterface;
import com.eci.ariendamesta.repository.mongorepo.ReviewMongoRepositoryInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Repository
public class ReviewRepository implements ReviewRepositoryInterface {

    private final ReviewMongoRepositoryInterface mongo;

    public ReviewRepository(@Autowired ReviewMongoRepositoryInterface mongo) {
        this.mongo = mongo;
    }

    @Override
    public Review save(Review review) {
        return mongo.save(review);
    }

    @Override
    public Optional<Review> findById(String reviewId) {
        return mongo.findById(reviewId);
    }
    @Override
    public void delete(Review review) {
        mongo.delete(review);
    }

    @Override
    public List<Review> getReviewsByUser(String userid) {
        List<Review> reviewList = mongo.findAll();
        reviewList.removeIf(review -> !Objects.equals(review.getTargetId(), userid));
        return reviewList;
    }

    @Override
    public List<Review> getReviewsByProperty(String propertyId) {
        List<Review> reviewList = mongo.findAll();
        reviewList.removeIf(review -> !Objects.equals(review.getTargetId(), propertyId));
        return reviewList;
    }


}
