package com.eci.ariendamesta.repository.repointerfaces;

import com.eci.ariendamesta.model.Property;
import com.eci.ariendamesta.model.State;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface PropertyRepositoryInterface {

    Optional<Property> findById(String propertyId);
    Property save(Property property);
    void deleteEntity(Property property);
    List<Property> getProperties();
    //List<Property> findHomeOwnerProperties(String homeOwnerId);
    List<Property> getProperties(Map<String, String> params);
}
