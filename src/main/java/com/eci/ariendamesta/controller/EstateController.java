package com.eci.ariendamesta.controller;

import com.eci.ariendamesta.model.Estate;
import com.eci.ariendamesta.service.LandlordServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.eci.ariendamesta.model.Review;
import com.eci.ariendamesta.model.User;
import com.eci.ariendamesta.model.dtos.ReviewDTO;
import com.eci.ariendamesta.service.EstateServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/v1/user/landlord/{idLandlord}/estate")
public class EstateController {

    private LandlordServiceInterface landlordService;


    public EstateController(@Autowired LandlordServiceInterface landlordService) {
        this.landlordService = landlordService;
    }
    @GetMapping("/{idEstate}")
    public ResponseEntity<?> readEstate(@PathVariable("idLandlord") String idLandlord, @PathVariable("idEstate") String idEstate) {
        try {
            return ResponseEntity.ok().build();
        } catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping
    public ResponseEntity<?> createEstate(@PathVariable("idLandlord") String idLandlord, @RequestBody Estate estate) {
        try {
            //Landlord landlord = landlordService.getLandlord(idLandlord);
            //landlord.addEstate(estate);
            //Estate newEstate = landlord.getMyEstates().get(estate.getId());
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{idEstate}")
    public ResponseEntity<?> updateEstate(@PathVariable("idEstate") String idEstate, @RequestBody Estate estate) {
        try {
            //Estate updateEstate = estateServices.update(idEstate, estate);
            //return ResponseEntity.ok(updateEstate);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
        return null;
    }

    @DeleteMapping("/{idEstate}")
    public ResponseEntity<?> deleteEstate(@PathVariable("idEstate") String idEstate) {
        try {
            //estateServices.delete(idEstate);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    private final EstateServiceInterface estateService;

    public EstateController(@Autowired EstateServiceInterface estateService){
        this.estateService = estateService;
    }

    @GetMapping("/{estateId}/review/{reviewId}")
    public ResponseEntity<Review> getReview(@PathVariable("reviewId") String reviewId,
                                            @PathVariable("landlordId") String landlordId,
                                            @PathVariable("estateId") String estateId){
        Optional<Review> review = estateService.getReview(reviewId, landlordId, estateId);
        if(review.isPresent()){
            return ResponseEntity.ok(review.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/{estateId}/review")
    public ResponseEntity<Review> postReview(@RequestBody ReviewDTO review, @PathVariable("landlordId") String landlordId,
                                        @PathVariable("estateId") String estateId){
        Optional<Review> created = estateService.postReview(review, landlordId, estateId);
        if (created.isPresent()){
            return ResponseEntity.ok(created.get());
        } else {
            return ResponseEntity.badRequest().build();
        }
    }
}
