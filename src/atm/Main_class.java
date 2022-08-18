package atm;

import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

class Main_class {

	public static void main(String[] args) {
		int ch;
		int ld;
		boolean b = false;
		JPasswordField pf = new JPasswordField();
		JPasswordField pn = new JPasswordField();
		while (true) {
			while (true) {
				try {

					ch = Integer
							.parseInt(JOptionPane.showInputDialog(
									"1.Register\n2.Login\n3.Exit",
									"Enter Your Choice"));
					break;
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null,
							"Single or Multiple Entry left empty!!!");
				}
			}

			switch (ch) {
			case 1:
				try {
					Banker b1 = new Banker();
					b1.setBname(JOptionPane.showInputDialog("Enter Name",
							"type here"));
					b1.setPass(JOptionPane.showInputDialog(
							"Enter desired password", "type here"));
					try {
						b1.setPin(Integer.parseInt(JOptionPane.showInputDialog(
								"Enter desired pin", "Pin should be a number")));
					} catch (Exception e) {
						JOptionPane.showMessageDialog(null,
								"Please enter combination of numbers");
					}
					b1.setAbal(Integer.parseInt(JOptionPane.showInputDialog(
							"Enter Account Balance", "type here")));
					b1.setAccno(JOptionPane.showInputDialog(
							"Enter Account No.", "type here"));

					Dao d = new Daoimpl();
					d.addBanker(b1);
					JOptionPane.showMessageDialog(null,
							"Successfully Registered");
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null,
							"Single or Multiple Entry left empty!!!");
				}
				break;
			case 2:
				try {
					Customer cs = new Customer();
					Dao e = new Daoimpl();

					String name, acc_num = "", passwrd = "", choice;
					int pin = 0;
					name = JOptionPane.showInputDialog("Enter Name:",
							"Type Here");

					int pass = JOptionPane.showConfirmDialog(null, pf,
							"Enter Password", JOptionPane.OK_CANCEL_OPTION,
							JOptionPane.PLAIN_MESSAGE);
					if (pass == JOptionPane.OK_OPTION)
						passwrd = new String(pf.getPassword());

					int pn1 = JOptionPane.showConfirmDialog(null, pn,
							"Enter Pin no.", JOptionPane.OK_CANCEL_OPTION,
							JOptionPane.PLAIN_MESSAGE);
					if (pn1 == JOptionPane.OK_OPTION)
						pin = Integer.parseInt(new String(pn.getPassword()));
					cs.setPino(pin);
					Customer x = e.findCustomer(cs);

					if (name.equals(cs.getBaname())
							&& passwrd.equals(cs.getPasswrd())
							&& pin == cs.getPino()) {
						try {
							Connection con = Utility.getCon();
						} catch (SQLException f) {
							f.printStackTrace();
						}
						JOptionPane.showMessageDialog(null,
								"Connected To Your Account!!!!");
						b = true;
						while (true) {
							ld = Integer
									.parseInt(JOptionPane
											.showInputDialog(
													"1.Deposit\n2.Balance Enquiry\n3.Withdraw Money\n4.Transfer\n5.Exit",
													"Type here"));
							switch (ld) {
							case 1:
								try {
									Deposit da = new Deposit();
									Dao dr = new Daoimpl();
									da.setDname(name);
									da.setBal(Integer.parseInt(JOptionPane
											.showInputDialog(
													"Enter the balance to be deposited",
													"type here")));
									dr.Addbal(da);
									JOptionPane
											.showMessageDialog(null,
													"balance deposited To Your Account!!!!");
								}

								catch (Exception g) {
									JOptionPane
											.showMessageDialog(null,
													"Single or Multiple Entry left empty!!!");
								}
								break;

							case 2:

								if (b == true) {

									JOptionPane.showMessageDialog(null,
											new Daoimpl().bal_enquiry(x));
								}

								break;

							case 3:
								try {
									int abal = 0, w_bal = 0;
									Withdrawl wd = new Withdrawl();
									Dao wr = new Daoimpl();
									wd.setWname(name);
									while (true) {
										try {
											w_bal = Integer
													.parseInt(JOptionPane
															.showInputDialog(
																	"Enter the balance to withdraw",
																	"type here"));
											Not_less_than_100_Exception
													.compute(w_bal);
											break;
										} catch (Not_less_than_100_Exception1 less_than_100) {
											JOptionPane
													.showMessageDialog(null,
															"Withdrawal Amount must be greater than 100");
										}
									}
									wd.setWamt(w_bal);
									abal = new Daoimpl().bal_enquiry(x);

									if (abal >= wd.getWamt()) {
										try {
											Connection con = Utility.getCon();
											wr.Witamt(wd);
										} catch (SQLException f) {
											f.printStackTrace();
										}

										JOptionPane
												.showMessageDialog(null,
														"Deducted from your account!!!!");
									} else {
										JOptionPane
												.showMessageDialog(null,
														"You do not have sufficient balance!!!!");
									}
								} catch (Exception wtr) {
									JOptionPane
											.showMessageDialog(null,
													"Single or Multiple Entry left empty!!!");
								}
								break;

							case 4:
								try {
									int bal, user_bal;
									String creditor_name = "";
									Transfer tr = new Transfer();
									Dao tk = new Daoimpl();
									while (true) {

										try {
											creditor_name = JOptionPane
													.showInputDialog(
															"Enter Creditor's name",
															"type here");
											No_Such_User_Exc
													.find(creditor_name);
											break;
										} catch (No_Such_User_Exc1 fake_user) {
											JOptionPane
													.showMessageDialog(null,
															"No Such user exists!!! Try Again!!");
										}
									}
									tr.setT1name(creditor_name);
									while (true) {
										try {
											bal = Integer
													.parseInt((JOptionPane
															.showInputDialog(
																	"Enter amount to be transferred",
																	"type here")));
											Multiple_of_100_Exc.compute(bal);
											break;
										} catch (Multiple_of_100_Exc1 tr_exception) {
											JOptionPane
													.showMessageDialog(null,
															"Transferrable Amount must be greater than and multiple of 100");
										}

									}
									user_bal = new Daoimpl().bal_enquiry(x);
									if (user_bal >= bal) {
										tr.setT1bal(bal);

										tr.setT2name(name);
										tr.setT2bal(bal);

										tk.transfer(tr);
										JOptionPane
												.showMessageDialog(null,
														"Money transferred successfully!!!");
									} else
										JOptionPane
												.showMessageDialog(null,
														"You do not have sufficient balance!!!!");
								} catch (Exception tr) {
									JOptionPane
											.showMessageDialog(null,
													"Single or Multiple Entry left empty!!!");
								}
								break;

							case 5:
								System.exit(0);
							}
						}

					} else {
						JOptionPane.showMessageDialog(null,
								"Not Connected To Your Account!!!!");
					}
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null,
							"Single or Multiple Entry left empty!!!");
				}
				break;
			case 3:
				System.exit(0);

			}
		}
	}
}
