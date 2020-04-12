package com.cg.hotelmanagement.dao;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.cg.hotelmanagement.bean.Customer;

public class CustomerDAOImpl implements CustomerDAO{
	Logger logger = LogManager.getLogger(CustomerDAOImpl.class);
	public static HashMap<Customer, String> CustMap = new HashMap<>(); // String is password here.
	public static ArrayList<Customer> custList = new ArrayList<>();
	public void signIn(Customer cust) {

		custList.add(cust);
		logger.info("Customer added");
		System.out.println(custList);
		
		
	}
	
	
	public void hardCodedValues() {
		Customer C1 = new Customer(2001, "po1ar", "Dinesh","Sharma","Male", "12/2 BlueStreet", "", "9897210076", "dcloudrider@gmail.com", "muzikfreak");
		Customer C2 = new Customer(2002, "happy", "Harshit","Joshi","Male", "429/38", "", "7897210026", "joshiHarshit@gmail.com", "khabib");
		Customer C3 = new Customer(2003, "anand12", "Anand", "Soni", "Male", "441/1 Everest", "", "32186291442", "sonianand@gmail.com", "12345");
		Customer C4 = new Customer(2004, "swetha", "swetha", "vemula", "Female", "Bangalore", "", "9848012345", "svemula@gmail.com", "12345");
		
		
		custList.add(C1);
		custList.add(C2);
		custList.add(C3);
		custList.add(C4);
		
		CustMap.put(C1, C1.getCustomerPassword());
		CustMap.put(C2, C2.getCustomerPassword());
		CustMap.put(C3, C3.getCustomerPassword());
		CustMap.put(C4, C4.getCustomerPassword());
		

	}
	
}
