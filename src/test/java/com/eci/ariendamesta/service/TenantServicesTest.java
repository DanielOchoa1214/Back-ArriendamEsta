package com.eci.ariendamesta.service;

import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TenantServicesTest {
/*
    @Mock
    TenantRepositoryInterface tenantRepository;

    @Mock
    LandlordRepositoryInterface landlordRepository;

    @InjectMocks
    TenantServices tenantService;

    @Test
    public void whenTenantIsFoundByIdAndExistThenReturnTenant() throws AppExceptions {
        //Arrange
        HomeRenter tenant = new HomeRenter("1", "test","test@gmail.com", "1234", "1234", "18", Gender.MALE);
        when(tenantRepository.findById(tenant.getId())).thenReturn(Optional.of(tenant));
        //Act
        HomeRenter tenantTest = tenantService.foundById(tenant.getId());
        //Assert
        Assertions.assertEquals(tenant, tenantTest);
    }

    @Test
    public void whenTenantNotExistThenThrowException() {
        Assertions.assertThrowsExactly(UserException.class,() -> {
            //Arrange
            when(tenantRepository.findById("2")).thenReturn(Optional.empty());
            //Act
            HomeRenter tenantTest = tenantService.foundById("2");
            //Assert
        });
    }

    @Test
    public void whenTenantIsCreatedAndNotExistThenReturnTenant() throws AppExceptions {
        //Arrange
        HomeRenter tenant = new HomeRenter("1", "test","test@gmail.com", "1234", "1234", "18", Gender.MALE);
        when(tenantRepository.findById(tenant.getId())).thenReturn(Optional.empty()).thenReturn(Optional.of(tenant));
        //Act
        HomeRenter tenantTest = tenantService.createTenant(tenant);
        //Assert
        Assertions.assertEquals(tenant, tenantTest);
    }

    @Test
    public void whenTenantCreatedAndExistThenThrowException() {
        Assertions.assertThrowsExactly(UserException.class,() -> {
            //Arrange
            HomeRenter tenant = new HomeRenter("1", "test","test@gmail.com", "1234", "1234", "18", Gender.MALE);
            when(tenantRepository.findById("1")).thenReturn(Optional.of(tenant));
            //Act
            HomeRenter tenantTest = tenantService.createTenant(tenant);
            //Assert
        });
    }

    @Test
    public void whenUpdateTenantAndExistThenReturnTenant() throws AppExceptions {
        //Arrange
        HomeRenter tenant = new HomeRenter("1", "test","test@gmail.com", "1234", "1234", "18", Gender.MALE);
        TenantDto tenantDto = new TenantDto("newTest", "test@gmail.com", "12345", "1234", "18", Gender.MALE);
        when(tenantRepository.findById(tenant.getId())).thenReturn(Optional.of(tenant));
        //Act
        HomeRenter tenantTest = tenantService.updateTenant(tenant.getId(), tenantDto);
        //Assert
        Assertions.assertEquals(tenantDto.getName(), tenant.getName());
        Assertions.assertEquals(tenantDto.getPassword(), tenant.getPassword());
    }

    @Test
    public void whenUpdateTenantAndNotExistThenThrowException() {
        Assertions.assertThrowsExactly(UserException.class,() -> {
            //Arrange
            HomeRenter tenant = new HomeRenter("1", "test","test@gmail.com", "1234", "1234", "18", Gender.MALE);
            TenantDto tenantDto = new TenantDto("newTest", "test@gmail.com", "12345", "1234", "18", Gender.MALE);
            when(tenantRepository.findById("1")).thenReturn(Optional.empty());
            //Act
            HomeRenter tenantTest = tenantService.updateTenant(tenant.getId(), tenantDto);
            //Assert
        });
    }

    @Test
    public void whenDeletedTenantAndExistThenReturnNothing() throws AppExceptions {
        //Arrange
        HomeRenter tenant = new HomeRenter("1", "test","test@gmail.com", "1234", "1234", "18", Gender.MALE);
        when(tenantRepository.findById(tenant.getId())).thenReturn(Optional.of(tenant));
        //Act
        tenantService.foundById(tenant.getId());
        //Assert
    }

    @Test
    public void whenDeleteTenantAndNotExistThenThrowException() {
        Assertions.assertThrowsExactly(UserException.class,() -> {
            //Arrange
            HomeRenter tenant = new HomeRenter("1", "test","test@gmail.com", "1234", "1234", "18", Gender.MALE);
            when(tenantRepository.findById("1")).thenReturn(Optional.empty());
            //Act
            tenantService.deleteTenant(tenant.getId());
            //Assert
        });
    }

    @Test
    public void whenGetReviewAndReviewExistAndTenantExistThenReturnReview() throws AppExceptions {
        //Arrange
        HomeRenter tenant = new HomeRenter("1", "test","test@gmail.com", "1234", "1234", "18", Gender.MALE);
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
        HomeRenter tenant = new HomeRenter("1", "test","test@gmail.com", "1234", "1234", "18", Gender.MALE);
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
            HomeRenter tenant = new HomeRenter("1", "test","test@gmail.com", "1234", "1234", "18", Gender.MALE);
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
        HomeRenter tenant = new HomeRenter("1", "test","test@gmail.com", "1234", "1234", "18", Gender.MALE);
        HomeOwner landlord = new HomeOwner("1", "test","test@gmail.com", "1234", "1234", "18", Gender.FEMALE);
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
            HomeRenter tenant = new HomeRenter("1", "test","test@gmail.com", "1234", "1234", "18", Gender.MALE);
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
            HomeRenter tenant = new HomeRenter("1", "test","test@gmail.com", "1234", "1234", "18", Gender.MALE);
            HomeOwner landlord = new HomeOwner("1", "test","test@gmail.com", "1234", "1234", "18", Gender.FEMALE);
            Review review = new Review("1", "sikas", 3, "1");
            when(tenantRepository.findById(tenant.getId())).thenReturn(Optional.of(tenant));
            when(landlordRepository.findById(landlord.getId())).thenReturn(Optional.empty());
            //Act
            Optional<Review> review1 = tenantService.postReview(review, tenant.getId());
            //Assert
        });
    }*/

}
