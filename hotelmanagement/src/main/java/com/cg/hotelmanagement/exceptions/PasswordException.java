package com.cg.hotelmanagement.exceptions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PasswordException extends Exception {
	
    private String hotelException;
    
    static Logger logger = LogManager.getLogger(HotelManagementException.class);
    public PasswordException(String hotelException)
    {
    	logger.error("Password is not acceptable!");
      
    }
}