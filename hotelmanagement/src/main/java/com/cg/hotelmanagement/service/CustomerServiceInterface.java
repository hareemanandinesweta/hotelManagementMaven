package com.cg.hotelmanagement.service;

import java.util.ArrayList;
import java.util.HashMap;

import com.cg.hotelmanagement.bean.City;
import com.cg.hotelmanagement.bean.Customer;
import com.cg.hotelmanagement.bean.Hotel;
import com.cg.hotelmanagement.bean.Room;
import com.cg.hotelmanagement.exceptions.HotelManagementException;

public interface CustomerServiceInterface {
	
	public boolean logIn(Customer C, String id, HashMap<Customer, String> CustMap, String pass) throws HotelManagementException;
	public Customer custProfileDetails(Customer cust) throws Exception;
	public void viewHotelList(ArrayList<City> cityHotelList) throws Exception;
	public void bookRoom(ArrayList<Room> roomList, Customer cust, int roomAvail, int numBookRoomCount)throws Exception; 
	public void checkAvailablity(ArrayList<Room> roomList, int noOfRoomsAvai) throws Exception;
	public ArrayList<Hotel> myBooking(ArrayList<City> cityList) throws Exception;
	public String cancelRoom(ArrayList<Room> roomList, Customer cst) throws Exception;
	public ArrayList<Hotel> getHotelListFromCity(ArrayList<City> cityList, String cityName) throws Exception;

}
