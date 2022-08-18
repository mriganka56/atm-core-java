package com.atm.app;

import java.sql.SQLException;

import com.atm.app.entity.Customer;
import com.atm.app.transaction.Transaction;

public class Main {

	public static void main(String[] args) {
		try {
			Customer customer = Customer.builder().name("a").email("a@gmail").atmPin(8888).password("a").phoneNumber(1L)
					.accountNumber(101L).accountBalance(2000L).build();
			System.out.println(Transaction.register(customer));
			System.out.println(Transaction.fetchCustomer(101L));
		} catch (SQLException e) {
			System.out.println("----- SQL: " + e + " -----");
		}
	}

}
