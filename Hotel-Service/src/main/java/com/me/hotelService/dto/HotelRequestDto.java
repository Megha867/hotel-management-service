package com.me.hotelService.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class HotelRequestDto {

    @NotBlank(message="Hotel name is required")
    private String name;

    @NotBlank(message="Hotel location is required")
    private String location;

    @NotBlank
    private String about;
}
