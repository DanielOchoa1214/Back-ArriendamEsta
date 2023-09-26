package com.eci.ariendamesta.repository.impl;

import com.eci.ariendamesta.model.Property;
import com.eci.ariendamesta.repository.repointerfaces.PropertyRepositoryInterface;
import com.eci.ariendamesta.repository.mongorepo.PropertyMongoRepositoryInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class PropertyRepository implements PropertyRepositoryInterface {
    private PropertyMongoRepositoryInterface mongo;

    public PropertyRepository(@Autowired PropertyMongoRepositoryInterface mongo) {
        this.mongo = mongo;
    }

    @Override
    public Optional<Property> findById(String propertyId) {
        return mongo.findById(propertyId);
    }

    @Override
    public Property save(Property property) {
        return mongo.save(property);
    }

    @Override
    public void deleteEntity(Property property) {
        mongo.delete(property);
    }

    @Override
    public List<Property> getEstates() {
        return null;
    }
}
