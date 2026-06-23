package com.me.hotelService.servicesImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.me.hotelService.dto.HotelRequestDto;
import com.me.hotelService.dto.HotelResponseDto;
import com.me.hotelService.exception.customeExceptions.HotelNotFoundException;
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
		Hotel hotel = mapper.toEntity(requestDto);
		hotel.setHotelId(UUID.randomUUID().toString());
		log.info("Hotel repository call to persist hotel details - Hotel ID : {}", hotel.getHotelId());
		Hotel createHotel = hotelRepository.save(hotel);
		log.info("Hotel details created with - Hotel ID : {}", hotel.getHotelId());
		// log.error("Unable to save - throw error with exception and stack trace");
		return mapper.toResponseDto(createHotel);
	}

	@Override
	public HotelResponseDto getHotelById(String hotelId) {
		Hotel hotel = hotelRepository.findById(hotelId).orElseThrow(() ->
				new HotelNotFoundException("Hotel not found"));
		return mapper.toResponseDto(hotel);
	}

	@Override
	public List<HotelResponseDto> getListOfHotels() {
		List<Hotel> hotels = hotelRepository.findAll();
		List<HotelResponseDto> responseHotel = new ArrayList<>();
		hotels.forEach(hotel ->
				responseHotel.add(mapper.toResponseDto(hotel)));
		return responseHotel;

	}

}
