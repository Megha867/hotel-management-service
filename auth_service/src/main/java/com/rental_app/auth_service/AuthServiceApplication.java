package com.rental_app.auth_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {
		"com.rental_app.controller",
		"com.rental_app.services",
		"com.rental_app.config",
		"com.rental_app.exceptions",
		"com.rental_app.dto"
})
@EntityScan("com.rental_app.model")
@EnableJpaRepositories(basePackages = "com.rental_app.repositories")
public class AuthServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuthServiceApplication.class, args);
	}

}
