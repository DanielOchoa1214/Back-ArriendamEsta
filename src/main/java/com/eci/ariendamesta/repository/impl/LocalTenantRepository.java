package com.eci.ariendamesta.repository.impl;

import com.eci.ariendamesta.model.Tenant;
import com.eci.ariendamesta.repository.TenantRepositoryInterface;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;


public class LocalTenantRepository implements TenantRepositoryInterface{
    private Map<String, Tenant> tenants = new HashMap<>();


    @Override
    public Tenant save(Tenant tenant) {
        tenants.put(tenant.getId(), tenant);
        return tenant;
    }

    @Override
    public Optional<Tenant> findById(String idTenant) {
        return Optional.empty();
    }

    @Override
    public void deleteEntity(Tenant tenant) {

    }

    @Override
    public Tenant update(Tenant tenant) {
        return null;
    }
}
