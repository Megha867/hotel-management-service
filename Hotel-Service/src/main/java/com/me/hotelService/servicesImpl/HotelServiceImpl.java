package com.me.hotelService.servicesImpl;

import java.util.List;
import java.util.UUID;

import com.me.hotelService.dto.HotelRequestDto;
import com.me.hotelService.dto.HotelResponseDto;
import com.me.hotelService.mapper.HotelMapper;
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

	@Autowired
	public HotelMapper mapper;

	@Override
	public HotelResponseDto creatHotel(HotelRequestDto requestDto) {
		String hotelId = UUID.randomUUID().toString();
		Hotel hotel = mapper.toEntity(requestDto);
		hotel.setHotelId(hotelId);
		log.info("Hotel repository call to persist hotel details - Hotel ID : {}", hotelId);
		Hotel createHotel = hotelRepository.save(hotel);
		log.info("Hotel details created with - Hotel ID : {}", hotelId);
		// log.error("Unable to save - throw error with exception and stack trace");
		return mapper.toResponseDto(createHotel);
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
