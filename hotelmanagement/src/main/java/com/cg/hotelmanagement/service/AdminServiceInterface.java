package com.cg.hotelmanagement.service;

import java.util.HashMap;

import com.cg.hotelmanagement.bean.Admin;

public interface AdminServiceInterface {
	public boolean loginAdmin(Admin A, String id, HashMap<Admin, String> AdMap, String pass);
	public boolean removeCity(String cityId);

}
