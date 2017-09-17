package org.bwillard.ocp.test.practice._7_threads;

public class PrintData implements Runnable {

	public PrintData() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		new Thread(new PrintData()).start();
	}

	@Override
	public void run() {
		for(int i = 0; i < 3; i++) {
			System.out.println("Printing record: " +i);
		}
		
	}

}
