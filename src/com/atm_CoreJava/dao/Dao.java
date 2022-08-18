package com.atm_CoreJava.dao;

import com.atm_CoreJava.entity.Banker;
import com.atm_CoreJava.entity.Customer;
import com.atm_CoreJava.entity.Deposit;
import com.atm_CoreJava.entity.Transfer;
import com.atm_CoreJava.entity.Withdrawl;

public interface Dao {

	boolean addBanker(Banker b);

	Customer findCustomer(Customer c);

	Deposit Addbal(Deposit da);

	int bal_enquiry(Customer cus);

	int Witamt(Withdrawl w);

	int transfer(Transfer t);
}
