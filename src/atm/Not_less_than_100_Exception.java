package atm;

class Not_less_than_100_Exception1 extends Throwable {
	private int bal;

	public Not_less_than_100_Exception1(int bal) {
		super();
		this.bal = bal;
	}

}

class Not_less_than_100_Exception {
	static void compute(int a) throws Not_less_than_100_Exception1 {
		if (a < 100)
			throw new Not_less_than_100_Exception1(a);

	}

	public static void main(String s[]) {

	}
}