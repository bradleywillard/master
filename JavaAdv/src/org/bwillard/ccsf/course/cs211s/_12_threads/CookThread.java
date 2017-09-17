package org.bwillard.ccsf.course.cs211s._12_threads;

import java.util.List;
import java.util.concurrent.BlockingQueue;

import static org.bwillard.ccsf.course.cs211s._12_threads.FoodTester.DELAY;

/**
 * This thread class is used to manage a cook station.  BlockingQueue will allow only so many
 * plates, say 3 to be sitting in between the cook and server station at any given time.
 * Cook will be blocked from adding more plates if more than n number of plates are sitting there
 * waiting for the server to take them.
 * 
 * @author bradleywillard
 *
 */
public class CookThread implements Runnable {

	/**
	 * Instance data 
	 */
	List<Food> foodList;
	BlockingQueue<Food> cookQueue;
	
	/**
	 * Constructor
	 * 
	 * @param foodList
	 * @param cookQueue
	 */
	public CookThread(List<Food> foodList, BlockingQueue<Food> cookQueue) {
		this.foodList = foodList;
		this.cookQueue = cookQueue;
	}
	
	/**
	 * Cook the food dish, can only happen if the queue has remaining capacity for it
	 */
	private void cook() {
		//The queue can only have however many items in it will fit on top of the 
		//cook/server counter at any given time because the queue represents the 
		//counter the cook puts the food items on top of, where the waiter picks them up
		//WTH is that thing called????? LOL.
		if(cookQueue.remainingCapacity() > 0) {
			System.out.println("COOK READY");
			//Remove the food dish from foodList so we're just synchronizing foodList
			Food item;
			synchronized(foodList) {
				item = foodList.remove(0);
			}
			
			//EACH ITEM TAKES THIS LONG TO COOK AND ONLY ONE ITEM MAY BE COOKED AT A TIME....
			System.out.println("COOK STARTING: " + item.getName() + 
					"(" + item.getCookTime() + " COOK, " + item.getServeTime() + " SERVE)");
			try {
				//Sleeping represents time it takes for cook to cook the item...
				Thread.sleep(item.getCookTime() * DELAY);
				//cookQueue is thread safe already, so adding an item to it is okay without synchronizing
				cookQueue.put(item);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			System.out.println("COOK ENDING: " + item.getName() + 
					"(" + item.getCookTime() + " COOK, " + item.getServeTime() + " SERVE)");
		}
	}
	
	@Override
	public void run() {
		while(!foodList.isEmpty()) {
			cook();
		}
	}

}
