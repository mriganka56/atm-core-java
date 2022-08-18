package com.atm.app.transaction;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.atm.app.entity.Customer;
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

	public static Customer fetchCustomer(Long accountNumber) throws SQLException {
		try (Connection connection = Helper.getConnection()) {

			String sql = "select * from customer where accno=?";
			PreparedStatement ps = connection.prepareStatement(sql);

			ps.setLong(1, accountNumber);
			ResultSet resultSet = ps.executeQuery();
			resultSet.next();

			Customer customer = new Customer();
			customer.setName(resultSet.getString("name"));
			customer.setEmail(resultSet.getString("email"));
			customer.setAtmPin(resultSet.getInt("atm_pin"));
			customer.setPassword(resultSet.getString("pass"));
			customer.setPhoneNumber(resultSet.getLong("phone"));
			customer.setAccountNumber(resultSet.getLong("accno"));
			customer.setAccountBalance(resultSet.getLong("accbal"));
			return customer;

		}
	}

}
