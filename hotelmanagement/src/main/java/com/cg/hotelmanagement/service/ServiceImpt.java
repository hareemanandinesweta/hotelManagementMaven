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
	public String bookRoom(ArrayList<Room> roomList, Customer cust, int roomAvail, int numBookRoomCount) {
		int cost = 0;
		ArrayList<Long> lis = new ArrayList<Long>();
		if (numBookRoomCount > roomAvail) {
			return "Only this number of rooms available:" +roomAvail;
		}

		if (roomAvail > 0) {
			for (int i = 0; i < roomList.size(); i++) {
				if (roomList.get(i).isIsbooked() == false && numBookRoomCount > 0) {

					roomList.get(i).setIsbooked(true);
					roomList.get(i).setCustomer(cust);
				//	roomList.get(i).setCustomer(cust);
					 cost += roomList.get(i).getRoomcost();
					 cust.setBillAmount(cost);
					numBookRoomCount--;
					long r = roomList.get(i).getRoomid();
					
					lis.add(r);
				}
				
			}
			return "Room allocated successfully and room id is:" + lis;
		}
		if (roomAvail == 0) {
			return "rooms not available";
		}
		 return "Invalid Options";
	}
	@Override
	public String checkAvailablity(ArrayList<Room> roomList, int noOfRoomsAvai) {

		if (noOfRoomsAvai > 0) {
			for (int i = 0; i < roomList.size(); i++) {
				if (roomList.get(i).isIsbooked() == false) 
					return "room is available with room no: " + roomList.get(i).getRoomid();
				
			}
		} 
	 	
		return "No Rooms available to book.";
		
		
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
	public String refund(Customer cust) {
		int bill = cust.getBillAmount()-500;
		cust.setBillAmount(0);
		return "Refunded amount from Customer with custid:"+cust.getCustomerId()+" amount is:"+bill;
		
	}

	@Override
	public String payBill(Customer cust) {
		return "Customer with :"+cust.getCustomerId()+" Please pay: "+cust.getBillAmount();
	}

	@Override
	public void checkOut(String custID, ArrayList<Room> roomList) {
		{
		//	System.out.println("room checkout:" + custID);
			roomList.stream().filter(r -> r.isIsbooked())
					.filter(c -> c.getCustomer().getCustomerUsername().equalsIgnoreCase(custID)).forEach(r -> {
						r.setIsbooked(false);
						r.setCustomer(null);
					});

		}
		System.out.println("---------------Check out Successful!!----------------");

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

	
	
	@Override
	public void menu() {
		// TODO Auto-generated method stub
		
	}

}
