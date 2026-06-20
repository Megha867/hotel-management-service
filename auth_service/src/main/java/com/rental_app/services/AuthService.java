package com.rental_app.services;

import org.springframework.security.core.Authentication;

import com.rental_app.dto.LoginRequestDTO;
import com.rental_app.dto.LoginResponseDTO;

public interface AuthService {

    LoginResponseDTO loginRequest(LoginRequestDTO request);

}
