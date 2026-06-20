package com.rental_app.services;

import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.rental_app.config.JwtTokenProvider;
import com.rental_app.dto.LoginRequestDTO;
import com.rental_app.dto.LoginResponseDTO;
import com.rental_app.model.Login;
import com.rental_app.repositories.AuthRepository;

@ExtendWith(MockitoExtension.class)
public class AuthServiceTest {

    @InjectMocks
    AuthServiceImpl authService;

    @Mock
    AuthRepository authRepository;

    @Mock
    JwtTokenProvider jwtTokenProvider;

    @Mock
    AuthenticationManager authenticationManager;

    @Mock
    PasswordEncoder passwordEncoder;

//    @Test
//    void shouldSendTokenWhenCredentialsAreValid() {
//        LoginRequestDTO request = new LoginRequestDTO();
//        request.setUsername("testuser");
//        request.setPassword("testpassword");
//
//        Login login = new Login();
//        login.setUsername("testuser");
//        login.setPassword("testpassword");
//
//        UserDetails userDetails = new User("testuser", "testpassword", new ArrayList<>());
//
//        when(authRepository.findByUsername("testuser")).thenReturn(java.util.Optional.of(login));
//        when(passwordEncoder.matches(request.getPassword(), login.getPassword())).thenReturn(true);
//        when(jwtTokenProvider.generateToken(userDetails)).thenReturn("jwt-token");
//
//        LoginResponseDTO response = authService.loginRequest(request);
//
//        assert "jwt-token".equals(response.getToken());
//        assert "Login successful".equals(response.getMessage());
//    }
}
