package com.eci.ariendamesta.service;

import com.eci.ariendamesta.exceptions.AppExceptions;
import com.eci.ariendamesta.exceptions.EstateException;
import com.eci.ariendamesta.model.Petition;
import com.eci.ariendamesta.model.dtos.PetitionDTO;
import com.eci.ariendamesta.model.Review;

import java.util.List;
import java.util.Optional;


import com.eci.ariendamesta.model.estate.Estate;
import com.eci.ariendamesta.model.estate.EstateDto;
import com.eci.ariendamesta.model.landlord.Landlord;

public interface EstateServiceInterface {
    Estate getEstate(String idEstate, Landlord landlord) throws AppExceptions;
    Estate createEstate(Estate newEstate, Landlord landlord) throws AppExceptions;
    Estate updateEstate(String idEstate, EstateDto estateDto, Landlord landlord) throws AppExceptions;
    void deleteEstate(String idEstate, Landlord landlord) throws AppExceptions;
    List<Estate> getEstates() throws AppExceptions;
    Optional<Review> postReview(Review reviewDTO, Landlord landlord, String estateId) throws AppExceptions;
    Optional<Review> getReview(String reviewId, Landlord landlord, String estateId) throws AppExceptions;
    Optional<Petition> postPetition(PetitionDTO petitionDTO, Landlord landlord, String estateId) throws AppExceptions;
    Optional<Petition> getPetition(String petitionId, Landlord landlord, String estateId) throws AppExceptions;
}
