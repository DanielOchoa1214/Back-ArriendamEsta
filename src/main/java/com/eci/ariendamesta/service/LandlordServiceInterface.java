package com.eci.ariendamesta.service;

import com.eci.ariendamesta.exceptions.AppExceptions;
import com.eci.ariendamesta.exceptions.UserException;
import com.eci.ariendamesta.model.landlord.Landlord;
import com.eci.ariendamesta.model.landlord.LandlordDto;

public interface LandlordServiceInterface {

    Landlord foundById(String idLandlord) throws AppExceptions;

    Landlord createLandlord(Landlord landlord) throws AppExceptions;

    Landlord updateLandlord(String idLandlord, LandlordDto landlord) throws AppExceptions;

    void deleteLandlord(String idLandlord) throws AppExceptions;
}
