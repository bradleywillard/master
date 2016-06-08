package org.bwillard.ccsf.course.cs211s._11_threads;

import java.time.*;

public class DatePrintThread extends Thread {

	private int delay;
	private int times;

	public DatePrintThread(int delay, int times) {
		super("Date Print Threaded");
		this.delay = delay;
		this.times = times;
	}

	@Override
	public void run() {
		for (int i = 0; i < times; i++) {
			try {
				System.out.println(getName() + " " + i + ": " + LocalTime.now());
				Thread.sleep(delay);
				this.interrupt();
			} catch (InterruptedException ex) {
				System.out.println("DatePrintThread has been interrupted");
				return;
			}

		}
	}
}
