package com.cg.hotelmanagement.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.stream.Collectors;

import com.cg.hotelmanagement.bean.Admin;
import com.cg.hotelmanagement.bean.City;
import com.cg.hotelmanagement.bean.Customer;
import com.cg.hotelmanagement.bean.Hotel;
import com.cg.hotelmanagement.bean.Room;
import com.cg.hotelmanagement.exceptions.HotelManagementException;

public class ServiceImpt implements ServiceInteface {

	public Hotel selectedHotel;
	public boolean userEntered;
	public boolean adminEntered;

	@Override
	public boolean logIn(Customer C, String id, HashMap<Customer, String> CustMap, String pass) throws HotelManagementException {

		if (C.getCustomerUsername().equals(id) && CustMap.containsValue(pass)) {

			System.out.println("Welcome " + C.getCustomerUsername());
			userEntered = true;
			
		}
		try {
			if (!C.getCustomerUsername().equals(id) && CustMap.containsValue(pass))  {
				
				throw new HotelManagementException("Wrong Input");
			}
			
		}
		catch(Exception e) {
			
		}

		return userEntered;

	}

	public boolean logInAdmin(Admin A, String id, HashMap<Admin, String> AdMap, String pass) {

		if (A.getAdminID().equals(id) && AdMap.containsValue(pass)) {

			System.out.println("Welcome " + A.getAdminID());
			adminEntered = true;

		}
		return adminEntered;

	}

	/*
	 * if (C2.getCustId().equals(id) && CustMap.containsValue(pass)) {
	 * System.out.println("Welcome Harshit"); userEntered = true; break;
	 * 
	 * }
	 * 
	 * if (C3.getCustId().equals(id) && CustMap.containsValue(pass)) {
	 * System.out.println("Welcome Anand"); userEntered = true; break;
	 */

//	@Override
//	public void SignIn(Customer cust, ArrayList<Customer> list) {
//
//		list.add(cust);
//
//	}

	@Override
	public boolean ChooseInitialOption(int opt) {
		if (opt == 1) {
			return true;
		} else
			return false;

	}

	@Override
	public void custProfileDetails(Customer cust) {

		System.out.println(cust);

	}

	@Override
	public Hotel getHotel(String hotel, ArrayList<Hotel> hotelList) {

		for (Hotel hot : hotelList) {
			if (hot.getHotelName().equalsIgnoreCase(hotel)) {
				selectedHotel = hot;
			}
		}
		return selectedHotel;

	}

	@Override
	public void viewHotelList(ArrayList<Hotel> hotelList) {
		// TODO Auto-generated method stub
		for (Hotel hots : hotelList) {

			System.out.println(hots.getHotelName() + "\n");

		}

	}

	@Override
	public void bookRoom(ArrayList<Room> roomList, Customer cust, int roomAvail, int numBookRoomCount) {

		if (numBookRoomCount > roomAvail) {
			System.out.println("Only this number of rooms available:" + roomAvail);
		}

		if (roomAvail > 0) {
			for (int i = 0; i < roomList.size(); i++) {
				if (roomList.get(i).isIsbooked() == false && numBookRoomCount > 0) {

					roomList.get(i).setIsbooked(true);
					roomList.get(i).setCustomer(cust);
					roomList.get(i).setCustomer(cust);
//					cost += roomList.get(i).getRoomcost();
//					customer1.setBillAmount(cost);
					numBookRoomCount--;
					System.out.println("Room allocated successfully and room id is:" + roomList.get(i).getRoomid());
				}

			}
		}
		if (roomAvail == 0) {
			System.out.println("rooms not available");
		}
	}

	@Override
	public void checkAvailablity(ArrayList<Room> roomList, int noOfRoomsAvai) {

		if (noOfRoomsAvai > 0) {
			for (int i = 0; i < roomList.size(); i++) {
				if (roomList.get(i).isIsbooked() == false) {
					System.out.println("room is available with room no: " + roomList.get(i).getRoomid());
				}
			}
		} else {
			System.out.println("No Rooms available to book.");
		}
	}

	@Override
	public void formFill() {
		// TODO Auto-generated method stub

	}

	@Override
	public void viewCustomers() {
		// TODO Auto-generated method stub

	}

	@Override
	public void cancelRoom(ArrayList<Room> roomList, Customer cst) {
		System.out.println("In cancel room.....");

		ArrayList<Long> roomsIdList = (ArrayList<Long>) roomList.stream().filter(r -> r.isIsbooked())
				.filter(r -> r.getCustomer().getCustomerUsername().equalsIgnoreCase(cst.getCustomerUsername())).map(r -> r.getRoomid())
				.collect(Collectors.toList());
		if (roomsIdList.isEmpty()) {
			System.out.println("No room is booked yet!");
		}
		if (!roomsIdList.isEmpty()) {
			System.out.println("You have following booked rooms: " + roomsIdList);
		}
		for (Long roomNo : roomsIdList) {
			for (Room r : roomList) {
				if (r.getRoomid() == roomNo) {
					r.setIsbooked(false);
					r.setCustomer(null);
					System.out.println("------------------------------------------------------------------------\n");
					System.out.println("Room Booking cancelled!");
					System.out.println("------------------------------------------------------------------------\n");
				}
			}
		}
	}

	@Override
	public void refund() {
		// TODO Auto-generated method stub

	}

	@Override
	public void payBill() {

	}

	@Override
	public void checkOut(String custID, ArrayList<Room> roomList) {
		{
			System.out.println("room checkout:" + custID);
			roomList.stream().filter(r -> r.isIsbooked())
					.filter(c -> c.getCustomer().getCustomerUsername().equalsIgnoreCase(custID)).forEach(r -> {
						r.setIsbooked(false);
						r.setCustomer(null);
					});

		}
		System.out.println("---------------Check out Successful!!----------------");

	}

	@Override
	public void menu() {

		System.out.println("Services you can avail are as below");
		System.out.println("Press 1: For Customer form fill");
		System.out.println("Press 2: For View Customers");
		System.out.println("Press 3: Check Availability");
		System.out.println("Press 4: To Book Room and Pay Bill");
		System.out.println("Press 5: To Cancel Room and Refund");
		System.out.println("Press 6: For CheckOut");
	}

	@Override
	public void searchHotel(ArrayList<City> cityList, String cityName) {

		for (City c : cityList) {
			if (cityName.equalsIgnoreCase(c.getCityName())) {
				System.out.println("------------These are the hotels in " + c.getCityName() + "------------");
				for (Hotel h : c.getHotelList()) {

					System.out.println(h.getHotelName());
				}
			}
			// if().equalsIgnoreCase(cityName))
			{

			}
		}
	}

}
