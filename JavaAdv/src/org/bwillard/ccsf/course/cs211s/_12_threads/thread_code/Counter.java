import java.util.concurrent.locks.*;

public class Counter {
	
	private int c;
	
	public Counter() {
		c = 0;
	}
	
	public void increment() {
			c++;
	}
	
	public void decrement() {
		c--;
	}
	
	public String toString() {
		return Integer.toString(c);
	}

}
