package com.cg.hotelmanagement.Validation;

import com.cg.hotelmanagement.exceptions.ContactNumberException;
import com.cg.hotelmanagement.exceptions.EmailIdException;
import com.cg.hotelmanagement.exceptions.HotelManagementException;
import com.cg.hotelmanagement.exceptions.NameException;

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
		
		public static void customerFirstNameValidation(String customerFirstName) throws NameException
		{
			String pattern = "[A-Za-z]{4,20}";
			if(!customerFirstName.matches(pattern))
			throw new NameException("Please Enter a Valid FirstName!!");
		}
		
		public static void customerLastNameValidation(String customerFirstName) throws NameException
		{
			String pattern = "[A-Za-z]{4,20}";
			if(!customerFirstName.matches(pattern))
			throw new NameException("Please Enter a Valid SurName!!");
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
			
			public static void customerPhoneNumberValidation(String customerPhoneNumber) throws ContactNumberException
			{
				String pattern = "[6-9]{1}[0-9]{9}";
				if(!customerPhoneNumber.matches(pattern))
				throw new ContactNumberException("Please Enter a valid phone number!!");
			}
			
			public static void customerEmailIdValidation(String customerEmailId) throws EmailIdException
			{
				String pattern = "[A-Za-z]{4,20}[@]{1}[gmail]{5}[.com]{4}";
				if(!customerEmailId.matches(pattern))
				throw new EmailIdException("Please Enter a valid Email Id");
			}
			
			public static void customerpasswordValidation(String customerPassword) throws HotelManagementException
			{
				String pattern = "[A-Za-z]{3,6}[0-9]{2}[@#$%&*]{1}";
				if(customerPassword.matches(pattern))
				throw new HotelManagementException("Please Enter a valid password");
			}
			
		}

