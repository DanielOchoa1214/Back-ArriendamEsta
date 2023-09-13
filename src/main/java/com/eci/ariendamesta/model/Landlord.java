package com.eci.ariendamesta.model;

import java.util.List;

public class Landlord extends User{

    private List<Estate> myEstates;
    private List<Review> reviews;

    public Landlord(String id, String name, String email, String password, String contact, String age, Gender gender) {
        super(id, name, email, password, contact, age, gender);
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


}
