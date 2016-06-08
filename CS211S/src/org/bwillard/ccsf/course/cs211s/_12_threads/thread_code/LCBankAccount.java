import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.util.concurrent.locks.*;

public class LCBankAccount {

	
	private double balance;
	private static final double FEE=1;
	private static final double BONUS = 100;
	
	private Lock bankLock;
	private Condition depositThreshold;

	public LCBankAccount() {
		balance = 0;
		bankLock = new ReentrantLock();
		depositThreshold = bankLock.newCondition();
	}

	public double getBalance() {
		return balance;
	}

	public void deposit(double depositAmount) {
		bankLock.lock();
		try {
			if(depositAmount>=0) {
				System.out.println("BEFORE DEPOSIT: Balance is " + balance);
				balance += depositAmount;
				System.out.println("AFTER DEPOSIT: Balance is " + balance);
				depositThreshold.signalAll();
			}
		} finally {
			bankLock.unlock();
		}
	}
	
	
	public void addBonus() {
		bankLock.lock();
		try {
			while(balance<10000) {
				System.out.println("INSIDE BONUS WHILE LOOP");
				depositThreshold.await();
			}
			System.out.println("BEFORE BONUS: Balance is " + balance);
			balance += BONUS;
			System.out.println("AFTER BONUS: Balance is " + balance);
		} catch(InterruptedException ex) { 	
		} finally {
			bankLock.unlock();
		}
	}
	
	@Override
	public String toString() {
		return NumberFormat.getCurrencyInstance().format(balance);
	}
	
	
}
