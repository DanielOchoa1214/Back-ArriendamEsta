package com.eci.ariendamesta.repository.impl;

import com.eci.ariendamesta.model.landlord.Landlord;
import com.eci.ariendamesta.repository.LandlordRepositoryInterface;
import com.eci.ariendamesta.repository.mongorepo.LandlordMongoRepositoryInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class MongoLandlordRepository implements LandlordRepositoryInterface {

    private LandlordMongoRepositoryInterface mongoDB;

    public MongoLandlordRepository(@Autowired LandlordMongoRepositoryInterface mongoDB) {
        this.mongoDB = mongoDB;
    }

    @Override
    public Landlord save(Landlord landlord) {
        mongoDB.save(landlord);
        return landlord;
    }

    @Override
    public Optional<Landlord> findById(String idLandlord) {
        return mongoDB.findById(idLandlord);
    }

    @Override
    public void deleteEntity(Landlord landlord) {
        mongoDB.delete(landlord);
    }

    @Override
    public Landlord update(Landlord landlord) {
        return null;
    }
}
