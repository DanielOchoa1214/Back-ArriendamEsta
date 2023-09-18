package com.eci.ariendamesta.repository;

import com.eci.ariendamesta.model.estate.Estate;

import java.util.List;
import java.util.Optional;

public interface PublicationRepositoryInterface {

    Optional<Estate> findById(String estateId);
    Estate save(Estate estate);
    void deleteEntity(Estate estate);
    List<Estate> getEstates();
}
