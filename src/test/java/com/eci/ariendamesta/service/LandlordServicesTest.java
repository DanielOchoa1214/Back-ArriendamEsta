package com.eci.ariendamesta.service;

import com.eci.ariendamesta.exceptions.AppExceptions;
import com.eci.ariendamesta.exceptions.UserException;
import com.eci.ariendamesta.model.Gender;
import com.eci.ariendamesta.model.User;
import com.eci.ariendamesta.model.landlord.Landlord;
import com.eci.ariendamesta.repository.impl.LocalLandlordRepository;
import com.eci.ariendamesta.repository.impl.MongoLandlordRepository;
import com.eci.ariendamesta.service.impl.LandlordServices;
import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
public class LandlordServicesTest {

    @Mock
    private LocalLandlordRepository landlordRepository;

    @InjectMocks
    private LandlordServices landlordServices;

    @Test
    public void whenLandlordIsFoundByIdThenReturnLandlord() throws AppExceptions {
        Landlord landlord = new Landlord("1", "Prueba", "prueba@mail.com", "31", "12", "12",Gender.MALE);
        when(landlordRepository.findById("1")).thenReturn(Optional.of(landlord));
        Landlord landlord1 = landlordServices.foundById("1");
        assertEquals(landlord, landlord1);
    }

    /*@Test
    public void whenLandlordIsCreatedThenReturnLandlord() throws AppExceptions {
        Landlord landlord = new Landlord("1", "Prueba", "prueba@mail.com", "31", "12", "12",Gender.MALE);
        when(landlordRepository.save(landlord)).thenReturn(landlord);
        Landlord landlord1 = landlordServices.foundById(landlord.getId());
        assertEquals(landlord, landlord1);
    }*/
}