package com.eci.ariendamesta.service.servinterfaces;


import com.eci.ariendamesta.exceptions.AppExceptions;
import com.eci.ariendamesta.exceptions.UserException;
import com.eci.ariendamesta.model.User;
import com.eci.ariendamesta.model.dtos.UserRequestDTO;

import java.util.List;

public interface UserServiceInterface {
    User createUser(UserRequestDTO userDTO) throws AppExceptions;
    User findById(String userId) throws UserException;
    User updateUser(String userId, UserRequestDTO userDTO) throws AppExceptions;
    void deleteUser(String userId) throws AppExceptions;
}
