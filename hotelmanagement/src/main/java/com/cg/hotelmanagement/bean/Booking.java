package com.cg.hotelmanagement.bean;

public class Booking {

    private String bookingId;
    private String bookingCheckIn;
    private String bookingCheckOut;
    private String bookingCity;
    private Customer customer;

    public Booking(String bookingId, String bookingCheckIn, String bookingCheckOut, String bookingCity, Customer customer) {
        this.bookingId = bookingId;
        this.bookingCheckIn = bookingCheckIn;
        this.bookingCheckOut = bookingCheckOut;
        this.bookingCity = bookingCity;
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "bookingId='" + bookingId + '\'' +
                ", bookingCheckIn='" + bookingCheckIn + '\'' +
                ", bookingCheckOut='" + bookingCheckOut + '\'' +
                ", bookingCity='" + bookingCity + '\'' +
                ", customer=" + customer +
                '}';
    }

    public String getBookingId() {
        return bookingId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    public String getBookingCheckIn() {
        return bookingCheckIn;
    }

    public void setBookingCheckIn(String bookingCheckIn) {
        this.bookingCheckIn = bookingCheckIn;
    }

    public String getBookingCheckOut() {
        return bookingCheckOut;
    }

    public void setBookingCheckOut(String bookingCheckOut) {
        this.bookingCheckOut = bookingCheckOut;
    }

    public String getBookingCity() {
        return bookingCity;
    }

    public void setBookingCity(String bookingCity) {
        this.bookingCity = bookingCity;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}