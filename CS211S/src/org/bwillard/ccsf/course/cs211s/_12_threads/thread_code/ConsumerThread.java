import java.util.Random;

public class ConsumerThread implements Runnable{
	
	private NumberBox numberBox;
	
	public ConsumerThread(NumberBox numberBox) {
		this.numberBox = numberBox;
	}
	public void run() {
		for(int i=0; i<10; i++) {
			Random generator = new Random();
			int num = numberBox.getNumberFromBox();
			//System.out.println("Consuming a number from the box: " + num);				
			try {
				int sleepTime = generator.nextInt(5000);
				System.out.println("Consumer sleeping...");
				Thread.sleep(sleepTime);
				System.out.println("Consumer awake...");
			} catch(InterruptedException ex) { }
		}
	}

}
