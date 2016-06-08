
public class WNBankTester {

	public static void main(String[] args) throws InterruptedException {
		WNBankAccount account = new WNBankAccount();
		Thread despositThread = new Thread(new WNBankThread("DEPOSIT", account));
		Thread bonusThread = new Thread(new WNBankThread("BONUS", account));
		
		despositThread.start();
		bonusThread.start();
		
		despositThread.join();
		bonusThread.join();
		
		System.out.println(account);
		

	}

}
