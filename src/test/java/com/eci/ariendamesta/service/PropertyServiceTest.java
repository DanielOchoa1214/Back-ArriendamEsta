package com.eci.ariendamesta.service;

import com.eci.ariendamesta.exceptions.AppExceptions;
import com.eci.ariendamesta.exceptions.PropertyException;
import com.eci.ariendamesta.model.Property;
import com.eci.ariendamesta.model.State;
import com.eci.ariendamesta.model.dtos.PropertyDTO;
import com.eci.ariendamesta.repository.repointerfaces.PropertyRepositoryInterface;
import com.eci.ariendamesta.service.impl.PropertyService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
public class PropertyServiceTest {
    @Mock
    PropertyRepositoryInterface propertyRepository;
    @InjectMocks
    PropertyService propertyService;

    @Test
    public void whenPropertyIsFindByIdAndExistThenReturnState() throws AppExceptions {
        //Arrange
        Property property = new Property("1","lugar Bonito",3000000,"el mejor lugar del mundo",300,"La mejor casa del pueblo", State.RENTED, "1");
        when(propertyRepository.findById("1")).thenReturn(Optional.of(property));
        //Act
        Property propertyTest = propertyService.findProperty(property.getId());
        //Assert
        Assertions.assertEquals(property, propertyTest);
    }

    @Test
    public void whenPropertyNotExistThenThrowException() {
        Assertions.assertThrowsExactly(PropertyException.class,() -> {
            //Arrange
            when(propertyRepository.findById("1")).thenReturn(Optional.empty());
            //Act
            Property propertyTest = propertyService.findProperty("1");
            //Assert
        });
    }

    @Test
    public void whenPropertyIsCreatedAndNotExistThenReturnState() throws AppExceptions {
        //Arrange
        PropertyDTO propertyDTO = new PropertyDTO("1","lugar Bonito",3000000,"el mejor lugar del mundo",300,"La mejor casa del pueblo", State.RENTED, "1");
        Property property = new Property(propertyDTO);
        when(propertyRepository.findById("1")).thenReturn(Optional.empty());
        when(propertyRepository.save(any())).thenReturn(property);
        //Act
        Property propertyTest = propertyService.createProperty(propertyDTO);
        //Assert
        Assertions.assertEquals(property.getId(), propertyTest.getId());
    }

    @Test
    public void whenPropertyIsCreatedAndExistThenThrowException() {
        Assertions.assertThrowsExactly(PropertyException.class,() -> {
            //Arrange
            PropertyDTO propertyDTO = new PropertyDTO("1","lugar Bonito",3000000,"el mejor lugar del mundo",300,"La mejor casa del pueblo", State.RENTED, "1");
            Property property = new Property(propertyDTO);
            when(propertyRepository.findById("1")).thenReturn(Optional.of(property));
            //Act
            Property propertyTest = propertyService.createProperty(propertyDTO);
            //Assert
        });
    }

    @Test
    public void whenUpdatePropertyAndExistThenReturnProperty() throws AppExceptions {
        //Arrange
        Property property = new Property("1","lugar Bonito",3000000,"el mejor lugar del mundo",300,"La mejor casa del pueblo", State.RENTED, "1");
        PropertyDTO propertyDTO = new PropertyDTO(3000000,"el mejor lugar del mundo", "Lo mejor de lo mejor", State.NOT_RENTED);
        Property propertyUpdated = new Property("1","lugar Bonito",3000000,"el mejor lugar del mundo",300,"Lo mejor de lo mejor", State.NOT_RENTED, "1");
        when(propertyRepository.findById("1")).thenReturn(Optional.of(property));
        when(propertyRepository.save(any())).thenReturn(propertyUpdated);
        //Act
        Property propertyTest = propertyService.updateProperty("1", propertyDTO);
        //Assert
        Assertions.assertEquals(propertyUpdated.getStateProperty(), propertyTest.getStateProperty());
    }

    @Test
    public void whenUpdatePropertyAndNotExistThenThrowException() throws AppExceptions {
        Assertions.assertThrowsExactly(PropertyException.class,() -> {
            //Arrange
            PropertyDTO propertyDTO = new PropertyDTO(3000000,"el mejor lugar del mundo", "Lo mejor de lo mejor", State.NOT_RENTED);
            when(propertyRepository.findById("1")).thenReturn(Optional.empty());
            //Act
            Property propertyTest = propertyService.updateProperty("1", propertyDTO);
            //Assert
        });
    }

