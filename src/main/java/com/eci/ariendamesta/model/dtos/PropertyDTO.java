package com.eci.ariendamesta.model.dtos;

import com.eci.ariendamesta.model.State;

public class PropertyDTO {

    private String id;
    private String location;
    private int price;
    private String description;
    private int squareMeters;
    private String title;
    private State stateProperty;
    private String homeOwnerId;

    public PropertyDTO(String id, String location, int price, String description, int squareMeters, String title, State stateProperty, String homeOwnerId) {
        this.id = id;
        this.location = location;
        this.price = price;
        this.description = description;
        this.squareMeters = squareMeters;
        this.title = title;
        this.stateProperty = stateProperty;
        this.homeOwnerId = homeOwnerId;
    }

    public PropertyDTO(int price, String description, String title, State stateProperty) {
        this.price = price;
        this.description = description;
        this.title = title;
        this.stateProperty = stateProperty;
    }

    public PropertyDTO() {}

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
}
