package com.cg.hotelmanagement;

public class OddEven {
	public String oeven() {
		int a = 10;
		if(a%2==1) {
			return"Odd";
		}
		else return "Even";
	}
	
	public static void main(String args[]) {
		OddEven oe = new OddEven();
		System.out.println(oe.oeven());
	}
}