    /*@Test
    public void whenUpdatePropertyAndExistAndNotSaveThenThrowException() {
        Assertions.assertThrowsExactly(PropertyException.class,() -> {
            Property property = new Property("1","lugar Bonito",3000000,"el mejor lugar del mundo",300,"La mejor casa del pueblo", State.RENTED, "1");
            PropertyDTO propertyDTO = new PropertyDTO(3000000,"el mejor lugar del mundo", "Lo mejor de lo mejor", State.NOT_RENTED);
            Property propertyUpdated = new Property("1","lugar Bonito",3000000,"el mejor lugar del mundo",300,"Lo mejor de lo mejor", State.NOT_RENTED, "1");
            when(propertyRepository.findById("1")).thenReturn(Optional.of(property));
            Mockito.doThrow(new Exception()).when(propertyRepository.save(any());
            //Act
            Property propertyTest = propertyService.updateProperty("1", propertyDTO);
            //Assert
        });
    }*/

    @Test
    public void whenDeletedPropertyAndExistThenReturnNothing() throws AppExceptions {
        //Arrange
        Property property = new Property("1","lugar Bonito",3000000,"el mejor lugar del mundo",300,"La mejor casa del pueblo", State.RENTED, "1");
        when(propertyRepository.findById("1")).thenReturn(Optional.of(property));
        //Act
        propertyService.deleteProperty("1");
        //Assert
    }

    @Test
    public void whenDeletedPropertyAndExistThenTrowException() {
        Assertions.assertThrowsExactly(PropertyException.class,() -> {
            //Arrange
            when(propertyRepository.findById("1")).thenReturn(Optional.empty());
            //Act
            propertyService.deleteProperty("1");
            //Assert
        });
    }

    /*
    @Test
    public void whenFindHomeOwnerPropertiesAndExistPropertiesThenReturnProperties() throws AppExceptions {
        //Arrange
        Property propertyUno = new Property("1","lugar Bonito",3000000,"el mejor lugar del mundo",300,"La mejor casa del pueblo", State.RENTED, "1");
        Property propertyDos = new Property("2","lugar Bonito",3000000,"el mejor lugar del mundo",300,"La mejor casa del pueblo", State.RENTED, "1");
        List<Property> properties = new ArrayList<>();
        properties.add(propertyUno);
        properties.add(propertyDos);
        Map<String, String> params = new HashMap<>();
        params.put("homeOwnerId", "1");
        when(propertyRepository.findHomeOwnerProperties(params)).thenReturn(properties);
        //Act
        List<Property> propertiesTest = propertyService.findHomeOwnerProperties(params);
        //Assert
        Assertions.assertEquals(properties.size(), propertiesTest.size());
    }

    @Test
    public void whenFindHomeOwnerPropertiesAndExistPropertiesAndFilterThenReturnFilteredProperties() throws AppExceptions {
        //Arrange
        Property propertyUno = new Property("1","lugar Bonito",3000000,"el mejor lugar del mundo",300,"La mejor casa del pueblo", State.RENTED, "1");
        Property propertyDos = new Property("2","lugar Bonito",3000000,"el mejor lugar del mundo",300,"La mejor casa del pueblo", State.NOT_RENTED, "1");
        List<Property> properties = new ArrayList<>();
        properties.add(propertyUno);
        Map<String, String> params = new HashMap<>();
        params.put("homeOwnerId", "1");
        when(propertyRepository.findHomeOwnerProperties(params)).thenReturn(properties);
        //Act
        List<Property> propertiesTest = propertyService.findHomeOwnerProperties(params);
        //Assert
        Assertions.assertEquals(properties.size(), propertiesTest.size());
    }

    @Test
    public void whenExistPropertiesThenReturnProperties() throws AppExceptions {
        //Arrange
        Property propertyUno = new Property("1","lugar Bonito",3000000,"el mejor lugar del mundo",300,"La mejor casa del pueblo", State.RENTED, "1");
        Property propertyDos = new Property("2","lugar Bonito",3000000,"el mejor lugar del mundo",300,"La mejor casa del pueblo", State.NOT_RENTED, "1");
        List<Property> properties = new ArrayList<>();
        properties.add(propertyUno);
        properties.add(propertyDos);
        when(propertyRepository.getProperties()).thenReturn(properties);
        //Act
        List<Property> propertiesTest = propertyService.findProperties();
        //Assert
        Assertions.assertEquals(properties.size(), propertiesTest.size());
    }*/

}
