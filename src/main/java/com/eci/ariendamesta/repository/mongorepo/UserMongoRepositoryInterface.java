package com.eci.ariendamesta.repository.mongorepo;

import com.eci.ariendamesta.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Optional;

public interface UserMongoRepositoryInterface extends MongoRepository<User, String> {

    @Query("{email: '?0'}")
    Optional<User> findUserByEmail(String email);
}
