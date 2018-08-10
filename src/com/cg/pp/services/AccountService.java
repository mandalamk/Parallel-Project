package com.cg.pp.services;

import java.util.ArrayList;

import com.cg.pp.exceptions.MyException;

public interface AccountService {

	int showBalance(int accNum) throws MyException;
	int deposit(int accNum, int amount) throws MyException;
	int withdraw(int accNum, int amount) throws MyException;
	ArrayList<Integer> transfer(int accNum_from,int accNum_to, int amount) throws MyException;
	void printTransactions(int accNum) throws MyException;
}
