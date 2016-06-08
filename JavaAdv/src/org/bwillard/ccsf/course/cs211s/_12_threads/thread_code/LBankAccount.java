import java.text.NumberFormat;
import java.util.concurrent.locks.*;

public class LBankAccount {

	private double balance;
	private static final double FEE=1;
	private double bonus;
	private Lock balanceLock, bonusLock;

	public LBankAccount() {
		balance = 0;
		bonus = 1;
		balanceLock = new ReentrantLock();
		bonusLock = new ReentrantLock();
	}

	public void setBonus(double bonus) {
		bonusLock.lock();
		try {
			this.bonus = bonus;
		} finally {
			bonusLock.unlock();
		}
	}
	public double getBalance() {
		return balance;
	}

	public void applyFee() {
		balanceLock.lock();
		try {
			balance -= FEE;	
		} finally {
			balanceLock.unlock();
		}
	}
	public void addBonus() {
		bonusLock.lock();
		balanceLock.lock();
		try {
			balance += bonus;
		} finally {
			balanceLock.unlock();
			bonusLock.unlock();
		}
	}
	
	@Override
	public String toString() {
		return NumberFormat.getCurrencyInstance().format(balance);

	}
	
	
}
