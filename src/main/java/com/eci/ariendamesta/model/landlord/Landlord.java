package com.eci.ariendamesta.model.landlord;

import com.eci.ariendamesta.model.*;
import com.eci.ariendamesta.model.estate.Estate;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.*;

@Document(collection = "landlord")
public class Landlord extends User {

    private Map<String, Estate> myEstates = new HashMap<>();
    private List<Review> reviews = new ArrayList<>();

    public Landlord(String id, String name, String email, String password, String contact, String age, Gender gender) {
        super(id, name, email, password, contact, age, gender);
    }

    public Estate addEstate(Estate estate) {
        myEstates.put(estate.getId(), estate);
        return myEstates.get(estate.getId());
    }

    public Optional<Estate> getEstate(String estateId){
        try {
            Estate estate = myEstates.get(estateId);
            return Optional.of(estate);
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    public void deleteEstate(Estate estate) {
        myEstates.remove(estate.getId());
    }

    public Map<String, Estate> getMyEstates() {
        return myEstates;
    }

    public void setMyEstates(Map<String, Estate> myEstates) {
        this.myEstates = myEstates;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    public Optional<Review> getReview(String reviewId){
        for (Review r: reviews){
            if (r.getId().equals(reviewId)){
                return Optional.of(r);
            }
        }
        return Optional.empty();
    }

    public void addReview(Review review){
        reviews.add(review);
    }


    public void update(LandlordDto landlordDto) {
        setName(landlordDto.getName());
        setEmail(landlordDto.getEmail());
        setPassword(landlordDto.getPassword());
        setContact(landlordDto.getContact());
        setAge(landlordDto.getAge());
        setGender(landlordDto.getGender());
    }
}
