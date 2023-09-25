package com.eci.ariendamesta.service;

import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class StateServicesTest {

    /*@Mock
    LandlordRepositoryInterface landlordRepository;
    @Mock
    TenantRepositoryInterface tenantRepository;
    @Mock
    PublicationRepositoryInterface publicationRepository;
    @InjectMocks
    EstateServices estateServices;

    @Test
    public void whenStateIsFoundByIdAndExistThenReturnState() throws AppExceptions {
        //Arrange
        HomeOwner landlord = new HomeOwner("1","test","test@gmail.com","1234","1234","18",Gender.MALE);
        Property estate = new Property("1","lugar Bonito",3000000,"el mejor lugar del mundo",300,"conjuntoBonito");
        when(landlordRepository.findById("1")).thenReturn(Optional.of(landlord));
        landlord.addEstate(estate);
        //Act
        Property EstateTest = estateServices.getEstate(estate.getId(), landlord);
        //Assert
        Assertions.assertEquals(estate, EstateTest);
    }
    @Test
    public void whenStateNotExistThenThrowException() {
        Assertions.assertThrowsExactly(EstateException.class,() -> {
            //Arrange
            HomeOwner landlord = new HomeOwner("1","test","test@gmail.com","1234","1234","18",Gender.MALE);
            Property estate = new Property("1","lugar Bonito",3000000,"el mejor lugar del mundo",300,"conjuntoBonito");
            when(landlordRepository.findById("1")).thenReturn(Optional.of(landlord));
            //Act
            Property EstateTest = estateServices.getEstate(estate.getId(), landlord);
            //Assert
        });
    }
    @Test
    public void whenStateIsCreatedAndNotExistThenReturnState() throws AppExceptions {
        //Arrange
        HomeOwner landlord = new HomeOwner("1","test","test@gmail.com","1234","1234","18",Gender.MALE);
        Property estate = new Property("2","lugar Bonito",3000000,"el mejor lugar del mundo",300,"conjuntoBonito");
        when(landlordRepository.findById("1")).thenReturn(Optional.of(landlord));
        //Act
        Property EstateTest = estateServices.createEstate(estate, landlord);
        //Assert
        Assertions.assertEquals(estate, EstateTest);
    }
    @Test
    public void whenStateIsCreatedAndExistThenReturnState() throws AppExceptions {
        Assertions.assertThrowsExactly(EstateException.class,() -> {
            //Arrange
            HomeOwner landlord = new HomeOwner("1","test","test@gmail.com","1234","1234","18",Gender.MALE);
            Property estate = new Property("2","lugar Bonito",3000000,"el mejor lugar del mundo",300,"conjuntoBonito");
            when(landlordRepository.findById("1")).thenReturn(Optional.of(landlord));
            landlord.addEstate(estate);
            //Act
            Property EstateTest = estateServices.createEstate(estate, landlord);
            //Assert
        });
    }
    @Test
    public void whenUpdateStateAndExistThenReturnTenant() throws AppExceptions {
        //Arrange
        HomeOwner landlord = new HomeOwner("1","test","test@gmail.com","1234","1234","18",Gender.MALE);
        Property estate = new Property("2","lugar Bonito",3000000,"el mejor lugar del mundo",300,"conjuntoBonito");
        when(landlordRepository.findById("1")).thenReturn(Optional.of(landlord));
        landlord.addEstate(estate);
        //
        PropertyDto estateDto = new PropertyDto(1500000,"casa","ssss");
        Optional<Property> estateOptional = landlord.getEstate(estate.getId());
        Property estate1 = estateOptional.get();
        estate1.update(estateDto);
        //Act
        Property EstateTest = estateServices.updateEstate(estate.getId(), estateDto, landlord);
        //Assert
        Assertions.assertEquals(estateDto.getPrice(), estate1.getPrice());
    }
    @Test
    public void whenUpdateStateAndNotExistThenReturnTenant() throws AppExceptions {
        Assertions.assertThrowsExactly(EstateException.class,() -> {
            //Arrange
            PropertyDto estateDto = new PropertyDto(1500000,"casa","ssss");
            HomeOwner landlord = new HomeOwner("1","test","test@gmail.com","1234","1234","18",Gender.MALE);
            Property estate = new Property("2","lugar Bonito",3000000,"el mejor lugar del mundo",300,"conjuntoBonito");
            when(landlordRepository.findById("1")).thenReturn(Optional.of(landlord));
            landlord.addEstate(estate);
            //Act
            Property EstateTest = estateServices.updateEstate("10", estateDto, landlord);
            //Assert
        });
    }
    @Test
    public void whenDeletedStateAndExistThenReturnNothing() throws AppExceptions {
        //Arrange
        HomeOwner landlord = new HomeOwner("1","test","test@gmail.com","1234","1234","18",Gender.MALE);
        Property estate = new Property("2","lugar Bonito",3000000,"el mejor lugar del mundo",300,"conjuntoBonito");
        when(landlordRepository.findById("1")).thenReturn(Optional.of(landlord));
        landlord.addEstate(estate);
        //Act
        estateServices.deleteEstate("2", landlord);
        //Assert
    }
    @Test
    public void whenDeletedStateAndNotExistThenReturnException() throws AppExceptions {
        Assertions.assertThrowsExactly(EstateException.class,() -> {
            //Arrange
            HomeOwner landlord = new HomeOwner("1","test","test@gmail.com","1234","1234","18",Gender.MALE);
            Property estate = new Property("2","lugar Bonito",3000000,"el mejor lugar del mundo",300,"conjuntoBonito");
            when(landlordRepository.findById("1")).thenReturn(Optional.of(landlord));
            //Act
            estateServices.deleteEstate("2", landlord);
            //Assert
        });
    }
    @Test
    public void whenReviewExistThenReturnReview() throws AppExceptions {
        //Arrange
        HomeOwner landlord = new HomeOwner("1","test","test@gmail.com","1234","1234","18",Gender.MALE);
        Property estate = new Property("2","lugar Bonito",3000000,"el mejor lugar del mundo",300,"conjuntoBonito");
        Review review = new Review("1", "sikas", 3, "1");
        when(landlordRepository.findById("1")).thenReturn(Optional.of(landlord));
        estate.addReview(review);
        landlord.addEstate(estate);
        //Act
        Optional<Review> review1 = estateServices.getReview("1",landlord,estate.getId());
        //Assert
        Assertions.assertEquals(review, review1.get());
    }
    @Test
    public void whenReviewNotExistThenReturnException() throws AppExceptions {
        Assertions.assertThrowsExactly(ReviewException.class,() -> {
            //Arrange
            HomeOwner landlord = new HomeOwner("1","test","test@gmail.com","1234","1234","18",Gender.MALE);
            Property estate = new Property("2","lugar Bonito",3000000,"el mejor lugar del mundo",300,"conjuntoBonito");
            Review review = new Review("1", "sikas", 3, "1");
            when(landlordRepository.findById("1")).thenReturn(Optional.of(landlord));
            landlord.addEstate(estate);
            //Act
            Optional<Review> review1 = estateServices.getReview("1",landlord,estate.getId());
            //Assert
        });
    }
    @Test
    public void whenPostReviewNotExistThenReturnReview() throws AppExceptions {
        Assertions.assertThrowsExactly(ReviewException.class,() -> {
            //Arrange
            HomeOwner landlord = new HomeOwner("1","test","test@gmail.com","1234","1234","18",Gender.MALE);
            Property estate = new Property("2","lugar Bonito",3000000,"el mejor lugar del mundo",300,"conjuntoBonito");
            Review review = new Review("1", "sikas", 3, "1");
            when(landlordRepository.findById("1")).thenReturn(Optional.of(landlord));
            landlord.addEstate(estate);
            //Act
            Optional<Review> review1 = estateServices.postReview(review,landlord,estate.getId());
            //Assert
        });
    }
*/
}
