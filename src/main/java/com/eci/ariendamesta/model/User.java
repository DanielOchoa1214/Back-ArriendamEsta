package com.eci.ariendamesta.model;

import com.eci.ariendamesta.model.dtos.UserRequestDTO;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.awt.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Document("Users")
public class User {
    @Id
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

    public User(String id, String name, String email, String password, String phoneNumber, String birthDate, Gender gender) throws ParseException {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.birthDate = new SimpleDateFormat("dd/MM/yyyy").parse(birthDate);
        this.gender = gender;
    }

    public User(UserRequestDTO userDTO) {
        this.id = userDTO.getId();
        this.name = userDTO.getName();
        this.email = userDTO.getEmail();
        this.password = userDTO.getPassword();
        this.phoneNumber = userDTO.getPhoneNumber();
        this.birthDate = userDTO.getBirthDate();
        this.gender = userDTO.getGender();
    }
    public User() {}

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
        if(name != null){
            this.name = name;
        }
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (email != null){
            this.email = email;
        }
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        if(password != null){
            this.password = password;
        }
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        if(phoneNumber != null){
            this.phoneNumber = phoneNumber;
        }
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        if(gender != null){
            this.gender = gender;
        }
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        if(birthDate != null){
            this.birthDate = birthDate;
        }
    }

    public void update(UserRequestDTO userDTO) {
        setName(userDTO.getName());
        setEmail(userDTO.getEmail());
        setPassword(userDTO.getPassword());
        setPhoneNumber(userDTO.getPhoneNumber());
        setBirthDate(userDTO.getBirthDate());
        setGender(userDTO.getGender());
    }
}
