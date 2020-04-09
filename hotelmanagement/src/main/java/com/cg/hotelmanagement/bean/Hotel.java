package com.cg.hotelmanagement.bean;

import java.util.ArrayList;
import java.util.List;

public class Hotel {

    private String hotelId;
    private String hotelName;
    private String hotelType;
    private String hotelAddress;
    private String hotelPhoneNo;
    private String hotelRating;
    private ArrayList<Room> roomList;

    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((hotelAddress == null) ? 0 : hotelAddress.hashCode());
		result = prime * result + ((hotelId == null) ? 0 : hotelId.hashCode());
		result = prime * result + ((hotelName == null) ? 0 : hotelName.hashCode());
		result = prime * result + ((hotelPhoneNo == null) ? 0 : hotelPhoneNo.hashCode());
		result = prime * result + ((hotelRating == null) ? 0 : hotelRating.hashCode());
		result = prime * result + ((hotelType == null) ? 0 : hotelType.hashCode());
		result = prime * result + ((roomList == null) ? 0 : roomList.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Hotel other = (Hotel) obj;
		if (hotelAddress == null) {
			if (other.hotelAddress != null)
				return false;
		} else if (!hotelAddress.equals(other.hotelAddress))
			return false;
		if (hotelId == null) {
			if (other.hotelId != null)
				return false;
		} else if (!hotelId.equals(other.hotelId))
			return false;
		if (hotelName == null) {
			if (other.hotelName != null)
				return false;
		} else if (!hotelName.equals(other.hotelName))
			return false;
		if (hotelPhoneNo == null) {
			if (other.hotelPhoneNo != null)
				return false;
		} else if (!hotelPhoneNo.equals(other.hotelPhoneNo))
			return false;
		if (hotelRating == null) {
			if (other.hotelRating != null)
				return false;
		} else if (!hotelRating.equals(other.hotelRating))
			return false;
		if (hotelType == null) {
			if (other.hotelType != null)
				return false;
		} else if (!hotelType.equals(other.hotelType))
			return false;
		if (roomList == null) {
			if (other.roomList != null)
				return false;
		} else if (!roomList.equals(other.roomList))
			return false;
		return true;
	}

	public Hotel(){

    }

    public Hotel(String hotelId, String hotelName, String hotelType, String hotelAddress, String hotelPhoneNo, String hotelRating, ArrayList<Room> roomList) {
        this.hotelId = hotelId;
        this.hotelName = hotelName;
        this.hotelType = hotelType;
        this.hotelAddress = hotelAddress;
        this.hotelPhoneNo = hotelPhoneNo;
        this.hotelRating = hotelRating;
        this.roomList = roomList;
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "hotelId='" + hotelId + '\'' +
                ", hotelName='" + hotelName + '\'' +
                ", hotelType='" + hotelType + '\'' +
                ", hotelAddress='" + hotelAddress + '\'' +
                ", hotelPhoneNo='" + hotelPhoneNo + '\'' +
                ", hotelRating='" + hotelRating + '\'' +
                ", roomList=" + roomList +
                '}';
    }

    public String getHotelId() {
        return hotelId;
    }

    public void setHotelId(String hotelId) {
        this.hotelId = hotelId;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getHotelType() {
        return hotelType;
    }

    public void setHotelType(String hotelType) {
        this.hotelType = hotelType;
    }

    public String getHotelAddress() {
        return hotelAddress;
    }

    public void setHotelAddress(String hotelAddress) {
        this.hotelAddress = hotelAddress;
    }

    public String getHotelPhoneNo() {
        return hotelPhoneNo;
    }

    public void setHotelPhoneNo(String hotelPhoneNo) {
        this.hotelPhoneNo = hotelPhoneNo;
    }

    public String getHotelRating() {
        return hotelRating;
    }

    public void setHotelRating(String hotelRating) {
        this.hotelRating = hotelRating;
    }

    public ArrayList<Room> getRoomList() {
        return roomList;
    }

    public void setRoomList(ArrayList<Room> roomList) {
        this.roomList = roomList;
    }
}