package com.eci.ariendamesta.model.tenant;

import com.eci.ariendamesta.model.Gender;
import com.eci.ariendamesta.model.Petition;
import com.eci.ariendamesta.model.Review;
import com.eci.ariendamesta.model.User;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "Tenants")
public class Tenant extends User {
    private List<Review> reviews = new ArrayList<>();
    private List<Petition> petitions =  new ArrayList<>();

    public Tenant(String id, String name, String email, String password, String contact, String age, Gender gender) {
        super(id, name, email, password, contact, age, gender);
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    public List<Petition> getPetitions() {
        return petitions;
    }

    public void setPetitions(List<Petition> petitions) {
        this.petitions = petitions;
    }


    public void update(TenantDto tenant) {
        setName(tenant.getName());
        setEmail(tenant.getEmail());
        setPassword(tenant.getPassword());
        setContact(tenant.getContact());
        setAge(tenant.getAge());
        setGender(tenant.getGender());
    }
}
