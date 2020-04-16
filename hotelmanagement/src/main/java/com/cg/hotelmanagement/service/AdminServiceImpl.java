package com.cg.hotelmanagement.service;

import java.util.HashMap;

import com.cg.hotelmanagement.bean.Admin;
import com.cg.hotelmanagement.bean.City;
import com.cg.hotelmanagement.dao.CityDAOImpl;


public class AdminServiceImpl implements AdminServiceInterface {
	
	boolean adminEntered;
	
	@Override
	public boolean loginAdmin(Admin A, String id, HashMap<Admin, String> AdMap, String pass) {
		if (A.getAdminID().equals(id) && AdMap.containsValue(pass)) {

			System.out.println("Welcome " + A.getAdminID());
			adminEntered = true;
		}
		
		return adminEntered;
	}

	@Override
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

	

}
