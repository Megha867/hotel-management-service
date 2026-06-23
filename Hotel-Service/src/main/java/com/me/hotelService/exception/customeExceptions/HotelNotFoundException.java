package com.me.hotelService.exception.customeExceptions;

public class HotelNotFoundException extends  RuntimeException {

    public HotelNotFoundException(String message) {
        super(message);
    }

}
