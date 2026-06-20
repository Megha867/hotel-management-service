package com.me.rating_service.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.me.rating_service.entities.Rating;

public interface RatingRepository extends JpaRepository<Rating, String>{
	
	List<Rating> findByUserId(String userId);
	List<Rating> findByHotelId(String hotelId);

}
