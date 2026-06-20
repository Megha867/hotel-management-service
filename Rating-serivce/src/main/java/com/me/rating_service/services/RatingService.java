package com.me.rating_service.services;

import java.util.List;


import com.me.rating_service.entities.Rating;


public interface RatingService {
	
	 Rating createRating(Rating rating);
	 List<Rating> getAllRatings();
	 List<Rating> getRatingByUserId(String user_id);
	 List<Rating> getRatingByHotelId(String hotel_id);

}
