package com.eci.ariendamesta.service;

import com.eci.ariendamesta.exceptions.AppExceptions;
import com.eci.ariendamesta.exceptions.UserException;
import com.eci.ariendamesta.model.Gender;
import com.eci.ariendamesta.model.User;
import com.eci.ariendamesta.model.dtos.UserRequestDTO;
import com.eci.ariendamesta.repository.repointerfaces.UserRepositoryInterface;
import com.eci.ariendamesta.service.impl.UserService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.ParseException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;


@SpringBootTest
public class UserServicesTest {

    @Mock
    private UserRepositoryInterface userRepository;

    @InjectMocks
    private UserService userService;

    @Test
    public void whenUserIsFoundByIdThenReturnUser() throws AppExceptions, ParseException {
        // ARRANGE
        User user = new User("1", "Prueba", "prueba@mail.com", "31", "12", "12/09/2022", Gender.MALE);
        when(userRepository.findById(user.getId())).thenReturn(Optional.of(user));
        // ACT
        User user1 = userService.findById(user.getId());
        // ASSERT
        assertEquals(user, user1);
    }


    @Test
    public void whenUserIsNotFoundByIdThenThrowException() throws ParseException {
        // ARRANGE
        User user = new User("1", "Prueba", "prueba@mail.com", "31", "12", "12/09/2022", Gender.MALE);
        when(userRepository.findById(user.getId())).thenReturn(Optional.empty());
        // ACT
        // ASSERT
        assertThrows(UserException.class, () -> userService.findById(user.getId()));
    }

    @Test
    public void whenUserIsCreatedAndDoesNotExistsThenReturnUser() throws AppExceptions, ParseException {
        // ARRANGE
        UserRequestDTO dto = new UserRequestDTO("1", "Prueba", "prueba@mail.com", "31", "12", "12/09/2022", Gender.MALE);
        User user = new User(dto);
        when(userRepository.findById(dto.getId())).thenReturn(Optional.empty());
        when(userRepository.save(any())).thenReturn(user);
        // ACT
        User user1 = userService.createUser(dto);
        // ASSERT
        assertEquals(user, user1);
    }

    @Test
    public void whenUserIsCreatedAndExistsThenThrowsException() throws ParseException {
        // ARRANGE
        UserRequestDTO dto = new UserRequestDTO("1", "Prueba", "prueba@mail.com", "31", "12", "12/09/2022", Gender.MALE);
        User user = new User(dto);
        when(userRepository.findById(dto.getId())).thenReturn(Optional.of(user));
        // ACT
        // ASSERT
        assertThrows(UserException.class, () -> userService.createUser(dto));
    }

    @Test
    public void whenUpdateUserAndFoundThenReturnUpdatedUser() throws AppExceptions, ParseException {
        // ARRANGE
        User user = new User("1", "Prueba", "prueba@mail.com", "31", "12", "12/09/2022",Gender.MALE);
        when(userRepository.findById(user.getId())).thenReturn(Optional.of(user));
        // ACT
        UserRequestDTO dto = new UserRequestDTO("id", "Pedro", "prueba@mail.com", "31", "12", "12/09/2022",Gender.MALE);
        User user1 = userService.updateUser("1", dto);
        // ASSERT
        assertEquals(user.getName(), user1.getName());
    }

    @Test
    public void whenUpdateUserAndNotFoundThenThrowException() throws ParseException {
        // ARRANGE
        User user = new User("1", "Prueba", "prueba@mail.com", "31", "12", "12/09/2022",Gender.MALE);
        when(userRepository.findById(user.getId())).thenReturn(Optional.empty());
        UserRequestDTO dto = new UserRequestDTO("id", "Pedro", "prueba@mail.com", "31", "12", "12/09/2022",Gender.MALE);
        // ACT
        // ASSERT
        assertThrows(UserException.class, () -> userService.updateUser("1", dto));
    }

    @Test
    public void whenDeleteUserAndFoundThenDeleteUser() throws AppExceptions, ParseException {
        User user = new User("1", "Prueba", "prueba@mail.com", "31", "12", "12/09/2022",Gender.MALE);
        when(userRepository.findById(user.getId())).thenReturn(Optional.of(user));
        userService.deleteUser(user.getId());
    }

    @Test
    public void whenDeleteUserAndNotFoundThenThrowException() throws AppExceptions, ParseException {
        when(userRepository.findById("1")).thenReturn(Optional.empty());
        assertThrows(UserException.class, () -> userService.deleteUser("1"));
    }


    /*



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