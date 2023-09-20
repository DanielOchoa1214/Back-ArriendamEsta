package com.eci.ariendamesta.model.estate;

import com.eci.ariendamesta.model.Petition;
import com.eci.ariendamesta.model.Review;
import com.eci.ariendamesta.model.Roles;
import com.eci.ariendamesta.model.State;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Document("Estates")
public class Estate {

    private String id;
    private String location;
    private int price;
    private String description;
    private int squareMeters;
    private String title;
    private List<Review> reviews = new ArrayList<>();
    private List<Petition> petitions = new ArrayList<>();
    private State stateEstate;

    public Estate(String id, String location, int price, String description, int squareMeters, String title) {
        this.id = id;
        this.location = location;
        this.price = price;
        this.description = description;
        this.squareMeters = squareMeters;
        this.title = title;
        this.stateEstate = State.NOT_RENTED;
    }

    public void addReview(Review review){
        reviews.add(review);
    }

    public Optional<Review> getReview(String reviewId){
        for (Review r : reviews){
            if (r.getId().equals(reviewId)){
                return Optional.of(r);
            }
        }
        return Optional.empty();
    }

    public void addPetition(Petition petition){
        petitions.add(petition);
    }

    public Optional<Petition> getPetitions(String petitionId){
        for (Petition p : petitions){
            if (p.getId().equals(petitionId)){
                return Optional.of(p);
            }
        }
        return Optional.empty();
    }

    public String getId() {
        return id;
    }

    public int getPrice() {
        return price;
    }

    public State getStateEstate() {
        return stateEstate;
    }

    public int getSquareMeters() {
        return squareMeters;
    }

    public List<Petition> getPetitions() {
        return petitions;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public String getDescription() {
        return description;
    }

    public String getLocation() {
        return location;
    }

    public String getTitle() {
        return title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setPetitions(List<Petition> petitions) {
        this.petitions = petitions;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setReviews(List<Review> reviews) {

    }

    public void setSquareMeters(int squareMeters) {
        this.squareMeters = squareMeters;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void update(EstateDto estateDto) {
        this.title = estateDto.getTitle();
        this.description = estateDto.getDescription();
        this.price = estateDto.getPrice();
    }
}
