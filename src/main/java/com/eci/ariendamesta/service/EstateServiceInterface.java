package com.eci.ariendamesta.service;


import com.eci.ariendamesta.model.Estate;

public interface EstateServiceInterface {
    Estate getEstate(String idEstate);

    void createEstate(Estate estate);

    Estate update(String idEstate, Estate estate);

    void delete(String idEstate);
}
