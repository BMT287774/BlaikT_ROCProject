package com.app.dao;

import java.util.List;

import com.app.exception.BusinessException;
import com.app.model.Customer;

public interface CustomerCrudDAO {
	public int createCustomer(Customer customer) throws BusinessException;
	public void deleteCustomer(int customer_id) throws BusinessException;
	public String updateCustomer(String physical_address, String email);
	public Customer getCustomerbyId(int customer_id) throws BusinessException;
	public List<Customer>getAllCustomers() throws BusinessException;

}
