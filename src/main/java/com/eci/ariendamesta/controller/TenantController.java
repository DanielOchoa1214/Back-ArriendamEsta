package com.eci.ariendamesta.controller;

import com.eci.ariendamesta.exceptions.AppExceptions;
import com.eci.ariendamesta.exceptions.UserException;
import com.eci.ariendamesta.model.Review;
import com.eci.ariendamesta.model.tenant.Tenant;
import com.eci.ariendamesta.model.tenant.TenantDto;
import com.eci.ariendamesta.service.TenantServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping(value = "/v1/user/tenant")
public class TenantController {

    private TenantServiceInterface tenantServices;

    public TenantController(@Autowired  TenantServiceInterface tenantServices){
        this.tenantServices = tenantServices;
    }

    @GetMapping("/{tenantId}")
    public ResponseEntity<?> readTenant(@PathVariable("tenantId") String idTenant) {
        try {
            Tenant tenant = tenantServices.findById(idTenant);
            return ResponseEntity.ok(tenant);
        } catch (AppExceptions e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<?> createTenant(@RequestBody Tenant Tenant){
        try{
            Tenant newTenant = tenantServices.createTenant(Tenant);
            return ResponseEntity.created(URI.create("")).body(newTenant);
        } catch (AppExceptions e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{tenantId}")
    public ResponseEntity<?> updateTenant(@PathVariable("tenantId") String idTenant, @RequestBody TenantDto tenantBody) {
        try {
            Tenant Tenant = tenantServices.updateTenant(idTenant, tenantBody);
            return ResponseEntity.ok(Tenant);
        } catch (AppExceptions e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{tenantId}")
    public ResponseEntity<?> deleteTenant(@PathVariable("tenantId") String idTenant) {
        try {
            tenantServices.deleteTenant(idTenant);
            return ResponseEntity.ok().build();
        } catch (AppExceptions e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/{tenantId}/review/{reviewId}")
    public ResponseEntity<?> getReview(@PathVariable("reviewId") String reviewId, @PathVariable("tenantId") String tenantId){
        try{
            Optional<Review> review = tenantServices.getReview(tenantId, reviewId);
            return ResponseEntity.ok(review);
        } catch (AppExceptions e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/{tenantId}/review")
    public ResponseEntity<?> postReview(@PathVariable("tenantId") String tenantId, @RequestBody Review reviewDTO){
        try{
            Optional<Review> review = tenantServices.postReview(reviewDTO, tenantId);
            return ResponseEntity.ok(review.get());
        } catch (AppExceptions e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
