package atm;

class Banker {
	private String bname;
	private String pass;
	private int pin;
	private int Abal;
	private String accno;

	public String getBname() {
		return bname;
	}

	public void setBname(String bname) {
		this.bname = bname;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public int getPin() {
		return pin;
	}

	public void setPin(int pin) {
		this.pin = pin;
	}

	public int getAbal() {
		return Abal;
	}

	public void setAbal(int abal) {
		this.Abal = abal;
	}

	public String getAccno() {
		return accno;
	}

	public void setAccno(String accno) {
		this.accno = accno;
	}

}
