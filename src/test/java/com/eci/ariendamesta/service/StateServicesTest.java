package com.eci.ariendamesta.service;

import com.eci.ariendamesta.exceptions.AppExceptions;
import com.eci.ariendamesta.exceptions.EstateException;
import com.eci.ariendamesta.exceptions.ReviewException;
import com.eci.ariendamesta.exceptions.UserException;
import com.eci.ariendamesta.model.Gender;
import com.eci.ariendamesta.model.Review;
import com.eci.ariendamesta.model.estate.Estate;
import com.eci.ariendamesta.model.estate.EstateDto;
import com.eci.ariendamesta.model.landlord.Landlord;
import com.eci.ariendamesta.model.tenant.Tenant;
import com.eci.ariendamesta.model.tenant.TenantDto;
import com.eci.ariendamesta.repository.LandlordRepositoryInterface;
import com.eci.ariendamesta.repository.PublicationRepositoryInterface;
import com.eci.ariendamesta.repository.TenantRepositoryInterface;
import com.eci.ariendamesta.service.impl.EstateServices;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.mockito.Mockito.when;

@SpringBootTest
public class StateServicesTest {

    @Mock
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
        Landlord landlord = new Landlord("1","test","test@gmail.com","1234","1234","18",Gender.MALE);
        Estate estate = new Estate("1","lugar Bonito",3000000,"el mejor lugar del mundo",300,"conjuntoBonito");
        when(landlordRepository.findById("1")).thenReturn(Optional.of(landlord));
        landlord.addEstate(estate);
        //Act
        Estate EstateTest = estateServices.getEstate(estate.getId(), landlord);
        //Assert
        Assertions.assertEquals(estate, EstateTest);
    }
    @Test
    public void whenStateNotExistThenThrowException() {
        Assertions.assertThrowsExactly(EstateException.class,() -> {
            //Arrange
            Landlord landlord = new Landlord("1","test","test@gmail.com","1234","1234","18",Gender.MALE);
            Estate estate = new Estate("1","lugar Bonito",3000000,"el mejor lugar del mundo",300,"conjuntoBonito");
            when(landlordRepository.findById("1")).thenReturn(Optional.of(landlord));
            //Act
            Estate EstateTest = estateServices.getEstate(estate.getId(), landlord);
            //Assert
        });
    }
    @Test
    public void whenStateIsCreatedAndNotExistThenReturnState() throws AppExceptions {
        //Arrange
        Landlord landlord = new Landlord("1","test","test@gmail.com","1234","1234","18",Gender.MALE);
        Estate estate = new Estate("2","lugar Bonito",3000000,"el mejor lugar del mundo",300,"conjuntoBonito");
        when(landlordRepository.findById("1")).thenReturn(Optional.of(landlord));
        //Act
        Estate EstateTest = estateServices.createEstate(estate, landlord);
        //Assert
        Assertions.assertEquals(estate, EstateTest);
    }
    @Test
    public void whenStateIsCreatedAndExistThenReturnState() throws AppExceptions {
        Assertions.assertThrowsExactly(EstateException.class,() -> {
            //Arrange
            Landlord landlord = new Landlord("1","test","test@gmail.com","1234","1234","18",Gender.MALE);
            Estate estate = new Estate("2","lugar Bonito",3000000,"el mejor lugar del mundo",300,"conjuntoBonito");
            when(landlordRepository.findById("1")).thenReturn(Optional.of(landlord));
            landlord.addEstate(estate);
            //Act
            Estate EstateTest = estateServices.createEstate(estate, landlord);
            //Assert
        });
    }
    @Test
    public void whenUpdateStateAndExistThenReturnTenant() throws AppExceptions {
        //Arrange
        Landlord landlord = new Landlord("1","test","test@gmail.com","1234","1234","18",Gender.MALE);
        Estate estate = new Estate("2","lugar Bonito",3000000,"el mejor lugar del mundo",300,"conjuntoBonito");
        when(landlordRepository.findById("1")).thenReturn(Optional.of(landlord));
        landlord.addEstate(estate);
        //
        EstateDto estateDto = new EstateDto(1500000,"casa","ssss");
        Optional<Estate> estateOptional = landlord.getEstate(estate.getId());
        Estate estate1 = estateOptional.get();
        estate1.update(estateDto);
        //Act
        Estate EstateTest = estateServices.updateEstate(estate.getId(), estateDto, landlord);
        //Assert
        Assertions.assertEquals(estateDto.getPrice(), estate1.getPrice());
    }
    @Test
    public void whenUpdateStateAndNotExistThenReturnTenant() throws AppExceptions {
        Assertions.assertThrowsExactly(EstateException.class,() -> {
            //Arrange
            EstateDto estateDto = new EstateDto(1500000,"casa","ssss");
            Landlord landlord = new Landlord("1","test","test@gmail.com","1234","1234","18",Gender.MALE);
            Estate estate = new Estate("2","lugar Bonito",3000000,"el mejor lugar del mundo",300,"conjuntoBonito");
            when(landlordRepository.findById("1")).thenReturn(Optional.of(landlord));
            landlord.addEstate(estate);
            //Act
            Estate EstateTest = estateServices.updateEstate("10", estateDto, landlord);
            //Assert
        });
    }
    @Test
    public void whenDeletedStateAndExistThenReturnNothing() throws AppExceptions {
        //Arrange
        Landlord landlord = new Landlord("1","test","test@gmail.com","1234","1234","18",Gender.MALE);
        Estate estate = new Estate("2","lugar Bonito",3000000,"el mejor lugar del mundo",300,"conjuntoBonito");
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
            Landlord landlord = new Landlord("1","test","test@gmail.com","1234","1234","18",Gender.MALE);
            Estate estate = new Estate("2","lugar Bonito",3000000,"el mejor lugar del mundo",300,"conjuntoBonito");
            when(landlordRepository.findById("1")).thenReturn(Optional.of(landlord));
            //Act
            estateServices.deleteEstate("2", landlord);
            //Assert
        });
    }
    @Test
    public void whenReviewExistThenReturnReview() throws AppExceptions {
        //Arrange
        Landlord landlord = new Landlord("1","test","test@gmail.com","1234","1234","18",Gender.MALE);
        Estate estate = new Estate("2","lugar Bonito",3000000,"el mejor lugar del mundo",300,"conjuntoBonito");
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
            Landlord landlord = new Landlord("1","test","test@gmail.com","1234","1234","18",Gender.MALE);
            Estate estate = new Estate("2","lugar Bonito",3000000,"el mejor lugar del mundo",300,"conjuntoBonito");
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
            Landlord landlord = new Landlord("1","test","test@gmail.com","1234","1234","18",Gender.MALE);
            Estate estate = new Estate("2","lugar Bonito",3000000,"el mejor lugar del mundo",300,"conjuntoBonito");
            Review review = new Review("1", "sikas", 3, "1");
            when(landlordRepository.findById("1")).thenReturn(Optional.of(landlord));
            landlord.addEstate(estate);
            //Act
            Optional<Review> review1 = estateServices.postReview(review,landlord,estate.getId());
            //Assert
        });
    }

}
