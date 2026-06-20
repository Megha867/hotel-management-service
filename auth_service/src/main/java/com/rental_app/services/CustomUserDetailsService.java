package com.rental_app.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.rental_app.model.Login;
import com.rental_app.repositories.AuthRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final static Logger logger = LoggerFactory.getLogger(CustomUserDetailsService.class);

    @Autowired
    AuthRepository authRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
            Optional<Login> loginOptional = authRepository.findByUsername(username);

             Login login =  loginOptional.orElseThrow(() -> new BadCredentialsException(""));

            List<GrantedAuthority> authorities =  new ArrayList<>();
            authorities.add(new SimpleGrantedAuthority("ROLE_USER"));

            return new org.springframework.security.core.userdetails.User(
                login.getUsername(),
                login.getPassword(), // must be encoded in DB (BCrypt)
                authorities
        );
    }
    


    
}
