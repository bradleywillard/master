package org.bwillard.ccsf.course.cs211s._12_threads.thread_code;

import java.util.Random;
import java.util.concurrent.BlockingQueue;

public class ConsumerThreadBQ implements Runnable{
	
	private BlockingQueue<Integer> queue;
	
	public ConsumerThreadBQ(BlockingQueue queue) {
		this.queue = queue;
	}
	public void run() {
		for(int i=0; i<10; i++) {
			Random generator = new Random();
			try {
				int num = queue.take();
				System.out.println("Consuming a number to be processed: " + num);				

				int sleepTime = generator.nextInt(5000);
				System.out.println("Consumer sleeping...");
				Thread.sleep(sleepTime);
				System.out.println("Consumer awake...");
			} catch(InterruptedException ex) { }
		}
	}

}
