package org.bwillard.ccsf.course.cs211s._12_threads.thread_code;

import java.util.concurrent.*;

public class ProducerConsumerTestBQ {

	public static void main(String[] args) {
		BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(3);
		
		Thread producerThread = new Thread(new ProducerThreadBQ(queue));
		Thread consumerThread = new Thread(new ConsumerThreadBQ(queue));
		
		producerThread.start();
		consumerThread.start();

	}

}
