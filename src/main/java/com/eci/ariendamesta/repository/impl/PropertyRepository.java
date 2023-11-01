package com.eci.ariendamesta.repository.impl;

import com.eci.ariendamesta.model.Property;
import com.eci.ariendamesta.repository.repointerfaces.PropertyRepositoryInterface;
import com.eci.ariendamesta.repository.mongorepo.PropertyMongoRepositoryInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public class PropertyRepository implements PropertyRepositoryInterface {
    private PropertyMongoRepositoryInterface mongo;
    private final MongoTemplate mongoTemplate;

    public PropertyRepository(@Autowired PropertyMongoRepositoryInterface mongo, @Autowired MongoTemplate mongoTemplate) {
        this.mongo = mongo;
        this.mongoTemplate = mongoTemplate;
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
    public List<Property> getProperties() {
        return mongo.findAll();
    }

    @Override
    public List<Property> findHomeOwnerProperties(Map<String, String> params) {
        Criteria criteria = new Criteria();
        for (String paramKey : params.keySet()) {
            criteria.and(paramKey).is(params.get(paramKey));
        }
        return mongoTemplate.find(Query.query(criteria), Property.class);
    }

    //private void buildQuery(Query query, )
}
