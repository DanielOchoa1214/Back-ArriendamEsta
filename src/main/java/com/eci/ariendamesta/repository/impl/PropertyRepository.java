package com.eci.ariendamesta.repository.impl;

import com.eci.ariendamesta.model.Property;
import com.eci.ariendamesta.repository.repointerfaces.PropertyRepositoryInterface;
import com.eci.ariendamesta.repository.mongorepo.PropertyMongoRepositoryInterface;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class PropertyRepository implements PropertyRepositoryInterface {
    private PropertyMongoRepositoryInterface mongo;

    public PropertyRepository(@Autowired PropertyMongoRepositoryInterface mongo) {
        this.mongo = mongo;
    }

    @Override
    public Optional<Property> findById(String estateId) {
        return Optional.empty();
    }

    @Override
    public Property save(Property estate) {
        return null;
    }

    @Override
    public void deleteEntity(Property estate) {

    }

    @Override
    public List<Property> getEstates() {
        return null;
    }
}
