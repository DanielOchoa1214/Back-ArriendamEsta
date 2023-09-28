package com.eci.ariendamesta.service;

import com.eci.ariendamesta.exceptions.AppExceptions;
import com.eci.ariendamesta.exceptions.PropertyException;
import com.eci.ariendamesta.exceptions.ReviewException;
import com.eci.ariendamesta.exceptions.UserException;
import com.eci.ariendamesta.model.*;
import com.eci.ariendamesta.model.dtos.ReviewDTO;
import com.eci.ariendamesta.repository.repointerfaces.PropertyRepositoryInterface;
import com.eci.ariendamesta.repository.repointerfaces.ReviewRepositoryInterface;
import com.eci.ariendamesta.repository.repointerfaces.UserRepositoryInterface;
import com.eci.ariendamesta.service.impl.ReviewService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
public class ReviewServiceTest {

    @Mock
    private ReviewRepositoryInterface reviewRepository;
    @Mock
    private UserRepositoryInterface userRepository;
    @Mock
    private PropertyRepositoryInterface propertyRepository;
    @InjectMocks
    private ReviewService reviewService;

    @Test
    public void whenReviewIsCreatedAndDoesntExistReturnReview() throws AppExceptions {
        // Arrange
        ReviewDTO reviewDTO = new ReviewDTO("1", "terrible servicio", 2, "1", "2", "jelou");
        Review review = new Review(reviewDTO);
        when(reviewRepository.findById("1")).thenReturn(Optional.empty());
        when(reviewRepository.save(any())).thenReturn(review);
        // Act
        Review review1 = reviewService.createReview(reviewDTO);
        // Assert
        assertEquals(review, review1);
    }

    @Test
    public void whenReviewIsCreatedAndExistsThenReturnException(){
        assertThrowsExactly(ReviewException.class, () -> {
            // Arrange
            ReviewDTO reviewDTO = new ReviewDTO("1", "terrible servicio", 2, "1", "2", "jelou");
            Review review = new Review(reviewDTO);
            when(reviewRepository.findById("1")).thenReturn(Optional.of(review));
            // Act
            Review review1 = reviewService.createReview(reviewDTO);
        });
    }

    @Test
    public void whenGetReviewAndExistsReturnReview() throws AppExceptions {
        // Arrange
        ReviewDTO reviewDTO = new ReviewDTO("1", "terrible servicio", 2, "1", "2", "jelou");
        Review review = new Review(reviewDTO);
        when(reviewRepository.findById("1")).thenReturn(Optional.of(review));
        // Act
        Review review1 = reviewService.getReview("1");
        // Assert
        assertEquals(review, review1);
    }

    @Test
    public void whenGetReviewAndDoesntExistReturnException(){
        assertThrowsExactly(ReviewException.class, () -> {
            // Act
            when(reviewRepository.findById("1")).thenReturn(Optional.empty());
            // Assert
            Review review = reviewService.getReview("1");
        });
    }

    @Test
    public void whenUpdateReviewAndReviewExistsThenReturnReview() throws AppExceptions{
        // Arrange
        Review review = new Review("1", "terrible servicio", 2, "1", "2", "jelou");
        ReviewDTO reviewDTO = new ReviewDTO("1", "terrible terrible", 2, "1", "2", "jelou");
        Review r1 = new Review(reviewDTO);
        when(reviewRepository.findById(review.getId())).thenReturn(Optional.of(review));
        when(reviewRepository.save(any())).thenReturn(r1);
        // Act
        Review review1 = reviewService.updateReview("1", reviewDTO);
        // Assert
        assertEquals(review.getName(), review1.getName());
    }

    @Test
    public void whenUpdateReviewAndDoesntExistReturnException(){
        assertThrowsExactly(ReviewException.class, () -> {
            // Arrange
            when(reviewRepository.findById("1")).thenReturn(Optional.empty());
            ReviewDTO reviewDTO = new ReviewDTO("1", "terrible terrible", 2, "1", "2", "jelou");
            // Act
            Review review = reviewService.updateReview("1", reviewDTO);
        });
    }

    @Test
    public void whenDeleteReviewAndExistsReturnNothing() throws AppExceptions {
        // Arrange
        ReviewDTO reviewDTO = new ReviewDTO("1", "terrible servicio", 2, "1", "2", "jelou");
        Review review = new Review(reviewDTO);
        when(reviewRepository.findById("1")).thenReturn(Optional.of(review));
        // Act
        reviewService.deleteReview("1");
    }

    @Test
    public void whenDeleteReviewAndDoesntExistReturnException(){
        assertThrowsExactly(ReviewException.class, () -> {
            // Arrange
            when(reviewRepository.findById("1")).thenReturn(Optional.empty());
            // Act
            reviewService.deleteReview("1");
        });
    }

    @Test
    public void whenGetReviewsByUserAndUserFoundThenReturnReviews() throws ParseException, AppExceptions {
        // Arrange
        User user = new User("2", "Prueba", "prueba@mail.com", "31", "12", "12/09/2022", Gender.MALE);
        Review review = new Review("1", "terrible servicio", 2, "1", "2", "jelou");
        List<Review> reviews = new ArrayList<>();
        reviews.add(review);
        when(userRepository.findById(user.getId())).thenReturn(Optional.of(user));
        when(reviewRepository.getReviewsByUser(user.getId())).thenReturn(reviews);
        // Act
        List<Review> reviews1 = reviewService.getReviewsByUser("2");
        // Assert
        assertEquals(reviews, reviews1);
    }

    @Test
    public void whenGetReviewsByUserAndUserNotFoundThenReturnException(){
        assertThrowsExactly(UserException.class, () -> {
            // Arrange
            when(userRepository.findById("1")).thenReturn(Optional.empty());
            // Act
            reviewService.getReviewsByUser("1");
        });
    }

    @Test
    public void whenGetReviewsByPropertyAndUserFoundThenReturnReviews() throws AppExceptions {
        // Arrange
        Property property = new Property("1","lugar Bonito",3000000,"el mejor lugar del mundo",300,"La mejor casa del pueblo", State.RENTED, "1");
        Review review = new Review("1", "terrible apto, no es el mejor lugar del pueblo", 2, "14989", "1", "jelou");
        List<Review> reviews = new ArrayList<>();
        reviews.add(review);
        when(propertyRepository.findById(property.getId())).thenReturn(Optional.of(property));
        when(reviewRepository.getReviewsByUser(property.getId())).thenReturn(reviews);
        // Act
        List<Review> reviews1 = reviewService.getReviewsByProperty("1");
        // Assert
        assertEquals(reviews, reviews1);
    }

    @Test
    public void whenGetReviewsByPropertyAndPropertyNotFoundThenReturnException(){
        assertThrowsExactly(PropertyException.class, () -> {
            // Arrange
            when(propertyRepository.findById("1")).thenReturn(Optional.empty());
            // Act
            reviewService.getReviewsByProperty("1");
        });
    }
}
