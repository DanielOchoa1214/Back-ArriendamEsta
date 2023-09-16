package com.eci.ariendamesta.model;

import java.util.List;
import java.util.Optional;

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
}
