package com.atm_CoreJava.entity;

public class Customer {

	private String name;
	private String email;
	private Integer atmPin;
	private String password;
	private Long phoneNumber;
	private Long accountNumber;
	private Long accountBalance;

	public Customer(String name, String email, Integer atmPin, String password, Long phoneNumber, Long accountNumber,
			Long accountBalance) {
		super();
		this.name = name;
		this.email = email;
		this.atmPin = atmPin;
		this.password = password;
		this.phoneNumber = phoneNumber;
		this.accountNumber = accountNumber;
		this.accountBalance = accountBalance;
	}

	public Customer() {
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getAtmPin() {
		return atmPin;
	}

	public void setAtmPin(Integer atmPin) {
		this.atmPin = atmPin;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(Long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public Long getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(Long accountBalance) {
		this.accountBalance = accountBalance;
	}

	@Override
	public String toString() {
		return "Customer [name=" + name + ", email=" + email + ", atmPin=" + atmPin + ", password=" + password
				+ ", phoneNumber=" + phoneNumber + ", accountNumber=" + accountNumber + ", accountBalance="
				+ accountBalance + "]";
	}

}
