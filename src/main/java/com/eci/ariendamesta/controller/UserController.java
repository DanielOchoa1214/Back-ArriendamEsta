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
    public ResponseEntity<?> createUser(@RequestBody UserRequestDTO userDTO){
        try{
            User user = services.createUser(userDTO);
            return ResponseEntity.created(URI.create("")).body(user);
        } catch (AppExceptions e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/{userId}")
    public ResponseEntity<?> getUser(@PathVariable("userId") String userId){
        try {
            User user = services.findById(userId);
            return ResponseEntity.ok(user);
        } catch (AppExceptions e){
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{userId}")
    public ResponseEntity<?> updateUser(@PathVariable("userId") String userId, @RequestBody UserRequestDTO userDTO){
        try{
            User user = services.updateUser(userId, userDTO);
            return ResponseEntity.ok(user);
        } catch (AppExceptions e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<?> deleteUser(@PathVariable("userId") String userId){
        try{
            services.deleteUser(userId);
            return ResponseEntity.ok().build();
        } catch (AppExceptions e) {
            return ResponseEntity.notFound().build();
        }
    }
}
