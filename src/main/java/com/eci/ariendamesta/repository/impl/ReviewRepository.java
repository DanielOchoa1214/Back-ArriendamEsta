package com.eci.ariendamesta.repository.impl;

import com.eci.ariendamesta.model.Review;
import com.eci.ariendamesta.repository.repointerfaces.ReviewRepositoryInterface;
import com.eci.ariendamesta.repository.mongorepo.ReviewMongoRepositoryInterface;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

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
}
