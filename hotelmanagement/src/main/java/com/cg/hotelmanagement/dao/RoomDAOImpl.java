package com.cg.hotelmanagement.dao;

import java.util.ArrayList;
import java.util.List;

import com.cg.hotelmanagement.bean.City;
import com.cg.hotelmanagement.bean.Hotel;
import com.cg.hotelmanagement.bean.Room;
//import com.cg.hotelmanagement.presentation.MainInterface.ROOM_COST;
//import com.cg.hotelmanagement.presentation.MainInterface.ROOM_TYPE;

public class RoomDAOImpl {

	public enum ROOM_COST {

		AC(4000), NONAC(2000);

		public final int val;

		ROOM_COST(int val) {
			this.val = val;
		}
	}

	public enum ROOM_TYPE {
		AC, NON_AC;
	}

	public static ArrayList<Room> roomList = new ArrayList<>();
	public static ArrayList<Room> roomList2 = new ArrayList<>();
	public static ArrayList<Room> roomList3 = new ArrayList<>();
	public static ArrayList<Room> roomList4 = new ArrayList<>();
	public static ArrayList<Room> roomList5 = new ArrayList<>();
	public static ArrayList<Room> roomList6 = new ArrayList<>();
	public static ArrayList<Room> roomList7 = new ArrayList<>();
	public static ArrayList<Room> roomList8 = new ArrayList<>();
	public static ArrayList<Room> roomList9 = new ArrayList<>();

