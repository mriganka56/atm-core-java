package atm;

class Multiple_of_100_Exc1 extends Throwable {
	private int bal;

	public Multiple_of_100_Exc1(int bal) {
		super();
		this.bal = bal;
	}

}

class Multiple_of_100_Exc {

	static void compute(int a) throws Multiple_of_100_Exc1 {
		if (a < 100 || a % 100 != 0)
			throw new Multiple_of_100_Exc1(a);

	}

	public static void main(String s[]) {

	}

}
