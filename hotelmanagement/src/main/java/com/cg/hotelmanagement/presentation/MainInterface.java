package com.cg.hotelmanagement.presentation;

import java.sql.*;
import java.util.*;

import com.cg.hotelmanagement.bean.Admin;
import com.cg.hotelmanagement.bean.City;
import com.cg.hotelmanagement.bean.Customer;
import com.cg.hotelmanagement.bean.Hotel;
import com.cg.hotelmanagement.bean.Room;
import com.cg.hotelmanagement.dao.CustomerDAOImpl;
import com.cg.hotelmanagement.dao.HotelDAOImpl;
import com.cg.hotelmanagement.dao.RoomDAOImpl;
import com.cg.hotelmanagement.exceptions.*;
import com.cg.hotelmanagement.service.ServiceImpt;

public class MainInterface {

//	enum ROOM_COST {
//
//		AC(4000), NONAC(2000);
//
//		public final int val;
//
//		ROOM_COST(int val) {
//			this.val = val;
//		}
//	}
//
//	enum ROOM_TYPE {
//		AC, NON_AC;
//	}
	// Customer Cust = new Customer();

	public static void main(String args[]) throws HotelManagementException

	{
		boolean loggedin = false;
		int count = 0;
		boolean userEntered = false;
		String id;
		RoomDAOImpl roomDAO = new RoomDAOImpl();
		HotelDAOImpl hotelDAO = new HotelDAOImpl();
		CustomerDAOImpl customerDao = new CustomerDAOImpl();

		ServiceImpt serv = new ServiceImpt();
		Scanner scr = new Scanner(System.in);
//		ArrayList<Hotel> hotelList = new ArrayList<>(); // List of Hotels
//		ArrayList<Hotel> hotelList2 = new ArrayList<>();
//
//		ArrayList<Room> roomList = new ArrayList<>(); // List of rooms\
//		ArrayList<Room> roomList2 = new ArrayList<>(); // List of rooms
//		ArrayList<Room> roomList3 = new ArrayList<>(); // List of rooms

		ArrayList<City> cityList = new ArrayList<>();
		ArrayList<ArrayList<Room>> wholeRoomList = new ArrayList<>();
		// ArrayList<Customer> CustomerList = new ArrayList<>();
		ArrayList<Admin> adminList = new ArrayList<>();

		cityList.add(new City("11", "Bangalore", hotelDAO.hotelList));
		cityList.add(new City("11", "Delhi",hotelDAO.hotelList2));

//		roomList.add(new Room(101, ROOM_TYPE.AC.toString(), false, "swetha", null, null, ROOM_COST.AC.val, null));
//		roomList.add(new Room(102, ROOM_TYPE.NON_AC.toString(), false, "capg", null, null, ROOM_COST.NONAC.val, null));
//		roomList.add(
//				new Room(103, ROOM_TYPE.NON_AC.toString(), false, "peetha", null, null, ROOM_COST.NONAC.val, null));
//		roomList.add(new Room(104, ROOM_TYPE.AC.toString(), false, "capg", null, null, ROOM_COST.AC.val, null));
//		roomList.add(new Room(105, ROOM_TYPE.NON_AC.toString(), false, "aith", null, null, ROOM_COST.NONAC.val, null));
//		roomList.add(new Room(106, ROOM_TYPE.AC.toString(), false, "sonu", null, null, ROOM_COST.AC.val, null));
//		roomList.add(new Room(201, ROOM_TYPE.AC.toString(), false, "capg", null, null, ROOM_COST.AC.val, null));
//		roomList.add(new Room(202, ROOM_TYPE.AC.toString(), false, "karthik", null, null, ROOM_COST.AC.val, null));
//
//		roomList2.add(new Room(101, ROOM_TYPE.AC.toString(), false, "swetha", null, null, ROOM_COST.AC.val, null));
//		roomList2.add(new Room(102, ROOM_TYPE.NON_AC.toString(), false, "capg", null, null, ROOM_COST.NONAC.val, null));
//		roomList2.add(
//				new Room(103, ROOM_TYPE.NON_AC.toString(), false, "peetha", null, null, ROOM_COST.NONAC.val, null));
//		roomList2.add(new Room(104, ROOM_TYPE.AC.toString(), false, "capg", null, null, ROOM_COST.AC.val, null));
//		roomList2.add(new Room(105, ROOM_TYPE.NON_AC.toString(), false, "aith", null, null, ROOM_COST.NONAC.val, null));
//		roomList2.add(new Room(106, ROOM_TYPE.AC.toString(), false, "sonu", null, null, ROOM_COST.AC.val, null));
//		roomList2.add(new Room(201, ROOM_TYPE.AC.toString(), false, "capg", null, null, ROOM_COST.AC.val, null));
//		roomList2.add(new Room(202, ROOM_TYPE.AC.toString(), false, "karthik", null, null, ROOM_COST.AC.val, null));
//
//		roomList3.add(new Room(101, ROOM_TYPE.AC.toString(), false, "swetha", null, null, ROOM_COST.AC.val, null));
//		roomList3.add(new Room(102, ROOM_TYPE.NON_AC.toString(), false, "capg", null, null, ROOM_COST.NONAC.val, null));
//		roomList3.add(
//				new Room(103, ROOM_TYPE.NON_AC.toString(), false, "peetha", null, null, ROOM_COST.NONAC.val, null));
//		roomList3.add(new Room(104, ROOM_TYPE.AC.toString(), false, "capg", null, null, ROOM_COST.AC.val, null));
//		roomList3.add(new Room(105, ROOM_TYPE.NON_AC.toString(), false, "aith", null, null, ROOM_COST.NONAC.val, null));
//		roomList3.add(new Room(106, ROOM_TYPE.AC.toString(), false, "sonu", null, null, ROOM_COST.AC.val, null));
//		roomList3.add(new Room(201, ROOM_TYPE.AC.toString(), false, "capg", null, null, ROOM_COST.AC.val, null));
//		roomList3.add(new Room(202, ROOM_TYPE.AC.toString(), false, "karthik", null, null, ROOM_COST.AC.val, null));
		roomDAO.hardcodedValues();
		hotelDAO.hardCodedValues();
		
		// System.out.println(wholeRoomList);

		System.out.println(cityList);
		System.out.println("Log in as: \n1.Customer \n2.Admin");
		int option = scr.nextInt();

		boolean user = serv.ChooseInitialOption(option);

		if (user) {
			while (true) {

				customerDao.hardCodedValues();

//				System.out.println(CustomerList);

				// System.out.println(CustMap.entrySet());

				System.out.println("Enter you ID");
				id = scr.next();

				System.out.println("Enter your password");
				String pass = scr.next();
				for (Customer cs : CustomerDAOImpl.custList) {
					if (cs.getCustomerUsername().equalsIgnoreCase(id)) {
						loggedin = serv.logIn(cs, id, CustomerDAOImpl.CustMap, pass);
						break;

					}
				}

				if (loggedin) {
					while (true) {
						System.out.println(
								"Select an option:\n 1.Show your profile\n 2.Search hotel on the basis of City: \n 3.Show List of hotels and choose a hotel to check.\n 4.CheckAvailabilty\n 5.Cancel Booked room?\n 6.Check Out?");
						int opt = scr.nextInt();

						for (Customer cst : CustomerDAOImpl.custList) {

							if (cst.getCustomerUsername().equals(id)) {
								switch (opt) {
								case 1:
									System.out.println("--------------YOUR PROFILE---------------");
									serv.custProfileDetails(cst);
									break;
								case 2:
									System.out.println("Enter city name: \n1.Banglore\n2.Delhi");
									String cityOpt = scr.next();
									try {
										if (Integer.parseInt(cityOpt) > 2) {
											throw new HotelManagementException("Wrong input");
										}
									} catch (Exception e) {
										System.out.println("Wrong input");
									}
									serv.searchHotel(cityList, cityOpt);
									break;

								case 3:
									System.out.println("--------------HOTEL LIST-----------------");
									serv.viewHotelList(hotelDAO.hotelList);
									serv.viewHotelList(hotelDAO.hotelList2);
									System.out.println("Enter a hotel name you want to check");
									String hotOpt = scr.next();
									Hotel hotelSelected = serv.getHotel(hotOpt, hotelDAO.hotelList);

									// System.out.println(hotelSelected);

									System.out.println("------------Do you want to book room from "
											+ hotelSelected.getHotelName() + "(Y/N)------------");
									System.out.println(
											"------------------------------------------------------------------------\n");
									String yesno = scr.next();
									if (yesno.equalsIgnoreCase("Y")) {
										int noOfRoomsAvail = (int) hotelSelected.getRoomList().stream()
												.filter(r -> !r.isIsbooked()).count();
										System.out.println("No.of rooms available is:" + noOfRoomsAvail);
										System.out.println(
												"------------------------------------------------------------------------\n");
										System.out.println("Enter the number of rooms you want to book:");
										System.out.println(
												"------------------------------------------------------------------------\n");
										int numBook = scr.nextInt();
										serv.bookRoom(hotelSelected.getRoomList(), cst, noOfRoomsAvail, numBook);
									}

									else {
										System.out.println("See you later!");
										System.exit(1);
									}

									break;

								case 4:
									System.out.println("Enter a hotel name you want to see availabilty:");
									System.out.println(
											"------------------------------------------------------------------------\n");
									String hotOpt1 = scr.next();
									Hotel hotelSelected1 = serv.getHotel(hotOpt1, hotelDAO.hotelList);
									int noOfRoomsAvai = (int) hotelSelected1.getRoomList().stream()
											.filter(r -> !r.isIsbooked()).count();
									System.out.println("No.of rooms available is:" + noOfRoomsAvai);

									System.out.println(
											"------------------------------------------------------------------------\n");

									serv.checkAvailablity(roomDAO.roomList, noOfRoomsAvai);
									break;

								case 5:
									System.out.println(
											"------------------Cancellation Rooms for which hotel?------------------ ");
									System.out.println(
											"------------------------------------------------------------------------\n");
									String hotOpt2 = scr.next();
									Hotel hotelSelected3 = serv.getHotel(hotOpt2, hotelDAO.hotelList);
									serv.cancelRoom(hotelSelected3.getRoomList(), cst);
									break;

								case 6:
									System.out.println("Check out for" + cst.getCustomerUsername());
									serv.checkOut(cst.getCustomerUsername(), roomDAO.roomList);
									break;
//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
								/*
								 * System.out.println(count + " rooms are avalaible! Hurry up!");
								 * System.out.println( "Do you want to book a room from " +
								 * hotelSelected.getHotelName() + ": Y/N"); String bookopt = scr.next();
								 * 
								 * if (bookopt.equalsIgnoreCase("Y")) { System.out.println("Rooms available: ");
								 * for (Room rl : rlist) { if (!rl.isIsbooked()) {
								 * System.out.println(rl.getRoomid()); } }
								 * System.out.println("Which room do you want to book?"); int roomNo =
								 * scr.nextInt(); for (Room r : rlist) { if (roomNo == r.getRoomid()) {
								 * 
								 * System.out.println("Congratulations! Room Booked: " + r.getRoomid());
								 * r.setIsbooked(true); count = 0; } } System.out.println(rlist); }
								 */

//--------------------------------------------------------------------------------------------------------------------------------------------------

								}

							}
						}

					}
					// ----------------------------------------------------------------------------------------------
				} else {
					System.out.println("Invalid password or username!!");
				}
			}
		} else if (!user) {
			while (true) {

				HashMap<Admin, String> AdminHash = new HashMap<>();
				Admin A1 = new Admin("11");
				Admin A2 = new Admin("22");

				AdminHash.put(A1, "hahahah");
				AdminHash.put(A2, "hohohoho");
				while (true) {
					System.out.println("Enter your UserName");
					id = scr.next();
					System.out.println("Enter your Password");
					String pass2 = scr.next();

					boolean adminLoggedIn = serv.logInAdmin(A1, id, AdminHash, pass2);

					if (adminLoggedIn) {

						System.out.println("Admin switch cases");
						int opt2 = scr.nextInt();
						System.out.println("1. Add a new Customer");
						switch (opt2) {
						case 1:
							Customer newCust = new Customer();
							System.out.println("Enter Customer ID: ");
							long idnew = scr.nextLong();
							newCust.setCustomerId(idnew);

							System.out.println("Enter Customer Username: ");
							String userName = scr.next();
							newCust.setCustomerUsername(userName);

							System.out.println("Enter Customer first name: ");
							String fname = scr.next();
							newCust.setCustomerFirstName(fname);

							System.out.println("Enter Customer last name: ");
							String lname = scr.next();
							newCust.setCustomerLastName(lname);

							System.out.println("Enter Customer gender: ");
							String gen = scr.next();
							newCust.setGender(gen);

							System.out.println("Enter Customer address: ");
							String addr = scr.next();
							newCust.setCustomerAddress(addr);

							System.out.println("Enter Customer Adhaar No: ");
							String adhaarNo = scr.next();
							newCust.setCustomerIdNo(adhaarNo);

							System.out.println("Enter Customer phone No.: ");
							String phno = scr.next();
							newCust.setCustomerPhoneNo(phno);

							System.out.println("Enter Customer email id: ");
							String email = scr.next();
							newCust.setCustomerEmailId(email);

							System.out.println("Enter Customer password: ");
							String pass = scr.next();
							newCust.setCustomerPassword(pass);
							Customer newCustomer = new Customer(newCust.getCustomerId(), newCust.getCustomerUsername(),
									newCust.getCustomerFirstName(), newCust.getCustomerLastName(), newCust.getGender(),
									newCust.getCustomerAddress(), newCust.getCustomerIdNo(),
									newCust.getCustomerPhoneNo(), newCust.getCustomerEmailId(),
									newCust.getCustomerPassword());

							customerDao.signIn(newCustomer);
							System.out.println("Customer Added Successfully");

						}
					}

//						  
				}
			}

		} else {
			System.out.println("Invalid Option");
		}
	}
}
