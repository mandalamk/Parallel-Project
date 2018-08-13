/*
 CHECK FOR THE RUN OF THE WHILE LOOP FOR INPUTMISMATCHEXCEPTION.
 TAKES THE WRONG INPUT TO AN ACTION AS THE INPUT TO YES/NO QUESTION FOR MORE TRANSACTION.
 BECAUSE OF THIS THE LOOP RUNS ONE TIME MORE EACH TIME.
 
 */
package com.cg.pp.ui;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.cg.pp.exceptions.AccountException;
import com.cg.pp.services.AccountServiceImpl;

public class Driver {

	public Driver() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args)  {
		// TODO Auto-generated method stub

		AccountServiceImpl impl = new AccountServiceImpl();
		System.out.println("Welcome!");
		Scanner sc = new Scanner(System.in);
		boolean bool=true;
		int i=1;
		System.out.println(" 1.Create new account \n 2.Transfer funds \n 3.Deposit money \n 4.Withdraw funds \n 5.Show balance \n 6.Show Transactions \n 7.Exit");
		System.out.println("Enter Choice.");
		
		while(bool == true)
		{
			
			String response="";
			if(i!=1) {
				System.out.println("Do you want to do any other Transaction? \n 1.Yes/Y \n 2.No/N");
				response = sc.next();
			}
			if(response.toLowerCase().equals("yes") || response.toLowerCase().equals("y")||i==1)
			{
				if(i!=1) {
				System.out.println(" 1.Create new account \n 2.Transfer funds \n 3.Deposit money \n 4.Withdraw funds \n 5.Show balance \n 6.Show Transactions \n 7.Exit");
				System.out.println("Enter Choice.");
				}
				int n = sc.nextInt();

				switch (n) {
				case (1): {
					System.out.println("Enter Customer Name:");
					String name = sc.next();
					impl.newCustomer(name);
					//impl.displayAll();
					break;
				}
				case (2): {
					int accFrom=0;
					int accTo=0;
					int amount=0;
				
						try {
							System.out.println("Enter Sender's account number:");
							accFrom = sc.nextInt();
						} catch (InputMismatchException e1) {
							// TODO Auto-generated catch block
							System.out.println("Enter Only Numbers.");
						}
						try {
							System.out.println("Enter Receiver's account number:");
							accTo = sc.nextInt();
						} catch (InputMismatchException e1) {
							// TODO Auto-generated catch block
							System.out.println("Enter Only Numbers.");
						}
						try {
							System.out.println("Enter Amount:");
							amount = sc.nextInt();
						} catch (InputMismatchException e1) {
							// TODO Auto-generated catch block
							System.out.println("Enter Only Numbers.");
						}
					 

					try {
						impl.transfer(accFrom, accTo, amount);
					} catch (AccountException e) {
						// TODO Auto-generated catch block
						System.out.println(e.getMessage());
					}
					/*
					try {
						impl.printTransactions(accFrom);
					} catch (MyException e) {
						// TODO Auto-generated catch block
						System.out.println(e.getMessage());
					}
					impl.displayAll();
					 */
					break;
				}
				case (3): {
					int accNum=0;
					int amount=0;
					try {
						System.out.println("Enter Account Number:");
						accNum = sc.nextInt();
					}catch (InputMismatchException e1) {
						// TODO Auto-generated catch block
						System.out.println("Enter Only Numbers.");
						break;
					}
						try {
							System.out.println("Enter Amount:");
							amount = sc.nextInt();
						} catch (InputMismatchException e1) {
							// TODO Auto-generated catch block
							System.out.println("Enter Only Numbers.");
							break;
						}
					
					try {
						impl.deposit(accNum, amount);
					} catch (AccountException e) {
						// TODO Auto-generated catch block
						System.out.println(e.getMessage());
					}
					/*
					try {
						impl.printTransactions(accNum);
					} catch (MyException e) {
						// TODO Auto-generated catch block
						System.out.println(e.getMessage());
					}
					impl.displayAll();
					 */
					break;

				}
				case (4): {
					int accNum=0;
					int amount=0;
					try {
						System.out.println("Enter Account Number:");
						accNum = sc.nextInt();
					} catch (InputMismatchException e1) {
						// TODO Auto-generated catch block
						System.out.println("Enter Only Numbers.");
					}
					try {
						System.out.println("Enter Amount:");
						amount = sc.nextInt();
					} catch (InputMismatchException e1) {
						// TODO Auto-generated catch block
						System.out.println("Enter Only Numbers");
					}
					try {
						impl.withdraw(accNum, amount);
					} catch (AccountException e) {
						// TODO Auto-generated catch block
						System.out.println(e.getMessage());
					}
					/*
					try {
						impl.printTransactions(accNum);
					} catch (MyException e) {
						// TODO Auto-generated catch block
						System.out.println(e.getMessage());
					}
					impl.displayAll();
					 */
					break;
				}
				case (5): {
					int accNum=0;
					int bal = 0;
					try {
						System.out.println("Enter Account Number:");
						accNum = sc.nextInt();
					} catch (InputMismatchException e1) {
						// TODO Auto-generated catch block
						System.out.println("Enter Only Numbers");
					}

					try {
						bal = impl.showBalance(accNum);
					} catch (AccountException e) {
						// TODO Auto-generated catch block
						System.out.println(e.getMessage());
					}

					System.out.println(bal);
					break;
				}
				case(6):{
					int accNum=0;
					try {
						System.out.println("Enter Account Number:");
						accNum = sc.nextInt();
					} catch (InputMismatchException e1) {
						// TODO Auto-generated catch block
						System.out.println("Enter Only Numbers");
					}
					try {
						impl.printTransactions(accNum);
					} catch (AccountException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;
				}
				case(7):
					System.out.println("Thank you for using the service.");
					sc.close();
					bool = false;
					break;
				}


			}
			else if(response.toLowerCase().equals("no") || response.toLowerCase().equals("n")){
				System.out.println("Thank You for using the application.");
				bool=false;
				break;
			}
			else {
				System.out.println(response);
				System.out.println("Please enter Valid Response.");
			}

			i++;
		}

		

		}
}
