package com.cg.hotelmanagement.dao;

import java.util.ArrayList;

import com.cg.hotelmanagement.bean.Customer;

public interface CustomerDAO {
		
	public void signIn(Customer cst);
	public ArrayList<Customer> viewCustomer() throws Exception;
	public boolean deleteCustomer(long customerId) throws Exception;
	public boolean updateCustomer(long customerId,String updateCustomerUserName,String updateCustomerPhoneNo,String updateCustomerEmailId) throws Exception;
	public Customer findById(long customerid) throws Exception;
}
