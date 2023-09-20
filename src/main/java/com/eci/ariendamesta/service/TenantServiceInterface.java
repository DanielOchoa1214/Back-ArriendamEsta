package com.eci.ariendamesta.service;

import com.eci.ariendamesta.exceptions.AppExceptions;
import com.eci.ariendamesta.exceptions.UserException;
import com.eci.ariendamesta.model.Review;
import com.eci.ariendamesta.model.landlord.Landlord;
import com.eci.ariendamesta.model.tenant.Tenant;
import com.eci.ariendamesta.model.tenant.TenantDto;

import java.util.Optional;

public interface TenantServiceInterface {
    Tenant createTenant(Tenant tenant) throws AppExceptions;

    Tenant findById(String idTenant) throws AppExceptions;

    Tenant findByEmail(String email) throws AppExceptions;

    Tenant updateTenant(String idTenant, TenantDto tenantBody) throws AppExceptions;

    void deleteTenant(String idTenant) throws AppExceptions;

    Optional<Review> getReview(String landlordId, String reviewId) throws AppExceptions;

    Optional<Review> postReview(Review reviewDTO, String landlordId) throws AppExceptions;
}
