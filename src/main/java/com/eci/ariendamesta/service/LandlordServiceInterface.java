package com.eci.ariendamesta.service;

import com.eci.ariendamesta.exceptions.AppExceptions;
import com.eci.ariendamesta.model.Review;
import com.eci.ariendamesta.model.landlord.Landlord;
import com.eci.ariendamesta.model.landlord.LandlordDto;

import java.util.Optional;

public interface LandlordServiceInterface {

    Landlord findById(String idLandlord) throws AppExceptions;

    Landlord findByEmail(String email) throws AppExceptions;

    Landlord createLandlord(Landlord landlord) throws AppExceptions;

    Landlord updateLandlord(String idLandlord, LandlordDto landlord) throws AppExceptions;

    void deleteLandlord(String idLandlord) throws AppExceptions;

    Optional<Review> getReview(String landlordId, String reviewId) throws AppExceptions;

    Optional<Review> postReview(Review reviewDTO, String landlordId) throws AppExceptions;
}
