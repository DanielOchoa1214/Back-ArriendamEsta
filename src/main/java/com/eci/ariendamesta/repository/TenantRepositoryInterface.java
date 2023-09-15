package com.eci.ariendamesta.repository;

import com.eci.ariendamesta.model.Tenant;

import java.util.Optional;

public interface TenantRepositoryInterface {
    Tenant save(Tenant tenant);
    Optional<Tenant> get(String tenantId);
}
