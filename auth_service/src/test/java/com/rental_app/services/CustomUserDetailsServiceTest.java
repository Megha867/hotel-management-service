package com.rental_app.services;

import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.hibernate.service.spi.InjectService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import com.rental_app.model.Login;
import com.rental_app.repositories.AuthRepository;

@ExtendWith(MockitoExtension.class)
public class CustomUserDetailsServiceTest {

    @InjectMocks
    CustomUserDetailsService customUserDetailsService;

    @Mock
    AuthRepository authRepository;

    @Test
    public void shouldReturnUserIfPresentInDB() {
        Login login = new Login();
        login.setUsername("testuser");
        login.setPassword("testpassword");

        when(authRepository.findByUsername("testuser")).thenReturn(java.util.Optional.of(login));

        UserDetails userDetails = customUserDetailsService.loadUserByUsername("testuser");

        assert "testuser".equals(userDetails.getUsername());
    }

}
