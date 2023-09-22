package com.eci.ariendamesta.service;

import com.eci.ariendamesta.exceptions.AppExceptions;
import com.eci.ariendamesta.exceptions.ReviewException;
import com.eci.ariendamesta.exceptions.UserException;
import com.eci.ariendamesta.model.Gender;
import com.eci.ariendamesta.model.Review;
import com.eci.ariendamesta.model.landlord.Landlord;
import com.eci.ariendamesta.model.tenant.Tenant;
import com.eci.ariendamesta.model.tenant.TenantDto;
import com.eci.ariendamesta.repository.LandlordRepositoryInterface;
import com.eci.ariendamesta.repository.TenantRepositoryInterface;
import com.eci.ariendamesta.service.impl.TenantServices;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.mockito.Mockito.*;

@SpringBootTest
public class TenantServicesTest {

    @Mock
    TenantRepositoryInterface tenantRepository;

    @Mock
    LandlordRepositoryInterface landlordRepository;

    @InjectMocks
    TenantServices tenantService;

    @Test
    public void whenTenantIsFoundByIdAndExistThenReturnTenant() throws AppExceptions {
        //Arrange
        Tenant tenant = new Tenant("1", "test","test@gmail.com", "1234", "1234", "18", Gender.MALE);
        when(tenantRepository.findById(tenant.getId())).thenReturn(Optional.of(tenant));
        //Act
        Tenant tenantTest = tenantService.foundById(tenant.getId());
        //Assert
        Assertions.assertEquals(tenant, tenantTest);
    }

    @Test
    public void whenTenantNotExistThenThrowException() {
        Assertions.assertThrowsExactly(UserException.class,() -> {
            //Arrange
            when(tenantRepository.findById("2")).thenReturn(Optional.empty());
            //Act
            Tenant tenantTest = tenantService.foundById("2");
            //Assert
        });
    }

    @Test
    public void whenTenantIsCreatedAndNotExistThenReturnTenant() throws AppExceptions {
        //Arrange
        Tenant tenant = new Tenant("1", "test","test@gmail.com", "1234", "1234", "18", Gender.MALE);
        when(tenantRepository.findById(tenant.getId())).thenReturn(Optional.empty()).thenReturn(Optional.of(tenant));
        //Act
        Tenant tenantTest = tenantService.createTenant(tenant);
        //Assert
        Assertions.assertEquals(tenant, tenantTest);
    }

    @Test
    public void whenTenantCreatedAndExistThenThrowException() {
        Assertions.assertThrowsExactly(UserException.class,() -> {
            //Arrange
            Tenant tenant = new Tenant("1", "test","test@gmail.com", "1234", "1234", "18", Gender.MALE);
            when(tenantRepository.findById("1")).thenReturn(Optional.of(tenant));
            //Act
            Tenant tenantTest = tenantService.createTenant(tenant);
            //Assert
        });
    }

    @Test
    public void whenUpdateTenantAndExistThenReturnTenant() throws AppExceptions {
        //Arrange
        Tenant tenant = new Tenant("1", "test","test@gmail.com", "1234", "1234", "18", Gender.MALE);
        TenantDto tenantDto = new TenantDto("newTest", "test@gmail.com", "12345", "1234", "18", Gender.MALE);
        when(tenantRepository.findById(tenant.getId())).thenReturn(Optional.of(tenant));
        //Act
        Tenant tenantTest = tenantService.updateTenant(tenant.getId(), tenantDto);
        //Assert
        Assertions.assertEquals(tenantDto.getName(), tenant.getName());
        Assertions.assertEquals(tenantDto.getPassword(), tenant.getPassword());
    }

    @Test
    public void whenUpdateTenantAndNotExistThenThrowException() {
        Assertions.assertThrowsExactly(UserException.class,() -> {
            //Arrange
            Tenant tenant = new Tenant("1", "test","test@gmail.com", "1234", "1234", "18", Gender.MALE);
            TenantDto tenantDto = new TenantDto("newTest", "test@gmail.com", "12345", "1234", "18", Gender.MALE);
            when(tenantRepository.findById("1")).thenReturn(Optional.empty());
            //Act
            Tenant tenantTest = tenantService.updateTenant(tenant.getId(), tenantDto);
            //Assert
        });
    }

    @Test
    public void whenDeletedTenantAndExistThenReturnNothing() throws AppExceptions {
        //Arrange
        Tenant tenant = new Tenant("1", "test","test@gmail.com", "1234", "1234", "18", Gender.MALE);
        when(tenantRepository.findById(tenant.getId())).thenReturn(Optional.of(tenant));
        //Act
        tenantService.foundById(tenant.getId());
        //Assert
    }

