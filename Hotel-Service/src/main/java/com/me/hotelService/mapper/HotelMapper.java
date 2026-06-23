package com.me.hotelService.mapper;

import com.me.hotelService.dto.HotelRequestDto;
import com.me.hotelService.dto.HotelResponseDto;
import com.me.hotelService.entities.Hotel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface HotelMapper {

    @Mapping(target = "hotelId", ignore = true)
    Hotel toEntity(HotelRequestDto dto);

    HotelRequestDto toRequestDto(Hotel hotel);

    HotelResponseDto toResponseDto(Hotel hotel);
}
