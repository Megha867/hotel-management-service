package com.me.rating_service.entities;

import lombok.Data;

import jakarta.persistence.*;

@Data
@Entity
@Table(name="rating")
public class Rating {
	
	@Id
	private String rating_id;
	private String userId;
	private String hotelId;
	private int rating;
	private String feedback;
	
}
