package com.app.model;

import java.util.Date;

public class Customer {
	
	private int customer_id;
	private String first_name;
	private String last_name;
	private String drivers_license;
	private int ssn;
	private String email;
	private String physical_address;
	private String mailing_address;
	private Date dob;
	private String gender;
	
	public Customer() {
		
	}
	public Customer(int customer_id, String first_name, String last_name, String drivers_license, int ssn, String email, String physical_address, String mailing_address,Date dob, String gender) {
		super();
		this.customer_id=customer_id;
		this.first_name=first_name;
		this.last_name=last_name;
		this.drivers_license=drivers_license;
		this.ssn=ssn;
		this.email=email;
		this.physical_address=physical_address;
		this.mailing_address=mailing_address;
		this.dob=dob;
		this.gender=gender;
		
		// TODO Auto-generated constructor stub
	}
	public int getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getDrivers_license() {
		return drivers_license;
	}
	public void setDrivers_license(String drivers_license) {
		this.drivers_license = drivers_license;
	}
	public int getSsn() {
		return ssn;
	}
	public void setSsn(int ssn) {
		this.ssn = ssn;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhysical_address() {
		return physical_address;
	}
	public void setPhysical_address(String physical_address) {
		this.physical_address = physical_address;
	}
	public String getMailing_address() {
		return mailing_address;
	}
	public void setMailing_address(String mailing_address) {
		this.mailing_address = mailing_address;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	@Override
	public String toString() {
		return "Customer [customer_id=" + customer_id + ", first_name=" + first_name + ", last_name=" + last_name
				+ ", drivers_license=" + drivers_license + ", ssn=" + ssn + ", email=" + email + ", physical_address="
				+ physical_address + ", mailing_address=" + mailing_address + ", dob=" + dob + ", gender=" + gender
				+ "]";
	}
	
	
	
	

}
