/*
CHECK FOR SUFFICIENT FUNDS DURING TRANSFER. DISPLAY APPROPRIATE EXCEPTIONS.
 
*/

package com.cg.pp.services;

import java.util.ArrayList;
import java.util.Iterator;
import com.cg.pp.beans.Transaction;
import com.cg.pp.dao.AccountDaoImpl;
import com.cg.pp.exceptions.AccountException;

public class AccountServiceImpl implements AccountService {

	AccountDaoImpl acimpl = new AccountDaoImpl();

	public AccountServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	private void check(int amount) throws AccountException {

		if (amount < 0)
			throw new MyException("This transaction is Not Possible.");

	}

	private void validate(int key) throws AccountException {

		if (!acimpl.exists(key))
			throw new AccountException("Account Number Invalid!");
	}

	@Override
	public int showBalance(int accNum) throws AccountException {

		validate(accNum);
		return acimpl.showBalance(accNum);
	}

	@Override
	public int deposit(int accNum, int amount) throws AccountException {
		// TODO Auto-generated method stub
		validate(accNum);
		check(amount);
		acimpl.deposit(accNum, amount);
		return 0;
	}

	@Override
	public int withdraw(int accNum, int amount) throws AccountException {
		// TODO Auto-generated method stub
		validate(accNum);
		check(amount);
		if ((acimpl.showBalance(accNum) - amount) <= 0) {
			throw new AccountException("Insufficinet funds. Cannot perform the Transaction.");
		}
		acimpl.withdraw(accNum, amount);
		return 0;
	}

	@Override
	public ArrayList<Integer> transfer(int accNum_from, int accNum_to, int amount) throws AccountException {
		// TODO Auto-generated method stub
		validate(accNum_from);
		validate(accNum_to);
		check(amount);
		ArrayList<Integer> al_asimpl = new ArrayList<Integer>();
		al_asimpl = acimpl.transfer(accNum_from, accNum_to, amount);
		return al_asimpl;
	}

	@Override
	public void printTransactions(int accNum) throws AccountException {
		// TODO Auto-generated method stub
		validate(accNum);
		ArrayList<Transaction> al_astrans = new ArrayList<Transaction>();
		al_astrans = acimpl.printTransactions(accNum);

		Iterator<Transaction> it = al_astrans.iterator();
		while (it.hasNext()) {
			Transaction temp = it.next();
			System.out.println(temp.getTransacted_account() + " " + temp.getAction());
		}

	}

	public void newCustomer(String name) {
		// TODO Auto-generated method stub

		acimpl.newCustomer(name);

	}

	public void displayAll() {
		// TODO Auto-generated method stub
		acimpl.displayAll();

	}

}
