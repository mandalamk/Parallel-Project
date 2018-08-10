package com.cg.pp.beans;

public class Transaction {

	private int amount;
	private String transacted_account;
	private String action;

	public Transaction() {
		// TODO Auto-generated constructor stub
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getTransacted_account() {
		return transacted_account;
	}

	public void setTransacted_account(String transacted_account) {
		this.transacted_account = transacted_account;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

}
