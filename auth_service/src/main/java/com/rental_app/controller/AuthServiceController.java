package com.rental_app.controller;

import com.rental_app.dto.LoginRequestDTO;
import com.rental_app.dto.LoginResponseDTO;
import com.rental_app.services.AuthService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/auth/v1")
public class AuthServiceController {

    private static final Logger logger = LoggerFactory.getLogger(AuthServiceController.class);

    @Autowired
    AuthService authService;

//    @Autowired
//    AuthenticationManager authenticationManager;

    @Autowired
    PasswordEncoder passwordEncoder;

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> getLoginDetails(@RequestBody LoginRequestDTO loginRequestDTO) {
        LoginResponseDTO response = authService.loginRequest(loginRequestDTO);
        return ResponseEntity.status(200).body(response);
    }
    
}
