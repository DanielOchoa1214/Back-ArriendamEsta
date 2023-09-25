package com.eci.ariendamesta.model.dtos;

public class PetitionDTO {

    private String id;
    private boolean acepted;
    private String content;
    private String authorId;

    public PetitionDTO(String id,Boolean acepted, String content, String authorId){
        this.id = id;
        this.content = content;
        this.acepted = acepted;
        this.authorId = authorId;
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
}
