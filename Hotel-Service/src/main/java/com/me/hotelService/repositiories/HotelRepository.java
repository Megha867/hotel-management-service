package com.me.hotelService.repositiories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.me.hotelService.entities.Hotel;

public interface HotelRepository extends JpaRepository<Hotel, String>{ }
