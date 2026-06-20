package com.me.hotelService.servicesImpl;

import java.util.List;
import java.util.UUID;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.me.hotelService.entities.Hotel;
import com.me.hotelService.repositiories.HotelRepository;
import com.me.hotelService.services.HotelService;

@Service
@Slf4j
public class HotelServiceImpl implements HotelService{
	
	@Autowired
	public HotelRepository hotelRepository;

	@Override
	public Hotel creatHotel(Hotel hotel) {
		String hotelId = UUID.randomUUID().toString();
		hotel.setHotelId(hotelId);
		log.info("Hotel repository call to persist hotel details - Hotel ID : {}", hotelId);
		Hotel createHotel = hotelRepository.save(hotel);
		log.info("Hotel details created with - Hotel ID : {}", hotelId);
		// log.error("Unable to save - throw error with exception and stack trace");
		return createHotel;
	}

	@Override
	public Hotel getHotelById(String hotelId) {
		return hotelRepository.findById(hotelId).get();
	}

	@Override
	public List<Hotel> getListOfHotels() {
		return hotelRepository.findAll();
	}

}
