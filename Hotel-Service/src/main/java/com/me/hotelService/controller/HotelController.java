package com.me.hotelService.controller;

import java.util.List;

import com.me.hotelService.dto.HotelRequestDto;
import com.me.hotelService.dto.HotelResponseDto;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.me.hotelService.entities.Hotel;
import com.me.hotelService.services.HotelService;

@RestController
@Slf4j
@Validated
@RequestMapping("/v1/hotel")
public class HotelController {

	@Autowired
	public HotelService hotelService;
	
	  @PostMapping 
	  public HotelResponseDto creatHotel(@RequestBody @Valid HotelRequestDto requestDto)
	  {
		  log.info("START : API to persist hotel details");
		  HotelResponseDto createdHotel = hotelService.creatHotel(requestDto);
		  log.info("END : API to persist hotel details");
		  return createdHotel;
	  }
	  
	  
	  @GetMapping("/{hotelId}")
	  public HotelResponseDto getHotelById(@PathVariable @NotBlank(message="Hotel id is required") String hotelId) {
		  return hotelService.getHotelById(hotelId);
	  }
	  
	  @GetMapping
	  public List<HotelResponseDto> getListOfHotels(){
		  // when no hotel data present returning - 200 OK with empty list
		  return hotelService.getListOfHotels();
	  }
	 

}
