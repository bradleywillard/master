
public class BankTester {

	public static void main(String[] args) throws InterruptedException {
		BankAccount account = new BankAccount();
		Thread feeThread = new Thread(new BankThread("FEE", account));
		Thread bonusThread = new Thread(new BankThread("BONUS", account));
		
		feeThread.start();
		bonusThread.start();
		
		feeThread.join();
		bonusThread.join();
		
		System.out.println(account);
		

	}

}
