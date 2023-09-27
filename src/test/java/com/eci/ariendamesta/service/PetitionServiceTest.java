package com.eci.ariendamesta.service;

import com.eci.ariendamesta.exceptions.AppExceptions;
import com.eci.ariendamesta.exceptions.PetitionException;
import com.eci.ariendamesta.exceptions.PropertyException;
import com.eci.ariendamesta.model.Petition;
import com.eci.ariendamesta.model.Property;
import com.eci.ariendamesta.model.State;
import com.eci.ariendamesta.model.dtos.PetitionDTO;
import com.eci.ariendamesta.model.dtos.PropertyDTO;
import com.eci.ariendamesta.repository.repointerfaces.PetitionRepositoryInterface;;
import com.eci.ariendamesta.service.impl.PetitionService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
public class PetitionServiceTest {
    @Mock
    PetitionRepositoryInterface petitionRepository;
    @InjectMocks
    PetitionService petitionService;

    @Test
    public void whenPetitionIsFindByIdAndExistThenReturnPetition() throws AppExceptions {
        //Arrange
        Petition petition = new Petition("1",true,"quiero arrendar esta casa","1","1");
        when(petitionRepository.findById("1")).thenReturn(Optional.of(petition));
        //Act
        Petition petitionTest = petitionService.findPetition(petition.getId());
        //Assert
        Assertions.assertEquals(petition, petitionTest);
    }
    @Test
    public void whenPetitionNotExistThenThrowException() {
        Assertions.assertThrowsExactly(PetitionException.class,() -> {
            //Arrange
            when(petitionRepository.findById("1")).thenReturn(Optional.empty());
            //Act
            Petition petitionTest = petitionService.findPetition("1");
            //Assert
        });
    }
    @Test
    public void whenPetitionIsCreatedAndNotExistThenReturnPetition() throws AppExceptions {
        //Arrange
        PetitionDTO petitiondto = new PetitionDTO("1",true,"quiero arrendar esta casa","1","1");
        Petition petition = new Petition(petitiondto);
        when(petitionRepository.findById("1")).thenReturn(Optional.empty());
        when(petitionRepository.save(any())).thenReturn(petition);
        //Act
        Petition petitionTest = petitionService.createPetition(petitiondto);
        //Assert
        Assertions.assertEquals(petition.getId(), petitionTest.getId());
    }
    @Test
    public void whenPetitionIsCreatedAndExistThenThrowException() {
        Assertions.assertThrowsExactly(PetitionException.class,() -> {
            //Arrange
            PetitionDTO petitiondto = new PetitionDTO("1",true,"quiero arrendar esta casa","1","1");
            Petition petition = new Petition(petitiondto);
            when(petitionRepository.findById("1")).thenReturn(Optional.of(petition));
            //Act
            Petition petitionTest = petitionService.createPetition(petitiondto);
            //Assert
        });
    }
    @Test
    public void whenUpdatePetitionAndExistThenReturnPetition() throws AppExceptions {
        //Arrange
        Petition petition = new Petition("1",true,"quiero arrendar esta casa","1","1");
        Petition petitionupdate = new Petition("1",false,"quiero arrendar esta casa","1","1");
        PetitionDTO petitiondto = new PetitionDTO("1",false,"quiero arrendar esta casa","1","1");
        when(petitionRepository.findById("1")).thenReturn(Optional.of(petition));
        when(petitionRepository.save(any())).thenReturn(petitionupdate);
        //Act
        Petition petitionTest = petitionService.updatePetition("1", petitiondto);
        //Assert
        Assertions.assertEquals(petitionupdate, petitionTest);
    }
    @Test
    public void whenUpdatePetitionAndNotExistThenThrowException() throws AppExceptions {
        Assertions.assertThrowsExactly(PetitionException.class,() -> {
            //Arrange
            PetitionDTO petitiondto = new PetitionDTO("1",false,"quiero arrendar esta casa","1","1");
            when(petitionRepository.findById("1")).thenReturn(Optional.empty());
            //Act
            Petition petitionTest = petitionService.updatePetition("1", petitiondto);
            //Assert
        });
    }
    @Test
    public void whenDeletedPetitionAndExistThenReturnNothing() throws AppExceptions {
        //Arrange
        Petition petition = new Petition("1",true,"quiero arrendar esta casa","1","1");
        when(petitionRepository.findById("1")).thenReturn(Optional.of(petition));
        //Act
        petitionService.deletePetition("1");
        //Assert
    }
    @Test
    public void whenDeletedPetitionAndExistThenTrowException() {
        Assertions.assertThrowsExactly(PetitionException.class,() -> {
            //Arrange
            when(petitionRepository.findById("1")).thenReturn(Optional.empty());
            //Act
            petitionService.deletePetition("1");
            //Assert
        });
    }
    @Test
    public void whenExistPetitionsThenReturnPetition() throws AppExceptions {
        //Arrange
        Petition petition1 = new Petition("1",true,"quiero arrendar esta casa","1","1");
        Petition petition2 = new Petition("2",true,"quiero arrendar esta casa","3","5");
        List<Petition> petitions = new ArrayList<>();
        petitions.add(petition1);
        petitions.add(petition2);
        when(petitionRepository.getPetitions()).thenReturn(petitions);
        //Act
        List<Petition> petitionsTest = petitionService.findPetitions();
        //Assert
        Assertions.assertEquals(petitions.size(), petitionsTest.size());
    }
}