	public void hardcodedValues() {
		roomList.add(new Room(101, ROOM_TYPE.AC.toString(), false, "swetha", null, null, ROOM_COST.AC.val, null));
		roomList.add(new Room(102, ROOM_TYPE.NON_AC.toString(), false, "capg", null, null, ROOM_COST.NONAC.val, null));
		roomList.add(
				new Room(103, ROOM_TYPE.NON_AC.toString(), false, "peetha", null, null, ROOM_COST.NONAC.val, null));
		roomList.add(new Room(104, ROOM_TYPE.AC.toString(), false, "capg", null, null, ROOM_COST.AC.val, null));
		roomList.add(new Room(105, ROOM_TYPE.NON_AC.toString(), false, "aith", null, null, ROOM_COST.NONAC.val, null));
		roomList.add(new Room(106, ROOM_TYPE.AC.toString(), false, "sonu", null, null, ROOM_COST.AC.val, null));
		roomList.add(new Room(201, ROOM_TYPE.AC.toString(), false, "capg", null, null, ROOM_COST.AC.val, null));
		roomList.add(new Room(202, ROOM_TYPE.AC.toString(), false, "karthik", null, null, ROOM_COST.AC.val, null));

		roomList2.add(new Room(101, ROOM_TYPE.AC.toString(), false, "swetha", null, null, ROOM_COST.AC.val, null));
		roomList2.add(new Room(102, ROOM_TYPE.NON_AC.toString(), false, "capg", null, null, ROOM_COST.NONAC.val, null));
		roomList2.add(
				new Room(103, ROOM_TYPE.NON_AC.toString(), false, "peetha", null, null, ROOM_COST.NONAC.val, null));
		roomList2.add(new Room(104, ROOM_TYPE.AC.toString(), false, "capg", null, null, ROOM_COST.AC.val, null));
		roomList2.add(new Room(105, ROOM_TYPE.NON_AC.toString(), false, "aith", null, null, ROOM_COST.NONAC.val, null));
		roomList2.add(new Room(106, ROOM_TYPE.AC.toString(), false, "sonu", null, null, ROOM_COST.AC.val, null));
		roomList2.add(new Room(201, ROOM_TYPE.AC.toString(), false, "capg", null, null, ROOM_COST.AC.val, null));
		roomList2.add(new Room(202, ROOM_TYPE.AC.toString(), false, "karthik", null, null, ROOM_COST.AC.val, null));

		roomList3.add(new Room(101, ROOM_TYPE.AC.toString(), false, "swetha", null, null, ROOM_COST.AC.val, null));
		roomList3.add(new Room(102, ROOM_TYPE.NON_AC.toString(), false, "capg", null, null, ROOM_COST.NONAC.val, null));
		roomList3.add(
				new Room(103, ROOM_TYPE.NON_AC.toString(), false, "peetha", null, null, ROOM_COST.NONAC.val, null));
		roomList3.add(new Room(104, ROOM_TYPE.AC.toString(), false, "capg", null, null, ROOM_COST.AC.val, null));
		roomList3.add(new Room(105, ROOM_TYPE.NON_AC.toString(), false, "aith", null, null, ROOM_COST.NONAC.val, null));
		roomList3.add(new Room(106, ROOM_TYPE.AC.toString(), false, "sonu", null, null, ROOM_COST.AC.val, null));
		roomList3.add(new Room(201, ROOM_TYPE.AC.toString(), false, "capg", null, null, ROOM_COST.AC.val, null));
		roomList3.add(new Room(202, ROOM_TYPE.AC.toString(), false, "karthik", null, null, ROOM_COST.AC.val, null));

		roomList4.add(new Room(101, ROOM_TYPE.AC.toString(), false, "swetha", null, null, ROOM_COST.AC.val, null));
		roomList4.add(new Room(102, ROOM_TYPE.NON_AC.toString(), false, "capg", null, null, ROOM_COST.NONAC.val, null));
		roomList4.add(
				new Room(103, ROOM_TYPE.NON_AC.toString(), false, "peetha", null, null, ROOM_COST.NONAC.val, null));
		roomList4.add(new Room(104, ROOM_TYPE.AC.toString(), false, "capg", null, null, ROOM_COST.AC.val, null));
		roomList4.add(new Room(105, ROOM_TYPE.NON_AC.toString(), false, "aith", null, null, ROOM_COST.NONAC.val, null));
		roomList4.add(new Room(106, ROOM_TYPE.AC.toString(), false, "sonu", null, null, ROOM_COST.AC.val, null));
		roomList4.add(new Room(201, ROOM_TYPE.AC.toString(), false, "capg", null, null, ROOM_COST.AC.val, null));
		roomList4.add(new Room(202, ROOM_TYPE.AC.toString(), false, "karthik", null, null, ROOM_COST.AC.val, null));

		roomList5.add(new Room(101, ROOM_TYPE.AC.toString(), false, "swetha", null, null, ROOM_COST.AC.val, null));
		roomList5.add(new Room(102, ROOM_TYPE.NON_AC.toString(), false, "capg", null, null, ROOM_COST.NONAC.val, null));
		roomList5.add(
				new Room(103, ROOM_TYPE.NON_AC.toString(), false, "peetha", null, null, ROOM_COST.NONAC.val, null));
		roomList5.add(new Room(104, ROOM_TYPE.AC.toString(), false, "capg", null, null, ROOM_COST.AC.val, null));
		roomList5.add(new Room(105, ROOM_TYPE.NON_AC.toString(), false, "aith", null, null, ROOM_COST.NONAC.val, null));
		roomList5.add(new Room(106, ROOM_TYPE.AC.toString(), false, "sonu", null, null, ROOM_COST.AC.val, null));
		roomList5.add(new Room(201, ROOM_TYPE.AC.toString(), false, "capg", null, null, ROOM_COST.AC.val, null));
		roomList5.add(new Room(202, ROOM_TYPE.AC.toString(), false, "karthik", null, null, ROOM_COST.AC.val, null));

		roomList6.add(new Room(101, ROOM_TYPE.AC.toString(), false, "swetha", null, null, ROOM_COST.AC.val, null));
		roomList6.add(new Room(102, ROOM_TYPE.NON_AC.toString(), false, "capg", null, null, ROOM_COST.NONAC.val, null));
		roomList6.add(
				new Room(103, ROOM_TYPE.NON_AC.toString(), false, "peetha", null, null, ROOM_COST.NONAC.val, null));
		roomList6.add(new Room(104, ROOM_TYPE.AC.toString(), false, "capg", null, null, ROOM_COST.AC.val, null));
		roomList6.add(new Room(105, ROOM_TYPE.NON_AC.toString(), false, "aith", null, null, ROOM_COST.NONAC.val, null));
		roomList6.add(new Room(106, ROOM_TYPE.AC.toString(), false, "sonu", null, null, ROOM_COST.AC.val, null));
		roomList6.add(new Room(201, ROOM_TYPE.AC.toString(), false, "capg", null, null, ROOM_COST.AC.val, null));
		roomList6.add(new Room(202, ROOM_TYPE.AC.toString(), false, "karthik", null, null, ROOM_COST.AC.val, null));

		roomList7.add(new Room(101, ROOM_TYPE.AC.toString(), false, "swetha", null, null, ROOM_COST.AC.val, null));
		roomList7.add(new Room(102, ROOM_TYPE.NON_AC.toString(), false, "capg", null, null, ROOM_COST.NONAC.val, null));
		roomList7.add(
				new Room(103, ROOM_TYPE.NON_AC.toString(), false, "peetha", null, null, ROOM_COST.NONAC.val, null));
		roomList7.add(new Room(104, ROOM_TYPE.AC.toString(), false, "capg", null, null, ROOM_COST.AC.val, null));
		roomList7.add(new Room(105, ROOM_TYPE.NON_AC.toString(), false, "aith", null, null, ROOM_COST.NONAC.val, null));
		roomList7.add(new Room(106, ROOM_TYPE.AC.toString(), false, "sonu", null, null, ROOM_COST.AC.val, null));
		roomList7.add(new Room(201, ROOM_TYPE.AC.toString(), false, "capg", null, null, ROOM_COST.AC.val, null));
		roomList7.add(new Room(202, ROOM_TYPE.AC.toString(), false, "karthik", null, null, ROOM_COST.AC.val, null));

		roomList8.add(new Room(101, ROOM_TYPE.AC.toString(), false, "swetha", null, null, ROOM_COST.AC.val, null));
		roomList8.add(new Room(102, ROOM_TYPE.NON_AC.toString(), false, "capg", null, null, ROOM_COST.NONAC.val, null));
		roomList8.add(
				new Room(103, ROOM_TYPE.NON_AC.toString(), false, "peetha", null, null, ROOM_COST.NONAC.val, null));
		roomList8.add(new Room(104, ROOM_TYPE.AC.toString(), false, "capg", null, null, ROOM_COST.AC.val, null));
		roomList8.add(new Room(105, ROOM_TYPE.NON_AC.toString(), false, "aith", null, null, ROOM_COST.NONAC.val, null));
		roomList8.add(new Room(106, ROOM_TYPE.AC.toString(), false, "sonu", null, null, ROOM_COST.AC.val, null));
		roomList8.add(new Room(201, ROOM_TYPE.AC.toString(), false, "capg", null, null, ROOM_COST.AC.val, null));
		roomList8.add(new Room(202, ROOM_TYPE.AC.toString(), false, "karthik", null, null, ROOM_COST.AC.val, null));

		roomList9.add(new Room(101, ROOM_TYPE.AC.toString(), false, "swetha", null, null, ROOM_COST.AC.val, null));
		roomList9.add(new Room(102, ROOM_TYPE.NON_AC.toString(), false, "capg", null, null, ROOM_COST.NONAC.val, null));
		roomList9.add(
				new Room(103, ROOM_TYPE.NON_AC.toString(), false, "peetha", null, null, ROOM_COST.NONAC.val, null));
		roomList9.add(new Room(104, ROOM_TYPE.AC.toString(), false, "capg", null, null, ROOM_COST.AC.val, null));
		roomList9.add(new Room(105, ROOM_TYPE.NON_AC.toString(), false, "aith", null, null, ROOM_COST.NONAC.val, null));
		roomList9.add(new Room(106, ROOM_TYPE.AC.toString(), false, "sonu", null, null, ROOM_COST.AC.val, null));
		roomList9.add(new Room(201, ROOM_TYPE.AC.toString(), false, "capg", null, null, ROOM_COST.AC.val, null));
		roomList9.add(new Room(202, ROOM_TYPE.AC.toString(), false, "karthik", null, null, ROOM_COST.AC.val, null));
	}

