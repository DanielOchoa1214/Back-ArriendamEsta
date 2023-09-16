package com.eci.ariendamesta.controller;

import com.eci.ariendamesta.exceptions.UserException;
import com.eci.ariendamesta.model.landlord.Landlord;
import com.eci.ariendamesta.model.landlord.LandlordDto;
import com.eci.ariendamesta.service.LandlordServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping(value = "/v1/user/landlord")
public class LandlordController {
    private LandlordServiceInterface landlordServices;

    public LandlordController(@Autowired LandlordServiceInterface landlordServices){
        this.landlordServices = landlordServices;
    }

    @GetMapping("/{idLandlord}")
    public ResponseEntity<?> readLandlord(@PathVariable("idLandlord") String idLandlord) {
        try {
            Landlord landlord = landlordServices.foundById(idLandlord);
            return ResponseEntity.ok(landlord);
        } catch (UserException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<?> createLandlord(@RequestBody Landlord landlord){
        try{
            Landlord newLandlord = landlordServices.createLandlord(landlord);
            return ResponseEntity.created(URI.create("")).body(newLandlord);
        } catch (UserException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{idLandlord}")
    public ResponseEntity<?> updateLandlord(@PathVariable("idLandlord") String idLandlord, @RequestBody LandlordDto landlordBody) {
        try {
            Landlord landlord = landlordServices.updateLandlord(idLandlord, landlordBody);
            return ResponseEntity.ok(landlord);
        } catch (UserException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{idLandlord}")
    public ResponseEntity<?> deleteLandlord(@PathVariable("idLandlord") String idLandlord) {
        try {
            landlordServices.deleteLandlord(idLandlord);
            return ResponseEntity.ok().build();
        } catch (UserException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
