package com.eci.ariendamesta.service.servinterfaces;

import com.eci.ariendamesta.exceptions.AppExceptions;
import com.eci.ariendamesta.model.User;
import com.eci.ariendamesta.model.dtos.UserRequestDTO;

public interface AuthServiceInterface {
    User autheticate(UserRequestDTO userDTO) throws AppExceptions;
}
