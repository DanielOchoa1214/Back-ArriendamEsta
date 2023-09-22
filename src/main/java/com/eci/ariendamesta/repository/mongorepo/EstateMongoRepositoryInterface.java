package com.eci.ariendamesta.repository.mongorepo;

import com.eci.ariendamesta.model.estate.Estate;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EstateMongoRepositoryInterface extends MongoRepository<Estate, String> {
}
