package com.me.hotelService.controller;

import java.util.List;
import java.util.Optional;

import com.me.hotelService.dto.HotelRequestDto;
import com.me.hotelService.dto.HotelResponseDto;
import com.me.hotelService.entities.IdempotencyRecord;
import com.me.hotelService.servicesImpl.IdempotencyServiceImpl;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

	@Autowired
	public IdempotencyServiceImpl idempotencyService;

	  @PostMapping
	  public ResponseEntity<?> creatHotel(@RequestHeader(value="idempotency-key", required = false) String key,
										 @RequestBody @Valid HotelRequestDto requestDto)
	  {
		  if(key == null || key.isEmpty()) {
			  log.info("idempotency key is not present");
			  return ResponseEntity.badRequest().body("Missing Idempotency key");
	  		}

		  Optional<IdempotencyRecord> keyExist = idempotencyService.find(key);

		  if(keyExist.isPresent()) {
			  log.info("idempotency key is present");
			  IdempotencyRecord record = keyExist.get();
				return ResponseEntity.status(record.getStatusCode()).body(record.getResponseBody());
		  }

		  log.info("START : API to persist hotel details");
		  HotelResponseDto createdHotel = hotelService.creatHotel(requestDto);

		  String response = "Hotel record is already created";
		  idempotencyService.createIdempotencyRecord(key, response, 200);
		  log.info("END : API to persist hotel details");

		  return ResponseEntity.ok().body(createdHotel);
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
