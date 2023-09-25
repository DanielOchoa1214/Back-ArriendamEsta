package com.eci.ariendamesta.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/property")
public class PropertyController {
/*

    private final PropertyServiceInterface estateServices;
    private final LandlordServiceInterface landlordServices;

    public EstateController(@Autowired PropertyServiceInterface estateService,
                            @Autowired LandlordServiceInterface landlordServices){
        this.estateServices = estateService;
        this.landlordServices = landlordServices;
    }
    @GetMapping("/{estateId}")
    public ResponseEntity<?> readEstate(@PathVariable("landlordId") String landlordId, @PathVariable("estateId") String estateId) {
        try {
            HomeOwner landlord = landlordServices.foundById(landlordId);
            Property estate = estateServices.getEstate(estateId, landlord);
            return ResponseEntity.ok(estate);
        } catch (AppExceptions e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity<?> createEstate(@PathVariable("landlordId") String landlordId, @RequestBody Property estate) {
        try{
            HomeOwner landlord = landlordServices.foundById(landlordId);
            Property newEstate = estateServices.createEstate(estate, landlord);
            return ResponseEntity.created(URI.create("")).body(newEstate);
        } catch (AppExceptions e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{estateId}")
    public ResponseEntity<?> updateEstate(@PathVariable("landlordId") String landlordId, @PathVariable("estateId") String estateId, @RequestBody PropertyDto estate) {
        try {
            HomeOwner landlord = landlordServices.foundById(landlordId);
            Property updateEstate = estateServices.updateEstate(estateId, estate, landlord);
            return ResponseEntity.ok(updateEstate);
        } catch (AppExceptions e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{estateId}")
    public ResponseEntity<?> deleteEstate(@PathVariable("landlordId") String landlordId, @PathVariable("estateId") String estateId) {
        try {
            HomeOwner landlord = landlordServices.foundById(landlordId);
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
            HomeOwner landlord = landlordServices.foundById(landlordId);
            Optional<Review> review = estateServices.getReview(reviewId, landlord, estateId);
            return ResponseEntity.ok(review);
        } catch (AppExceptions e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/{estateId}/review")
    public ResponseEntity<?> postReview(@RequestBody Review review, @PathVariable("landlordId") String landlordId,
                                        @PathVariable("estateId") String estateId){
        try {
            HomeOwner landlord = landlordServices.foundById(landlordId);
            Optional<Review> created = estateServices.postReview(review, landlord, estateId);
            return ResponseEntity.ok(created.get());
        } catch (AppExceptions e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/{estateId}/petition")
    public ResponseEntity<?> postPetition(@PathVariable("landlordId") String landlordId, @RequestBody PetitionDTO petitionDTO,
                                          @PathVariable("estateId") String estateId) {
        try{
            HomeOwner landlord = landlordServices.foundById(landlordId);
            Optional<Petition> created = estateServices.postPetition(petitionDTO, landlord,estateId);
            return ResponseEntity.ok(created.get());
        } catch (AppExceptions e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/{estateId}/petition/{petitionId}")
    public ResponseEntity<?> getpetiion(@PathVariable("petitionId") String petitionId,
                                       @PathVariable("landlordId") String landlordId,
                                       @PathVariable("estateId") String estateId) {
        try {
            HomeOwner landlord = landlordServices.foundById(landlordId);
            Optional<Petition> petition = estateServices.getPetition(petitionId, landlord, estateId);
            return ResponseEntity.ok(petition);
        } catch (AppExceptions e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
*/

}
