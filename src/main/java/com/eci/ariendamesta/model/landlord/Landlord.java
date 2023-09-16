package com.eci.ariendamesta.model.landlord;

import com.eci.ariendamesta.model.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Document(collection = "landlord")
public class Landlord extends User {

    private Map<String, Estate> myEstates = new HashMap<>();
    private List<Review> reviews = new ArrayList<>();

    public Landlord(String id, String name, String email, String password, String contact, String age, Gender gender) {
        super(id, name, email, password, contact, age, gender);
    }

    public Map<String, Estate> getMyEstates() {
        return myEstates;
    }

    public void addEstate(Estate estate) {
        myEstates.put(estate.getId(), estate);
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
