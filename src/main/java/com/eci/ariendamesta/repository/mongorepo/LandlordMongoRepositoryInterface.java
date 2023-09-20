package com.eci.ariendamesta.repository.mongorepo;

import com.eci.ariendamesta.model.landlord.Landlord;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Optional;

public interface LandlordMongoRepositoryInterface extends MongoRepository<Landlord, String> {

    @Query("{email:'?0'}")
    Optional<Landlord> findByEmail(String email);
}
