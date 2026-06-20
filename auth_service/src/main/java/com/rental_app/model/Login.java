package com.rental_app.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "login")
public class Login {

    @Id
    @GeneratedValue
    private Long login_id;

    private String username;
    private String password;
    private String role;

}
