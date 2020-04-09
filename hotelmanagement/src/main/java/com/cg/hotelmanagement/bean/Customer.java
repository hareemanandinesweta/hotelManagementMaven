package com.cg.hotelmanagement.bean;

public class Customer {

	private long customerId;
	private String customerUsername;
	private String customerFirstName;
	private String customerLastName;
	private String gender;
	private String customerAddress;
	private String customerIdNo;
	private String customerPhoneNo;
	private String customerEmailId;
	private String customerPassword;

	public Customer(long customerId, String customerUsername, String customerFirstName, String customerLastName,
			String gender, String customerAddress, String customerIdNo, String customerPhoneNo, String customerEmailId,
			String customerPassword) {
		super();
		this.customerId = customerId;
		this.customerUsername = customerUsername;
		this.customerFirstName = customerFirstName;
		this.customerLastName = customerLastName;
		this.gender = gender;
		this.customerAddress = customerAddress;
		this.customerIdNo = customerIdNo;
		this.customerPhoneNo = customerPhoneNo;
		this.customerEmailId = customerEmailId;
		this.customerPassword = customerPassword;
	}
	
	public Customer() {
		
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerUsername=" + customerUsername + ", customerFirstName="
				+ customerFirstName + ", customerLastName=" + customerLastName + ", gender=" + gender
				+ ", customerAddress=" + customerAddress + ", customerIdNo=" + customerIdNo + ", customerPhoneNo="
				+ customerPhoneNo + ", customerEmailId=" + customerEmailId + ", customerPassword=" + customerPassword
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((customerAddress == null) ? 0 : customerAddress.hashCode());
		result = prime * result + ((customerEmailId == null) ? 0 : customerEmailId.hashCode());
		result = prime * result + ((customerFirstName == null) ? 0 : customerFirstName.hashCode());
		result = prime * result + (int) (customerId ^ (customerId >>> 32));
		result = prime * result + ((customerIdNo == null) ? 0 : customerIdNo.hashCode());
		result = prime * result + ((customerLastName == null) ? 0 : customerLastName.hashCode());
		result = prime * result + ((customerPassword == null) ? 0 : customerPassword.hashCode());
		result = prime * result + ((customerPhoneNo == null) ? 0 : customerPhoneNo.hashCode());
		result = prime * result + ((customerUsername == null) ? 0 : customerUsername.hashCode());
		result = prime * result + ((gender == null) ? 0 : gender.hashCode());
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
		Customer other = (Customer) obj;
		if (customerAddress == null) {
			if (other.customerAddress != null)
				return false;
		} else if (!customerAddress.equals(other.customerAddress))
			return false;
		if (customerEmailId == null) {
			if (other.customerEmailId != null)
				return false;
		} else if (!customerEmailId.equals(other.customerEmailId))
			return false;
		if (customerFirstName == null) {
			if (other.customerFirstName != null)
				return false;
		} else if (!customerFirstName.equals(other.customerFirstName))
			return false;
		if (customerId != other.customerId)
			return false;
		if (customerIdNo == null) {
			if (other.customerIdNo != null)
				return false;
		} else if (!customerIdNo.equals(other.customerIdNo))
			return false;
		if (customerLastName == null) {
			if (other.customerLastName != null)
				return false;
		} else if (!customerLastName.equals(other.customerLastName))
			return false;
		if (customerPassword == null) {
			if (other.customerPassword != null)
				return false;
		} else if (!customerPassword.equals(other.customerPassword))
			return false;
		if (customerPhoneNo == null) {
			if (other.customerPhoneNo != null)
				return false;
		} else if (!customerPhoneNo.equals(other.customerPhoneNo))
			return false;
		if (customerUsername == null) {
			if (other.customerUsername != null)
				return false;
		} else if (!customerUsername.equals(other.customerUsername))
			return false;
		if (gender == null) {
			if (other.gender != null)
				return false;
		} else if (!gender.equals(other.gender))
			return false;
		return true;
	}

	public long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}

	public String getCustomerUsername() {
		return customerUsername;
	}

	public void setCustomerUsername(String customerUsername) {
		this.customerUsername = customerUsername;
	}

	public String getCustomerFirstName() {
		return customerFirstName;
	}

	public void setCustomerFirstName(String customerFirstName) {
		this.customerFirstName = customerFirstName;
	}

	public String getCustomerLastName() {
		return customerLastName;
	}

	public void setCustomerLastName(String customerLastName) {
		this.customerLastName = customerLastName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getCustomerAddress() {
		return customerAddress;
	}

	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}

	public String getCustomerIdNo() {
		return customerIdNo;
	}

	public void setCustomerIdNo(String customerIdNo) {
		this.customerIdNo = customerIdNo;
	}

	public String getCustomerPhoneNo() {
		return customerPhoneNo;
	}

	public void setCustomerPhoneNo(String customerPhoneNo) {
		this.customerPhoneNo = customerPhoneNo;
	}

	public String getCustomerEmailId() {
		return customerEmailId;
	}

	public void setCustomerEmailId(String customerEmailId) {
		this.customerEmailId = customerEmailId;
	}

	public String getCustomerPassword() {
		return customerPassword;
	}

	public void setCustomerPassword(String customerPassword) {
		this.customerPassword = customerPassword;
	}

}