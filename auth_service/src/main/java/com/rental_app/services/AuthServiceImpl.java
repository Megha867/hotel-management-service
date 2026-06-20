package com.rental_app.services;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.rental_app.config.JwtTokenProvider;
import com.rental_app.dto.LoginRequestDTO;
import com.rental_app.dto.LoginResponseDTO;
import com.rental_app.model.Login;
import com.rental_app.repositories.AuthRepository;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    AuthRepository authRepository;

    @Autowired
    JwtTokenProvider jwtTokenProvider;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public LoginResponseDTO loginRequest(LoginRequestDTO loginRequestDTO) {


        Authentication authentication = authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(
            loginRequestDTO.getUsername(),
            loginRequestDTO.getPassword()
             ));

        LoginResponseDTO response = new LoginResponseDTO();

        UserDetails userDetails = (UserDetails) authentication.getPrincipal();

        String token = jwtTokenProvider.generateToken(userDetails);
        response.setToken(token);
        response.setMessage("Login successful");

        return response;
    }

}
