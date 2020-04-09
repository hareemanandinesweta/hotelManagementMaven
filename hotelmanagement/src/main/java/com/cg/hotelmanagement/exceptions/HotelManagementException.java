package com.cg.hotelmanagement.exceptions;

public class HotelManagementException extends Exception {
	
    private String hotelException;
    
    public HotelManagementException(String hotelException)
    {
        super(hotelException);
    }
}