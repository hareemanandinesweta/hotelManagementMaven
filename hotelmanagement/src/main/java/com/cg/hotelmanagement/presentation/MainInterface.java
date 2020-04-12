package com.cg.hotelmanagement.presentation;


import java.sql.*; 
import java.util.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.*;

import com.cg.hotelmanagement.bean.Admin;
import com.cg.hotelmanagement.bean.City;
import com.cg.hotelmanagement.bean.Customer;
import com.cg.hotelmanagement.bean.Hotel;
import com.cg.hotelmanagement.bean.Room;
import com.cg.hotelmanagement.dao.CityDAOImpl;
import com.cg.hotelmanagement.dao.CustomerDAOImpl;
import com.cg.hotelmanagement.dao.HotelDAOImpl;
import com.cg.hotelmanagement.dao.RoomDAOImpl;
import com.cg.hotelmanagement.exceptions.*;
import com.cg.hotelmanagement.service.CustomerValidations;
import com.cg.hotelmanagement.service.ServiceImpt;

public class MainInterface {


	static Logger logger = LogManager.getLogger(MainInterface.class);

	public static void main(String args[]) throws HotelManagementException

	{
		System.out.println("----Started----\n");
		logger.info("This is an info msg");
		logger.fatal("This is a fatal msg");
		logger.warn("This is a warn msg");
		logger.error("This is a error msg");
		
		System.out.println("\n----Completed----");
		
		
		boolean loggedin = false;
		//int count = 0;
		//boolean userEntered = false;
		String id;
		RoomDAOImpl roomDAO = new RoomDAOImpl();
		HotelDAOImpl hotelDAO = new HotelDAOImpl();
		CustomerDAOImpl customerDao = new CustomerDAOImpl();
		CityDAOImpl cityDAO = new CityDAOImpl();
		ServiceImpt serv = new ServiceImpt();
		Scanner scr = new Scanner(System.in);


//		ArrayList<City> cityList = new ArrayList<>();
//		
//		
//	
//		
		cityDAO.hardcodedvalues();
		roomDAO.hardcodedValues();
		hotelDAO.hardCodedValues();
		customerDao.hardCodedValues();
		// System.out.println(wholeRoomList);

		System.out.println(CityDAOImpl.cityList);
		System.out.println("Log in as: \n1.Customer \n2.Admin");
		int option = scr.nextInt();

		boolean user = serv.ChooseInitialOption(option);

		if (user) {
			while (true) {
				

				System.out.println("Enter you ID");
				id = scr.next();

				System.out.println("Enter your password");
				String pass = scr.next();
				for (Customer cs : CustomerDAOImpl.custList) {
					loggedin = serv.logIn(cs, id, CustomerDAOImpl.CustMap, pass); 
					break;
					
			}
				System.out.println(CustomerDAOImpl.custList);
				if (loggedin) {
				while (true) {     
						System.out.println(
								"Select an option:\n 1.Show your profile\n 2.Search hotel on the basis of City: \n 3.Book a room.\n 4.CheckAvailabilty\n 5.Cancel Booked room?\n 6.Check Out?");
						int opt = scr.nextInt();

						for (Customer cst : CustomerDAOImpl.custList) {

							if (cst.getCustomerUsername().equals(id)) {
								switch (opt) {
								case 1:
									System.out.println("--------------YOUR PROFILE---------------");
									Customer cs = serv.custProfileDetails(cst);
									System.out.println("Name: " +cs.getCustomerFirstName()+ " " +cs.getCustomerLastName() +"\nEmail ID: "+cs.getCustomerEmailId() +"\nPhone Number: "+cs.getCustomerPhoneNo()+"\nAddress: "+cs.getCustomerAddress()+"\nUserName: "+cs.getCustomerUsername() );
									
									break;
								case 2:
									System.out.println("--------------CITIES---------------");
									for(City c :CityDAOImpl.cityList) {
										System.out.println(" "+c.getCityName());
									}
									System.out.println("Enter city name: ");
									String cityName = scr.next();
									
									serv.getHotelListFromCity(CityDAOImpl.cityList, cityName);
									break;

								case 3:
									System.out.println("--------------HOTEL LIST-----------------");
									serv.viewHotelList(CityDAOImpl.cityList);
								
									System.out.println("Enter city name: ");
									String SearchcityName = scr.next();
									
									System.out.println("------------These are the hotels in " +SearchcityName + "------------");
									ArrayList<Hotel> hotlist = serv.getHotelListFromCity(CityDAOImpl.cityList, SearchcityName);
									for(Hotel h: hotlist) {
										System.out.println("~"+h.getHotelName());
									}
									
									System.out.println("Enter a hotel name from "+SearchcityName );
									String hotelName = scr.next();
									
									Hotel hotelSelected = serv.getHotel(hotelName, hotlist);
									
									// System.out.println(hotelSelected);

									System.out.println("------------Do you want to book from "
											+ hotelSelected.getHotelName().toUpperCase()+","+SearchcityName.toUpperCase() + "(Y/N)?------------");
									System.out.println(
											"------------------------------------------------------------------------\n");
									String yesno = scr.next();
									if (yesno.equalsIgnoreCase("Y")) {
										int noOfRoomsAvail = (int) hotelSelected.getRoomList().stream()
												.filter(r -> !r.isIsbooked()).count();
										System.out.println("No.of rooms available is:" + noOfRoomsAvail);
										System.out.println(
												"------------------------------------------------------------------------");
										System.out.println("Enter the number of rooms you want to book:");
										System.out.println(
												"------------------------------------------------------------------------\n");
										int numBook = scr.nextInt();
										serv.bookRoom(hotelSelected.getRoomList(), cst, noOfRoomsAvail, numBook);
										HotelDAOImpl.bookedHotels.add(hotelSelected);
									}

									else {
										System.out.println("See you later!");
										System.exit(1);
									}

									break;

								case 4:
									System.out.println("--------------Check Availability-----------------");
									serv.viewHotelList(CityDAOImpl.cityList);
								
									System.out.println("Enter city name: ");
									String SearchcityName2 = scr.next();
									
									System.out.println("------------These are the hotels in " +SearchcityName2 + "------------");
									ArrayList<Hotel> hotlist2 = serv.getHotelListFromCity(CityDAOImpl.cityList, SearchcityName2);
									for(Hotel h: hotlist2) {
										System.out.println("~"+h.getHotelName());
									}
									
									System.out.println("Enter a hotel name from "+SearchcityName2 );
									String hotelName2 = scr.next();
									
									Hotel hotelSelected1 = serv.getHotel(hotelName2, hotlist2);
									//Hotel hotelSelected1 = serv.getHotel(hotOpt1, HotelDAOImpl.hotelList);
									int noOfRoomsAvai = (int) hotelSelected1.getRoomList().stream()
											.filter(r -> !r.isIsbooked()).count();
									System.out.println("No.of rooms available is:" + noOfRoomsAvai);

									System.out.println(
											"------------------------------------------------------------------------\n");

									serv.checkAvailablity(hotelSelected1.getRoomList(), noOfRoomsAvai);
									break;

								case 5:
									System.out.println(
											"------------------Cancellation Rooms for which hotel?------------------ ");
									System.out.println(
											"------------------------------------------------------------------------\n");
									String hotOpt2 = scr.next();
									Hotel hotelSelected3 = serv.getHotel(hotOpt2, HotelDAOImpl.hotelList);
									String cancelledRoom = serv.cancelRoom(hotelSelected3.getRoomList(), cst);
									System.out.println("------------------------------------------------------------------------");
									System.out.println(cancelledRoom);
									System.out.println("------------------------------------------------------------------------\n");
									break;

								case 6:
									System.out.println("Check out for" + cst.getCustomerUsername());
									serv.checkOut(cst.getCustomerUsername(), RoomDAOImpl.roomList);
									break;
									
								case 7: 
									System.out.println("--------------My bookings--------------");
									System.out.println("You have bookings for these hotels: ");
									 
									ArrayList<Hotel> bookedList = serv.myBooking(CityDAOImpl.cityList);
									System.out.println(bookedList);

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
				Admin A1 = new Admin("po1ar");
				Admin A2 = new Admin("happy");

				AdminHash.put(A1, "muzikfreak");
				AdminHash.put(A2, "khabib");
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
							while(true) {
							System.out.println("Enter Customer ID: ");
							long idnew = scr.nextLong();
							try {	
								CustomerValidations.customerIdValidation(Long.toString(idnew));
								newCust.setCustomerId(idnew);
								break;
							}
							catch(HotelManagementException e) {
								System.out.println(e);
							}
							}
							while(true) {
							
								System.out.println("Enter Customer Username: ");
								String userName = scr.next();
								try {
									CustomerValidations.customerUserNameValidation(userName);
								newCust.setCustomerUsername(userName);
								break;
							}
							catch(HotelManagementException e) {
								System.out.println(e);
							}
							}
							while(true) {
							System.out.println("Enter Customer first name: ");
							String fname = scr.next();
							try {
							newCust.setCustomerFirstName(fname);
							CustomerValidations.customerFirstNameValidation(fname);
							break;
							}
							catch(HotelManagementException e) {
								System.out.println(e);
							}
							}
							while(true) {
							System.out.println("Enter Customer last name: ");
							String lname = scr.next();
							try {
								CustomerValidations.customerLastNameValidation(lname);
								newCust.setCustomerLastName(lname);	
								break;
							}
							catch(HotelManagementException e) {
								System.out.println(e);
							}
							}
							while(true) {
							System.out.println("Enter Customer gender: ");
							String gen = scr.next();
							try {
								CustomerValidations.genderValidation(gen);
								newCust.setGender(gen);
								break;
							}
							catch(HotelManagementException e) {
								System.out.println(e);
							}}
							while(true) {
							System.out.println("Enter Customer address: ");
							String addr = scr.next();
							try {
								CustomerValidations.customerAddressValidation(addr);
								newCust.setCustomerAddress(addr);
								break;
							}
							catch(HotelManagementException e){
								System.out.println(e);
							}
							}
							while(true) {
							System.out.println("Enter Customer Adhaar No: ");
							String adhaarNo = scr.next();
							try {
								CustomerValidations.customerIdValidation(adhaarNo);
								newCust.setCustomerIdNo(adhaarNo);
								break;
							}
							catch(HotelManagementException e) {
								System.out.println(e);
							}
							}
							while(true) {
							System.out.println("Enter Customer phone No.: ");
							String phno = scr.next();
							try {
								CustomerValidations.customerPhoneNumberValidation(phno);
								newCust.setCustomerPhoneNo(phno);	
								break;
							}
							catch(HotelManagementException e) {
								System.out.println(e);
							}
							
							}
							while(true) {
							System.out.println("Enter Customer email id: ");
							String email = scr.next();
							try {
								CustomerValidations.customerEmailIdValidation(email);
								newCust.setCustomerEmailId(email);
								break;
							}
							catch(HotelManagementException e) {
								System.out.println(e);
							}
							}
							while(true) {
							System.out.println("Enter Customer password: ");
							String pass = scr.next();
							try {
								CustomerValidations.customerpasswordValidation(pass);
								newCust.setCustomerPassword(pass);
								break;
							}
							catch(HotelManagementException e) {
								System.out.println(e);
							}
							}
							Customer newCustomer = new Customer(newCust.getCustomerId(), newCust.getCustomerUsername(),
									newCust.getCustomerFirstName(), newCust.getCustomerLastName(), newCust.getGender(),
									newCust.getCustomerAddress(), newCust.getCustomerIdNo(),
									newCust.getCustomerPhoneNo(), newCust.getCustomerEmailId(),
									newCust.getCustomerPassword());

							customerDao.signIn(newCustomer);
							System.out.println("Customer Added Successfully");

						}
					}
					else {
						System.out.println("Wrong Username or password");
					}
//						  
				}
			}
			

		} else {
			System.out.println("Invalid Option");
		}
	}
}
