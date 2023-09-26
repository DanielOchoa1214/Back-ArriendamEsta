package com.eci.ariendamesta.service.servinterfaces;

import com.eci.ariendamesta.exceptions.AppExceptions;
import com.eci.ariendamesta.model.Property;
import com.eci.ariendamesta.model.State;
import com.eci.ariendamesta.model.dtos.PropertyDTO;

import java.util.List;

public interface PropertyServiceInterface {
    Property findProperty(String propertyId) throws AppExceptions;

    Property createProperty(PropertyDTO propertyDTO) throws AppExceptions;

    Property updateProperty(String propertyId, PropertyDTO propertyDTO) throws AppExceptions;

    void deleteProperty(String propertyId) throws AppExceptions;

    List<Property> findProperties() throws AppExceptions;

    List<Property> findHomeOwnerProperties(String homeOwnerId, State state) throws AppExceptions;


}
