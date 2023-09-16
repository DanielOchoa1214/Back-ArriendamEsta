package com.eci.ariendamesta.model;

import java.util.List;

public class Estate {
    private String id;
    private String location;
    private int price;
    private String description;
    private int squareMeters;
    private String title;
    private List<Review> reviews;
    private List<Petition> petitions;

    public String getId() {
        return id;
    }
}
