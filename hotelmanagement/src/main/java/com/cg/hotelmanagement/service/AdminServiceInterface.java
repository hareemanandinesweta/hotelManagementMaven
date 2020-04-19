package com.cg.hotelmanagement.service;

import java.util.HashMap;

import com.cg.hotelmanagement.bean.Admin;
import com.cg.hotelmanagement.bean.Hotel;

public interface AdminServiceInterface {
	public boolean loginAdmin(Admin A, String id, HashMap<Admin, String> AdMap, String pass);
	
}
