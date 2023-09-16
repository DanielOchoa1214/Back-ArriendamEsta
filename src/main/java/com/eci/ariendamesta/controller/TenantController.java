package com.eci.ariendamesta.controller;

import com.eci.ariendamesta.exceptions.UserException;
import com.eci.ariendamesta.model.tenant.Tenant;
import com.eci.ariendamesta.model.tenant.TenantDto;
import com.eci.ariendamesta.service.TenantServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping(value = "/v1/user/tenant")
public class TenantController {

    private TenantServiceInterface tenantServices;

    public TenantController(@Autowired  TenantServiceInterface tenantServices){
        this.tenantServices = tenantServices;
    }

    @GetMapping("/{idTenant}")
    public ResponseEntity<?> readTenant(@PathVariable("idTenant") String idTenant) {
        try {
            Tenant tenant = tenantServices.foundById(idTenant);
            return ResponseEntity.ok(tenant);
        } catch (UserException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<?> createTenant(@RequestBody Tenant Tenant){
        try{
            Tenant newTenant = tenantServices.createTenant(Tenant);
            return ResponseEntity.created(URI.create("")).body(newTenant);
        } catch (UserException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{idTenant}")
    public ResponseEntity<?> updateTenant(@PathVariable("idTenant") String idTenant, @RequestBody TenantDto tenantBody) {
        try {
            Tenant Tenant = tenantServices.updateTenant(idTenant, tenantBody);
            return ResponseEntity.ok(Tenant);
        } catch (UserException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{idTenant}")
    public ResponseEntity<?> deleteTenant(@PathVariable("idTenant") String idTenant) {
        try {
            tenantServices.deleteTenant(idTenant);
            return ResponseEntity.ok().build();
        } catch (UserException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
