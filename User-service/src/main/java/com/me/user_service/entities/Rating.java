package com.me.user_service.entities;

import lombok.Data;

@Data
public class Rating {

	private String rating_id;
	private String userId;
	private String hotelId;
	private int rating;
	private String feedback;
	private Hotel hotel;
}
