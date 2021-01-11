package com.app.dao;

import java.util.List;

import com.app.exception.BusinessException;
import com.app.model.Accounts;

public interface AccountsCrudDAO {
	
	public long createAccount(Accounts account) throws BusinessException;
	public void deleteAccount(int customer_id) throws BusinessException;
	public double updateAccount(double balance, int expense_alert, int low_balance_alert);
	public Accounts getAccountsbyId(int customer_id) throws BusinessException;
	public List<Accounts>getAllAccounts() throws BusinessException;
	

}
