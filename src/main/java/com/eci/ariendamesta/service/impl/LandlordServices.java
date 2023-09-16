package com.eci.ariendamesta.service.impl;

import com.eci.ariendamesta.exceptions.UserException;
import com.eci.ariendamesta.model.landlord.Landlord;
import com.eci.ariendamesta.model.landlord.LandlordDto;
import com.eci.ariendamesta.repository.LandlordRepositoryInterface;
import com.eci.ariendamesta.service.LandlordServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LandlordServices implements LandlordServiceInterface {

    LandlordRepositoryInterface landlordRepository;

    public LandlordServices(@Autowired LandlordRepositoryInterface landlordRepository) {
        this.landlordRepository = landlordRepository;
    }

    @Override
    public Landlord foundById(String idLandlord) throws UserException {
        Optional<Landlord> landlord = landlordRepository.findById(idLandlord);
        if (landlord.isPresent()) {
            return landlord.get();
        }
        throw new UserException(UserException.NOT_FOUND);
    }


    @Override
    public Landlord createLandlord(Landlord landlord) throws UserException {
        if(landlordRepository.findById(landlord.getId()).isEmpty()) {
            landlordRepository.save(landlord);
            return foundById(landlord.getId());
        }
        throw new UserException(UserException.NOT_CREATED);
    }

    @Override
    public Landlord updateLandlord(String idLandlord, LandlordDto landlordBody) throws UserException {
        Landlord landlord = foundById(idLandlord);
        try {
            landlord.update(landlordBody);
            landlordRepository.save(landlord);
            return foundById(idLandlord);
        } catch (Exception e) {
            throw new UserException(UserException.NOT_UPDATE);
        }
    }

    @Override
    public void deleteLandlord(String idLandlord) throws UserException {
        Landlord landlord = foundById(idLandlord);
        try {
            landlordRepository.deleteEntity(landlord);
        } catch (Exception e) {
            throw new UserException(UserException.NOT_DELETE);
        }
    }
}
