package com.eci.ariendamesta.model.landlord;

import com.eci.ariendamesta.model.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.*;

@Document(collection = "landlord")
public class Landlord extends User {

    private List<Estate> myEstates = new ArrayList<>();
    private List<Review> reviews = new ArrayList<>();

    public Landlord(String id, String name, String email, String password, String contact, String age, Gender gender) {
        super(id, name, email, password, contact, age, gender);
    }

    public Optional<Estate> getEstate(String estateId){
        for (Estate e: myEstates){
            if (e.getId().equals(estateId)){
                return Optional.of(e);
            }
        }
        return Optional.empty();
    }

    public List<Estate> getMyEstates() {
        return myEstates;
    }

    public void setMyEstates(List<Estate> myEstates) {
        this.myEstates = myEstates;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
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
