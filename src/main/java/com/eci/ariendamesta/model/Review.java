package com.eci.ariendamesta.model;

import com.eci.ariendamesta.model.dtos.ReviewDTO;

public class Review {
    private String id;
    private String content;
    private int stars;
    private User author;

    public Review(ReviewDTO reviewDTO, User author) {
        this.id = reviewDTO.getId();
        this.content = reviewDTO.getContent();
        this.stars = reviewDTO.getStars();
        this.author = author;
    }
}
