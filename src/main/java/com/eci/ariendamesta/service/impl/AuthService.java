package com.eci.ariendamesta.service.impl;

import com.eci.ariendamesta.exceptions.AppExceptions;
import com.eci.ariendamesta.exceptions.AuthException;
import com.eci.ariendamesta.model.User;
import com.eci.ariendamesta.model.dtos.UserRequestDTO;
import com.eci.ariendamesta.repository.repointerfaces.UserRepositoryInterface;
import com.eci.ariendamesta.service.servinterfaces.AuthServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService implements AuthServiceInterface {

    private final UserRepositoryInterface repository;

    public AuthService(@Autowired UserRepositoryInterface repository){
        this.repository = repository;
    }
    @Override
    public User autheticate(UserRequestDTO userDTO) throws AppExceptions {
        Optional<User> user = repository.findByEmail(userDTO.getEmail());
        if (user.isEmpty()) throw new AuthException(AuthException.USER_DOESNT_EXIST);
        if (!user.get().comparePassword(userDTO.getPassword())) throw new AuthException(AuthException.INVALID_CREDENTIALS);
        return user.get();
    }
}
