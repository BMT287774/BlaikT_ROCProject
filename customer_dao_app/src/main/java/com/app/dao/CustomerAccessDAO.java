package com.app.dao;

import java.util.List;

import com.app.model.Customer;

public interface CustomerAccessDAO {
	public int getCustomerBySsn(int ssn);
	public List<Customer> getCustomerByGender(String gender);
	

}
