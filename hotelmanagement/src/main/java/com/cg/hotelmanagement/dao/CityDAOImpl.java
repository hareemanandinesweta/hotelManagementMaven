package com.cg.hotelmanagement.dao;

import java.util.ArrayList;

import com.cg.hotelmanagement.bean.City;

public class CityDAOImpl {

	public static ArrayList<City> cityList = new ArrayList<>();

	public void hardcodedvalues() {
		cityList.add(new City("11", "Bangalore", HotelDAOImpl.hotelList));
		cityList.add(new City("12", "Delhi", HotelDAOImpl.hotelList2));
		cityList.add(new City("13", "Pune", HotelDAOImpl.hotelList3));
		cityList.add(new City("14", "Chennai", HotelDAOImpl.hotelList4));
		cityList.add(new City("15", "Hyderabad", HotelDAOImpl.hotelList5));
		cityList.add(new City("16", "Chandigarh", HotelDAOImpl.hotelList2));
		cityList.add(new City("17", "Mumbai", HotelDAOImpl.hotelList4));
	}
	
	public ArrayList<City> getCityList(){
		return this.cityList;
	}
	
	public boolean removeCity(String cityId) {
		for(int i = 0 ; i <CityDAOImpl.cityList.size();i++) {
			City city = CityDAOImpl.cityList.get(i);
			if((city.getCityId()).equals(cityId)) {
				CityDAOImpl.cityList.remove(i);
				return true;
			}			
		}
		return false;
	}
	
	public boolean findCity(String cityId) {
		for(int i = 0 ; i <CityDAOImpl.cityList.size();i++) {
			City city = CityDAOImpl.cityList.get(i);
			if((city.getCityId()).equals(cityId)){
				return true;
			}			
		}
		return false;
	}


}