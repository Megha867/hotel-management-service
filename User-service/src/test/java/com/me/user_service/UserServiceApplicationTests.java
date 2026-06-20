package com.me.user_service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.me.user_service.entities.Rating;
import com.me.user_service.external.services.RatingService;

@SpringBootTest
class UserServiceApplicationTests {
	
	@Autowired
	private RatingService ratingService;

	@Test
	void contextLoads() {
	}
	
//	@Test
//	public void testCreatRating() {
//		Rating rating = new Rating();
//		rating.setUserId("");
//		rating.setHotelId("");
//		rating.setRating(10);
//		rating.setFeedback("Good");
//		rating.setHotel(null);
//		ratingService.createRating(rating);
//		System.out.println("new Rating created");
//	}
	
	

}
