package com.cg.hotelmanagement.dao;

import java.util.ArrayList;
import java.util.HashMap;

import java.util.*;

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
	
	@Override
	public ArrayList<Customer> viewCustomer() throws Exception {
		// TODO Auto-generated method stub
		try {
			return custList;
	     }
	  catch(Exception e){
		  throw e;
	  }
	}
	
	@Override
	public boolean deleteCustomer(long customerId) {
		boolean del = false;
		Iterator<Customer> itrCust = custList.iterator();
		while(itrCust.hasNext()) {
			Customer cst = itrCust.next();
			if(cst.getCustomerId()==customerId) {
				itrCust.remove();
				del = true;
			}
		}
		return del;
		// TODO Auto-generated method stub
//		try {
//			boolean available=false;
//			for(int i = 0; i<custList.size();i++) {
//				if(custList.get(i).getCustomerId()==customerId) {
//					custList.remove(custList.get(i));
//					available=true;
//					break;
//				}
//			}
//			return available;
//		}
//		catch(Exception e){
//			throw e;
//		}
	}
	
	@Override
	public boolean updateCustomer(long customerId, String updateCustomerUserName, String updateCustomerPhoneNo,
			String updateCustomerEmailId) throws Exception {
		// TODO Auto-generated method stub
		try {
			boolean available=false;
			for(Customer c1:custList) {
				if(c1.getCustomerId()==customerId) {
					c1.setCustomerUsername(updateCustomerUserName);
					c1.setCustomerPhoneNo(updateCustomerPhoneNo);
					c1.setCustomerEmailId(updateCustomerEmailId);
					available=true;
					break;
				}
			}
			return available;
		}
		catch(Exception e){
			throw e;
		}
	}
  
	@Override
	public Customer findById(long customerid) throws Exception {
		Customer result = custList.stream().filter(n -> n.getCustomerId() == customerid).findAny().orElse(null);
		return result;
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
