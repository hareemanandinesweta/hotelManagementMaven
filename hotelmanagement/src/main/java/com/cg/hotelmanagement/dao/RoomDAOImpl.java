package com.cg.hotelmanagement.dao;

import java.util.ArrayList;

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
	}
}
