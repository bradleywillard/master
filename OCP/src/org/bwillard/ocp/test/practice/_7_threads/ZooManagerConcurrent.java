package org.bwillard.ocp.test.practice._7_threads;

import java.util.ConcurrentModificationException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

//Class that illustrates how using a ConcurrentHashMap vs a HashMap
//will avoid a ConcurrentModificationException, and is a good way
//to code for thread safety
public class ZooManagerConcurrent {

	//Swap between these two....
	private static Map<String, Object> foodData = new ConcurrentHashMap<String, Object>();
	//private static Map<String, Object> foodData = new HashMap<String, Object>();
	
	public static void main(String[] args) {
		//ZooManagerConcurrent manager = new ZooManagerConcurrent();
		int numItems = 5000000;
		long start1 = System.currentTimeMillis();
		for(int i = 0; i < numItems; i++) {
			foodData.put(""+i, ""+i);
		}
		System.out.println((System.currentTimeMillis() - start1) + "ms to add key/values with " + numItems + " items");
		long start2 = System.currentTimeMillis();
		try {
			for(String key : foodData.keySet()) {
				foodData.remove(key);
			}
		} catch(ConcurrentModificationException e) {
			System.out.println((System.currentTimeMillis() - start2) + "ms to catch " + e + " with " + numItems + " items");
		}
		System.out.println((System.currentTimeMillis() - start2) + "ms to remove keys with " + numItems + " items");
	}
	
	public void put(String key, String value) {
		foodData.put(key, value);
	}
	
	public Object get(String key) {
		return foodData.get(key);
	}

}
