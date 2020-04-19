package com.cg.hotelmanagement;

import org.junit.Assert;
import org.junit.Test;

import com.cg.hotelmanagement.bean.Customer;
import com.cg.hotelmanagement.bean.Hotel;
import com.cg.hotelmanagement.bean.Room;
import com.cg.hotelmanagement.service.ServiceImpt;

public class CustomerTest1 {
	ServiceImpt serv = new ServiceImpt();

	@Test
	public void CheckAvailablityTest() {
		Room r = new Room();
		Hotel h = new Hotel();
		String expected = "No Rooms available to book.";
		String actual = serv.checkAvailablity(h.getRoomList(), 0);
		Assert.assertEquals(actual, expected);
	}

//	@Test
//	public void CancelRoomTest() {
//		Room r = new Room();
//		Hotel h = new Hotel();
//		String expected = "No Rooms available to book.";
//		
//		String actual = serv.cancelRoom(h.getRoomList(), cst);
//		Assert.assertEquals(actual, expected);
//	}
	@Test
	public void payBillTest() {
		Customer cust = new Customer();
		String expected = "Customer with :"+cust.getCustomerId()+" Please pay: "+cust.getBillAmount();
		String actual = serv.payBill(cust);
		Assert.assertEquals(expected, actual);
		
	}
	@Test
	public void bookingTest() {
		Hotel h= new Hotel();
		int roomAvail = 1;
		Customer cust = new Customer();
		String expected = "Only this number of rooms available:"+roomAvail;
		String actual = serv.bookRoom(h.getRoomList(), cust, roomAvail, 2);
		Assert.assertEquals(actual,expected);
	}
	@Test
	public void initialOptionTest() {
		boolean expected = true;
		boolean actual = serv.ChooseInitialOption(1);
		Assert.assertEquals(actual, expected);
	}
}
