package org.bwillard.ccsf.course.cs211s.assn12.thread_code;

import java.util.Random;
import java.util.concurrent.BlockingQueue;

public class ProducerThreadBQ implements Runnable{
	
	private BlockingQueue<Integer> queue;
	
	public ProducerThreadBQ(BlockingQueue queue) {
		this.queue = queue;
	}
	public void run() {
		for(int i=0; i<10; i++) {
			Random generator = new Random();
			int num = generator.nextInt(1000);
			try {
				queue.put(num);
				System.out.println("Producing a number for processing: " + num);

				int sleepTime = generator.nextInt(2000);
				System.out.println("Producer sleeping...");
				Thread.sleep(sleepTime);
				System.out.println("Producer awake...");
			} catch(InterruptedException ex) { }
		}
	}

}
