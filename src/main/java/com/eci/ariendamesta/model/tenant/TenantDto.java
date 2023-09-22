package com.eci.ariendamesta.model.tenant;

import com.eci.ariendamesta.model.Gender;
import com.eci.ariendamesta.model.User;

public class TenantDto extends User {

    public TenantDto(String name, String email, String password, String contact, String age, Gender gender) {
        super(name, email, password, contact, age, gender);
    }
}
