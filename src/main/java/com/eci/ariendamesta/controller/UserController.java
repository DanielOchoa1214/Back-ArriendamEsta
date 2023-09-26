package com.eci.ariendamesta.controller;

import com.eci.ariendamesta.exceptions.AppExceptions;
import com.eci.ariendamesta.model.User;
import com.eci.ariendamesta.model.dtos.UserRequestDTO;
import com.eci.ariendamesta.service.servinterfaces.UserServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/v1/user")
public class UserController {

    private final UserServiceInterface services;

    public UserController(@Autowired UserServiceInterface services) {
        this.services = services;
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody UserRequestDTO userDTO){
        try{
            User user = services.createUser(userDTO);
            return ResponseEntity.created(URI.create("")).body(user);
        } catch (AppExceptions e){
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/{userId}")
    public ResponseEntity<User> getUser(@PathVariable("userId") String userId){
        try {
            User user = services.findById(userId);
            return ResponseEntity.ok(user);
        } catch (AppExceptions e){
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{userId}")
    public ResponseEntity<User> updateUser(@PathVariable("userId") String userId, @RequestBody UserRequestDTO userDTO){
        try{
            User user = services.updateUser(userId, userDTO);
            return ResponseEntity.ok(user);
        } catch (AppExceptions e) {
            return ResponseEntity.badRequest().build();
        }
    }

    /*    private LandlordServiceInterface landlordServices;

    public LandlordController(@Autowired LandlordServiceInterface landlordServices){
        this.landlordServices = landlordServices;
    }

    @GetMapping("/{idLandlord}")
    public ResponseEntity<?> readLandlord(@PathVariable("idLandlord") String idLandlord) {
        try {
            HomeOwner landlord = landlordServices.foundById(idLandlord);
            return ResponseEntity.ok(landlord);
        } catch (AppExceptions e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<?> createLandlord(@RequestBody HomeOwner landlord){
        try{
            HomeOwner newLandlord = landlordServices.createLandlord(landlord);
            return ResponseEntity.created(URI.create("")).body(newLandlord);
        } catch (AppExceptions e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{idLandlord}")
    public ResponseEntity<?> updateLandlord(@PathVariable("idLandlord") String idLandlord, @RequestBody HomeOwnerDto landlordBody) {
        try {
            HomeOwner landlord = landlordServices.updateLandlord(idLandlord, landlordBody);
            return ResponseEntity.ok(landlord);
        } catch (AppExceptions e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{idLandlord}")
    public ResponseEntity<?> deleteLandlord(@PathVariable("idLandlord") String idLandlord) {
        try {
            landlordServices.deleteLandlord(idLandlord);
            return ResponseEntity.ok().build();
        } catch (AppExceptions e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/{landlordId}/review/{reviewId}")
    public ResponseEntity<?> getReview(@PathVariable("reviewId") String reviewId, @PathVariable("landlordId") String landlordId){
        try{
            Optional<Review> review = landlordServices.getReview(landlordId, reviewId);
            return ResponseEntity.ok(review);
        } catch (AppExceptions e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/{landlordId}/review")
    public ResponseEntity<?> postReview(@PathVariable("landlordId") String landlordId, @RequestBody Review reviewDTO){
        try{
            Optional<Review> review = landlordServices.postReview(reviewDTO, landlordId);
            return ResponseEntity.ok(review.get());
        } catch (AppExceptions e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }*/
}
