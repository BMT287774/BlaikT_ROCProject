package com.app.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.app.dao.CustomerCrudDAO;
import com.app.dao.dbutil.PostgresqlConnection;
import com.app.exception.BusinessException;
import com.app.model.Customer;

public class CustomerCrudDAOImpl implements CustomerCrudDAO{

	public int createCustomer(Customer customer) throws BusinessException {
		int c = 0;
		try (Connection connection = PostgresqlConnection.getConnection()) {
			String sql = "insert into bankdata.customer(customer_id,first_name,last_name,drivers_license,ssn,email,physical_address,mailing_address,dob,gender) values(?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setInt(1, customer.getCustomer_id());
			preparedStatement.setString(2, customer.getFirst_name());
			preparedStatement.setString(3, customer.getLast_name());
			preparedStatement.setString(4, customer.getDrivers_license());
			preparedStatement.setInt(5, customer.getSsn());
			preparedStatement.setString(6, customer.getEmail());
			preparedStatement.setString(7, customer.getPhysical_address());
			preparedStatement.setString(8, customer.getMailing_address());
			preparedStatement.setDate(9, new java.sql.Date(customer.getDob().getTime()));
			preparedStatement.setString(10, customer.getGender());

			c = preparedStatement.executeUpdate();

		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e); // Take off this line when app is live
			throw new BusinessException("Internal error occured contact SYSADMIN ");
		}
		return c;
	}

	public void deleteCustomer(int customer_id) throws BusinessException {
		int d=0;
		try(Connection connection = PostgresqlConnection.getConnection()){
			String sql = "delete from bankdata.customer where customer_id=?";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, customer_id);
			d=statement.executeUpdate();
		}catch (ClassNotFoundException | SQLException e) {
			System.out.println(e);
			throw new BusinessException("Internal error occured, please contact SYSADMIN");
		}
		
		
	}

	public String updateCustomer(String physical_address, String email) {
		// TODO Auto-generated method stub
		return null;
	}

	public Customer getCustomerbyId(int customer_id) throws BusinessException {
		Customer customer = null;
		try (Connection connection = PostgresqlConnection.getConnection()) {
			String sql="select customer_id,first_name,last_name,drivers_license,ssn,email,physical_address,mailing_address,dob,gender from bankdata.customer where id=?";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setInt(1, customer_id);
			ResultSet resultSet=preparedStatement.executeQuery();
			if(resultSet.next()) {
				customer =new Customer();
				customer.setCustomer_id(customer_id);
				customer.setFirst_name(resultSet.getString("first_name"));
				customer.setLast_name(resultSet.getString("last_name"));
				customer.setDrivers_license(resultSet.getString("gender"));
				customer.setSsn(resultSet.getInt("ssn"));
				customer.setEmail(resultSet.getString("email"));
				customer.setPhysical_address(resultSet.getString("physical_address"));
				customer.setMailing_address(resultSet.getString("mailing_address"));
				customer.setDob(resultSet.getDate("dob"));
				customer.setGender(resultSet.getString("gender"));
			}else {
				throw new BusinessException("No Customer found with Id "+customer_id);
			}
		}catch (ClassNotFoundException | SQLException e) {
			System.out.println(e); // Take off this line when app is live
			throw new BusinessException("Internal error occured contact SYSADMIN ");
		}
		return customer;

	}

	public List<Customer> getAllCustomers() throws BusinessException {
		List<Customer> customersList=new ArrayList<>();
		try (Connection connection = PostgresqlConnection.getConnection()) {
			String sql="select customer_id,first_name,last_name,drivers_license,ssn,email,physical_address,mailing_address,dob,gender from bankdata.customer";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			ResultSet resultSet=preparedStatement.executeQuery();
			while(resultSet.next()) {
				Customer customer =new Customer();
				customer.setCustomer_id(resultSet.getInt("customer_id"));
				customer.setFirst_name(resultSet.getString("first_name"));
				customer.setLast_name(resultSet.getString("last_name"));
				customer.setDrivers_license(resultSet.getString("drivers_license"));
				customer.setSsn(resultSet.getInt("ssn"));
				customer.setEmail(resultSet.getString("email"));
				customer.setPhysical_address(resultSet.getString("physical_address"));
				customer.setMailing_address(resultSet.getString("mailing_address"));
				customer.setDob(resultSet.getDate("dob"));
				customer.setGender(resultSet.getString("gender"));
				customersList.add(customer);
			}
			if(customersList.size()==0)
			{
				throw new BusinessException("No customers in the DB so far");
			}
		}catch (ClassNotFoundException | SQLException e) {
			System.out.println(e); // Take off this line when app is live
			throw new BusinessException("Internal error occured contact SYSADMIN ");
		}
		return customersList;
		
	}
	

}
