package com.eci.ariendamesta.service.servinterfaces;


import com.eci.ariendamesta.exceptions.AppExceptions;
import com.eci.ariendamesta.exceptions.UserException;
import com.eci.ariendamesta.model.User;
import com.eci.ariendamesta.model.dtos.UserRequestDTO;

public interface UserServiceInterface {

    User createUser(UserRequestDTO userDTO) throws AppExceptions;

    User findById(String userId) throws UserException;

    User updateUser(String userId, UserRequestDTO userDTO) throws AppExceptions;
    /*
        HomeRenter createTenant(HomeRenter tenant) throws AppExceptions;

    HomeRenter foundById(String idTenant) throws AppExceptions;

    HomeRenter updateTenant(String idTenant, TenantDto tenantBody) throws AppExceptions;

    void deleteTenant(String idTenant) throws AppExceptions;

    Optional<Review> getReview(String landlordId, String reviewId) throws AppExceptions;

    Optional<Review> postReview(Review reviewDTO, String landlordId) throws AppExceptions;
     */
}
