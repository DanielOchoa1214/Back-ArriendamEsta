package com.eci.ariendamesta.repository.impl;

import com.eci.ariendamesta.model.Gender;
import com.eci.ariendamesta.model.landlord.Landlord;
import com.eci.ariendamesta.repository.LandlordRepositoryInterface;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class LocalLandlordRepository implements LandlordRepositoryInterface {

    private static Map<String, Landlord> landlordMap = new HashMap<>();

    LocalLandlordRepository() {
        Landlord landlord = new Landlord("1", "Prueba", "prueba@mail.com", "31", "12", "12",Gender.MALE);
        landlordMap.put(landlord.getId(), landlord);
    }

    @Override
    public Landlord save(Landlord landlord) {
        if (!landlordMap.containsKey(landlord.getId())) {
            landlordMap.put(landlord.getId(), landlord);
            return landlordMap.get(landlord.getId());
        }
        return null;
    }

    @Override
    public Optional<Landlord> findById(String idLandlord) {
        return Optional.ofNullable(landlordMap.get(idLandlord));
    }

    @Override
    public void deleteEntity(Landlord landlord) {
        landlordMap.remove(landlord.getId());
    }

    @Override
    public Landlord update(Landlord landlord) {
        landlordMap.put(landlord.getId(), landlord);
        return landlordMap.get(landlord.getId());
    }
}
