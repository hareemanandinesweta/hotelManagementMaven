package com.cg.hotelmanagement.service;

import java.util.HashMap;

import com.cg.hotelmanagement.bean.Admin;


public class AdminServiceImpl {

	boolean adminEntered;
	public boolean logInAdmin(Admin A, String id, HashMap<Admin, String> AdMap, String pass) {

		if (A.getAdminID().equals(id) && AdMap.containsValue(pass)) {

			System.out.println("Welcome " + A.getAdminID());
			adminEntered = true;

		}
		return adminEntered;

	}

}
