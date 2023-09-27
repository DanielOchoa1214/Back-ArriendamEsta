package com.eci.ariendamesta.repository.impl;

import com.eci.ariendamesta.model.Petition;
import com.eci.ariendamesta.repository.repointerfaces.PetitionRepositoryInterface;
import com.eci.ariendamesta.repository.mongorepo.PetitionMongoRepositoryInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class PetitionRepository implements PetitionRepositoryInterface {

    private PetitionMongoRepositoryInterface mongo;

    public PetitionRepository(@Autowired PetitionMongoRepositoryInterface mongo) {
        this.mongo = mongo;
    }

    @Override
    public Optional<Petition> findById(String petitionId) {
        return mongo.findById(petitionId);
    }

    @Override
    public Petition save(Petition petition) {
        return mongo.save(petition);
    }

    @Override
    public void deleteEntity(Petition petition) {
        mongo.delete(petition);
    }

    @Override
    public List<Petition> getPetitions() {
        return mongo.findAll();
    }

    @Override
    public List<Petition> findPetitionsHomeOwner(String homeOwnerId) {
        return null;
    }

    @Override
    public List<Petition> findPetitionsHomerenter(String homeRenterId) {
        return null;
    }
}
