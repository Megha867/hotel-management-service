package com.me.hotelService.controller;

import java.util.List;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.me.hotelService.entities.Hotel;
import com.me.hotelService.services.HotelService;

@RestController
@Slf4j
@RequestMapping("/hotel")
public class HotelController {

	@Autowired
	public HotelService hotelService;
	
	  @PostMapping 
	  public Hotel creatHotel(@RequestBody Hotel hotel)
	  {
		  log.info("START : API to persist hotel details");
		  Hotel createdHotel = hotelService.creatHotel(hotel);
		  log.info("END : API to persist hotel details");
		  return createdHotel;
	  }
	  
	  
	  @GetMapping("/{hotelId}")
	  public Hotel getHotelById(@PathVariable String hotelId) {
		  return hotelService.getHotelById(hotelId);
	  }
	  
	  @GetMapping
	  public List<Hotel> getListOfHotels(){
		  return hotelService.getListOfHotels();
	  }
	 

}
