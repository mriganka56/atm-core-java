package com.atm.app.dao;

import java.sql.SQLException;

import com.atm.app.entity.Customer;
import com.atm.app.entity.Deposit;
import com.atm.app.entity.Withdraw;
import com.atm.app.exception.AccountNotFoundException;
import com.atm.app.exception.WrongPasswordException;

public interface Dao {

	public String deposit(Deposit deposit) throws SQLException, AccountNotFoundException;

	public String withdraw(Withdraw withdraw) throws SQLException, AccountNotFoundException;

	public Boolean register(Customer customer) throws SQLException;

	public Customer fetchCustomer(Long accountNumber) throws SQLException, AccountNotFoundException;

	public Long balanceEnquiry(Long accountNumber, String password)
			throws SQLException, WrongPasswordException, AccountNotFoundException;

}
