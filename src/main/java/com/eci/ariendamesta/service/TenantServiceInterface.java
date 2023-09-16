package com.eci.ariendamesta.service;

import com.eci.ariendamesta.exceptions.UserException;
import com.eci.ariendamesta.model.tenant.Tenant;
import com.eci.ariendamesta.model.tenant.TenantDto;

public interface TenantServiceInterface {
    Tenant createTenant(Tenant tenant) throws UserException;

    Tenant foundById(String idTenant) throws UserException;

    Tenant updateTenant(String idTenant, TenantDto tenantBody) throws UserException;

    void deleteTenant(String idTenant) throws UserException;
}
