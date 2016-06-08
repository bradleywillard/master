import java.text.NumberFormat;

public class WNBankAccount {

	private double balance;
	private static final double FEE=1;
	private static final double BONUS = 100;

	public WNBankAccount() {
		balance = 0;
	}

	public double getBalance() {
		return balance;
	}

	public synchronized void deposit(double depositAmount) {
		if(depositAmount>=0) {
			System.out.println("BEFORE DEPOSIT: Balance is " + balance);
			balance += depositAmount;
			System.out.println("AFTER DEPOSIT: Balance is " + balance);
			this.notifyAll();
		}
	}

	public void addBonus() {
		synchronized(this) {
			while(balance<10000) {
				System.out.println("INSIDE BONUS WHILE LOOP");
				try {
					this.wait();
				} catch(InterruptedException ex) {}
			}
			System.out.println("BEFORE BONUS: Balance is " + balance);
			balance += BONUS;
			System.out.println("AFTER BONUS: Balance is " + balance);
		}
		
	}
	
	@Override
	public String toString() {
		return NumberFormat.getCurrencyInstance().format(balance);
	}
	
	
}
