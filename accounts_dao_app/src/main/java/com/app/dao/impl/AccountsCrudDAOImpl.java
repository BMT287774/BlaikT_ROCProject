package com.app.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.app.dao.AccountsCrudDAO;
import com.app.dao.dbutil.PostgresqlConnection;
import com.app.exception.BusinessException;
import com.app.model.Accounts;



public class AccountsCrudDAOImpl implements AccountsCrudDAO {

	public long createAccount(Accounts account) throws BusinessException {
		
		int a = 0;
		try (Connection connection = PostgresqlConnection.getConnection()) {
			String sql = "insert into bankdata.accounts(account_id,account_type,routing_id,balance,low_balance_alert,expense_alert,customer_id) values(?,?,?,?,?,?,?)";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setLong(1, account.getAccount_id());
			preparedStatement.setString(2, account.getAccount_type());
			preparedStatement.setLong(3, account.getRouting_id());
			preparedStatement.setDouble(4, account.getBalance());
			preparedStatement.setInt(5, account.getLow_balance_alert());
			preparedStatement.setInt(6, account.getExpense_alert());
			preparedStatement.setInt(7, account.getCustomer_id());
			

			a = preparedStatement.executeUpdate();

		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e); // Take off this line when app is live
			throw new BusinessException("Internal error occured contact SYSADMIN ");
		}
		return a;
	}

	public void deleteAccount(int customer_id) throws BusinessException {
		int d=0;
		try(Connection connection = PostgresqlConnection.getConnection()){
			String sql = "delete from bankdata.accounts where customer_id=?";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(7, customer_id);
			d=statement.executeUpdate();
		}catch (ClassNotFoundException | SQLException e) {
			System.out.println(e);
			throw new BusinessException("Internal error occured, please contact SYSADMIN");
		}
		
	}

	public double updateAccount(double balance, int expense_alert, int low_balance_alert) {
		// TODO Auto-generated method stub
		return 0;
	}

	public Accounts getAccountsbyId(int customer_id) throws BusinessException {
		Accounts account = null;
		try (Connection connection = PostgresqlConnection.getConnection()) {
			String sql="select account_id,account_type,routing_id,balance,low_balance_alert,expense_alert,customer_id from bankdata.accounts where customer_id=?";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setInt(1, customer_id);
			ResultSet resultSet=preparedStatement.executeQuery();
			if(resultSet.next()) {
				account =new Accounts();
				account.setCustomer_id(customer_id);
				account.setAccount_id(resultSet.getLong("account_id"));
				account.setAccount_type(resultSet.getString("account_type"));
				account.setRouting_id(resultSet.getLong("routing_id"));
				account.setBalance(resultSet.getDouble("balance"));
				account.setLow_balance_alert(resultSet.getInt("low_balance_alert"));
				account.setExpense_alert(resultSet.getInt("expense_alert"));
				account.setCustomer_id(resultSet.getInt("customer_id"));
				
			}else {
				throw new BusinessException("No Account found with Id "+customer_id);
			}
		}catch (ClassNotFoundException | SQLException e) {
			System.out.println(e); // Take off this line when app is live
			throw new BusinessException("Internal error occured contact SYSADMIN ");
		}
		return account;
	}


	public List<Accounts> getAllAccounts() throws BusinessException {
		List<Accounts> accountsList=new ArrayList<>();
		try (Connection connection = PostgresqlConnection.getConnection()) {
			String sql="select account_id,account_type,routing_id,balance,low_balance_alert,expense_alert,customer_id from bankdata.accounts";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			ResultSet resultSet=preparedStatement.executeQuery();
			while(resultSet.next()) {
				Accounts account =new Accounts();
				account.setAccount_id(resultSet.getLong("account_id"));
				account.setAccount_type(resultSet.getString("account_type"));
				account.setRouting_id(resultSet.getLong("routing_id"));
				account.setBalance(resultSet.getDouble("balance"));
				account.setLow_balance_alert(resultSet.getInt("low_balance_alert"));
				account.setExpense_alert(resultSet.getInt("expense_alert"));
				account.setCustomer_id(resultSet.getInt("customer_id"));
				
				accountsList.add(account);
			}
			if(accountsList.size()==0)
			{
				throw new BusinessException("No accounts in the DB so far");
			}
		}catch (ClassNotFoundException | SQLException e) {
			System.out.println(e); // Take off this line when app is live
			throw new BusinessException("Internal error occured contact SYSADMIN ");
		}
		return accountsList;
		
	}
	
	

}
