package com.eci.ariendamesta.service;

import com.eci.ariendamesta.exceptions.AppExceptions;
import com.eci.ariendamesta.exceptions.UserException;
import com.eci.ariendamesta.model.tenant.Tenant;
import com.eci.ariendamesta.model.tenant.TenantDto;

public interface TenantServiceInterface {
    Tenant createTenant(Tenant tenant) throws AppExceptions;

    Tenant foundById(String idTenant) throws AppExceptions;

    Tenant updateTenant(String idTenant, TenantDto tenantBody) throws AppExceptions;

    void deleteTenant(String idTenant) throws AppExceptions;
}
