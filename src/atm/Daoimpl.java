package atm;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

class Daoimpl implements Dao {
	ResultSet t;
	Connection con;
	PreparedStatement ps;

	@Override
	public boolean addBanker(Banker b) {

		int f = 0;
		try {
			Connection con = Utility.getCon();
			PreparedStatement ps = con.prepareStatement("insert into banker1 values(?,?,?,?,?)");
			ps.setString(1, b.getBname());
			ps.setString(2, b.getPass());
			ps.setInt(3, b.getPin());
			ps.setInt(4, b.getAbal());
			ps.setString(5, b.getAccno());

			f = ps.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (f > 0)
			return true;
		else
			return false;

	}

	@Override
	public Customer findCustomer(Customer cus) {

		// TODO Auto-generated method stub
		Connection con;
		try {
			con = Utility.getCon();
			PreparedStatement ps;
			ps = con.prepareStatement("select bname,password,pin from banker1 where pin=?");
			ps.setInt(1, cus.getPino());
			ResultSet r;
			r = ps.executeQuery();
			while (r.next()) {

				cus.setBaname(r.getString("bname"));
				cus.setPino(r.getInt("pin"));
				cus.setPasswrd(r.getString("password"));

			}
		} catch (SQLException e) {
			System.out.println(e);
		}
		return cus;
	}

	public Deposit Addbal(Deposit d) {
		try {
			Connection con = Utility.getCon();
			PreparedStatement dp = con.prepareStatement("update banker1 set abal=abal+? where bname=?");
			dp.setInt(1, d.getBal());
			dp.setString(2, d.getDname());
			ResultSet da = dp.executeQuery();
		} catch (SQLException e) {
			System.out.println("dao error" + e);
		}
		return d;

	}

	public int bal_enquiry(Customer cus) {

		int acc_bal = 0;
		try {
			con = Utility.getCon();
			ps = con.prepareStatement("select abal from banker1 where pin=?");
			ps.setInt(1, cus.getPino());
			t = ps.executeQuery();
			while (t.next()) {
				acc_bal = t.getInt("abal");
			}
		} catch (SQLException e) {
		}
		return acc_bal;

	}

	public int Witamt(Withdrawl w) {
		int bal = 0;
		try {
			Connection con = Utility.getCon();
			PreparedStatement dp = con.prepareStatement("update banker1 set abal=abal-? where bname=?");
			dp.setInt(1, w.getWamt());
			dp.setString(2, w.getWname());
			ResultSet da = dp.executeQuery();
			PreparedStatement ps = con.prepareStatement("select abal from banker1 where bname=?");
			ps.setString(1, w.getWname());
			ResultSet rs = ps.executeQuery();
			while (rs.next())
				bal = rs.getInt("abal");
		} catch (SQLException e) {
			System.out.println("dao error" + e);

		}
		return bal;
	}

	public int transfer(Transfer t) {
		int bal = 0;
		try {
			Connection con = Utility.getCon();
			PreparedStatement ps = con.prepareStatement("update banker1 set abal=abal+? where bname=?");
			ps.setInt(1, t.getT1bal());
			ps.setString(2, t.getT1name());
			ResultSet rs = ps.executeQuery();
			PreparedStatement ps1 = con.prepareStatement("update banker1 set abal=abal-? where bname=?");
			ps1.setInt(1, t.getT2bal());
			ps1.setString(2, t.getT2name());
			ResultSet rs1 = ps1.executeQuery();
			ps1 = con.prepareStatement("select abal from banker1 where bname=?");
			ps1.setString(1, t.getT1name());
			rs1 = ps1.executeQuery();
			while (rs1.next()) {
				bal = rs1.getInt("abal");
			}
		} catch (SQLException e) {
			System.out.println("error" + e);

		}
		return bal;
	}
}
