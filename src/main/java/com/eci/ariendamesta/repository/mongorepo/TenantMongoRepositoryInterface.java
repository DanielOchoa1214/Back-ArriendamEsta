package com.eci.ariendamesta.repository.mongorepo;

import com.eci.ariendamesta.model.tenant.Tenant;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TenantMongoRepositoryInterface extends MongoRepository<Tenant, String> {
}
