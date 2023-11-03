package com.eci.ariendamesta.service.servinterfaces;

import com.eci.ariendamesta.exceptions.AppExceptions;
import com.eci.ariendamesta.model.Petition;
import com.eci.ariendamesta.model.Property;
import com.eci.ariendamesta.model.dtos.PetitionDTO;

import java.util.List;
import java.util.Map;

public interface PetitionServiceInterface {
    Petition findPetition(String petitionId) throws AppExceptions;
    Petition createPetition(PetitionDTO petitionDTO) throws AppExceptions;
    Petition updatePetition(String petitionId, PetitionDTO petitionDTO) throws AppExceptions;
    void deletePetition(String petitionId) throws AppExceptions;
    List<Petition> findPetitions() throws AppExceptions;
    List<Petition> findEstatePetitions(Map<String, String> params) throws AppExceptions;

    Petition updatePetitionStatus(String petitionId, String status) throws AppExceptions;
}
