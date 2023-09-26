package com.eci.ariendamesta.repository.impl;

import com.eci.ariendamesta.model.User;
import com.eci.ariendamesta.repository.repointerfaces.UserRepositoryInterface;
import com.eci.ariendamesta.repository.mongorepo.UserMongoRepositoryInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Repository
public class UserRepository implements UserRepositoryInterface {

    private final UserMongoRepositoryInterface mongo;

    public UserRepository(@Autowired UserMongoRepositoryInterface mongo){
        this.mongo = mongo;
    }

    @Override
    public User save(User user) {
        return mongo.save(user);
    }

    @Override
    public Optional<User> findById(String userId) {
        return mongo.findById(userId);
    }

    @Override
    public void delete(String userId) {
        mongo.deleteById(userId);
    }
}
