package com.eci.ariendamesta.repository;

import com.eci.ariendamesta.model.landlord.Landlord;

import java.util.Optional;

public interface LandlordRepositoryInterface {
    Landlord save(Landlord landlord);

    Optional<Landlord> findById(String idLandlord);

    Optional<Landlord> findByEmail(String email);

    void deleteEntity(Landlord landlord);

    Landlord update(Landlord landlord);

}
