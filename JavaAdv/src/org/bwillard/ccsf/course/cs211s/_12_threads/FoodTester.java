package org.bwillard.ccsf.course.cs211s._12_threads;

import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class FoodTester {

	public static final int DELAY = 1000;
	
	public static void main(String[] args) {
		List<Food> foodList = Collections.synchronizedList(new ArrayList<>());
		foodList.add(new Food("Spinach Dip", 2, 1));
		foodList.add(new Food("Burger", 5, 1));
		foodList.add(new Food("Pasta", 4, 3));
		foodList.add(new Food("Baked Alaska", 6, 20));
		foodList.add(new Food("Salad", 1, 1));
		foodList.add(new Food("Bruschetta", 3, 1));
		foodList.add(new Food("Bread", 1, 1));
		foodList.add(new Food("Fried Green Tomatoes", 2, 1));
		 
		// USE STREAMS HERE ON THE INITIAL LIST! 
		// NOTE: THIS PART HAS NOTHING TO DO WITH THE THREADS- JUST MORE STREAM PRACTICE! :)
		// USE METHOD REFERENCES!
		int totalCookTime = foodList.stream().mapToInt(c -> c.getCookTime()).sum();
		int totalServeTime = foodList.stream().mapToInt(s -> s.getServeTime()).sum();
		
		//This queue represents a counter top/food station where the cook puts 
		//the food dishes for the server to pick up.  Only 3 fit on the station
		//at any given time
		//Fairness is set to true to increase chances that items will be 
		//removed in FIFO order
		BlockingQueue<Food> queue = new ArrayBlockingQueue<Food>(3, true);
		
		// INITIALIZE AND START YOUR THREADS HERE!
		Thread cooker = new Thread(new CookThread(foodList, queue));  
		Thread server = new Thread(new ServeThread(foodList, queue));
		cooker.start();
		server.start();
			
		int programTimeCounter = 0;
		while(Thread.activeCount()>1) {
			System.out.println("TIME " + programTimeCounter);
			programTimeCounter++;
			try {
				Thread.sleep(DELAY);
			} catch(InterruptedException ex) {
				ex.printStackTrace();
			}
		}
		
		System.out.println("Total Cook Time = " + totalCookTime);
		System.out.println("Total Serve Time = " + totalServeTime);	
		System.out.println("Program Time = " + programTimeCounter);
		
	}

}
