import java.util.Random;

public class NumberBox {

	private int number;
	private boolean boxFilled;
	
	public NumberBox() {
		boxFilled = false;
	}

	public int getNumberFromBox() {
		synchronized(this) {
			while(!boxFilled) {
				try {
					System.out.println("Waiting to get a number...");
					this.wait();
				} catch(InterruptedException ex) { }
			}
			boxFilled = false;
			System.out.println("Number " + number + " removed. Notifying!");
			this.notify();
			return number;

		}
	}

	public void putNumberInBox(int number) {
		synchronized(this) {
			while(boxFilled) {
				try {
					System.out.println("Waiting for the box to be empty...");
					this.wait();
				} catch(InterruptedException ex) { }
			}
			this.number = number;
			boxFilled = true;
			System.out.println("Box filled with " + number + ". Notifying!");
			this.notify();
		}
	}
	public String toString() {
		return Integer.toString(number);
	}
}
