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
import com.cg.hotelmanagement.service.AdminServiceImpl;
import com.cg.hotelmanagement.service.CustomerValidations;
import com.cg.hotelmanagement.service.HotelValidation;
import com.cg.hotelmanagement.service.ServiceImpt;

public class MainInterface {

	static Logger logger = LogManager.getLogger(MainInterface.class);
	
	static Scanner scr = new Scanner(System.in);
	static AdminServiceImpl admin = new AdminServiceImpl();
	static CityDAOImpl cityDAO = new CityDAOImpl();

	public static void main(String args[]) throws HotelManagementException

	{
		System.out.println("----Started----\n");
		logger.info("This is an info msg");
		logger.fatal("This is a fatal msg");
		logger.warn("This is a warn msg");
		logger.error("This is a error msg");

		System.out.println("\n----Completed----");

		boolean loggedin = false;
		// int count = 0;
		// boolean userEntered = false;
		String id;
		RoomDAOImpl roomDAO = new RoomDAOImpl();
		HotelDAOImpl hotelDAO = new HotelDAOImpl();
		CustomerDAOImpl customerDao = new CustomerDAOImpl();
		CityDAOImpl cityDAO = new CityDAOImpl();
		ServiceImpt serv = new ServiceImpt();
		

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
					if (cs.getCustomerUsername().equalsIgnoreCase(id)) {
						loggedin = serv.logIn(cs, id, CustomerDAOImpl.CustMap, pass);
						break;

					}
				}
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
									System.out.println("Name: " + cs.getCustomerFirstName() + " "
											+ cs.getCustomerLastName() + "\nEmail ID: " + cs.getCustomerEmailId()
											+ "\nPhone Number: " + cs.getCustomerPhoneNo() + "\nAddress: "
											+ cs.getCustomerAddress() + "\nUserName: " + cs.getCustomerUsername());
									break;
								case 2:
									System.out.println("--------------CITIES---------------");
									for (City c : CityDAOImpl.cityList) {
										System.out.println(" " + c.getCityName());
									}
									System.out.println("Enter city name: ");
									String cityName = scr.next();
									//valide krna isko pattern="[A,Za-z]{1,20}";
									
									ArrayList<Hotel> citySelected= serv.getHotelListFromCity(CityDAOImpl.cityList, cityName);
									for(Hotel h: citySelected) {
										System.out.println(h.getHotelName() +", " +h.getHotelId() +", Contact no: "+h.getHotelPhoneNo());
									}
									break;

								case 3:
									System.out.println("--------------HOTEL LIST-----------------");
									serv.viewHotelList(CityDAOImpl.cityList);

									System.out.println("Enter city name: ");
									String SearchcityName = scr.next();
									// method banao city not found
									System.out.println(
											"------------These are the hotels in " + SearchcityName + "------------");
									ArrayList<Hotel> hotlist = serv.getHotelListFromCity(CityDAOImpl.cityList,
											SearchcityName);
									for (Hotel h : hotlist) {
										System.out.println("~" + h.getHotelName());
									}

									System.out.println("Enter a hotel name from " + SearchcityName);
									String hotelName = scr.next();
									// validate karo

									Hotel hotelSelected = serv.getHotel(hotelName, hotlist);

									// System.out.println(hotelSelected);

									System.out.println("------------Do you want to book from "
											+ hotelSelected.getHotelName().toUpperCase() + ","
											+ SearchcityName.toUpperCase() + "(Y/N)?------------");
									System.out.println(
											"------------------------------------------------------------------------\n");
									String yesno = scr.next();// 68978687btdbvcgfhk enum
									if (yesno.equalsIgnoreCase("Y")) {
										int noOfRoomsAvail = (int) hotelSelected.getRoomList().stream()
												.filter(r -> !r.isIsbooked()).count();
										System.out.println("No.of rooms available is:" + noOfRoomsAvail);
										System.out.println(
												"------------------------------------------------------------------------");
										System.out.println("Enter the number of rooms you want to book:");
										System.out.println(
												"------------------------------------------------------------------------\n");
										int numBook = scr.nextInt();// fghjghjghjg validate
										serv.bookRoom(hotelSelected.getRoomList(), cst, noOfRoomsAvail, numBook);
										HotelDAOImpl.bookedHotels.add(hotelSelected);

										System.out.println("Payment details...");
										serv.payBill(cst);
									}

									else {
										System.out.println("See you later!");
										System.exit(1);
									}

									break;

								case 4: // little problem with validations..
									ArrayList<Hotel> hotlist2 = new ArrayList<>();
									System.out.println("--------------Check Availability-----------------");
									serv.viewHotelList(CityDAOImpl.cityList);
									//while (true) {
										System.out.println("Enter city name: ");
										String SearchcityName2 = scr.next();// validate
									try {
										boolean valid = HotelValidation.cityNotFoundValidation(SearchcityName2);
										if (valid) {
											System.out.println("------------These are the hotels in " + SearchcityName2	+ "------------");
											hotlist2 = serv.getHotelListFromCity(CityDAOImpl.cityList,SearchcityName2);
											for (Hotel h : hotlist2) {
											System.out.println("~" + h.getHotelName());
											}
										//break;
									}
										else {
											throw new CityException("Wrong Input");
										}
									}
									catch (CityException e) {
										System.out.println(e);
									break;
									
									}
									System.out.println("Enter a hotel name from " + SearchcityName2);
									String hotelName2 = scr.next(); // validate

