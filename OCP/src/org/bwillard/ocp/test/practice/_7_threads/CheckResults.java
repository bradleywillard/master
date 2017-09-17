package org.bwillard.ocp.test.practice._7_threads;

public class CheckResults {

	private static int counter = 0;

	public static void main(String[] args) throws InterruptedException {
		new Thread(() -> {
			for(int i = 0; i < 500; i++) CheckResults.counter++;
		}).start();

		while(CheckResults.counter < 500) {
			System.out.println(" not reached yet, counter = " + counter);
			Thread.sleep(1000);
		}
		System.out.println("Reached!");
	}

}
