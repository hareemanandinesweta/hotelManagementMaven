package com.cg.hotelmanagement.exceptions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class NameException extends Exception {
	
    private String hotelException;
    
    static Logger logger = LogManager.getLogger(HotelManagementException.class);
    public NameException(String hotelException)
    {
    	logger.error("Please Enter a valid FirstName!!");
      
    }
}