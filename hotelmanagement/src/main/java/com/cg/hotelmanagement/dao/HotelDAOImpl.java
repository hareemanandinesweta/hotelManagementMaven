package com.cg.hotelmanagement.dao;

import java.util.ArrayList;

import com.cg.hotelmanagement.bean.Hotel;

public class HotelDAOImpl implements HotelDAO{

	public static ArrayList<Hotel> hotelList = new ArrayList<>();
	public static ArrayList<Hotel> hotelList2 = new ArrayList<>();
	public static ArrayList<Hotel> hotelList3 = new ArrayList<>();
	public static ArrayList<Hotel> hotelList4 = new ArrayList<>();
	public static ArrayList<Hotel> hotelList5= new ArrayList<>();
	
	public static ArrayList<Hotel> bookedHotels= new ArrayList<>();
	
	//public static ArrayList<Hotel> hotelList2 = new ArrayList<>();
	
	
	public void addHotel() {
		
	}
	
	public void hardCodedValues() {
		RoomDAOImpl roomDAO = new RoomDAOImpl();
		
		Hotel H1 = new Hotel("111", "Taj", "5-Star", "SomeAdress", "9929391993", "4.2", RoomDAOImpl.roomList );
		Hotel H2 = new Hotel("112", "Dhaba", "1-Star", "SomeAdress", "9929391493", "3.5", RoomDAOImpl.roomList2);
		Hotel H3 = new Hotel("113", "Prakash", "3-Star", "SomeAdress", "4929391993", "4.4", RoomDAOImpl.roomList3);
		Hotel H4 = new Hotel("114", "Leela", "5-Star", "SomeAdress", "5929391993", "4.5", RoomDAOImpl.roomList4);
		Hotel H5 = new Hotel("115", "Marriote", "5-Star", "SomeAdress", "5924391993", "4.4", RoomDAOImpl.roomList5);
		Hotel H6 = new Hotel("116", "Kundan", "5-Star", "SomeAdress", "5929391993", "4.6", RoomDAOImpl.roomList6);
		Hotel H7 = new Hotel("117", "Capital-O", "5-Star", "SomeAdress", "5929391993", "4.6", RoomDAOImpl.roomList7);
		Hotel H8 = new Hotel("118", "Superb", "5-Star", "SomeAdress", "5929391993", "4.6", RoomDAOImpl.roomList8);
		Hotel H9 = new Hotel("119", "MadIsland", "5-Star", "SomeAdress", "5929391993", "4.6", RoomDAOImpl.roomList9);
		Hotel H0 = new Hotel("110", "Anor Londo", "5-Star", "SomeAdress", "5929391993", "4.6", RoomDAOImpl.roomList);

		hotelList.add(H0);
		hotelList.add(H1);
		hotelList.add(H3);
		hotelList.add(H4);

		hotelList2.add(H8);
		hotelList2.add(H2);
		hotelList2.add(H9);
		hotelList2.add(H4);
		
		hotelList3.add(H3);
		hotelList3.add(H2);
		hotelList3.add(H6);
		hotelList3.add(H4);
		
		hotelList4.add(H3);
		hotelList4.add(H7);
		hotelList4.add(H6);
		hotelList4.add(H5);
		
		hotelList5.add(H5);
		hotelList5.add(H8);
		hotelList5.add(H9);
		hotelList5.add(H0);

	}
}
