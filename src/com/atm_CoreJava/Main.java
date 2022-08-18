package com.atm_CoreJava;

import java.sql.SQLException;

import com.atm_CoreJava.entity.Customer;
import com.atm_CoreJava.transaction.Transaction;

public class Main {

	public static void main(String[] args) {
		try {
			Customer customer = new Customer("a", "a@gmail.com", 700060, "xyz", 9204563217L, 123456789L, 50000L);
			System.out.println(Transaction.register(customer));
			System.out.println(Transaction.fetchCustomer(101L));
			Transaction.balanceEnquiry(123456789L, "xyz");
		} catch (SQLException e) {
			System.out.println("----- SQL: " + e + " -----");
		}
	}

}
