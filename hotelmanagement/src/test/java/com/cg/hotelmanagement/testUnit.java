package com.cg.hotelmanagement;


import org.junit.*;


public class testUnit {
	
	@Test
	public void testmethod() {
		String expected = "Even";
		OddEven oe = new OddEven();
		String actual = oe.oeven();
		
		System.out.println("I dont know if this would work..");
		Assert.assertEquals(expected, actual);
	}
	
}	
