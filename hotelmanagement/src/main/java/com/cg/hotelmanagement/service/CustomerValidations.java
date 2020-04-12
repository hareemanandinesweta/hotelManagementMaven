package com.cg.hotelmanagement.service;

import com.cg.hotelmanagement.exceptions.HotelManagementException;

public class CustomerValidations {

	

		public static void customerIdValidation(String customerId) throws HotelManagementException {
			String pattern = "^[0-9]{4,10}$";
			if (!customerId.matches(pattern))
				throw new HotelManagementException("Enter customer id in min 4 and max 10 digit only");
		}
		
		public static boolean customerUserNameValidation(String customerUsername) throws HotelManagementException
		{
			String pattern = "[A-Za-z]{4,20}[@]{1}[gmail]{5}[.com]{4}";
			if(customerUsername.matches(pattern))
			{
				return true;
			}
			else
				return false;
		}
		
		public static boolean customerFirstNameValidation(String customerFirstName) throws HotelManagementException
		{
			String pattern = "[A-Za-z]{4,20}";
			if(customerFirstName.matches(pattern))
			{
				return true;
			}
			else
				return false;
		}
		
		public static boolean customerLastNameValidation(String customerLastName) throws HotelManagementException
		{
			String pattern = "[A-Za-z]{4,20}";
			if(customerLastName.matches(pattern))
			{
				return true;
			}
			else
				return false;
		}
		
		public static void genderValidation(String gender) throws HotelManagementException {
			if (!(gender.equalsIgnoreCase("M") || gender.equalsIgnoreCase("F"))) {
				throw new HotelManagementException("enter gender F or M only");
			}
		}
		
			public static void customerAddressValidation(String customerAddress) throws HotelManagementException {
				String addressToken = "[\\p{Punct}&&[#,.()-]]+\\d*+\\s?+[\\p{Alpha}+\\s?]*";

				String addressPattern = "(" + addressToken + "){1,6}";

				if (customerAddress.matches(addressPattern))

					System.out.println("You entered a VALID Home Address format.");

				else

					System.out.println("You entered an INVALID Home Address format.");

			}
			
			public static boolean customerPhoneNumberValidation(String customerPhoneNumber) throws HotelManagementException
			{
				String pattern = "[6-9]{1}[0-9]{9}";
				if(customerPhoneNumber.matches(pattern))
				{
					return true;
				}
				else
					return false;
			}
			
			public static boolean customerEmailIdValidation(String customerEmailId) throws HotelManagementException
			{
				String pattern = "[A-Za-z]{4,20}[@]{1}[gmail]{5}[.com]{4}";
				if(customerEmailId.matches(pattern))
				{
					return true;
				}
				else
					return false;
			}
			
			public static boolean customerpasswordValidation(String customerPassword) throws HotelManagementException
			{
				String pattern = "[A-Za-z]{3,6}[0-9]{2}[@#$%&*]{1}";
				if(customerPassword.matches(pattern))
				{
					return true;
				}
				else
					return false;
			}
			
		}

