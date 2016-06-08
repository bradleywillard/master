package org.bwillard.ccsf.course.cs211s._11_threads;

import java.time.*;

public class DatePrintRunnable implements Runnable {

	private int delay;
	private int times;
	
	public DatePrintRunnable(int delay, int times) {
		this.delay = delay;
		this.times = times;
	}
	
	public void run() {
		for(int i=0; i<times; i++) {
			System.out.println("In Runnable time " + i + ": " + LocalTime.now());
			try {
				Thread.sleep(delay);
				Thread.interrupted();
			} catch(InterruptedException ex) {
				System.out.println("DatePrintRunnable has been interrupted");
				return;
			}
		}
	}
}
