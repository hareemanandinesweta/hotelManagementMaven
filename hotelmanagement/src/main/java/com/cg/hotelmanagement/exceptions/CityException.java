package com.cg.hotelmanagement.exceptions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CityException extends Exception {
	
    private String cityException;
    
    static Logger logger = LogManager.getLogger(HotelManagementException.class);
    public CityException(String cityException)
    {
    	logger.error("No such city found!");   
    }
}