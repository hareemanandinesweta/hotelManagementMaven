package com.cg.hotelmanagement.dao;

import java.util.ArrayList;

import com.cg.hotelmanagement.bean.Hotel;

public class HotelDAOImpl implements HotelDAO{

	public static ArrayList<Hotel> hotelList = new ArrayList<>();
	public static ArrayList<Hotel> hotelList2 = new ArrayList<>();
	
	
	public void addHotel() {
		
	}
	
	public void hardCodedValues() {
		RoomDAOImpl roomDAO = new RoomDAOImpl();
		
		Hotel H1 = new Hotel("111", "Taj", "5-Star", "SomeAdress", "9929391993", "4.2", roomDAO.roomList );
		Hotel H2 = new Hotel("112", "Dhaba", "1-Star", "SomeAdress", "9929391493", "3.5", roomDAO.roomList2);
		Hotel H3 = new Hotel("113", "Prakash", "3-Star", "SomeAdress", "4929391993", "4.4", roomDAO.roomList3);
		Hotel H4 = new Hotel("114", "Leela", "5-Star", "SomeAdress", "5929391993", "4.5", roomDAO.roomList);
		Hotel H5 = new Hotel("115", "Marriote", "5-Star", "SomeAdress", "5924391993", "4.4", roomDAO.roomList);
		Hotel H6 = new Hotel("114", "Hyatt", "5-Star", "SomeAdress", "5929391993", "4.6", roomDAO.roomList);

		hotelList.add(H1);
		hotelList.add(H2);
		hotelList.add(H3);
		hotelList.add(H4);

		hotelList2.add(H5);
		hotelList2.add(H2);
		hotelList2.add(H6);
		hotelList2.add(H4);

	}
}
