package com.cg.pp.beans;

import java.util.ArrayList;

public class Account {

	private int balance;
	private int accNumber;
	private ArrayList<Transaction> history;

	public Account(int i, int accid, ArrayList<Transaction> al) {
		balance = i;
		accNumber = accid;
		history = al;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public int getAccNumber() {
		return accNumber;
	}

	public void setAccNumber(int accNumber) {
		this.accNumber = accNumber;
	}

	public ArrayList<Transaction> getHistory() {
		// System.out.println("Got here");
		return history;
	}

	public void setHistory(ArrayList<Transaction> history) {
		this.history = history;
	}

}
