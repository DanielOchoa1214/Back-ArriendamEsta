package com.eci.ariendamesta.model;

import com.eci.ariendamesta.model.dtos.PropertyDTO;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("property")
public class Property {
    private String id;
    private String location;
    private int price;
    private String description;
    private int squareMeters;
    private String title;
    private State stateProperty;
    private String homeOwnerId;

    public Property(String id, String location, int price, String description, int squareMeters, String title, State stateProperty, String homeOwnerId) {
        this.id = id;
        this.location = location;
        this.price = price;
        this.description = description;
        this.squareMeters = squareMeters;
        this.title = title;
        this.stateProperty = stateProperty;
        this.homeOwnerId = homeOwnerId;
    }

    public Property(PropertyDTO propertyDTO) {
        this.id = propertyDTO.getId();
        this.location = propertyDTO.getLocation();
        this.price = propertyDTO.getPrice();
        this.description = propertyDTO.getDescription();
        this.squareMeters = propertyDTO.getSquareMeters();
        this.title = propertyDTO.getTitle();
        this.stateProperty = propertyDTO.getStateProperty();
        this.homeOwnerId = propertyDTO.getHomeOwnerId();
    }

    public Property() {}
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

    public String getLocation() {
        return location;
    }

    public int getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public int getSquareMeters() {
        return squareMeters;
    }

    public String getTitle() {
        return title;
    }

    public State getStateProperty() {
        return stateProperty;
    }

    public String getHomeOwnerId() {
        return homeOwnerId;
    }

    public void update(PropertyDTO propertyDTO) {
        this.title = propertyDTO.getTitle();
        this.description = propertyDTO.getDescription();
        this.price = propertyDTO.getPrice();
        this.stateProperty = propertyDTO.getStateProperty();
    }
}
