package com.eci.ariendamesta.model;

import com.eci.ariendamesta.model.dtos.PetitionDTO;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("petition")
public class Petition {
    private String id;
    private boolean acepted ;
    private String content;
    private String authorId;
    private String ownerId;
    private String propertyId;

    public Petition(String id,Boolean acepted, String content, String authorId,String ownerId,String propertyId){
        this.id = id;
        this.content = content;
        this.acepted = acepted;
        this.authorId = authorId;
        this.ownerId = ownerId;
        this.propertyId = propertyId;
    }
    public Petition(PetitionDTO petitionDTO){
        this.id = petitionDTO.getId();
        this.content = petitionDTO.getContent();
        this.acepted = petitionDTO.isAcepted();
        this.authorId = petitionDTO.getAuthorId();
        this.ownerId = petitionDTO.getOwnerId();
        this.propertyId = petitionDTO.getPropertyId();
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
    public String getPropertyId() {return propertyId;}
    public void setPropertyId(String propertyId) {this.propertyId = propertyId;}
    public String getOwnerId() {return ownerId;}
    public void setOwnerId(String ownerId) {this.ownerId = ownerId;}
    public void update(PetitionDTO petitionDTO) {
        this.id = petitionDTO.getId();
        this.content = petitionDTO.getContent();
        this.acepted = petitionDTO.isAcepted();
        this.authorId = petitionDTO.getAuthorId();
        this.ownerId = petitionDTO.getOwnerId();
        this.propertyId = petitionDTO.getPropertyId();
    }

    public void updateStatus(String acepted){
        if (acepted.equals("true")){
            this.acepted = true;
        }else {
            this.acepted = false;
        }
    }
}
