package com.eci.ariendamesta.repository.repointerfaces;

import com.eci.ariendamesta.model.User;

import java.util.Optional;

public interface UserRepositoryInterface {
    User save(User tenant);

    Optional<User> findById(String idTenant);

    void deleteEntity(User tenant);

    User update(User tenant);
}
