package org.bwillard.ccsf.course.cs211s.last;

public class RandomNumberThread extends Thread {

	public void run() {
		System.out.println(Math.random());
	}

	public static void main(String[] args) {
		for(int i = 0; i < 1000; i++) {
			Thread thread = new RandomNumberThread();
			thread.start();
		}
	}
}
