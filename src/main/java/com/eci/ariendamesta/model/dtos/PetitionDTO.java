package com.eci.ariendamesta.model.dtos;

public class PetitionDTO {
    private String id;
    private boolean acepted;
    private String content;
    private String authorId;
    private String ownerId;
    private String propertyId;

    public PetitionDTO(String id, Boolean acepted, String content, String authorId, String ownerId, String propertyId){
        this.id = id;
        this.content = content;
        this.acepted = acepted;
        this.authorId = authorId;
        this.ownerId = ownerId;
        this.propertyId = propertyId;
    }

    public boolean isAcepted() {
        return acepted;
    }

    public void setAcepted(boolean acepted) {
        this.acepted = acepted;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthorId() {
        return authorId;
    }

    public void setAuthorId(String authorId) {
        this.authorId = authorId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(String propertyId) {
        this.propertyId = propertyId;
    }

    public String getOwnerId() {return ownerId;}

    public void setOwnerId(String ownerId) {this.ownerId = ownerId;}
}
