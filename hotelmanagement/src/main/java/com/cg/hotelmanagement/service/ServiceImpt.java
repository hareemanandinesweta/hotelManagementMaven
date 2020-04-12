package com.cg.hotelmanagement.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.stream.Collectors;

import com.cg.hotelmanagement.bean.Admin;
import com.cg.hotelmanagement.bean.City;
import com.cg.hotelmanagement.bean.Customer;
import com.cg.hotelmanagement.bean.Hotel;
import com.cg.hotelmanagement.bean.Room;
import com.cg.hotelmanagement.dao.HotelDAOImpl;
import com.cg.hotelmanagement.exceptions.HotelManagementException;

public class ServiceImpt implements ServiceInteface {

	public Hotel selectedHotel;
	public boolean userEntered;
	public boolean adminEntered;

	@Override
	public boolean logIn(Customer C, String id, HashMap<Customer, String> CustMap, String pass)
			throws HotelManagementException {

		if (C.getCustomerUsername().equals(id) && CustMap.containsValue(pass)) {

			
			userEntered = true;

		}
		try {
			if (!C.getCustomerUsername().equals(id) && CustMap.containsValue(pass)) {
				userEntered = false;
				throw new HotelManagementException("Wrong Input");
			}

		} catch (Exception e) {
			System.out.println(e);
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

	// @Override
	// public void SignIn(Customer cust, ArrayList<Customer> list) {
	//
	// list.add(cust);
	//
	// }

	@Override
	public boolean ChooseInitialOption(int opt) {
		if (opt == 1) {
			return true;
		} else
			return false;

	}

	@Override
	public Customer custProfileDetails(Customer cust) {

		return cust;

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

	@Override
	public void bookRoom(ArrayList<Room> roomList, Customer cust, int roomAvail, int numBookRoomCount) {
		int cost = 0;
		if (numBookRoomCount > roomAvail) {
			System.out.println("Only this number of rooms available:" + roomAvail);
		}

		if (roomAvail > 0) {
			for (int i = 0; i < roomList.size(); i++) {
				if (roomList.get(i).isIsbooked() == false && numBookRoomCount > 0) {

					roomList.get(i).setIsbooked(true);
					roomList.get(i).setCustomer(cust);
					roomList.get(i).setCustomer(cust);
					 cost += roomList.get(i).getRoomcost();
					 cust.setBillAmount(cost);
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

	@Override
	public void formFill() {
		// TODO Auto-generated method stub

	}

	@Override
	public void viewCustomers() {
		// TODO Auto-generated method stub

	}

	@Override
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

	@Override
	public void refund(Customer cust) {
		System.out.println("Refunded amount from Customer with custid:"+cust.getCustomerId()+" amount is:"+(cust.getBillAmount()-500));
		cust.setBillAmount(0);
	}

	@Override
	public void payBill(Customer cust) {
		System.out.println("Customer with :"+cust.getCustomerId()+" Please pay: "+cust.getBillAmount());
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
