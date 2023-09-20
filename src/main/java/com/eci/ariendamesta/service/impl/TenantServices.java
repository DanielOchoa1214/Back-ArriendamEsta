package com.eci.ariendamesta.service.impl;

import com.eci.ariendamesta.exceptions.AppExceptions;
import com.eci.ariendamesta.exceptions.ReviewException;
import com.eci.ariendamesta.exceptions.UserException;
import com.eci.ariendamesta.model.Review;
import com.eci.ariendamesta.model.landlord.Landlord;
import com.eci.ariendamesta.model.tenant.Tenant;
import com.eci.ariendamesta.model.tenant.TenantDto;
import com.eci.ariendamesta.repository.LandlordRepositoryInterface;
import com.eci.ariendamesta.repository.TenantRepositoryInterface;
import com.eci.ariendamesta.service.LandlordServiceInterface;
import com.eci.ariendamesta.service.TenantServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TenantServices implements TenantServiceInterface {

    private final TenantRepositoryInterface tenantRepository;
    private final LandlordRepositoryInterface landlordRepository;

    public TenantServices(@Autowired TenantRepositoryInterface tenantRepository,
                          @Autowired LandlordRepositoryInterface landlordRepository){
        this.tenantRepository = tenantRepository;
        this.landlordRepository = landlordRepository;
    }
    @Override
    public Tenant createTenant(Tenant tenant) throws AppExceptions {
        if(tenantRepository.findById(tenant.getId()).isEmpty()) {
            tenantRepository.save(tenant);
            return findById(tenant.getId());
        }
        throw new UserException(UserException.NOT_CREATED);
    }

    @Override
    public Tenant findById(String idTenant) throws AppExceptions {
        Optional<Tenant> tenant = tenantRepository.findById(idTenant);
        if (tenant.isPresent()) {
            return tenant.get();
        }
        throw new UserException(UserException.NOT_FOUND);
    }

    @Override
    public Tenant findByEmail(String email) throws AppExceptions {
        Optional<Tenant> tenant = tenantRepository.findByEmail(email);
        if (tenant.isPresent()) {
            return tenant.get();
        }
        throw new UserException(UserException.NOT_FOUND);
    }

    @Override
    public Tenant updateTenant(String idTenant, TenantDto tenantBody) throws AppExceptions {
        Tenant tenant = findById(idTenant);
        try {
            tenant.update(tenantBody);
            tenantRepository.save(tenant);
            return findById(idTenant);
        } catch (Exception e) {
            throw new UserException(UserException.NOT_UPDATED);
        }
    }

    @Override
    public void deleteTenant(String tenantId) throws AppExceptions {
        Tenant tenant = findById(tenantId);
        try {
            tenantRepository.deleteEntity(tenant);
        } catch (Exception e) {
            throw new UserException(UserException.NOT_DELETED);
        }
    }

    @Override
    public Optional<Review> getReview(String tenantId, String reviewId) throws AppExceptions {
        try{
            Tenant tenant = findById(tenantId);
            return tenant.getReview(reviewId);
        } catch (Exception e) {
            throw new ReviewException(ReviewException.NOT_FOUND);
        }
    }

    @Override
    public Optional<Review> postReview(Review review, String tenantId) throws AppExceptions {
        Tenant tenant = findById(tenantId);
        Optional<Landlord> landlord = landlordRepository.findById(review.getAuthorId());
        if (landlord.isPresent()){
            //Review review = new Review();
            tenant.addReview(review);
            tenantRepository.save(tenant);
            return Optional.of(review);
        }
        throw new ReviewException(ReviewException.NOT_CREATED);
    }
}
