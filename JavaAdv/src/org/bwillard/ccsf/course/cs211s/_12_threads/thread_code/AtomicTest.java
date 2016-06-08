
public class AtomicTest implements Runnable {
	
	private AtomicCounter c;
	
	public AtomicTest(AtomicCounter c) {
		this.c = c;
	}
	
	public void run() {
		c.increment();
		c.decrement();
	}

	public static void main(String[] args) throws Exception {
		AtomicCounter  counter = new AtomicCounter();
		Thread[] threads = new Thread[50000];
		for(int i=0; i<threads.length; i++) {
			threads[i] = new Thread(new AtomicTest(counter));
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
