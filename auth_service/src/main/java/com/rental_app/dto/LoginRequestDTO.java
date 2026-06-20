package com.rental_app.dto;

import lombok.Data;

@Data
public class LoginRequestDTO {

    private long login_id;
    private String username;
    private String password;
}
