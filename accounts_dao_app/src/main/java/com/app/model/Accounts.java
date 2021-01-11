package com.app.model;

public class Accounts {
	private long account_id;
	private String account_type;
	private long routing_id;
	private double balance;
	private int low_balance_alert;
	private int expense_alert;
	private int customer_id;
	
	public Accounts() {
		
	}
	public Accounts(long account_id, String account_type, long routing_id, double balance, int low_balance_alert,
			int expense_alert, int customer_id) {
		super();
		this.account_id = account_id;
		this.account_type = account_type;
		this.routing_id = routing_id;
		this.balance = balance;
		this.low_balance_alert = low_balance_alert;
		this.expense_alert = expense_alert;
		this.customer_id = customer_id;
	}
	public long getAccount_id() {
		return account_id;
	}
	public void setAccount_id(long account_id) {
		this.account_id = account_id;
	}
	public String getAccount_type() {
		return account_type;
	}
	public void setAccount_type(String account_type) {
		this.account_type = account_type;
	}
	public long getRouting_id() {
		return routing_id;
	}
	public void setRouting_id(long routing_number) {
		this.routing_id = routing_number;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public int getLow_balance_alert() {
		return low_balance_alert;
	}
	public void setLow_balance_alert(int low_balance_alert) {
		this.low_balance_alert = low_balance_alert;
	}
	public int getExpense_alert() {
		return expense_alert;
	}
	public void setExpense_alert(int expense_alert) {
		this.expense_alert = expense_alert;
	}
	public int getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}
	@Override
	public String toString() {
		return "Accounts [account_id=" + account_id + ", account_type=" + account_type + ", routing_id="
				+ routing_id + ", balance=" + balance + ", low_balance_alert=" + low_balance_alert
				+ ", expense_alert=" + expense_alert + ", customer_id=" + customer_id + "]";
	}
	
	
	
	
	

}
