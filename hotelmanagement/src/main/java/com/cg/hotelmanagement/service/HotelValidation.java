package com.cg.hotelmanagement.service;

import com.cg.hotelmanagement.bean.City;
import com.cg.hotelmanagement.dao.CityDAOImpl;
import com.cg.hotelmanagement.exceptions.CityException;

public class HotelValidation {
	static boolean valid ;
	public static boolean cityNotFoundValidation(String cityName) throws CityException{
		for(City c:CityDAOImpl.cityList) {
			if(cityName.equalsIgnoreCase(c.getCityName())) {
				valid= true;
			}
			else valid = false;
			
		}
		 return valid;
	}
	
}
