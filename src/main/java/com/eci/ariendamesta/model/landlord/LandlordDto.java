package com.eci.ariendamesta.model.landlord;

import com.eci.ariendamesta.model.Gender;
import com.eci.ariendamesta.model.User;

public class LandlordDto extends User {

    public LandlordDto(String name, String email, String password, String contact, String age, Gender gender) {
        super(name, email, password, contact, age, gender);
    }
}
