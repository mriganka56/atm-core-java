package com.atm.app;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

import javax.swing.JOptionPane;

import com.atm.app.entity.Customer;
import com.atm.app.helper.Helper;
import com.atm.app.transaction.Transaction;

public class Main {

	private static void error(Throwable e) {
		System.out.println("----- " + e + " [" + new Date() + "] -----");
	}

	private static void init() {
		String username = JOptionPane.showInputDialog("Database Username", "Type your username");
		String password = JOptionPane.showInputDialog("Database Password", "Type your password");
		Helper.databaseConfiguration(username, password);

		try (Connection connection = Helper.getConnection()) {

			String msg = "----- Backend Development Server Running Successfully -----";
			Transaction.register(new Customer("DEV", "dev@gmail.com", 8585, "dev123", 9765671245L, 1760012001L, 1200L));
			Transaction.register(new Customer("RAM", "ram@gmail.com", 5266, "ram123", 9765671245L, 1760012002L, 1200L));
			Transaction.register(new Customer("SAM", "sam@gmail.com", 5444, "sam123", 9765671245L, 1760012003L, 1200L));
			Transaction.register(new Customer("ADI", "adi@gmail.com", 6997, "adi123", 9765671245L, 1760012004L, 1200L));
			Transaction
					.register(new Customer("ADIL", "adil@gmail.com", 3669, "adil123", 9765671245L, 1760012005L, 1200L));
			System.out.println(msg);

		} catch (SQLException e) {
			error(e);
			String msg = "Internal Server Error (500)\nCause: ";
			JOptionPane.showMessageDialog(null, msg + e.getMessage());
		} catch (Exception e) {
			error(e);
		}
	}

	private static void businessLogic() {
		init();
		while (true) {
			String options = "Create: C\n" + "Read: R\n" + "Update: U\n" + "Delete: D\n" + "Fixed Deposite: FD\n"
					+ "Exit: E or Q\n";
			String choice = JOptionPane.showInputDialog(options, "Type your choice");
			switch (choice.toUpperCase()) {
			case "CREATE", "C":
//				createAccount();
				break;

			case "READ", "R":
//				readAccount();
				break;

			case "UPDATE", "U":
//				updateAccount();
				break;

			case "DELETE", "D":
//				deleteAccount();
				break;

			case "QUIT", "EXIT", "Q", "E":
				System.exit(0);

			default:
				JOptionPane.showMessageDialog(null, "Please enter the right choice");
			}
		}
	}

	public static void main(String[] args) {
		businessLogic();
	}

}
