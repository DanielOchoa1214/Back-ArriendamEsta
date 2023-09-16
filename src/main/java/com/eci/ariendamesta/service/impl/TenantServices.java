package com.eci.ariendamesta.service.impl;

import com.eci.ariendamesta.exceptions.AppExceptions;
import com.eci.ariendamesta.exceptions.UserException;
import com.eci.ariendamesta.model.tenant.Tenant;
import com.eci.ariendamesta.model.tenant.TenantDto;
import com.eci.ariendamesta.repository.TenantRepositoryInterface;
import com.eci.ariendamesta.service.TenantServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TenantServices implements TenantServiceInterface {

    private final TenantRepositoryInterface tenantRepository;

    public TenantServices(@Autowired TenantRepositoryInterface tenantRepository){
        this.tenantRepository = tenantRepository;
    }
    @Override
    public Tenant createTenant(Tenant tenant) throws AppExceptions {
        if(tenantRepository.findById(tenant.getId()).isEmpty()) {
            tenantRepository.save(tenant);
            return foundById(tenant.getId());
        }
        throw new UserException(UserException.NOT_CREATED);
    }

    @Override
    public Tenant foundById(String idTenant) throws AppExceptions {
        Optional<Tenant> tenant = tenantRepository.findById(idTenant);
        if (tenant.isPresent()) {
            return tenant.get();
        }
        throw new UserException(UserException.NOT_FOUND);
    }

    @Override
    public Tenant updateTenant(String idTenant, TenantDto tenantBody) throws AppExceptions {
        Tenant tenant = foundById(idTenant);
        try {
            tenant.update(tenantBody);
            tenantRepository.save(tenant);
            return foundById(idTenant);
        } catch (Exception e) {
            throw new UserException(UserException.NOT_UPDATED);
        }
    }

    @Override
    public void deleteTenant(String idTenant) throws AppExceptions {
        Tenant tenant = foundById(idTenant);
        try {
            tenantRepository.deleteEntity(tenant);
        } catch (Exception e) {
            throw new UserException(UserException.NOT_DELETED);
        }
    }
}