	public void addRoom(String cityID, String hotelID, Room room) {
		for (int i = 0; i < CityDAOImpl.cityList.size(); i++) {
			City city = CityDAOImpl.cityList.get(i);

			if ((city.getCityId()).equals(cityID)) {
				for (int j = 0; i < HotelDAOImpl.hotelList.size(); j++) {
					Hotel hotel = HotelDAOImpl.hotelList.get(j);
					if ((hotel.getHotelId()).equals(hotelID)) {
						RoomDAOImpl.roomList.add(room);
					}

				}
			}
		}
	}
	
	public boolean findRoom(long roomId) {
			for(int i = 0 ; i <RoomDAOImpl.roomList.size();i++) {
				Room room = RoomDAOImpl.roomList.get(i);
				if((room.getRoomid()) == roomId){
					return true;
				}			
			}
			return false;
	}
	
	
	public boolean removeRoom(String HotelId,String cityId,long roomId) {
		for(int i = 0 ; i <CityDAOImpl.cityList.size();i++) {
			City city = CityDAOImpl.cityList.get(i);
			if((city.getCityId()).equals(cityId)) {
			for(int j = 0 ; i <HotelDAOImpl.hotelList.size();j++) {
			Hotel hotel = HotelDAOImpl.hotelList.get(j);		
				if((hotel.getHotelId()).equals(HotelId)){
					for(int k= 0 ; k < RoomDAOImpl.roomList.size() ; k++) {
						Room room = RoomDAOImpl.roomList.get(k);
						if(room.getRoomid() == roomId ) {
							RoomDAOImpl.roomList.remove(k);
						return true;
						}
					}
					
				}
				
			}			
		}
	}
		return false;
	}
	
	public List<Room> displayRoom(String cityId,String hotelId){
		City city = null;
		Hotel hotel = null;
		for(int i = 0 ; i <CityDAOImpl.cityList.size();i++) {
			city = CityDAOImpl.cityList.get(i);
		if((city.getCityId()).equals(cityId)) {
			for(int j = 0 ; j <HotelDAOImpl.hotelList.size();j++) {
				hotel = HotelDAOImpl.hotelList.get(i);
			if(hotel.getHotelId().equals(hotelId)) {
				return hotel.getRoomList();
			}
			
			}
		}		
	}
		return hotel.getRoomList();
	}
	
	
}
