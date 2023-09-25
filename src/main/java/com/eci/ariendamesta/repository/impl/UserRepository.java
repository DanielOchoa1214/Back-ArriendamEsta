package com.eci.ariendamesta.repository.impl;

import com.eci.ariendamesta.model.User;
import com.eci.ariendamesta.repository.repointerfaces.UserRepositoryInterface;
import com.eci.ariendamesta.repository.mongorepo.UserMongoRepositoryInterface;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class UserRepository implements UserRepositoryInterface {

    private UserMongoRepositoryInterface mongo;

    public UserRepository(@Autowired UserMongoRepositoryInterface mongo){
        this.mongo = mongo;
    }

    @Override
    public User save(User tenant) {
        return null;
    }

    @Override
    public Optional<User> findById(String idTenant) {
        return Optional.empty();
    }

    @Override
    public void deleteEntity(User tenant) {

    }

    @Override
    public User update(User tenant) {
        return null;
    }
}
