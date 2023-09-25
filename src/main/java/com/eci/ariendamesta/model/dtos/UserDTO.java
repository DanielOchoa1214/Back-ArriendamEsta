package com.eci.ariendamesta.model.dtos;

import com.eci.ariendamesta.model.Gender;
import com.eci.ariendamesta.model.User;

public class UserDTO{
    private String id;
    private String name;
    private String email;
    private String password;
    private String contact;
    private String age;
    private Gender gender;

    public UserDTO(String name, String email, String password, String contact, String age, Gender gender) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.contact = contact;
        this.age = age;
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

    public String getAge() {
        return age;
    }

    public Gender getGender() {
        return gender;
    }
}
