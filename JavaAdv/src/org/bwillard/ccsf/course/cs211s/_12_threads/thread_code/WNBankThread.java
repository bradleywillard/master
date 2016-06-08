import java.util.Random;

public class WNBankThread implements Runnable {

	private String type;
	private WNBankAccount account;

	public WNBankThread(String type, WNBankAccount account) {
		this.type = type;
		this.account = account;
	}

	public void run() {
		if(type.equals("DEPOSIT")) {
			for(int i=0; i<10; i++) {
				Random generator = new Random();
				account.deposit(generator.nextInt(3000));
				try {
					Thread.sleep(100);
				} catch(InterruptedException ex) {}
			}
		} else if(type.equals("BONUS")) {
			account.addBonus();
		}
		
		
	}

}
