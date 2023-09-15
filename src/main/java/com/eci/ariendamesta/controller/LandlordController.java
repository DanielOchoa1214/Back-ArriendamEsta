package com.eci.ariendamesta.controller;

import com.eci.ariendamesta.model.Tenant;
import com.eci.ariendamesta.model.User;
import com.eci.ariendamesta.service.TenantServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/v1/user/landlord")
public class LandlordController {
    private TenantServiceInterface tenantServices;

    public LandlordController(@Autowired TenantServiceInterface tenantServices){
        this.tenantServices = tenantServices;
    }

    @PostMapping
    public ResponseEntity<?> createUser(@RequestBody Tenant tenant){
        try{
            User user = tenantServices.createTenant(tenant);
            return new ResponseEntity<>(user, HttpStatus.CREATED);
        } catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
