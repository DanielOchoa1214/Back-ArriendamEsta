package com.eci.ariendamesta.repository;

import com.eci.ariendamesta.model.tenant.Tenant;

import java.util.Optional;

public interface TenantRepositoryInterface {
    Tenant save(Tenant tenant);

    Optional<Tenant> findById(String idTenant);

    Optional<Tenant> findByEmail(String email);

    void deleteEntity(Tenant tenant);

    Tenant update(Tenant tenant);

}
