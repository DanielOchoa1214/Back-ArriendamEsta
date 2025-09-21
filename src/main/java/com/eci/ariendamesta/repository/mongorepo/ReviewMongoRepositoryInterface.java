package com.eci.ariendamesta.repository.mongorepo;

import com.eci.ariendamesta.exceptions.ReviewException;
import com.eci.ariendamesta.model.Review;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ReviewMongoRepositoryInterface extends MongoRepository<Review, String> {

}
