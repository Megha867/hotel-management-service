package com.me.hotelService.services;

import java.util.List;

import com.me.hotelService.entities.Hotel;

public interface HotelService {
	
	public Hotel creatHotel(Hotel hotel);
	public Hotel getHotelById(String hotelId);
	public List<Hotel> getListOfHotels();

}
