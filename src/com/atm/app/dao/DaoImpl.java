package com.atm.app.dao;

import java.sql.SQLException;

import com.atm.app.entity.Customer;
import com.atm.app.entity.Deposit;
import com.atm.app.entity.Withdraw;
import com.atm.app.exception.AccountNotFoundException;
import com.atm.app.exception.WrongPasswordException;
import com.atm.app.transaction.Transaction;

public class DaoImpl implements Dao {

	@Override
	public String deposit(Deposit deposit) throws SQLException, AccountNotFoundException {
		return Transaction.deposit(deposit);
	}

	@Override
	public String withdraw(Withdraw withdraw) throws SQLException, AccountNotFoundException {
		return Transaction.withdraw(withdraw);
	}

	@Override
	public Boolean register(Customer customer) throws SQLException {
		return Transaction.register(customer);
	}

	@Override
	public Customer fetchCustomer(Long accountNumber) throws SQLException, AccountNotFoundException {
		return Transaction.fetchCustomer(accountNumber);
	}

	@Override
	public Long balanceEnquiry(Long accountNumber, String password)
			throws SQLException, WrongPasswordException, AccountNotFoundException {
		return Transaction.balanceEnquiry(accountNumber, password);
	}

}
