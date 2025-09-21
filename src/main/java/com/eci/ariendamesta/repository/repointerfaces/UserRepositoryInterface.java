package com.eci.ariendamesta.repository.repointerfaces;

import com.eci.ariendamesta.model.User;

import java.util.Optional;

public interface UserRepositoryInterface {
    User save(User user);

    Optional<User> findById(String userId);
    Optional<User> findByEmail(String email);
    void delete(String userId);
}
