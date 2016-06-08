package org.bwillard.ccsf.course.cs211s._12_threads;

import java.util.List;
import java.util.concurrent.BlockingQueue;

import static org.bwillard.ccsf.course.cs211s._12_threads.FoodTester.DELAY;

public class ServeThread implements Runnable {

	/**
	 * Instance data
	 */
	List<Food> foodList;
	BlockingQueue<Food> serveQueue;
	
	/**
	 * Constructor
	 * 
	 * @param foodList
	 * @param queue
	 */
	public ServeThread(List<Food> foodList, BlockingQueue<Food> queue) {
		this.foodList = foodList;
		this.serveQueue = queue;
	}
	
	/**
	 * Serve the food dish (removes it from the queue)
	 */
	private void serve() {
		System.out.println("SERVER READY");
		try {
			//queue is already thread safe, and take method waits for an item to
			//come available so we don't need a check for isEmpty() on the queue!
			Food item = serveQueue.take();
			System.out.println("SERVER STARTING: " + item.getName() + 
					"(" + item.getCookTime() + " COOK, " + item.getServeTime() + " SERVE)");
			//Sleeping represents the time it takes the server to serve the item...
			Thread.sleep(item.getServeTime() * DELAY);
			
			System.out.println("SERVER ENDING: " + item.getName() + 
					"(" + item.getCookTime() + " COOK, " + item.getServeTime() + " SERVE)");
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void run() {
		while(!foodList.isEmpty()) {
			serve();
		}
	}

}
