package com.cg.pp.dao;

import java.util.ArrayList;

import com.cg.pp.beans.*;

public interface AccountDao {

	int showBalance(int accNum);
	int deposit(int accNum, int amount);
	int withdraw(int accNum, int amount);
	ArrayList<Integer> transfer(int accNum_from,int accNum_to, int amount);
	ArrayList<Transaction> printTransactions(int accNum);

}
