package com.eci.ariendamesta.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public abstract class User {
    private String id;
    private String name;
    private String email;
    private String password;
    private String contact;
    private String age;
    private Gender gender;
    protected List<Roles> roles;

    protected List<Review> reviews = new ArrayList<>();

    public User(String id, String name, String email, String password, String contact, String age, Gender gender) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.contact = contact;
        this.age = age;
        this.gender = gender;
    }

    public User(String name, String email, String password, String contact, String age, Gender gender) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.contact = contact;
        this.age = age;
        this.gender = gender;
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public void addReview(Review review) {
        reviews.add(review);
    }

    public Optional<Review> getReview(String reviewId) {
        for (Review r: reviews){
            if (r.getId().equals(reviewId)){
                return Optional.of(r);
            }
        }
        return Optional.empty();
    }

    public List<Roles> getRoles() {
        return roles;
    }
}
