package com.app.main;

import java.util.List;

import com.app.dao.AccountsCrudDAO;
import com.app.dao.impl.AccountsCrudDAOImpl;
import com.app.exception.BusinessException;
import com.app.model.Accounts;

public class AccountsMain {
	
	public static void main(String[] args) {
		
		AccountsCrudDAO dao=new AccountsCrudDAOImpl();
		
//		Accounts a=new Accounts(4039834567L, "savings", 234876563L, 32476.28, 10000, 200, 378405);
		
//		try {
//			if(dao.createAccount(a)!=0) {
//				System.out.println("Account created successfully");
//			}
//		} catch (BusinessException e) {
//			System.out.println(e.getMessage());
//		}
		
//		try {
//			Accounts account=dao.getAccountsbyId(123450);
//			if(account!=null) {
//			System.out.println("Details of customer with id "+account.getCustomer_id());
//			System.out.println(account);
//		}
//		} catch (BusinessException e) {
//			System.out.println(e.getMessage());
//		}
		
		
		try {
		List<Accounts> accountList=dao.getAllAccounts();
		if(accountList!=null && accountList.size()!=0) {
				System.out.println("\n\nFound "+accountList.size()+" no of accounts in DB.... Printing them all");
				for(Accounts a:accountList) {
					System.out.println(a);
				}
			}
		} catch (BusinessException e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	

}
