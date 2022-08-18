package com.atm.app.dao;

import com.atm.app.entity.Customer;
import com.atm.app.entity.Deposit;
import com.atm.app.entity.Withdraw;

public interface Dao {

	public String deposit(Deposit deposit);

	public String withdraw(Withdraw withdraw);

	public Boolean register(Customer customer);

	public Customer fetchCustomer(Long accountNumber);

	public Long balanceEnquiry(Long accountNumber, String password);

}
