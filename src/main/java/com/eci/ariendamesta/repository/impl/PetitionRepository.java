package com.eci.ariendamesta.repository.impl;

import com.eci.ariendamesta.repository.repointerfaces.PetitionRepositoryInterface;
import com.eci.ariendamesta.repository.mongorepo.PetitionMongoRepositoryInterface;
import org.springframework.beans.factory.annotation.Autowired;

public class PetitionRepository implements PetitionRepositoryInterface {

    private PetitionMongoRepositoryInterface mongo;

    public PetitionRepository(@Autowired PetitionMongoRepositoryInterface mongo) {
        this.mongo = mongo;
    }
}
