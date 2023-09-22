package com.eci.ariendamesta.service;

import com.eci.ariendamesta.exceptions.AppExceptions;
import com.eci.ariendamesta.exceptions.ReviewException;
import com.eci.ariendamesta.exceptions.UserException;
import com.eci.ariendamesta.model.Gender;
import com.eci.ariendamesta.model.Review;
import com.eci.ariendamesta.model.landlord.Landlord;
import com.eci.ariendamesta.model.landlord.LandlordDto;
import com.eci.ariendamesta.model.tenant.Tenant;
import com.eci.ariendamesta.repository.impl.LocalLandlordRepository;
import com.eci.ariendamesta.repository.impl.LocalTenantRepository;
import com.eci.ariendamesta.repository.impl.MongoLandlordRepository;
import com.eci.ariendamesta.service.impl.LandlordServices;
import org.apache.catalina.User;
import org.junit.jupiter.api.Assertions;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
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

    @Mock
    private LocalTenantRepository tenantRepository;

    @InjectMocks
    private LandlordServices landlordServices;

    @Test
    public void whenLandlordIsFoundByIdThenReturnLandlord() throws AppExceptions {
        Landlord landlord = new Landlord("1", "Prueba", "prueba@mail.com", "31", "12", "12",Gender.MALE);
        when(landlordRepository.findById(landlord.getId())).thenReturn(Optional.of(landlord));
        Landlord landlord1 = landlordServices.foundById(landlord.getId());
        assertEquals(landlord, landlord1);
    }

    @Test
    public void whenLandlordIsCreatedThenReturnLandlord() throws AppExceptions {
        Landlord landlord = new Landlord("1", "Prueba", "prueba@mail.com", "31", "12", "12",Gender.MALE);
        when(landlordRepository.findById(landlord.getId())).thenReturn(Optional.empty()).thenReturn(Optional.of(landlord));
        Landlord landlord1 = landlordServices.createLandlord(landlord);
        assertEquals(landlord, landlord1);
    }

    @Test
    public void whenUpdateLandlordAndFoundThenReturnUpdatedLandlord() throws AppExceptions {
        Landlord landlord = new Landlord("1", "Prueba", "prueba@mail.com", "31", "12", "12",Gender.MALE);
        when(landlordRepository.findById(landlord.getId())).thenReturn(Optional.of(landlord));
        LandlordDto landlordDto = new LandlordDto("Pedro", "prueba@mail.com", "31", "12", "12",Gender.MALE);
        Landlord landlord1 = landlordServices.updateLandlord("1", landlordDto);
        assertEquals(landlord.getName(), landlord1.getName());
    }

    @Test
    public void whenDeleteLandlorAndLandlordFoundThenDeleteLandlord() throws AppExceptions {
        Landlord landlord = new Landlord("1", "Prueba", "prueba@mail.com", "31", "12", "12",Gender.MALE);
        when(landlordRepository.findById(landlord.getId())).thenReturn(Optional.of(landlord));
        landlordServices.deleteLandlord(landlord.getId());
    }

    @Test
    public void whenGetReviewAndLandlordFoundThenReturnReview() throws AppExceptions{
        Landlord landlord = new Landlord("1", "Prueba", "prueba@mail.com", "31", "12", "12",Gender.MALE);
        Review review = new Review("1", "content prueba", 5, "1");
        landlord.addReview(review);
        when(landlordRepository.findById(landlord.getId())).thenReturn(Optional.of(landlord));
        Optional<Review> review1 = landlordServices.getReview("1", "1");
        assertEquals(review, review1.get());
    }

    @Test
    public void whenPostReviewAndLandlordFoundThenReturnReview() throws AppExceptions {
        Landlord landlord = new Landlord("1", "Prueba", "prueba@mail.com", "31", "12", "12",Gender.MALE);
        Tenant tenant = new Tenant("1", "PruebaTenant", "pruebat@mail.com", "32", "11", "13",Gender.MALE);
        Review review = new Review("1", "content prueba", 5, "1");
        landlord.addReview(review);
        when(landlordRepository.findById(landlord.getId())).thenReturn(Optional.of(landlord));
        when(tenantRepository.findById(tenant.getId())).thenReturn(Optional.of(tenant));
        Optional<Review> review1 = landlordServices.postReview(review, "1");
        assertEquals(review, review1.get());
    }

    @Test
    public void whenLandlordIsnotFoundThenReturnException(){
        Assertions.assertThrowsExactly(UserException.class, () ->{
            when(landlordRepository.findById("pruebafail")).thenReturn(Optional.empty());
            Landlord landlord = landlordServices.foundById("pruebafail");
        });
    }

    @Test
    public void whenLandlordIsFoundAndCreateLandlordThenReturnException(){
        Assertions.assertThrowsExactly(UserException.class, () ->{
            Landlord landlord = new Landlord("1", "Prueba", "prueba@mail.com", "31", "12", "12",Gender.MALE);
            when(landlordRepository.findById("1")).thenReturn(Optional.of(landlord));
            Landlord landlord1 = landlordServices.createLandlord(landlord);
        });
    }

    @Test
    public void whenUpdateLandlordAndIsNotFoundThenReturnException(){
        Assertions.assertThrowsExactly(UserException.class, () -> {
            when(landlordRepository.findById("pruebafail")).thenReturn(Optional.empty());
            LandlordDto landlordDto = new LandlordDto("Prueba", "prueba@mail.com", "31", "12", "12",Gender.MALE);
            Landlord landlord = landlordServices.updateLandlord("1", landlordDto);
        });
    }

    @Test
    public void whenDeleteLandlordAndLandlordNotFoundThenReturnException(){
        Assertions.assertThrowsExactly(UserException.class, () -> {
            when(landlordRepository.findById("pruebafail")).thenReturn(Optional.empty());
            landlordServices.deleteLandlord("pruebafail");
        });
    }

    @Test
    public void whenGetReviewAndLandlordNotFoundThenReturnException(){
        Assertions.assertThrowsExactly(ReviewException.class, () -> {
            when(landlordRepository.findById("pruebafail")).thenReturn(Optional.empty());
            Optional<Review> review = landlordServices.getReview("pruebafail", "id");
        });
    }

    @Test
    public void whenPostReviewAndLanlordNotFoundReturnException(){
        Assertions.assertThrowsExactly(UserException.class, () -> {
            when(landlordRepository.findById("pruebafail")).thenReturn(Optional.empty());
            when(tenantRepository.findById("pruebatenant")).thenReturn(Optional.empty());
            Review review = new Review("1", "content prueba", 5, "pruebatenant");
            Optional<Review> review1 = landlordServices.postReview(review, "pruebafail");
        });
    }

}