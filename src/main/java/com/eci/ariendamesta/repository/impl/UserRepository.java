package com.eci.ariendamesta.repository.impl;

import com.eci.ariendamesta.model.User;
import com.eci.ariendamesta.repository.repointerfaces.UserRepositoryInterface;
import com.eci.ariendamesta.repository.mongorepo.UserMongoRepositoryInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
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
    public Optional<User> findByEmail(String email) {
        List<User> users = mongo.findAll();
        users.removeIf(user -> !user.getEmail().equals(email));
        if (!users.isEmpty()){
            return Optional.of(users.get(0));
        }
        return Optional.empty();
    }

    @Override
    public void delete(String userId) {
        mongo.deleteById(userId);
    }
}
