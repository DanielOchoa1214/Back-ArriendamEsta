package com.eci.ariendamesta.model;

import com.eci.ariendamesta.model.dtos.UserDTO;

import java.util.Date;

public abstract class User {
    private String id;
    private String name;
    private String email;
    private String password;
    private String phoneNumber;
    private Date birthDate;
    private Gender gender;

    public User(String id, String name, String email, String password, String phoneNumber, Date birthDate, Gender gender) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.birthDate = birthDate;
        this.gender = gender;
    }

    public User(String name, String email, String password, String phoneNumber, Date birthDate, Gender gender) {
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

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public void update(UserDTO userDTO) {
        setName(userDTO.getName());
        setEmail(userDTO.getEmail());
        setPassword(userDTO.getPassword());
        setPhoneNumber(userDTO.getContact());
        setBirthDate(userDTO.getBirthDate());
        setGender(userDTO.getGender());
    }
}
