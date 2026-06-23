package com.me.hotelService.services;

import java.util.List;

import com.me.hotelService.dto.HotelRequestDto;
import com.me.hotelService.dto.HotelResponseDto;
import com.me.hotelService.entities.Hotel;

public interface HotelService {
	
	public HotelResponseDto creatHotel(HotelRequestDto requestDto);
	public Hotel getHotelById(String hotelId);
	public List<Hotel> getListOfHotels();

}
