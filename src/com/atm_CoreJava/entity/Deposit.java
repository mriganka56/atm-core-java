package com.atm_CoreJava.entity;

public class Deposit {

	private Long amount;
	private Integer atmPin;
	private Long accountNumber;

	public Deposit(Long amount, Integer atmPin, Long accountNumber) {
		super();
		this.amount = amount;
		this.atmPin = atmPin;
		this.accountNumber = accountNumber;
	}

	public Long getAmount() {
		return amount;
	}

	public void setAmount(Long amount) {
		this.amount = amount;
	}

	public Integer getAtmPin() {
		return atmPin;
	}

	public void setAtmPin(Integer atmPin) {
		this.atmPin = atmPin;
	}

	public Long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(Long accountNumber) {
		this.accountNumber = accountNumber;
	}

	@Override
	public String toString() {
		return "Deposit [amount=" + amount + ", atmPin=" + atmPin + ", accountNumber=" + accountNumber + "]";
	}

}
