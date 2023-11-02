package com.eci.ariendamesta.controller;

import com.eci.ariendamesta.exceptions.AppExceptions;
import com.eci.ariendamesta.model.Petition;
import com.eci.ariendamesta.model.dtos.PetitionDTO;
import com.eci.ariendamesta.service.servinterfaces.PetitionServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/v1/petition")
public class PetitionController {
    private final PetitionServiceInterface petitionService;
    public PetitionController(@Autowired PetitionServiceInterface petitionService){this.petitionService=petitionService;}

    @GetMapping()
    public ResponseEntity<?> findHomeOwnerProperties(@RequestParam Map<String,String> allRequestParams) {
        try {
            List<Petition> petition = petitionService.findEstatePetitions(allRequestParams);
            return ResponseEntity.ok(petition);
        } catch (AppExceptions e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @GetMapping("/{petitionId}")
    public ResponseEntity<?> getPetition(@PathVariable("petitionId") String petitionId){
        try {
            Petition petition = petitionService.findPetition(petitionId);
            return ResponseEntity.ok(petition);
        } catch (AppExceptions e){
            return ResponseEntity.notFound().build();
        }
    }
    @PostMapping()
    public ResponseEntity<?> createPetition(@RequestBody PetitionDTO petitionDTO) {
        try {
            Petition petition = petitionService.createPetition(petitionDTO);
            return ResponseEntity.ok(petition);
        } catch (AppExceptions e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @PutMapping("/{petitionId}")
    public ResponseEntity<?> updatePetition(@PathVariable("petitionId") String petitionId, @RequestBody PetitionDTO petitionDTO){
        try{
            Petition petition = petitionService.updatePetition(petitionId,petitionDTO);
            return ResponseEntity.ok(petition);
        } catch (AppExceptions e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @DeleteMapping("/{petitionId}")
    public ResponseEntity<?> deletePetition(@PathVariable("petitionId") String petitionId){
        try{
            petitionService.deletePetition(petitionId);
            return ResponseEntity.ok().build();
        } catch (AppExceptions e) {
            return ResponseEntity.notFound().build();
        }
    }
}
