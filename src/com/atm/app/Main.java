package com.atm.app;

import java.sql.SQLException;

import com.atm.app.entity.Customer;
import com.atm.app.entity.Deposit;
import com.atm.app.entity.Withdraw;
import com.atm.app.exception.AccountNotFoundException;
import com.atm.app.exception.WrongPasswordException;
import com.atm.app.transaction.Transaction;

public class Main {

	public static void main(String[] args) throws WrongPasswordException, AccountNotFoundException {
		try {
			Customer customer = Customer.builder().name("a").email("a@gmail").atmPin(8888).password("a").phoneNumber(1L)
					.accountNumber(101L).accountBalance(2000L).build();
//			System.out.println(Transaction.register(customer));
			System.out.println(Transaction.fetchCustomer(101L));
			System.out.println(Transaction.balanceEnquiry(101L, "a"));
			System.out.println(Transaction.deposit(new Deposit(120L, 8881, 101L)));
			System.out.println(Transaction.withdraw(new Withdraw(120L, 8888, 101L)));
		} catch (SQLException e) {
			System.out.println("----- SQL: " + e + " -----");
		} catch (WrongPasswordException | AccountNotFoundException e) {
			System.out.println("----- Custom: " + e + " -----");
		}
	}

}
