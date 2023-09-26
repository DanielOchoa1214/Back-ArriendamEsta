package com.eci.ariendamesta.service.servinterfaces;

import com.eci.ariendamesta.exceptions.AppExceptions;
import com.eci.ariendamesta.model.Property;
import com.eci.ariendamesta.model.dtos.PropertyDTO;

public interface PropertyServiceInterface {
    Property findProperty(String propertyId) throws AppExceptions;

    Property createProperty(PropertyDTO propertyDTO) throws AppExceptions;

    Property updateProperty(String propertyId, PropertyDTO propertyDTO) throws AppExceptions;

    void deleteProperty(String propertyId) throws AppExceptions;
/*    Property getEstate(String idEstate, HomeOwner landlord) throws AppExceptions;
    Property createEstate(Property newEstate, HomeOwner landlord) throws AppExceptions;
    Property updateEstate(String idEstate, PropertyDto estateDto, HomeOwner landlord) throws AppExceptions;
    void deleteEstate(String idEstate, HomeOwner landlord) throws AppExceptions;
    List<Property> getEstates() throws AppExceptions;
    Optional<Review> postReview(Review reviewDTO, HomeOwner landlord, String propertyId) throws AppExceptions;
    Optional<Review> getReview(String reviewId, HomeOwner landlord, String propertyId) throws AppExceptions;
    Optional<Petition> postPetition(PetitionDTO petitionDTO, HomeOwner landlord, String propertyId) throws AppExceptions;
    Optional<Petition> getPetition(String petitionId, HomeOwner landlord, String propertyId) throws AppExceptions;*/
}
