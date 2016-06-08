import java.text.NumberFormat;

public class BankAccount {

	private double balance;
	private static final double FEE=1;
	private static final double BONUS = 1;

	public BankAccount() {
		balance = 0;
	}

	public double getBalance() {
		return balance;
	}

	public synchronized void applyFee() {
		balance -= FEE;
	}
	public synchronized void addBonus() {
		balance += BONUS;
	}
	
	@Override
	public String toString() {
		return NumberFormat.getCurrencyInstance().format(balance);
	}
	
	
}
