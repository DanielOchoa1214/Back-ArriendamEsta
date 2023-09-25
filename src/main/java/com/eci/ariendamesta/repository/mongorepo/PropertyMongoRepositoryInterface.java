package com.eci.ariendamesta.repository.mongorepo;

import com.eci.ariendamesta.model.Property;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PropertyMongoRepositoryInterface extends MongoRepository<Property, String> {
}
