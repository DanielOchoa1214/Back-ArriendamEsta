package com.eci.ariendamesta.repository.mongorepo;

import com.eci.ariendamesta.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserMongoRepositoryInterface extends MongoRepository<User, String> {
}
