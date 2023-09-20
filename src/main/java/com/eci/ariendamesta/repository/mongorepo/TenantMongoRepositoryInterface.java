package com.eci.ariendamesta.repository.mongorepo;

import com.eci.ariendamesta.model.landlord.Landlord;
import com.eci.ariendamesta.model.tenant.Tenant;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Optional;

public interface TenantMongoRepositoryInterface extends MongoRepository<Tenant, String> {

    @Query("{email:'?0'}")
    Optional<Tenant> findByEmail(String email);
}
