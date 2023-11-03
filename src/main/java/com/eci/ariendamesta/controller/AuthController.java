package com.eci.ariendamesta.controller;

import com.eci.ariendamesta.exceptions.AppExceptions;
import com.eci.ariendamesta.model.Petition;
import com.eci.ariendamesta.model.dtos.UserRequestDTO;
import com.eci.ariendamesta.model.dtos.UserResponseDTO;
import com.eci.ariendamesta.service.servinterfaces.AuthServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/v1/auth")
public class AuthController {

    private final AuthServiceInterface authService;
    public AuthController(@Autowired AuthServiceInterface authService){
        this.authService = authService;
    }

    @PostMapping()
    public ResponseEntity<?> autheticate(@RequestBody UserRequestDTO userDTO){
        try {
            UserResponseDTO response = new UserResponseDTO(authService.autheticate(userDTO));
            return ResponseEntity.created(URI.create("")).body(response);
        } catch (AppExceptions e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
