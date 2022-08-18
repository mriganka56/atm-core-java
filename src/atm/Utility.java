package atm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

class Utility {

	static {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	static Connection getCon() throws SQLException {
		return DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");

	}

//	static Connection getCon() throws SQLException {
//		return DriverManager.getConnection(
//				"jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
//
//	}

}
