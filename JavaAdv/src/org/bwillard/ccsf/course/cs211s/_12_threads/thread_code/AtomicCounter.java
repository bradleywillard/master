import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.*;

public class AtomicCounter {
	
	private AtomicInteger c;
	
	public AtomicCounter() {
		c = new AtomicInteger(0);
	}
	
	public void increment() {
		c.incrementAndGet();
	}
	
	public void decrement() {
		c.decrementAndGet();
	}
	
	public String toString() {
		return Integer.toString(c.get());
	}

}
