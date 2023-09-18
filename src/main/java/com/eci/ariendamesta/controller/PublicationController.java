package com.eci.ariendamesta.controller;

import com.eci.ariendamesta.exceptions.AppExceptions;
import com.eci.ariendamesta.model.estate.Estate;
import com.eci.ariendamesta.service.EstateServiceInterface;
import com.eci.ariendamesta.service.LandlordServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/v1/publication")
public class PublicationController {

    private final EstateServiceInterface estateServices;
    private final LandlordServiceInterface landlordServices;

    public PublicationController(@Autowired EstateServiceInterface estateService,
                            @Autowired LandlordServiceInterface landlordServices){
        this.estateServices = estateService;
        this.landlordServices = landlordServices;
    }
    @GetMapping
    public ResponseEntity<?> getEstates() {
        try {
            List<Estate> estatesList = estateServices.getEstates();
            return ResponseEntity.ok(estatesList);
        } catch (AppExceptions e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
