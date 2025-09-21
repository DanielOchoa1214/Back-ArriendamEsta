package com.eci.ariendamesta.repository.repointerfaces;

import com.eci.ariendamesta.model.Petition;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface PetitionRepositoryInterface {
    Optional<Petition> findById(String petitionId);
    Petition save(Petition petition);
    void deleteEntity(Petition petition);
    List<Petition> getPetitions();
    List<Petition> findEstatePetitions(Map<String, String> params);
    List<Petition> findPetitionsHomerenter(String homeRenterId);
}
