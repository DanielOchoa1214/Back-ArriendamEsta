package com.eci.ariendamesta.service.impl;

import com.eci.ariendamesta.exceptions.AppExceptions;
import com.eci.ariendamesta.exceptions.PropertyException;
import com.eci.ariendamesta.exceptions.ReviewException;
import com.eci.ariendamesta.exceptions.UserException;
import com.eci.ariendamesta.model.Property;
import com.eci.ariendamesta.model.Review;
import com.eci.ariendamesta.model.User;
import com.eci.ariendamesta.model.dtos.ReviewDTO;
import com.eci.ariendamesta.repository.repointerfaces.PropertyRepositoryInterface;
import com.eci.ariendamesta.repository.repointerfaces.ReviewRepositoryInterface;
import com.eci.ariendamesta.repository.repointerfaces.UserRepositoryInterface;
import com.eci.ariendamesta.service.servinterfaces.ReviewServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ReviewService implements ReviewServiceInterface {

    private final ReviewRepositoryInterface reviewRepository;
    private final UserRepositoryInterface userRepository;
    private final PropertyRepositoryInterface propertyRepository;

    public ReviewService(@Autowired ReviewRepositoryInterface repositoryInterface, @Autowired UserRepositoryInterface userRepository,
                         @Autowired PropertyRepositoryInterface propertyRepository){
        this.reviewRepository = repositoryInterface;
        this.userRepository = userRepository;
        this.propertyRepository = propertyRepository;
    }

    @Override
    public Review createReview(ReviewDTO reviewDTO) throws AppExceptions {
        if (reviewRepository.findById(reviewDTO.getId()).isEmpty()){
            Review review = new Review(reviewDTO);
            return reviewRepository.save(review);
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
        review.update(reviewDTO);
        try{
            return reviewRepository.save(review);
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

    @Override
    public List<Review> getReviewsByUser(String userId) throws AppExceptions {
        Optional<User> user = userRepository.findById(userId);
        if (user.isPresent()){
            return reviewRepository.getReviewsByUser(userId);
        } throw new UserException(UserException.NOT_FOUND);
    }

    @Override
    public List<Review> getReviewsByProperty(String propertyId) throws AppExceptions {
        Optional<Property> property = propertyRepository.findById(propertyId);
        if (property.isPresent()){
            return reviewRepository.getReviewsByUser(propertyId);
        } throw new PropertyException(PropertyException.NOT_FOUND);
    }
}
