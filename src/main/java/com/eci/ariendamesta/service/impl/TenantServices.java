package com.eci.ariendamesta.service.impl;

import com.eci.ariendamesta.model.Tenant;
import com.eci.ariendamesta.repository.TenantRepositoryInterface;
import com.eci.ariendamesta.service.TenantServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TenantServices implements TenantServiceInterface {

    private final TenantRepositoryInterface tenantRepository;

    public TenantServices(@Autowired TenantRepositoryInterface tenantRepository){
        this.tenantRepository = tenantRepository;
    }
    @Override
    public Tenant createTenant(Tenant tenant) {
        return tenantRepository.save(tenant);
    }
}
