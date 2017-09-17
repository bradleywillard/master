package org.bwillard.ocp.test.practice._7_threads;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class ConcurrentPractice {

	public static void main(String[] args) {
		/*Map<String, Integer> map = new ConcurrentHashMap<>();
		map.put("zebra", 52);
		map.put("elephant", 10);
		System.out.println(map.get("elephant"));
		
		Queue<Integer> queue = new ConcurrentLinkedQueue<>();
		queue.offer(31);
		System.out.println(queue.peek());
		System.out.println(queue.poll());
		
		Deque<Integer> deque = new ConcurrentLinkedDeque<>();
		deque.offer(10);
		deque.push(4);
		System.out.println(deque.peek());
		System.out.println(deque.pop());
		System.out.println(deque.poll());
		
		try {
			BlockingQueue<Integer> bQueue = new LinkedBlockingQueue<>();
			bQueue.offer(39);
			bQueue.offer(3,4,TimeUnit.SECONDS);
			System.out.println(bQueue.poll());
			System.out.println(bQueue.poll(10, TimeUnit.MILLISECONDS));
			
		} catch(InterruptedException e) {
			
		}
		
		try {
			BlockingDeque<Integer> bDeque = new LinkedBlockingDeque<>();
			bDeque.offer(91);
			bDeque.offerFirst(5, 2, TimeUnit.MINUTES);
			bDeque.offerLast(47, 100, TimeUnit.MICROSECONDS);
			bDeque.offer(3, 4, TimeUnit.SECONDS);
			System.out.println(bDeque.poll());
			System.out.println(bDeque.poll(950, TimeUnit.MILLISECONDS));
			System.out.println(bDeque.pollFirst(200, TimeUnit.NANOSECONDS));
			System.out.println(bDeque.pollLast(1, TimeUnit.SECONDS));
			
		} catch(InterruptedException e) {
			
		} 
		
		//Illustrates how only the items in the collection at the time the for loop
		//was created are accessed by the iterator.
		List<Integer> list = new CopyOnWriteArrayList<>(Arrays.asList(4,3,52));
		for(Integer item : list) {
			System.out.println(item+"");
			list.add(3);
		}
		System.out.println("\nSize: " + list.size()+"\n");
		for(Integer item : list) {
			System.out.println(item+"");
		}*/
		
		List<Integer> list = Collections.synchronizedList(Arrays.asList(4,3,52));
		synchronized(list) {
			for(int data : list) {
				System.out.println(data+" ");
			}
		}
		//Even though we wrap the HashMap into a synchronizedMap, this will 
		//throw a ConcurrentModificationException when attempting to modify
		//the map within the iterator, since it is not a ConcurrentHashMap
		Map<String, Object> foodData = new HashMap<>();
		foodData.put("penguin", 1);
		foodData.put("flamingo", 2);
		Map<String,Object> synchronizedFoodData = Collections.synchronizedMap(foodData);
		for(String key : synchronizedFoodData.keySet()) {
			synchronizedFoodData.remove(key);
		}
		
		
 		
	}
}
