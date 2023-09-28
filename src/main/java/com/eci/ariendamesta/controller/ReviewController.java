package com.eci.ariendamesta.controller;

import com.eci.ariendamesta.exceptions.AppExceptions;
import com.eci.ariendamesta.model.Review;
import com.eci.ariendamesta.model.dtos.ReviewDTO;
import com.eci.ariendamesta.service.servinterfaces.ReviewServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/review")
public class ReviewController {

    private final ReviewServiceInterface reviewServices;

    public ReviewController(@Autowired ReviewServiceInterface reviewServices){
        this.reviewServices = reviewServices;
    }

    @PostMapping
    public ResponseEntity<?> createReview(@RequestBody ReviewDTO reviewDTO){
        try{
            Review review = reviewServices.createReview(reviewDTO);
            return ResponseEntity.created(URI.create("")).body(review);
        } catch (AppExceptions e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/{reviewId}")
    public ResponseEntity<?> getReview(@PathVariable("reviewId") String reviewId){
        try{
            Review review = reviewServices.getReview(reviewId);
            return ResponseEntity.ok().body(review);
        } catch (AppExceptions e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{reviewId}")
    public ResponseEntity<?> updateReview(@PathVariable("reviewId") String reviewId, @RequestBody ReviewDTO reviewDTO){
        try{
            Review review = reviewServices.updateReview(reviewId, reviewDTO);
            System.out.println("Content: "+reviewDTO.getContent());
            return ResponseEntity.ok(review);
        } catch (AppExceptions e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{reviewId}")
    public ResponseEntity<?> deleteReview(@PathVariable("reviewId") String reviewId){
        try{
            reviewServices.deleteReview(reviewId);
            return ResponseEntity.ok().build();
        } catch (AppExceptions e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<?> getUserReviews(@PathVariable("userId") String userId){
        try{
            List<Review> reviews = reviewServices.getReviewsByUser(userId);
            return ResponseEntity.ok(reviews);
        } catch (AppExceptions e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/property/{propertyId}")
    public ResponseEntity<?> getPropertyReviews(@PathVariable("propertyId") String propertyId){
        try{
            List<Review> reviews = reviewServices.getReviewsByProperty(propertyId);
            return ResponseEntity.ok(reviews);
        } catch (AppExceptions e) {
            return ResponseEntity.notFound().build();
        }
    }
}
