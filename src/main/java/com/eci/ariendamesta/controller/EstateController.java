package com.eci.ariendamesta.controller;

import com.eci.ariendamesta.model.Review;
import com.eci.ariendamesta.model.User;
import com.eci.ariendamesta.model.dtos.ReviewDTO;
import com.eci.ariendamesta.service.EstateServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(value = "/v1/user/landlord/{landlordId}/estate")
public class EstateController {

    private final EstateServiceInterface estateService;

    public EstateController(@Autowired EstateServiceInterface estateService){
        this.estateService = estateService;
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
