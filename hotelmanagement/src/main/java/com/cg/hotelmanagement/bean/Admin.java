package com.cg.hotelmanagement.bean;

public class Admin {
    private String adminID;
  //  private String adminPassword;
    private Hotel hotelDetails;
    private Customer customerDetails;
    private Booking booking;
    private Room room;
    private City city;

    public Admin(String adminID, Hotel hotelDetails, Customer customerDetails, Booking booking, Room room, City city) {
        this.adminID = adminID;
        
        this.hotelDetails = hotelDetails;
        this.customerDetails = customerDetails;
        this.booking = booking;
        this.room = room;
        this.city = city;
    }

    public Admin(String adminID, String adminPassword) {
        this.adminID = adminID;
        
    }

    public Admin(Hotel hotelDetails) {
        this.hotelDetails = hotelDetails;
    }

    public Admin(Customer customerDetails) {
        this.customerDetails = customerDetails;
    }

    public Admin(Booking booking) {
        this.booking = booking;
    }

    public Admin(Room room) {
        this.room = room;
    }

    public Admin(City city) {
        this.city = city;
    }

   
	public String toString() {
		return "Admin [adminID=" + adminID + ", hotelDetails=" + hotelDetails + ", customerDetails=" + customerDetails
				+ ", booking=" + booking + ", room=" + room + ", city=" + city + "]";
	}

	
    
    public String getAdminID() {
		return adminID;
	}

	public void setAdminID(String adminID) {
		this.adminID = adminID;
	}

	public Hotel getHotelDetails() {
        return hotelDetails;
    }

    public void setHotelDetails(Hotel hotelDetails) {
        this.hotelDetails = hotelDetails;
    }

    public Customer getCustomerDetails() {
        return customerDetails;
    }

    public void setCustomerDetails(Customer customerDetails) {
        this.customerDetails = customerDetails;
    }

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }
    
    public Admin(String adminID) {
    	this.adminID = adminID;
    }
}