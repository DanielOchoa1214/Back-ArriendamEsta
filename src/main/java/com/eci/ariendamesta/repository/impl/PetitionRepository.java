package com.eci.ariendamesta.repository.impl;

import com.eci.ariendamesta.model.Petition;
import com.eci.ariendamesta.model.Property;
import com.eci.ariendamesta.repository.repointerfaces.PetitionRepositoryInterface;
import com.eci.ariendamesta.repository.mongorepo.PetitionMongoRepositoryInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public class PetitionRepository implements PetitionRepositoryInterface {

    private PetitionMongoRepositoryInterface mongo;
    private final MongoTemplate mongoTemplate;

    public PetitionRepository(@Autowired PetitionMongoRepositoryInterface mongo, @Autowired MongoTemplate mongoTemplate) {
        this.mongo = mongo;
        this.mongoTemplate = mongoTemplate;
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
    public List<Petition> findEstatePetitions(Map<String, String> params) {
        Criteria criteria = new Criteria();
        for (String paramKey : params.keySet()) {
            criteria.and(paramKey).is(params.get(paramKey));
        }
        return mongoTemplate.find(Query.query(criteria), Petition.class);
    }

    @Override
    public List<Petition> findPetitionsHomerenter(String homeRenterId) {
        return null;
    }
}
