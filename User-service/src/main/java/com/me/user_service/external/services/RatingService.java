package com.me.user_service.external.services;

import java.util.List;
import com.me.user_service.entities.Rating;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name="RATING-SERVICE")
public interface RatingService {

	@GetMapping("/rating/user/{user_id}")
	List<Rating> getListOfRatings(@PathVariable String user_id);
	
	@PostMapping("/rating")
	Rating createRating(Rating rating);
}
