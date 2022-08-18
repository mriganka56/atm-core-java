package atm;

class Transfer {
	private String t1name;

	private int t1bal;
	private int t2bal;

	public int getT2bal() {
		return t2bal;
	}

	public void setT2bal(int t2bal) {
		this.t2bal = t2bal;
	}

	private String t2name;

	public String getT1name() {
		return t1name;
	}

	public void setT1name(String t1name) {
		this.t1name = t1name;
	}

	public int getT1bal() {
		return t1bal;
	}

	public void setT1bal(int t1bal) {
		this.t1bal = t1bal;
	}

	public String getT2name() {
		return t2name;
	}

	public void setT2name(String t2name) {
		this.t2name = t2name;
	}

}
