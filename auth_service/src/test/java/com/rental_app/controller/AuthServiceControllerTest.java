package com.rental_app.controller;

import com.rental_app.auth_service.AuthServiceApplication;
import com.rental_app.dto.LoginRequestDTO;
import com.rental_app.dto.LoginResponseDTO;
import com.rental_app.services.AuthService;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest
@ContextConfiguration(classes = AuthServiceApplication.class)
@AutoConfigureMockMvc(addFilters = false)
@ExtendWith(MockitoExtension.class)
public class AuthServiceControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockitoBean
    AuthService authservice;

    @Mock
    AuthenticationManager authenticationManager;

    @Mock
    Authentication authentication;

    @Test
    void shouldAuthenticateUserWhenCredentialsAreValid() throws Exception {

        String payload = """
                {
                "username":"admin",
                "password":"12345"
                }
                """;

        LoginResponseDTO response = new LoginResponseDTO();
        response.setToken("jwt-token");
        response.setMessage("Login Successfully");

        when(authservice.loginRequest(any(LoginRequestDTO.class))).thenReturn(response);

        mockMvc.perform(post("/auth/v1/login")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payload))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.token").value("jwt-token"))
                .andExpect(jsonPath("$.message").value("Login Successfully"));

    }

//    @Test
//    void shouldNotAuthenticateUserWhenCredentialsAreInvalid() throws Exception {
//
//        String payload = """
//                {
//                "username":"admin",
//                "password":"wrongpassword"
//                }
//                """;
//
//        mockMvc.perform(post("/auth/login")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(payload))
//                .andExpect(status().isUnauthorized());
//
//    }
}
