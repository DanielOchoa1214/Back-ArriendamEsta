package com.eci.ariendamesta.model.dtos;

import com.eci.ariendamesta.model.Gender;

import java.util.Date;

public class UserRequestDTO {
    private String id;
    private String name;
    private String email;
    private String password;
    private String phoneNumber;
    private Date birthDate;
    private Gender gender;

    public UserRequestDTO(String name, String email, String password, String phoneNumber, Date birthDate, Gender gender) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
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
