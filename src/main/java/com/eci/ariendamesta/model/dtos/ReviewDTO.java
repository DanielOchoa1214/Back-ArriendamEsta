package com.eci.ariendamesta.model.dtos;

public class ReviewDTO {

    private String id;
    private String content;
    private int stars;
    private String authorId;
    private String targetId;
    private String name;

    public ReviewDTO(String id, String content, int stars, String authorId, String targetId, String name){
        this.id = id;
        this.content = content;
        this.stars = stars;
        this.authorId = authorId;
        this.targetId = targetId;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    public String getAuthorId() {
        return authorId;
    }

    public void setAuthorId(String authorId) {
        this.authorId = authorId;
    }

    public String getTargetId() {
        return targetId;
    }

    public void setTargetId(String targetId) {
        this.targetId = targetId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
