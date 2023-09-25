package com.eci.ariendamesta.repository.repointerfaces;

import com.eci.ariendamesta.model.Property;

import java.util.List;
import java.util.Optional;

public interface PropertyRepositoryInterface {

    Optional<Property> findById(String estateId);
    Property save(Property estate);
    void deleteEntity(Property estate);
    List<Property> getEstates();
}
