package atm;

public interface Dao {

	boolean addBanker(Banker b);

	Customer findCustomer(Customer c);

	Deposit Addbal(Deposit da);

	int bal_enquiry(Customer cus);

	int Witamt(Withdrawl w);

	int transfer(Transfer t);

}
