package com.eci.ariendamesta.repository.impl;

import com.eci.ariendamesta.model.Landlord;
import com.eci.ariendamesta.repository.LandlordRepositoryInterface;
import com.eci.ariendamesta.repository.mongorepo.LandlordMongoRepositoryInterface;
import org.springframework.beans.factory.annotation.Autowired;

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
}
