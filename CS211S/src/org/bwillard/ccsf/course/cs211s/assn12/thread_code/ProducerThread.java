import java.util.Random;

public class ProducerThread implements Runnable{
	
	private NumberBox numberBox;
	
	public ProducerThread(NumberBox numberBox) {
		this.numberBox = numberBox;
	}
	public void run() {
		for(int i=0; i<10; i++) {
			Random generator = new Random();
			int num = generator.nextInt(1000);
			numberBox.putNumberInBox(num);
		//	System.out.println("Producing a number for the box: " + num);				
			try {
				int sleepTime = generator.nextInt(5000);
				System.out.println("Producer sleeping...");
				Thread.sleep(sleepTime);
				System.out.println("Producer awake...");
			} catch(InterruptedException ex) { }
		}
	}

}
