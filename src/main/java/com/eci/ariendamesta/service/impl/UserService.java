package com.eci.ariendamesta.service.impl;

import com.eci.ariendamesta.exceptions.AppExceptions;
import com.eci.ariendamesta.exceptions.UserException;
import com.eci.ariendamesta.model.User;
import com.eci.ariendamesta.model.dtos.UserDTO;
import com.eci.ariendamesta.repository.repointerfaces.UserRepositoryInterface;
import com.eci.ariendamesta.service.servinterfaces.UserServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserService implements UserServiceInterface {

    private UserRepositoryInterface userRepository;

    public UserService(@Autowired UserRepositoryInterface userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User createUser(UserDTO userDTO) throws AppExceptions {
        System.out.println(userDTO.getId());
        if(userRepository.findById(userDTO.getId()).isEmpty()) {
            User created = new User(userDTO);
            return userRepository.save(created);
        }
        throw new UserException(UserException.NOT_CREATED);
    }
/*

    LandlordRepositoryInterface landlordRepository;
    TenantRepositoryInterface tenantRepository;

    public LandlordServices(@Autowired LandlordRepositoryInterface landlordRepository, @Autowired TenantRepositoryInterface tenantRepository) {
        this.landlordRepository = landlordRepository;
        this.tenantRepository = tenantRepository;
    }

    @Override
    public HomeOwner foundById(String idLandlord) throws AppExceptions {
        Optional<HomeOwner> landlord = landlordRepository.findById(idLandlord);
        if (landlord.isPresent()) {
            return landlord.get();
        }
        throw new UserException(UserException.NOT_FOUND);
    }


    @Override
    public HomeOwner createLandlord(HomeOwner landlord) throws AppExceptions {
        if(landlordRepository.findById(landlord.getId()).isEmpty()) {
            landlordRepository.save(landlord);
            return foundById(landlord.getId());
        }
        throw new UserException(UserException.NOT_CREATED);
    }

    @Override
    public HomeOwner updateLandlord(String idLandlord, HomeOwnerDto landlordBody) throws AppExceptions {
        HomeOwner landlord = foundById(idLandlord);
        try {
            landlord.update(landlordBody);
            landlordRepository.save(landlord);
            return foundById(idLandlord);
        } catch (Exception e) {
            throw new UserException(UserException.NOT_UPDATED);
        }
    }

    @Override
    public void deleteLandlord(String idLandlord) throws AppExceptions {
        HomeOwner landlord = foundById(idLandlord);
        try {
            landlordRepository.deleteEntity(landlord);
        } catch (Exception e) {
            throw new UserException(UserException.NOT_DELETED);
        }
    }

    @Override
    public Optional<Review> getReview(String landlordId, String reviewId) throws AppExceptions {
        try{
            HomeOwner landlord = foundById(landlordId);
            Optional<Review> review = landlord.getReview(reviewId);
            return review;
        } catch (Exception e){
            throw new ReviewException(ReviewException.NOT_FOUND);
        }
    }

    @Override
    public Optional<Review> postReview(Review review, String landlordId) throws AppExceptions {
        HomeOwner landlord = foundById(landlordId);
        Optional<HomeRenter> tenant = tenantRepository.findById(review.getAuthorId());
        if (tenant.isPresent()){
            //Review review = new Review();
            landlord.addReview(review);
            landlordRepository.save(landlord);
            return Optional.of(review);
        }
        throw new ReviewException(ReviewException.NOT_CREATED);
    }
*/

}
