package com.eci.ariendamesta.model;

import com.eci.ariendamesta.model.dtos.PetitionDTO;

public class Petition {
    private String id;
    private boolean acepted;
    private String content;
    private String authorId;
    private String propertyId;

    public Petition(String id,Boolean acepted, String content, String authorId){
        this.id = id;
        this.content = content;
        this.acepted = acepted;
        this.authorId = authorId;
    }

    public Petition(PetitionDTO petitionDTO, User author){
        this.id = petitionDTO.getId();
        this.content = petitionDTO.getContent();
        this.acepted = petitionDTO.isAcepted();
        this.authorId = author.getId();
    }

    public Petition(){}

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
}
