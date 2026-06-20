package com.me.rating_service.services.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.me.rating_service.entities.Rating;
import com.me.rating_service.repositories.RatingRepository;
import com.me.rating_service.services.RatingService;

@Service
public class RatingServiceImpl implements RatingService{
	
	
	@Autowired
	private RatingRepository ratingRepository;

	@Override
	public Rating createRating(Rating rating) {
		String id = UUID.randomUUID().toString();
		rating.setRating_id(id);
		return ratingRepository.save(rating);
	}

	@Override
	public List<Rating> getAllRatings() {
		return ratingRepository.findAll();
	}

	@Override
	public List<Rating> getRatingByUserId(String user_id) {
		return ratingRepository.findByUserId(user_id);
	}

	@Override
	public List<Rating> getRatingByHotelId(String hotel_id) {
		return ratingRepository.findByHotelId(hotel_id);
	}

}
