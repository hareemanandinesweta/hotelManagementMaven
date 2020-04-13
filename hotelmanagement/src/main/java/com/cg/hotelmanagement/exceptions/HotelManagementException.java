package com.cg.hotelmanagement.exceptions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class HotelManagementException extends Exception {
	
    private String hotelException;
    
    static Logger logger = LogManager.getLogger(HotelManagementException.class);
    public HotelManagementException(String hotelException)
    {
    	logger.error("Pls Enter a valid hotel name!!");
       // super(hotelException);
    	//System.out.println("Enter valid Hotel Name");
    }
}