    @Test
    public void whenDeleteTenantAndNotExistThenThrowException() {
        Assertions.assertThrowsExactly(UserException.class,() -> {
            //Arrange
            Tenant tenant = new Tenant("1", "test","test@gmail.com", "1234", "1234", "18", Gender.MALE);
            when(tenantRepository.findById("1")).thenReturn(Optional.empty());
            //Act
            tenantService.deleteTenant(tenant.getId());
            //Assert
        });
    }

    @Test
    public void whenGetReviewAndReviewExistAndTenantExistThenReturnReview() throws AppExceptions {
        //Arrange
        Tenant tenant = new Tenant("1", "test","test@gmail.com", "1234", "1234", "18", Gender.MALE);
        Review review = new Review("1", "sikas", 3, "1");
        tenant.addReview(review);
        when(tenantRepository.findById(tenant.getId())).thenReturn(Optional.of(tenant));
        //Act
        Optional<Review> review1 = tenantService.getReview(tenant.getId(), review.getId());
        //Assert
        Assertions.assertEquals(Optional.of(review), review1);
    }

    @Test
    public void whenGetReviewAndReviewNotExistAndTenantExistThenReturnOptionalEmpty() throws AppExceptions {
        //Arrange
        Tenant tenant = new Tenant("1", "test","test@gmail.com", "1234", "1234", "18", Gender.MALE);
        when(tenantRepository.findById(tenant.getId())).thenReturn(Optional.of(tenant));
        //Act
        Optional<Review> review1 = tenantService.getReview(tenant.getId(), "1");
        //Assert
        Assertions.assertEquals(Optional.empty(), review1);
    }

    @Test
    public void whenGetReviewAndTenantNotExistThrowException() {
        Assertions.assertThrowsExactly(ReviewException.class,() -> {
            //Arrange
            Tenant tenant = new Tenant("1", "test","test@gmail.com", "1234", "1234", "18", Gender.MALE);
            Review review = new Review("1", "sikas", 3, "1");
            tenant.addReview(review);
            when(tenantRepository.findById("1")).thenReturn(Optional.empty());
            //Act
            Optional<Review> review1 = tenantService.getReview(tenant.getId(), review.getId());
            //Assert
        });
    }

    @Test
    public void whenPostReviewAndReviewNotExistAndTenantExistAndLandlordExistThenReturnReview() throws AppExceptions {
        //Arrange
        Tenant tenant = new Tenant("1", "test","test@gmail.com", "1234", "1234", "18", Gender.MALE);
        Landlord landlord = new Landlord("1", "test","test@gmail.com", "1234", "1234", "18", Gender.FEMALE);
        Review review = new Review("1", "sikas", 3, "1");
        when(tenantRepository.findById(tenant.getId())).thenReturn(Optional.of(tenant));
        when(landlordRepository.findById(landlord.getId())).thenReturn(Optional.of(landlord));
        //Act
        Optional<Review> review1 = tenantService.postReview(review, tenant.getId());
        //Assert
        Assertions.assertEquals(Optional.of(review), review1);
    }

    @Test
    public void whenPostReviewAndTenantNotExistAndLandlordExistThenThrowException() {
        Assertions.assertThrowsExactly(UserException.class,() -> {
            //Arrange
            Tenant tenant = new Tenant("1", "test","test@gmail.com", "1234", "1234", "18", Gender.MALE);
            Review review = new Review("1", "sikas", 3, "1");
            when(tenantRepository.findById("1")).thenReturn(Optional.empty());
            //Act
            Optional<Review> review1 = tenantService.postReview(review, tenant.getId());
            //Assert
        });
    }

    @Test
    public void whenPostReviewAndLandlordNotExistThenThrowException() {
        Assertions.assertThrowsExactly(ReviewException.class,() -> {
            //Arrange
            Tenant tenant = new Tenant("1", "test","test@gmail.com", "1234", "1234", "18", Gender.MALE);
            Landlord landlord = new Landlord("1", "test","test@gmail.com", "1234", "1234", "18", Gender.FEMALE);
            Review review = new Review("1", "sikas", 3, "1");
            when(tenantRepository.findById(tenant.getId())).thenReturn(Optional.of(tenant));
            when(landlordRepository.findById(landlord.getId())).thenReturn(Optional.empty());
            //Act
            Optional<Review> review1 = tenantService.postReview(review, tenant.getId());
            //Assert
        });
    }

}
