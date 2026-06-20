package com.me.hotelService.entities;

import lombok.Data;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Data
@Entity
@Table(name="hotel")
public class Hotel {
	
	@Id
	private String hotelId;
	private String name;
	private String location;
	private String about;
}
