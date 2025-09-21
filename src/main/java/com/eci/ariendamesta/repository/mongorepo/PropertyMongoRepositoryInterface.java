package com.eci.ariendamesta.repository.mongorepo;

import com.eci.ariendamesta.model.Property;
import com.eci.ariendamesta.model.State;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface PropertyMongoRepositoryInterface extends MongoRepository<Property, String> {
    @Query("{homeOwnerId:'?0'}")
    List<Property> findHomeOwnerProperties(String homeOwnerId);

    @Query("{homeOwnerId:'?0', stateEstate:'?1'}")
    List<Property> findHomeOwnerProperties(String homeOwnerId, State state);

    @Query("{$and: [?0]}")
    List<Property> findHomeOwnerProperties(Criteria criteria);
}
