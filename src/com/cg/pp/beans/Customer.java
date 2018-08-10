package com.cg.pp.beans;

public class Customer {

	private int custID;
	private String custName;
	private Account account;

	public Customer(String name, Account account) {
		// TODO Auto-generated constructor stub
		custName = name;
		custID = (int) Math.random() * 100;
		this.account = account;
	}

	public int getCustID() {
		return custID;
	}

	public void setCustID(int custID) {
		this.custID = custID;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

}
