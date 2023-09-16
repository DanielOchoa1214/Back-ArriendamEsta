package com.eci.ariendamesta.repository.impl;

import com.eci.ariendamesta.model.Tenant;
import com.eci.ariendamesta.repository.TenantRepositoryInterface;
import com.eci.ariendamesta.repository.mongorepo.TenantMongoRepositoryInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MongoTenantRepository implements TenantRepositoryInterface {

    private TenantMongoRepositoryInterface mongoDB;

    public MongoTenantRepository(@Autowired TenantMongoRepositoryInterface mongoDB) {
        this.mongoDB = mongoDB;
    }

    @Override
    public Tenant save(Tenant tenant) {
        mongoDB.save(tenant);
        return tenant;
    }

    @Override
    public Optional<Tenant> findById(String idTenant) {
        return mongoDB.findById(idTenant);
    }

    @Override
    public void deleteEntity(Tenant tenant) {
        mongoDB.delete(tenant);
    }

    @Override
    public Tenant update(Tenant tenant) {
        return null;
    }
}
