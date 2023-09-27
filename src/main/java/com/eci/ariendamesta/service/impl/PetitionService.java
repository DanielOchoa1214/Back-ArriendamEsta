package com.eci.ariendamesta.service.impl;

import com.eci.ariendamesta.exceptions.AppExceptions;
import com.eci.ariendamesta.exceptions.PetitionException;
import com.eci.ariendamesta.model.Petition;
import com.eci.ariendamesta.model.dtos.PetitionDTO;
import com.eci.ariendamesta.repository.repointerfaces.PetitionRepositoryInterface;
import com.eci.ariendamesta.service.servinterfaces.PetitionServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class PetitionService implements PetitionServiceInterface {
    private final PetitionRepositoryInterface petitionRepository;

    public PetitionService(@Autowired PetitionRepositoryInterface petitionRepository) {
        this.petitionRepository = petitionRepository;
    }

    @Override
    public Petition findPetition(String petitionId) throws AppExceptions {
        Optional<Petition> petition = petitionRepository.findById(petitionId);
        if (petition.isPresent()) {
            return petition.get();
        }
        throw new PetitionException(PetitionException.NOT_FOUND);
    }

    @Override
    public Petition createPetition(PetitionDTO petitionDTO) throws AppExceptions {
        Optional<Petition> petitionOptional = petitionRepository.findById(petitionDTO.getId());
        if (petitionOptional.isEmpty()) {
            Petition petition = new Petition(petitionDTO);
            return petitionRepository.save(petition);
        }
        throw new PetitionException(PetitionException.NOT_CREATED);
    }

    @Override
    public Petition updatePetition(String petitionId, PetitionDTO petitionDTO) throws AppExceptions {
        Petition petition = findPetition(petitionId);
        petition.update(petitionDTO);
        try {
            return petitionRepository.save(petition);
        } catch (Exception e) {
            throw new PetitionException(PetitionException.NOT_UPDATED);
        }
    }

    @Override
    public void deletePetition(String petitionId) throws AppExceptions {
        Petition petition = findPetition(petitionId);
        try {
            petitionRepository.deleteEntity(petition);
        } catch (Exception e) {
            throw new PetitionException(PetitionException.NOT_DELETED);
        }
    }

    @Override
    public List<Petition> findPetitions() throws AppExceptions {
        try {
            List<Petition> petition = petitionRepository.getPetitions();
            return petition;
        }catch (Exception e){
            throw new PetitionException(PetitionException.NOT_FOUND);
        }
    }
}
