package com.eci.ariendamesta.service;

import com.eci.ariendamesta.exceptions.AppExceptions;
import com.eci.ariendamesta.exceptions.EstateException;
import com.eci.ariendamesta.model.Review;
import com.eci.ariendamesta.model.dtos.ReviewDTO;

import java.util.Optional;


import com.eci.ariendamesta.model.estate.Estate;
import com.eci.ariendamesta.model.estate.EstateDto;
import com.eci.ariendamesta.model.landlord.Landlord;

public interface EstateServiceInterface {
    Estate getEstate(String idEstate, Landlord landlord) throws AppExceptions;
    Estate createEstate(Estate newEstate, Landlord landlord) throws AppExceptions;
    Estate updateEstate(String idEstate, EstateDto estateDto, Landlord landlord) throws AppExceptions;
    void deleteEstate(String idEstate, Landlord landlord) throws AppExceptions;
    Optional<Review> postReview(ReviewDTO reviewDTO, Landlord landlord, String estateId) throws AppExceptions;
    Optional<Review> getReview(String reviewId, Landlord landlord, String estateId) throws AppExceptions;
}
