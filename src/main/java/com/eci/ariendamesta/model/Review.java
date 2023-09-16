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

    public Review(String id, String content, int stars, User author) {
        this.id = id;
        this.content = content;
        this.stars = stars;
        this.author = author;
    }

    public Review() {

    }

    public String getId() {
        return id;
    }

    public int getStars() {
        return stars;
    }

    public String getContent() {
        return content;
    }

    public User getAuthor() {
        return author;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }
}
