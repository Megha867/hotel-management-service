package com.me.hotelService.dto;

import lombok.Data;

@Data
public class HotelResponseDto {

    private String hotelId;
    private String name;
    private String location;
    private String about;
}
