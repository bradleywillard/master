package org.bwillard.ocp.test.practice._7_threads;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

//Class that uses the synchronized keyword to make it thread safe
//since it uses HashMap instead of ConcurrentHashMap
public class ZooManagerSynchronized {

private static Map<String, Object> foodData = new HashMap<String, Object>();
	
	public static void main(String[] args) {
		ZooManagerConcurrent manager = new ZooManagerConcurrent();
		manager.put("penguin", "1");
		manager.put("flamingo", "2");
		for(String key : foodData.keySet()) {
			foodData.remove(key);
		}
	}
	
	public synchronized void put(String key, String value) {
		foodData.put(key, value);
	}
	
	public synchronized Object get(String key) {
		return foodData.get(key);
	}

}
