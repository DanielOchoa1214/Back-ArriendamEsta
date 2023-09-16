package com.eci.ariendamesta.service;

import com.eci.ariendamesta.exceptions.UserException;
import com.eci.ariendamesta.model.landlord.Landlord;
import com.eci.ariendamesta.model.landlord.LandlordDto;

public interface LandlordServiceInterface {

    Landlord foundById(String idLandlord) throws UserException;

    Landlord createLandlord(Landlord landlord) throws UserException;

    Landlord updateLandlord(String idLandlord, LandlordDto landlord) throws UserException;

    void deleteLandlord(String idLandlord) throws UserException;
}
