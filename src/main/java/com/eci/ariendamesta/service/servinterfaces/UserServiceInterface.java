package com.eci.ariendamesta.service.servinterfaces;


import com.eci.ariendamesta.exceptions.AppExceptions;
import com.eci.ariendamesta.model.User;
import com.eci.ariendamesta.model.dtos.UserDTO;

public interface UserServiceInterface {

    User createUser(UserDTO userDTO) throws AppExceptions;
    /*
        HomeRenter createTenant(HomeRenter tenant) throws AppExceptions;

    HomeRenter foundById(String idTenant) throws AppExceptions;

    HomeRenter updateTenant(String idTenant, TenantDto tenantBody) throws AppExceptions;

    void deleteTenant(String idTenant) throws AppExceptions;

    Optional<Review> getReview(String landlordId, String reviewId) throws AppExceptions;

    Optional<Review> postReview(Review reviewDTO, String landlordId) throws AppExceptions;
     */
}
