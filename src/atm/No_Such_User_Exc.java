package atm;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

class No_Such_User_Exc1 extends Throwable {
	private String name = "";

	public No_Such_User_Exc1(String name) {
		super();
		this.name = name;
	}

}

class No_Such_User_Exc {
	static void find(String name) throws No_Such_User_Exc1 {
		Connection con;
		String test = "", test1 = "";
		try {
			con = Utility.getCon();
			PreparedStatement ps;
			ps = con.prepareStatement("select name from banker1 where name=?");
			ps.setString(1, name);
			ResultSet r;
			r = ps.executeQuery();
			while (r.next()) {
				test = r.getString("name");
			}
			if (test.equals(test1))
				throw new No_Such_User_Exc1(test);

		} catch (SQLException e) {

		}
	}

	public static void main(String s[]) {
	}
}