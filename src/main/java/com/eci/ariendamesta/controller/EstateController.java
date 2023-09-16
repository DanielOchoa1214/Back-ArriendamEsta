package com.eci.ariendamesta.controller;

import com.eci.ariendamesta.model.Estate;
import com.eci.ariendamesta.service.LandlordServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
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
}
