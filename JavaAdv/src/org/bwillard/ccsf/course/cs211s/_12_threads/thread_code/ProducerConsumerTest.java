package org.bwillard.ccsf.course.cs211s._12_threads.thread_code;

public class ProducerConsumerTest {

	public static void main(String[] args) {
		NumberBox numberBox = new NumberBox();
		Thread producerThread = new Thread(new ProducerThread(numberBox));
		Thread consumerThread = new Thread(new ConsumerThread(numberBox));
		
		producerThread.start();
		consumerThread.start();

	}

}
