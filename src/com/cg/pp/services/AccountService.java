package com.cg.pp.services;

import java.util.ArrayList;

import com.cg.pp.exceptions.MyException;

public interface AccountService {

	int showBalance(int accNum) throws AccountException;
	int deposit(int accNum, int amount) throws AccountException;
	int withdraw(int accNum, int amount) throws AccountException;
	ArrayList<Integer> transfer(int accNum_from,int accNum_to, int amount) throws AccountException;
	void printTransactions(int accNum) throws AccountException;
}
