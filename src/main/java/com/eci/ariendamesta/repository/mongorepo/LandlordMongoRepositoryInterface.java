package com.eci.ariendamesta.repository.mongorepo;

import com.eci.ariendamesta.model.Landlord;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LandlordMongoRepositoryInterface extends MongoRepository<Landlord, String> {
}
