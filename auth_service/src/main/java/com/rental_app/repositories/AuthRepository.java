package com.rental_app.repositories;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.rental_app.model.Login;

@Repository
public interface AuthRepository extends JpaRepository<Login, Long> {

    @Query("SELECT l FROM Login l WHERE l.username = :username")
    Optional<Login> findByUsername(@Param("username") String username);

}
