package com.eci.ariendamesta.model;

import com.eci.ariendamesta.model.dtos.PropertyDto;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("Estates")
public class Property {
    private String id;
    private String location;
    private int price;
    private String description;
    private int squareMeters;
    private String title;
    private State stateEstate;
    private String homeOwnerId;

    public Property(String id, String location, int price, String description, int squareMeters, String title, State stateEstate, String homeOwnerId) {
        this.id = id;
        this.location = location;
        this.price = price;
        this.description = description;
        this.squareMeters = squareMeters;
        this.title = title;
        this.stateEstate = stateEstate;
        this.homeOwnerId = homeOwnerId;
    }

    /*public void addReview(Review review){
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
    }*/

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

    public void setPrice(int price) {
        this.price = price;
    }

    public void setSquareMeters(int squareMeters) {
        this.squareMeters = squareMeters;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void update(PropertyDto estateDto) {
        this.title = estateDto.getTitle();
        this.description = estateDto.getDescription();
        this.price = estateDto.getPrice();
    }
}
