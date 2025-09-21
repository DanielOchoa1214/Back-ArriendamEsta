package com.eci.ariendamesta.model.dtos;

import com.eci.ariendamesta.model.Gender;
import com.eci.ariendamesta.model.User;

import java.util.Date;

public class UserResponseDTO {

    private String id;
    private String name;
    private String email;
    private String phoneNumber;
    private Date birthDate;
    private Gender gender;

    public UserResponseDTO(String name, String email, String phoneNumber, Date birthDate, Gender gender) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.birthDate = birthDate;
        this.gender = gender;
    }

    public UserResponseDTO(User user){
        this.id = user.getId();
        this.name = user.getName();
        this.email = user.getEmail();
        this.phoneNumber = user.getPhoneNumber();
        this.birthDate = user.getBirthDate();
        this.gender = user.getGender();
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public Gender getGender() {
        return gender;
    }
}
