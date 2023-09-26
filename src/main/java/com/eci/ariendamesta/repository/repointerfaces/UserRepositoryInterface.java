package com.eci.ariendamesta.repository.repointerfaces;

import com.eci.ariendamesta.model.User;

import java.util.Optional;

public interface UserRepositoryInterface {
    User save(User user);

    Optional<User> findById(String userId);

    void deleteEntity(User user);
}
