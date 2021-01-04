package com.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class connectTest {

	public static void main(String[] args) {
		Connection connection=null;
		
		try {
			Class.forName("org.postgresql.Driver");
			System.out.println("Driver Loaded Successfully");
			
			String url="jdbc:postgresql://localhost:5432/postgres";
			String username="postgres";
			String password="password";
			connection=DriverManager.getConnection(url, username, password);
			System.out.println("Connection Success");
			
			Statement statement=connection.createStatement();
			String sql="select customer_id,first_name,last_name,drivers_license,ssn,email,physical_address,mailing_address,dob,gender from bankdata.customer";
			
			ResultSet resultSet=statement.executeQuery(sql);
			System.out.println("Query Executed");
			
			while(resultSet.next()) {
				System.out.println("customer_id: "+resultSet.getInt("customer_id"));
				System.out.println("first_name : "+resultSet.getString("first_name"));
				System.out.println("last_name : "+resultSet.getString("last_name"));
				System.out.println("drivers_license : "+resultSet.getString("drivers_license"));
				System.out.println("ssn : "+resultSet.getInt("ssn"));
				System.out.println("email : "+resultSet.getString("email"));
				System.out.println("physical_address : "+resultSet.getString("physical_address"));
				System.out.println("mailing_address : "+resultSet.getString("mailing_address"));
				System.out.println("dob : "+resultSet.getDate("dob"));
				System.out.println("dob : "+resultSet.getString("gender"));
			}
			System.out.println("Results Processed");
			
		}catch (ClassNotFoundException e) {
			System.out.println(e);
		}catch(SQLException e) {
			System.out.println(e);
		}finally {
			try {
				
			}
		}

	}

}
