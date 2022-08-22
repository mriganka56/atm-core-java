package com.atm.app.transaction;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.atm.app.entity.Customer;
import com.atm.app.entity.Deposit;
import com.atm.app.entity.Withdraw;
import com.atm.app.exception.AccountNotFoundException;
import com.atm.app.exception.WrongPasswordException;
import com.atm.app.helper.Helper;

public class Transaction {

	public static Boolean register(Customer customer) throws SQLException {
		try (Connection connection = Helper.getConnection()) {

			String sql = "insert into customer values(?,?,?,?,?,?,?)";
			PreparedStatement ps = connection.prepareStatement(sql);

			ps.setString(1, customer.getName());
			ps.setString(2, customer.getEmail());
			ps.setInt(3, customer.getAtmPin());
			ps.setString(4, customer.getPassword());
			ps.setLong(5, customer.getPhoneNumber());
			ps.setLong(6, customer.getAccountNumber());
			ps.setLong(7, customer.getAccountBalance());
			int result = ps.executeUpdate();

			if (result > 0)
				return true;
			return false;

		}
	}

	public static Customer fetchCustomer(Long accountNumber) throws SQLException, AccountNotFoundException {
		try (Connection connection = Helper.getConnection()) {

			String name = null;
			Customer customer = new Customer();
			String sql = "select * from customer where accno=?";
			PreparedStatement ps = connection.prepareStatement(sql);

			ps.setLong(1, accountNumber);
			ResultSet resultSet = ps.executeQuery();
			while (resultSet.next()) {
				name = resultSet.getString("name");
				customer.setName(resultSet.getString("name"));
				customer.setEmail(resultSet.getString("email"));
				customer.setAtmPin(resultSet.getInt("atm_pin"));
				customer.setPassword(resultSet.getString("pass"));
				customer.setPhoneNumber(resultSet.getLong("phone"));
				customer.setAccountNumber(resultSet.getLong("accno"));
				customer.setAccountBalance(resultSet.getLong("accbal"));
			}

			System.out.println(name);
			if (name != null) {
				return customer;
			}
			throw new AccountNotFoundException("No account found with account number: " + accountNumber);

		}
	}

	public static Long balanceEnquiry(Long accountNumber, String password)
			throws SQLException, WrongPasswordException, AccountNotFoundException {
		try (Connection connection = Helper.getConnection()) {

			Long accountBalance = 0L;
			String originalPassword = null;
			String sql = "select * from customer where accno=?";
			PreparedStatement ps = connection.prepareStatement(sql);

			ps.setLong(1, accountNumber);
			ResultSet resultSet = ps.executeQuery();
			while (resultSet.next()) {
				accountBalance = resultSet.getLong("accbal");
				originalPassword = resultSet.getString("pass");
			}

			if (originalPassword != null) {
				if (password.equals(originalPassword))
					return accountBalance;
				throw new WrongPasswordException("Password did not match");
			}
			throw new AccountNotFoundException("No account found with account number: " + accountNumber);

		}
	}

	public static String deposit(Deposit deposit) throws SQLException, AccountNotFoundException {
		try (Connection connection = Helper.getConnection()) {

			String sql = "update customer set accbal=accbal+? where accno=? and atm_pin=?";
			PreparedStatement ps = connection.prepareStatement(sql);

			ps.setLong(1, deposit.getAmount());
			ps.setLong(2, deposit.getAccountNumber());
			ps.setInt(3, deposit.getAtmPin());

			Customer customer = Transaction.fetchCustomer(deposit.getAccountNumber());
			if (customer.getAtmPin().compareTo(deposit.getAtmPin()) == 0) {
				ps.executeQuery();
				customer.setAccountBalance(customer.getAccountBalance() + deposit.getAmount());
				return "Deposite Successful (Current balance " + customer.getAccountBalance() + ")";
			}
			return "Deposite Fail (ATM pin does not match)";

		}
	}

	public static String withdraw(Withdraw withdraw) throws SQLException, AccountNotFoundException {
		try (Connection connection = Helper.getConnection()) {

			String sql = "update customer set accbal=accbal-? where accno=? and atm_pin=?";
			PreparedStatement ps = connection.prepareStatement(sql);

			ps.setLong(1, withdraw.getAmount());
			ps.setLong(2, withdraw.getAccountNumber());
			ps.setInt(3, withdraw.getAtmPin());

			Customer customer = Transaction.fetchCustomer(withdraw.getAccountNumber());
			if (customer.getAtmPin().compareTo(withdraw.getAtmPin()) == 0) {
				ps.executeQuery();
				customer.setAccountBalance(customer.getAccountBalance() - withdraw.getAmount());
				return "Withdraw Successful (Current balance " + customer.getAccountBalance() + ")";
			}
			return "Withdraw Fail (ATM pin does not match)";

		}
	}

}
