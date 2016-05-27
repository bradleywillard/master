package org.bwillard.ccsf.course.cs211s.assn11;

import java.time.LocalTime;

public class DatePrintNonThread {

	private int delay;
	private int times;
	
	public DatePrintNonThread(int delay, int times) {
		this.delay = delay;
		this.times = times;
	}
	
	public void run() {
		for(int i=0; i<times; i++) {
			System.out.println("In old school time " + i + ": " + LocalTime.now());
			try {
				Thread.sleep(delay);
			} catch(InterruptedException ex) {}
		}
	}
}