									Hotel hotelSelected1 = serv.getHotel(hotelName2, hotlist2);
									// Hotel hotelSelected1 = serv.getHotel(hotOpt1, HotelDAOImpl.hotelList);
									int noOfRoomsAvai = (int) hotelSelected1.getRoomList().stream()
											.filter(r -> !r.isIsbooked()).count();
									System.out.println("No.of rooms available is:" + noOfRoomsAvai);

									System.out.println(
											"------------------------------------------------------------------------\n");

									serv.checkAvailablity(hotelSelected1.getRoomList(), noOfRoomsAvai);
									
									break;
									//}
								case 5:
									System.out.println(
											"------------------Cancellation Rooms for which hotel?------------------ ");
									System.out.println(
											"------------------------------------------------------------------------\n");
									String hotOpt2 = scr.next();// valida//te76788978797
									Hotel hotelSelected3 = serv.getHotel(hotOpt2, HotelDAOImpl.hotelList);
									String cancelledRoom = serv.cancelRoom(hotelSelected3.getRoomList(), cst);
									System.out.println(
											"------------------------------------------------------------------------");
									System.out.println(cancelledRoom);
									System.out.println(
											"------------------------------------------------------------------------\n");

									System.out.println("Cancellation details are:");
									serv.refund(cst);
									break;

								case 6:
									System.out.println("Check out for: " + cst.getCustomerUsername());
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
						boolean quit = false;
						int choice = 0;
						printInstructions();
						while (!quit) {
							System.out.println("Enter your choice: ");
							choice = scr.nextInt();
							scr.nextLine();

							switch (choice) {
							case 1:
								printInstructions();
								break;
							case 2:
								addCity();
								break;
							case 3:
								removeCity();
								break;
							case 11:
								quit = true;
								break;
							default:
								System.out.println("Choose correct option please.");
							}
						}
					} else {
						System.out.println("Wrong Username or password");
					}
//						  
				}
			}

		} else {
			System.out.println("Invalid Option");
		}
	}
	public static void printInstructions() {
		System.out.println("\nPress ");
		System.out.println("\t 1 - To list options.");
		System.out.println("\t 2 - To add new location.");
		System.out.println("\t 3 - To remove added location.");

		System.out.println("\t 4 - To add new hotels.");
		System.out.println("\t 5 - To remove added hotels .");

		System.out.println("\t 6 - To add new rooms.");
		System.out.println("\t 7 - To remove added rooms.");

		System.out.println("\t 8 - To display list of loactions.");
		System.out.println("\t 9 - To display list of hotels in location.");
		System.out.println("\t 10 - To display list of rooms in hotels.");

		System.out.println("\t 11 - To quit application.");
	}
	
	public static void addCity() {
		System.out.println("Enter the city name :");
		String cityName = scr.next();

		System.out.println("Assign an ID to city please :");
		String cityId = scr.next();
		
		System.out.println("City " + cityName + " assigned ID number :" + cityId + " added.");

		System.out.println("Do you want to add any new hotel?" + "\n Choose 1. for Yes and 2. for NO.");
		int option = scr.nextInt();
		if (option == 1) {
			System.out.println("Please enter Hotel details.");
			System.out.println("Enter Hotel Name : ");
			String hotelName = scr.next();
			System.out.println("Assign a Hotel Id :");
			String hotelId = scr.next();
			System.out.println("Enter the Hotel Type : ");
			String hotelType = scr.next();
			System.out.println("Enter the Hotel Address : ");
			String hotelAdddress = scr.next();
			System.out.println("Enter the Hotel Contact Number : ");
			String hotelContact = scr.next();
			System.out.println("Enter the Room Details of hotel :");
			ArrayList<Room> roomlist = RoomDAOImpl.roomList;
			
			Hotel hotel = new Hotel(hotelId,hotelName,hotelType,hotelAdddress,hotelContact,roomlist);
			HotelDAOImpl.hotelList.add(hotel);
			City city = new City(cityId, cityName,HotelDAOImpl.hotelList);
			CityDAOImpl.cityList.add(city);
		}else if(option == 2) {
			City city = new City(cityId, cityName);
			CityDAOImpl.cityList.add(city);
		}
	}
	
	public static void removeCity() {
		System.out.println("Enter the City ID  to remove City : ");
		String cityId = scr.next();
		if(admin.removeCity(cityId)) {
		       System.out.println("City with City ID "+cityId+ " removed.");
		       
		       for(City city : cityDAO.getCityList()) {
		    	    System.out.println("Available List of Cities : ");
					System.out.println(city.getCityId()+" "+city.getCityName());
				}
	       }
	       else
	    	   System.out.println("City does not exist.");
		
	}
}