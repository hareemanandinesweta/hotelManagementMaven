package com.cg.hotelmanagement.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.stream.Collectors;

import com.cg.hotelmanagement.bean.City;
import com.cg.hotelmanagement.bean.Customer;
import com.cg.hotelmanagement.bean.Hotel;
import com.cg.hotelmanagement.bean.Room;
import com.cg.hotelmanagement.dao.HotelDAOImpl;
import com.cg.hotelmanagement.exceptions.HotelManagementException;

public class CustomerServiceImpl {
	public Hotel selectedHotel;
	public boolean userEntered;
	public boolean adminEntered;
	
	public boolean logIn(Customer C, String id, HashMap<Customer, String> CustMap, String pass)
			throws HotelManagementException {

		if (C.getCustomerUsername().equals(id) && CustMap.containsValue(pass)) {

			System.out.println("Welcome " + C.getCustomerUsername());
			userEntered = true;

		}
		try {
			if (!C.getCustomerUsername().equals(id) && CustMap.containsValue(pass)) {

				throw new HotelManagementException("Wrong Input");
			}

		} catch (Exception e) {

		}

		return userEntered;

	}
	public Customer custProfileDetails(Customer cust) {

		return cust;

	}
	public void viewHotelList(ArrayList<City> cityHotelList) {
		// TODO Auto-generated method stub
		for (City c : cityHotelList) {
			System.out.println("\n---------------------------");
			System.out.println("City: " + c.getCityName());
			System.out.println("---------------------------");
			for (Hotel h : c.getHotelList()) {

				System.out.println(h.getHotelName());
			}

		}

	}
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
					// cost += roomList.get(i).getRoomcost();
					// customer1.setBillAmount(cost);
					numBookRoomCount--;
					System.out.println("Room allocated successfully and room id is:" + roomList.get(i).getRoomid());

				}

			}
		}
		if (roomAvail == 0) {
			System.out.println("rooms not available");
		}
	}
	
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
	public ArrayList<Hotel> myBooking(ArrayList<City> cityList) {
		ArrayList<Hotel> bookingList = new ArrayList<>();
		//String noBooking;
		for (City c : cityList) {
			for (Hotel h : c.getHotelList()) {
				for (Room r : h.getRoomList()) {
					if (r.isIsbooked()) {
						//bookingList = h.getHotelName() + "-" + r.getRoomid();
						HotelDAOImpl.bookedHotels.add(h);
						
					} else {
					//	bookingList = "No Booked rooms yet.";
					}
				}
			}
		}
		return bookingList;
	}
	public String cancelRoom(ArrayList<Room> roomList, Customer cst) {
		String cancelled = "";
		ArrayList<Long> roomsIdList = (ArrayList<Long>) roomList.stream().filter(r -> r.isIsbooked())
				.filter(r -> r.getCustomer().getCustomerUsername().equalsIgnoreCase(cst.getCustomerUsername()))
				.map(r -> r.getRoomid()).collect(Collectors.toList());
		if (roomsIdList.isEmpty()) {
			return "No room is booked yet!";
		}

		else if (!roomsIdList.isEmpty()) {
			// return "You have following booked rooms: " + roomsIdList;
			for (Long roomNo : roomsIdList) {
				for (Room r : roomList) {
					if (r.getRoomid() == roomNo) {
						r.setIsbooked(false);
						r.setCustomer(null);

					}
				}
			}
			cancelled = "You have cancelled the following booked rooms" + roomsIdList;
		}
		return cancelled;
	}
	
	public ArrayList<Hotel> getHotelListFromCity(ArrayList<City> cityList, String cityName) {
		ArrayList<Hotel> hotlist = new ArrayList<>();
		for (City c : cityList) {
			if (cityName.equalsIgnoreCase(c.getCityName())) {

				for (Hotel h : c.getHotelList()) {

					hotlist.add(h);
				}
			}

		}
		return hotlist;
	}



}
