package com.eci.ariendamesta.service.impl;

import com.eci.ariendamesta.exceptions.AppExceptions;
import com.eci.ariendamesta.exceptions.UserException;
import com.eci.ariendamesta.model.User;
import com.eci.ariendamesta.model.dtos.UserRequestDTO;
import com.eci.ariendamesta.repository.repointerfaces.UserRepositoryInterface;
import com.eci.ariendamesta.service.servinterfaces.UserServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class UserService implements UserServiceInterface {

    private final UserRepositoryInterface userRepository;

    public UserService(@Autowired UserRepositoryInterface userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User createUser(UserRequestDTO userDTO) throws AppExceptions {
        if(userRepository.findByEmail(userDTO.getEmail()).isEmpty()) {
            User created = new User(userDTO);
            return userRepository.save(created);
        }
        throw new UserException(UserException.NOT_CREATED);
    }

    @Override
    public User findById(String userId) throws UserException {
        Optional<User> user = userRepository.findById(userId);
        if (user.isPresent()) {
            return user.get();
        }
        throw new UserException(UserException.NOT_FOUND);
    }

    @Override
    public User updateUser(String userId, UserRequestDTO userDTO) throws AppExceptions {
        User user = findById(userId);
        user.update(userDTO);
        userRepository.save(user);
        return user;
    }

    @Override
    public void deleteUser(String userId) throws AppExceptions {
        if(userRepository.findById(userId).isEmpty()) throw new UserException(UserException.NOT_FOUND);
        userRepository.delete(userId);
    }
}
