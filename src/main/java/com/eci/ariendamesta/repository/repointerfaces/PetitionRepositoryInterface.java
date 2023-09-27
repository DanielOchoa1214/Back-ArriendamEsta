package com.eci.ariendamesta.repository.repointerfaces;

import com.eci.ariendamesta.model.Petition;

import java.util.List;
import java.util.Optional;

public interface PetitionRepositoryInterface {
    Optional<Petition> findById(String petitionId);
    Petition save(Petition petition);
    void deleteEntity(Petition petition);
    List<Petition> getPetitions();
    List<Petition> findPetitionsHomeOwner(String homeOwnerId);
    List<Petition> findPetitionsHomerenter(String homeRenterId);
}
