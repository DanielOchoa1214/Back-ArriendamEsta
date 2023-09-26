package com.eci.ariendamesta.service.impl;

import com.eci.ariendamesta.exceptions.AppExceptions;
import com.eci.ariendamesta.exceptions.PropertyException;
import com.eci.ariendamesta.model.Property;
import com.eci.ariendamesta.model.State;
import com.eci.ariendamesta.model.dtos.PropertyDTO;
import com.eci.ariendamesta.repository.repointerfaces.PropertyRepositoryInterface;
import com.eci.ariendamesta.service.servinterfaces.PropertyServiceInterface;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class PropertyService implements PropertyServiceInterface {

    private final PropertyRepositoryInterface propertyRepository;

    public PropertyService(@Autowired PropertyRepositoryInterface propertyRepository) {
        this.propertyRepository = propertyRepository;
    }

    @Override
    public Property findProperty(String propertyId) throws AppExceptions {
        Optional<Property> property = propertyRepository.findById(propertyId);
        if (property.isPresent()) {
            return property.get();
        }
        throw new PropertyException(PropertyException.NOT_FOUND);
    }

    @Override
    public List<Property> findProperties() throws AppExceptions {
        try {
            return propertyRepository.getProperties();
        } catch (Exception e) {
            throw new PropertyException(PropertyException.NOT_FOUND);
        }
    }

    @Override
    public Property createProperty(PropertyDTO propertyDTO) throws AppExceptions {
        Optional<Property> propertyOptional = propertyRepository.findById(propertyDTO.getId());
        if (propertyOptional.isEmpty()) {
            Property property = new Property(propertyDTO);
            return propertyRepository.save(property);
        }
        throw new PropertyException(PropertyException.NOT_CREATED);
    }

    @Override
    public Property updateProperty(String propertyId, PropertyDTO propertyDTO) throws AppExceptions {
        Property property = findProperty(propertyId);
        property.update(propertyDTO);
        try {
            return propertyRepository.save(property);
        } catch (Exception e) {
            throw new PropertyException(PropertyException.NOT_CREATED);
        }
    }

    @Override
    public void deleteProperty(String propertyId) throws AppExceptions {
        Property property = findProperty(propertyId);
        try {
            propertyRepository.deleteEntity(property);
        } catch (Exception e) {
            throw new PropertyException(PropertyException.NOT_DELETED);
        }
    }

    @Override
    public List<Property> findHomeOwnerProperties(String homeOwnerId, State state) throws AppExceptions {
        try {
            if (state != null) {
                List<Property> properties = propertyRepository.findHomeOwnerProperties(homeOwnerId, state);
                return properties;
            }
            List<Property> properties = propertyRepository.findHomeOwnerProperties(homeOwnerId);
            return properties;
        } catch (Exception e) {
            throw new PropertyException(PropertyException.NOT_FOUND);
        }
    }
/*

    private final LandlordRepositoryInterface landlordRepository;
    private final TenantRepositoryInterface tenantRepository;
    private final PublicationRepositoryInterface publicationRepository;

    public EstateServices(@Autowired LandlordRepositoryInterface landlordRepository,
                          @Autowired TenantRepositoryInterface tenantRepository,
                          @Autowired PublicationRepositoryInterface publicationRepository) {
        this.landlordRepository = landlordRepository;
        this.tenantRepository = tenantRepository;
        this.publicationRepository = publicationRepository;
    }


    @Override
    public Property getEstate(String idEstate, HomeOwner landlord) throws AppExceptions {
        Optional<Property> estate = landlord.getEstate(idEstate);
        if (estate.isPresent()) {
            return estate.get();
        }
        throw new EstateException(EstateException.NOT_FOUND);
    }

    @Override
    public Property createEstate(Property newEstate, HomeOwner landlord) throws AppExceptions {
        Optional<Property> estateOptional = landlord.getEstate(newEstate.getId());
        if (estateOptional.isEmpty()) {
            Property estate = landlord.addEstate(newEstate);
            publicationRepository.save(estate);
            landlordRepository.save(landlord);
            return estate;
        }
        throw new EstateException(EstateException.NOT_CREATED);
    }

    @Override
    public Property updateEstate(String idEstate, PropertyDto estateDto, HomeOwner landlord) throws AppExceptions {
        Optional<Property> estateOptional = landlord.getEstate(idEstate);
        if (estateOptional.isPresent()) {
            Property estate = estateOptional.get();
            estate.update(estateDto);
            landlord.addEstate(estate);
            landlordRepository.save(landlord);
            return estate;
        }
        throw new EstateException(EstateException.NOT_UPDATED);
    }

    @Override
    public void deleteEstate(String estateId, HomeOwner landlord) throws AppExceptions {
        Optional<Property> estateOptional = landlord.getEstate(estateId);
        if (estateOptional.isPresent()) {
            landlord.deleteEstate(estateOptional.get());
            landlordRepository.save(landlord);
        } else {
            throw new EstateException(EstateException.NOT_DELETED);
        }
    }

    @Override
    public List<Property> getEstates() throws AppExceptions {
        try {
            return publicationRepository.getEstates();
        } catch (Exception e) {
            throw new EstateException(EstateException.NOT_FOUND);
        }
    }

    @Override
    public Optional<Review> postReview(Review review, HomeOwner landlord, String estateId) throws AppExceptions {
        Property estate = getEstate(estateId, landlord);
        Optional<HomeRenter> reviewer = tenantRepository.findById(review.getAuthorId());
            if (reviewer.isPresent()) {
                //Review review = new Review(reviewDTO, reviewer.get());
                estate.addReview(review);
                landlord.addEstate(estate);
                landlordRepository.save(landlord);
                return Optional.of(review);
            }
        throw new ReviewException(ReviewException.NOT_CREATED);
    }

    @Override
    public Optional<Review> getReview(String reviewId, HomeOwner landlord, String estateId) throws AppExceptions {
        Property estate = getEstate(estateId, landlord);
        Optional<Review> review = estate.getReview(reviewId);
        if (review.isPresent()) {
            return review;
        }
        throw new ReviewException(ReviewException.NOT_FOUND);
    }

    @Override
    public Optional<Petition> postPetition(PetitionDTO petitionDTO, HomeOwner landlord, String estateId) throws AppExceptions {
        Property estate = getEstate(estateId, landlord);
        System.out.println(petitionDTO.getContent());
        Optional<HomeRenter> reviewer = tenantRepository.findById(petitionDTO.getAuthorId());
        if (reviewer.isPresent()) {
            Petition petition = new Petition(petitionDTO, reviewer.get());
            estate.addPetition(petition);
            landlord.addEstate(estate);
            landlordRepository.save(landlord);
            return Optional.of(petition);
        }
        throw new ReviewException(PetitionException.NOT_CREATED);
    }

    @Override
    public Optional<Petition> getPetition(String petitionId, HomeOwner landlord, String estateId) throws AppExceptions {
        Property estate = getEstate(estateId, landlord);
        Optional<Petition> petition = estate.getPetitions(petitionId);
        if (petition.isPresent()) {
            return petition;
        }
        throw new ReviewException(PetitionException.NOT_FOUND);
    }
*/

}
