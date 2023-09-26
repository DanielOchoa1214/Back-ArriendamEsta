package com.eci.ariendamesta.service.impl;

import com.eci.ariendamesta.exceptions.AppExceptions;
import com.eci.ariendamesta.exceptions.ReviewException;
import com.eci.ariendamesta.model.Review;
import com.eci.ariendamesta.model.dtos.ReviewDTO;
import com.eci.ariendamesta.repository.repointerfaces.ReviewRepositoryInterface;
import com.eci.ariendamesta.service.servinterfaces.ReviewServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ReviewService implements ReviewServiceInterface {

    private final ReviewRepositoryInterface reviewRepository;

    public ReviewService(@Autowired ReviewRepositoryInterface repositoryInterface){
        this.reviewRepository = repositoryInterface;
    }

    @Override
    public Review createReview(ReviewDTO reviewDTO) throws AppExceptions {
        if (reviewRepository.findById(reviewDTO.getId()).isEmpty()){
            Review review = new Review(reviewDTO);
            reviewRepository.save(review);
            return getReview(review.getId());
        }
        throw new ReviewException(ReviewException.NOT_CREATED);
    }

    @Override
    public Review getReview(String reviewId) throws AppExceptions {
        Optional<Review> review = reviewRepository.findById(reviewId);
        if (review.isPresent()){
            return review.get();
        }
        throw new ReviewException(ReviewException.NOT_FOUND);
    }

    @Override
    public Review updateReview(String reviewId, ReviewDTO reviewDTO) throws AppExceptions {
        Review review = getReview(reviewId);
        try{
            review.update(reviewDTO);
            reviewRepository.save(review);
            return getReview(reviewId);
        } catch (Exception e){
            throw new ReviewException(ReviewException.NOT_UPDATED);
        }

    }

    @Override
    public void deleteReview(String reviewId) throws AppExceptions {
        try{
            reviewRepository.delete(reviewRepository.findById(reviewId).get());
        } catch (Exception e){
            throw new ReviewException(ReviewException.NOT_DELETED);
        }
    }
}
