package com.cg.hotelmanagement.service;

import java.util.ArrayList;
import java.util.HashMap;

import com.cg.hotelmanagement.bean.Admin;
import com.cg.hotelmanagement.bean.City;
import com.cg.hotelmanagement.bean.Customer;
import com.cg.hotelmanagement.bean.Hotel;
import com.cg.hotelmanagement.bean.Room;
import com.cg.hotelmanagement.exceptions.HotelManagementException;

public interface ServiceInteface  {
	
	public boolean logIn(Customer C, String id, HashMap<Customer, String> CustMap, String pass)throws HotelManagementException; 
	public boolean logInAdmin(Admin C, String id, HashMap<Admin, String> AdMap, String pass)throws HotelManagementException;
	//public void SignIn(Customer cust,  ArrayList<Customer> list );
	public boolean ChooseInitialOption(int opt);
	public void viewHotelList(ArrayList<City> cityHotelList);
	public Customer custProfileDetails(Customer cust);
	public Hotel getHotel(String hotel, ArrayList<Hotel> hotelList);
	public ArrayList<Hotel> getHotelListFromCity(ArrayList<City> cityList, String cityName);
	public String bookRoom(ArrayList<Room> roomList, Customer cust, int roomAvail, int numBookRoomCount);
	public String checkAvailablity(ArrayList<Room> roomList, int noOfRoomsAvai );
	
	public void viewCustomers();
	public String cancelRoom(ArrayList<Room> roomList, Customer cst);
	public void checkOut(String custID, ArrayList<Room> roomList);
	public void menu();
	public String payBill(Customer cust);
	public String refund(Customer cust);
	

}
