package com.eci.ariendamesta.repository.mongorepo;

import com.eci.ariendamesta.model.Petition;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PetitionMongoRepositoryInterface extends MongoRepository<Petition, String> {
}
