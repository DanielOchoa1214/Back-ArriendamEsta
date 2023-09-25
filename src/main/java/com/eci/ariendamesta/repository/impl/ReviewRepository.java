package com.eci.ariendamesta.repository.impl;

import com.eci.ariendamesta.repository.repointerfaces.ReviewRepositoryInterface;
import com.eci.ariendamesta.repository.mongorepo.ReviewMongoRepositoryInterface;
import org.springframework.beans.factory.annotation.Autowired;

public class ReviewRepository implements ReviewRepositoryInterface {

    private ReviewMongoRepositoryInterface mongo;

    public ReviewRepository(@Autowired ReviewMongoRepositoryInterface mongo) {
        this.mongo = mongo;
    }
}
