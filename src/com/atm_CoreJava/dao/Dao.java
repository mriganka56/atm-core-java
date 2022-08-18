package com.atm_CoreJava.dao;

import com.atm_CoreJava.entity.Customer;
import com.atm_CoreJava.entity.Deposit;
import com.atm_CoreJava.entity.Withdraw;

public interface Dao {

	public String deposit(Deposit deposit);

	public String withdraw(Withdraw withdraw);

	public Boolean register(Customer customer);

	public Customer fetchCustomer(Long accountNumber);

	public Long balanceEnquiry(Long accountNumber, String password);

}
