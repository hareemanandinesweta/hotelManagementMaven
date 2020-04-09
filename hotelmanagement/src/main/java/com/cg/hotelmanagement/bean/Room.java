package com.cg.hotelmanagement.bean;

import java.util.List;

public class Room {
	private long roomid;
	private String roomtype;
	private boolean isbooked;
	
	private String checkin;
	private String checkout;
	private double roomcost;
	private Customer customer;
	private List<Booking> bookingDetails;

	public long getRoomid() {
		return roomid;
	}

	public void setRoomid(long roomid) {
		this.roomid = roomid;
	}

	public String getRoomtype() {
		return roomtype;
	}

	public void setRoomtype(String roomtype) {
		this.roomtype = roomtype;
	}


	public boolean isIsbooked() {
		return isbooked;
	}

	public void setIsbooked(boolean isbooked) {
		this.isbooked = isbooked;
	}

	
	public String getCheckin() {
		return checkin;
	}

	public void setCheckin(String checkin) {
		this.checkin = checkin;
	}

	public String getCheckout() {
		return checkout;
	}

	public void setCheckout(String checkout) {
		this.checkout = checkout;
	}

	public double getRoomcost() {
		return roomcost;
	}

	public void setRoomcost(double roomcost) {
		this.roomcost = roomcost;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	/**
	 * Instantiates a new room.
	 *
	 * @param roomid    the roomid
	 * @param roomtype  the roomtype
	 * @param isbooked  the isbooked
	 * @param roomowner the roomowner
	 * @param checkin   the checkin
	 * @param checkout  the checkout
	 * @param roomcost  the roomcost
	 * @param customer  the customer
	 */
	public Room(int roomid, String roomtype, boolean isbooked, String roomowner, String checkin, String checkout,
			int roomcost, Customer customer) {
		super();
		this.roomid = roomid;
		this.roomtype = roomtype;
		this.isbooked = isbooked;
		
		this.checkin = checkin;
		this.checkout = checkout;
		this.roomcost = roomcost;
		this.customer = customer;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((checkin == null) ? 0 : checkin.hashCode());
		result = prime * result + ((checkout == null) ? 0 : checkout.hashCode());
		result = prime * result + ((customer == null) ? 0 : customer.hashCode());
		result = prime * result + (isbooked ? 1231 : 1237);
		long temp;
		temp = Double.doubleToLongBits(roomcost);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = (int) (prime * result + roomid);
		result = prime * result + ((roomtype == null) ? 0 : roomtype.hashCode());
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
		Room other = (Room) obj;
		if (checkin == null) {
			if (other.checkin != null)
				return false;
		} else if (!checkin.equals(other.checkin))
			return false;
		if (checkout == null) {
			if (other.checkout != null)
				return false;
		} else if (!checkout.equals(other.checkout))
			return false;
		if (customer == null) {
			if (other.customer != null)
				return false;
		} else if (!customer.equals(other.customer))
			return false;
		if (isbooked != other.isbooked)
			return false;
		if (Double.doubleToLongBits(roomcost) != Double.doubleToLongBits(other.roomcost))
			return false;
		if (roomid != other.roomid)
			return false;
		if (roomtype == null) {
			if (other.roomtype != null)
				return false;
		} else if (!roomtype.equals(other.roomtype))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Room [roomid=" + roomid + ", roomtype=" + roomtype + ", isbooked=" + isbooked + ", checkin=" + checkin + ", checkout=" + checkout + ", roomcost=" + roomcost
				+ ", customer=" + customer + "]";
	}

}