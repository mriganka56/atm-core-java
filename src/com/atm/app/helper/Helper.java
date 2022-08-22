package com.atm.app.helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Helper {

	private static String username;
	private static String password;

	public static void databaseConfiguration(String username, String password) {
		Helper.username = username;
		Helper.password = password;
	}

	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			System.out.println("----- Driver Problem: " + e + " -----");
		}
	}

	public static Connection getConnection() throws SQLException {
		String driverURL = "jdbc:oracle:thin:@localhost:1521:XE";
		return DriverManager.getConnection(driverURL, username, password);
	}

}
