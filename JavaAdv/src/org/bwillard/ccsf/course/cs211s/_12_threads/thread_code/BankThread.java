import java.util.Random;

public class BankThread implements Runnable {

	private String type;
	private BankAccount account;

	public BankThread(String type, BankAccount account) {
		this.type = type;
		this.account = account;
	}

	public void run() {
		Random generator = new Random();
		for (int i = 0; i < 1000; i++) {
			if (type.equals("FEE")) {
					account.applyFee();
			} else if (type.equals("BONUS")) {
					account.addBonus();
			}
			try {
				int time = generator.nextInt(5);
				Thread.sleep(time);
			} catch (InterruptedException ex) {
			}
		}
	}

}
