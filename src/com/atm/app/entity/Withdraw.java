package com.atm.app.entity;

public class Withdraw extends Deposit {

	public Withdraw() {
		super();
	}

	public Withdraw(Long amount, Integer atmPin, Long accountNumber) {
		super(amount, atmPin, accountNumber);
	}

}
