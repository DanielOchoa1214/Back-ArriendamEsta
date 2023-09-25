package com.eci.ariendamesta.service;

import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class LandlordServicesTest {

    /*@Mock
    private LocalLandlordRepository landlordRepository;

    @Mock
    private LocalTenantRepository tenantRepository;

    @InjectMocks
    private LandlordServices landlordServices;

    @Test
    public void whenLandlordIsFoundByIdThenReturnLandlord() throws AppExceptions {
        HomeOwner landlord = new HomeOwner("1", "Prueba", "prueba@mail.com", "31", "12", "12",Gender.MALE);
        when(landlordRepository.findById(landlord.getId())).thenReturn(Optional.of(landlord));
        HomeOwner landlord1 = landlordServices.foundById(landlord.getId());
        assertEquals(landlord, landlord1);
    }

    @Test
    public void whenLandlordIsCreatedThenReturnLandlord() throws AppExceptions {
        HomeOwner landlord = new HomeOwner("1", "Prueba", "prueba@mail.com", "31", "12", "12",Gender.MALE);
        when(landlordRepository.findById(landlord.getId())).thenReturn(Optional.empty()).thenReturn(Optional.of(landlord));
        HomeOwner landlord1 = landlordServices.createLandlord(landlord);
        assertEquals(landlord, landlord1);
    }

    @Test
    public void whenUpdateLandlordAndFoundThenReturnUpdatedLandlord() throws AppExceptions {
        HomeOwner landlord = new HomeOwner("1", "Prueba", "prueba@mail.com", "31", "12", "12",Gender.MALE);
        when(landlordRepository.findById(landlord.getId())).thenReturn(Optional.of(landlord));
        HomeOwnerDto landlordDto = new HomeOwnerDto("Pedro", "prueba@mail.com", "31", "12", "12",Gender.MALE);
        HomeOwner landlord1 = landlordServices.updateLandlord("1", landlordDto);
        assertEquals(landlord.getName(), landlord1.getName());
    }

    @Test
    public void whenDeleteLandlorAndLandlordFoundThenDeleteLandlord() throws AppExceptions {
        HomeOwner landlord = new HomeOwner("1", "Prueba", "prueba@mail.com", "31", "12", "12",Gender.MALE);
        when(landlordRepository.findById(landlord.getId())).thenReturn(Optional.of(landlord));
        landlordServices.deleteLandlord(landlord.getId());
    }

    @Test
    public void whenGetReviewAndLandlordFoundThenReturnReview() throws AppExceptions{
        HomeOwner landlord = new HomeOwner("1", "Prueba", "prueba@mail.com", "31", "12", "12",Gender.MALE);
        Review review = new Review("1", "content prueba", 5, "1");
        landlord.addReview(review);
        when(landlordRepository.findById(landlord.getId())).thenReturn(Optional.of(landlord));
        Optional<Review> review1 = landlordServices.getReview("1", "1");
        assertEquals(review, review1.get());
    }

    @Test
    public void whenPostReviewAndLandlordFoundThenReturnReview() throws AppExceptions {
        HomeOwner landlord = new HomeOwner("1", "Prueba", "prueba@mail.com", "31", "12", "12",Gender.MALE);
        HomeRenter tenant = new HomeRenter("1", "PruebaTenant", "pruebat@mail.com", "32", "11", "13",Gender.MALE);
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
            HomeOwner landlord = landlordServices.foundById("pruebafail");
        });
    }

    @Test
    public void whenLandlordIsFoundAndCreateLandlordThenReturnException(){
        Assertions.assertThrowsExactly(UserException.class, () ->{
            HomeOwner landlord = new HomeOwner("1", "Prueba", "prueba@mail.com", "31", "12", "12",Gender.MALE);
            when(landlordRepository.findById("1")).thenReturn(Optional.of(landlord));
            HomeOwner landlord1 = landlordServices.createLandlord(landlord);
        });
    }

    @Test
    public void whenUpdateLandlordAndIsNotFoundThenReturnException(){
        Assertions.assertThrowsExactly(UserException.class, () -> {
            when(landlordRepository.findById("pruebafail")).thenReturn(Optional.empty());
            HomeOwnerDto landlordDto = new HomeOwnerDto("Prueba", "prueba@mail.com", "31", "12", "12",Gender.MALE);
            HomeOwner landlord = landlordServices.updateLandlord("1", landlordDto);
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
    }*/

}