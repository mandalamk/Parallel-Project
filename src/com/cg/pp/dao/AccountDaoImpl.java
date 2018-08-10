package com.cg.pp.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import com.cg.pp.beans.Account;
import com.cg.pp.beans.Customer;
import com.cg.pp.beans.Transaction;

public class AccountDaoImpl implements AccountDao {

	HashMap<Integer, Customer> hm = new HashMap<Integer, Customer>();
	// hm now stores account number and customer object.

	Transaction t = new Transaction();

	public AccountDaoImpl() {
		// TODO Auto-generated constructor stub

		newCustomer("bob");
		newCustomer("mark");
		newCustomer("dan");

	}

	@Override
	public int showBalance(int accNum) {

		int bal = hm.get(accNum).getAccount().getBalance();
		return bal;
	}

	@Override
	public int deposit(int accNum, int amount) {

		// To deposit into the account.
		Transaction t = new Transaction();

		int new_bal = hm.get(accNum).getAccount().getBalance() + amount;
		hm.get(accNum).getAccount().setBalance(new_bal);
		t.setAmount(amount);
		t.setTransacted_account(Integer.toString(accNum) + "(SELF)");
		t.setAction("DEPOSIT");
		hm.get(accNum).getAccount().getHistory().add(t);
		return new_bal;
	}

	@Override
	public int withdraw(int accNum, int amount) {

		// to withdraw from the account.
		Transaction t = new Transaction();

		int new_bal = hm.get(accNum).getAccount().getBalance() - amount;
		hm.get(accNum).getAccount().setBalance(new_bal);
		t.setAmount(amount);
		t.setTransacted_account(Integer.toString(accNum) + "(SELF)");
		t.setAction("WITHDRAW");
		hm.get(accNum).getAccount().getHistory().add(t);
		return new_bal;
	}

	@Override
	public ArrayList<Integer> transfer(int accNum_from, int accNum_to, int amount) {

		/*
		 * to transfer from the account. returns an arraylist of size 2, with al[0]
		 * being balance of the amount from which it is transferred. used hm to store
		 * accnum and customer data.
		 */
		Transaction t = new Transaction();


		ArrayList<Integer> al_local = new ArrayList<Integer>();
		int new_bal_from = hm.get(accNum_from).getAccount().getBalance() - amount;
		al_local.add(new_bal_from);
		hm.get(accNum_from).getAccount().setBalance(new_bal_from);

		int new_bal_to = hm.get(accNum_to).getAccount().getBalance() + amount;
		hm.get(accNum_to).getAccount().setBalance(new_bal_to);
		al_local.add(new_bal_to);

		String transferred_to_name = hm.get(accNum_to).getCustName();
		String transferred_from_name = hm.get(accNum_to).getCustName();

		t.setAmount(amount);
		t.setTransacted_account(accNum_to+" RECEIVED FROM" + Integer.toString(accNum_from) + " " + transferred_from_name);
		t.setAction("RECEIVED");
		hm.get(accNum_to).getAccount().getHistory().add(t);

		t.setTransacted_account(accNum_from+" TRANSFERRED TO " + Integer.toString(accNum_to) + " " + transferred_to_name);
		t.setAction("TRANSFER");
		hm.get(accNum_from).getAccount().getHistory().add(t);

		return al_local;
	}

	@Override
	public ArrayList<Transaction> printTransactions(int accNum) {

		ArrayList<Transaction> all = new ArrayList<Transaction>();
		all.addAll(hm.get(accNum).getAccount().getHistory());
		return all;
	}

	public void newCustomer(String name) {

		Account account = new Account(5000, (int) (Math.random() * 10000), new ArrayList<Transaction>());

		int accid = account.getAccNumber();
		Customer cust = new Customer(name, account);

		hm.put(accid, cust);
		System.out.println("accid " + accid + " " + cust.getCustName());
		System.out.println(cust.getAccount().getAccNumber());

	}

	public void displayAll() {

		Iterator<Entry<Integer, Customer>> it = hm.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<Integer, Customer> pair = (Map.Entry<Integer, Customer>) it.next();
			System.out.print("key =" + pair.getKey() + ": " + hm.get(pair.getKey()).getCustName() + " ");
			System.out.println(pair.getValue().getAccount().getBalance());
		}

	}

	public boolean exists(int key) {

		if (hm.containsKey(key))
			return true;
		return false;
	}

}
