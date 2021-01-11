package com.app.main;



import java.sql.Date;

import com.app.dao.CustomerCrudDAO;
import com.app.dao.impl.CustomerCrudDAOImpl;
import com.app.exception.BusinessException;
import com.app.model.Customer;

public class CustomerMain {

	public static void main(String[] args) {
		CustomerCrudDAO dao = new CustomerCrudDAOImpl();
		
		Customer c = new Customer(12345, "John", "Erickson", "T-345-210-345-676", 345971738, "JE20@gmail.com", "201 Safe St Houston, TX 7701", "201 Safe St Houston, TX 7701", new Date(1988-02-26), "M");
		Customer c1 = new Customer(37840,"Anabel", "Jackson", "K-345-543-964-223", 272234800, "AnabelJ200@hotmail.com", "1723 Bel Air Rd Baltimore, MD 21210", "1723 Bel Air Rd Baltimore, MD 21210", new Date(1968-06-29), "F");
		try {
			if(dao.createCustomer(c1)!=0) {
				System.out.println("customer created successfully");
			}
		} catch (BusinessException e) {
			System.out.println(e.getMessage());
		}
		

	}

}
