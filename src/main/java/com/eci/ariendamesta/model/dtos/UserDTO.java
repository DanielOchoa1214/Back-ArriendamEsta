package com.eci.ariendamesta.model.dtos;

import com.eci.ariendamesta.model.Gender;
import com.eci.ariendamesta.model.User;

import java.util.Date;

public class UserDTO{
    private String id;
    private String name;
    private String email;
    private String password;
    private String contact;
    private Date birthDate;
    private Gender gender;

    public UserDTO(String name, String email, String password, String contact, Date birthDate, Gender gender) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.contact = contact;
        this.birthDate = birthDate;
        this.gender = gender;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getContact() {
        return contact;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public Gender getGender() {
        return gender;
    }
}
