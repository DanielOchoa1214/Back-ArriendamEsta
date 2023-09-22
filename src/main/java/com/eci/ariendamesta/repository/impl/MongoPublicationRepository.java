package com.eci.ariendamesta.repository.impl;

import com.eci.ariendamesta.model.estate.Estate;
import com.eci.ariendamesta.repository.PublicationRepositoryInterface;
import com.eci.ariendamesta.repository.mongorepo.EstateMongoRepositoryInterface;
import com.eci.ariendamesta.repository.mongorepo.TenantMongoRepositoryInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Repository
public class MongoPublicationRepository implements PublicationRepositoryInterface {

    private EstateMongoRepositoryInterface mongoDB;

    public MongoPublicationRepository(@Autowired EstateMongoRepositoryInterface mongoDB) {
        this.mongoDB = mongoDB;
    }
    @Override
    public Optional<Estate> findById(String estateId) {
        return mongoDB.findById(estateId);
    }

    @Override
    public Estate save(Estate estate) {
        mongoDB.save(estate);
        return estate;
    }

    @Override
    public void deleteEntity(Estate estate) {
        mongoDB.delete(estate);
    }

    @Override
    public List<Estate> getEstates() {
        return mongoDB.findAll();
    }
}
