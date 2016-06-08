
public class RaceConditionTest implements Runnable {
	
	private Counter c;
	
	public RaceConditionTest(Counter c) {
		this.c = c;
	}
	
	public void run() {
		c.increment();
		c.decrement();
	}

	public static void main(String[] args) throws Exception {
		Counter  counter = new Counter();
		Thread[] threads = new Thread[50000];
		for(int i=0; i<threads.length; i++) {
			threads[i] = new Thread(new RaceConditionTest(counter));
		}
		for(Thread t : threads) {
			t.start();
		}
		for(Thread t : threads) {
			t.join();
		}
		System.out.println(counter);

	}

}
