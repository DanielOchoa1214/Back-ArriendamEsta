package com.eci.ariendamesta.controller;

import com.eci.ariendamesta.exceptions.AppExceptions;
import com.eci.ariendamesta.exceptions.EstateException;
import com.eci.ariendamesta.exceptions.UserException;
import com.eci.ariendamesta.model.User;
import com.eci.ariendamesta.model.estate.Estate;
import com.eci.ariendamesta.model.estate.EstateDto;
import com.eci.ariendamesta.model.landlord.Landlord;
import com.eci.ariendamesta.repository.LandlordRepositoryInterface;
import com.eci.ariendamesta.service.LandlordServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.eci.ariendamesta.model.Review;
import com.eci.ariendamesta.model.dtos.ReviewDTO;
import com.eci.ariendamesta.service.EstateServiceInterface;

import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping(value = "/v1/user/landlord/{landlordId}/estate")
public class EstateController {

    private final EstateServiceInterface estateServices;
    private final LandlordServiceInterface landlordServices;

    public EstateController(@Autowired EstateServiceInterface estateService,
                            @Autowired LandlordServiceInterface landlordServices){
        this.estateServices = estateService;
        this.landlordServices = landlordServices;
    }
    @GetMapping("/{estateId}")
    public ResponseEntity<?> readEstate(@PathVariable("landlordId") String landlordId, @PathVariable("estateId") String estateId) {
        try {
            Landlord landlord = landlordServices.foundById(landlordId);
            Estate estate = estateServices.getEstate(estateId, landlord);
            return ResponseEntity.ok(estate);
        } catch (AppExceptions e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity<?> createEstate(@PathVariable("landlordId") String landlordId, @RequestBody Estate estate) {
        try{
            Landlord landlord = landlordServices.foundById(landlordId);
            Estate newEstate = estateServices.createEstate(estate, landlord);
            return ResponseEntity.created(URI.create("")).body(newEstate);
        } catch (AppExceptions e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{estateId}")
    public ResponseEntity<?> updateEstate(@PathVariable("landlordId") String landlordId, @PathVariable("estateId") String estateId, @RequestBody EstateDto estate) {
        try {
            Landlord landlord = landlordServices.foundById(landlordId);
            Estate updateEstate = estateServices.updateEstate(estateId, estate, landlord);
            return ResponseEntity.ok(updateEstate);
        } catch (AppExceptions e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{estateId}")
    public ResponseEntity<?> deleteEstate(@PathVariable("landlordId") String landlordId, @PathVariable("estateId") String estateId) {
        try {
            Landlord landlord = landlordServices.foundById(landlordId);
            estateServices.deleteEstate(estateId, landlord);
            return ResponseEntity.ok().build();
        } catch (AppExceptions e) {
            return ResponseEntity.notFound().build();
        }
    }


    @GetMapping("/{estateId}/review/{reviewId}")
    public ResponseEntity<?> getReview(@PathVariable("reviewId") String reviewId,
                                            @PathVariable("landlordId") String landlordId,
                                            @PathVariable("estateId") String estateId) {
        try {
            Landlord landlord = landlordServices.foundById(landlordId);
            Optional<Review> review = estateServices.getReview(reviewId, landlord, estateId);
            return ResponseEntity.ok(review);
        } catch (AppExceptions e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/{estateId}/review")
    public ResponseEntity<?> postReview(@RequestBody ReviewDTO review, @PathVariable("landlordId") String landlordId,
                                        @PathVariable("estateId") String estateId){
        try {
            Landlord landlord = landlordServices.foundById(landlordId);
            Optional<Review> created = estateServices.postReview(review, landlord, estateId);
            return ResponseEntity.ok(created.get());
        } catch (AppExceptions e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
