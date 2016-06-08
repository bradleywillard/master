package org.bwillard.ccsf.course.cs111c.labE;
/**
 * NoDupsDePrioritizeArrayQueue
 * CIS 111C - Fall 2015
 * LAB E - Stacks & Queues
 * Professor Masters
 * 
 * @author Bradley D. Willard
 *
 * @param <T>
 */
public class NoDupsDePrioritizeArrayQueue<T> extends ArrayQueue<T> implements NoDupsDePrioritizeQueueInterface<T> {

	public NoDupsDePrioritizeArrayQueue() {
		this(DEFAULT_INITIAL_CAPACITY);
	} 

	public NoDupsDePrioritizeArrayQueue(int initialCapacity) {
		super(initialCapacity);
	} 
	
	@Override
	public void enqueue(T newEntry) {
		moveToBack(newEntry);
	}

	@Override
	public void moveToBack(T entry) {
		int dupIndex = getDuplicateIndex(entry);
		//Duplicate exists!
		if(dupIndex > -1) {
			//Copy the duplicate item and 
			T item = queue[dupIndex];
			//Shift all items down 1 starting from one after the duplicate index,
			//loop back around to the beginning if it gets to the end of the queue...
			int index = dupIndex;
			while(index != (backIndex + 1) % queue.length) {
				queue[index % queue.length] = queue[(index + 1) % queue.length];
				index = (index + 1) % queue.length;
			}
			//Move item to the top
			queue[backIndex] = item;
		//Duplicate does not exists, proceed as normal...
		} else {
			backIndex = (backIndex + 1) % queue.length;
			if (isArrayFull()) {
				doubleArray(); 
			}
			queue[backIndex] = entry;
		}
	}

	private int getDuplicateIndex(T entry) {
		if (entry != null && queue != null && backIndex >= 0) {
			int index = frontIndex;
			while(index != (backIndex + 1) % queue.length) {
				if(entry.equals(queue[index])) {
					return index;
				}
				index = (index + 1) % queue.length;
			}
		}
		return -1;
	}

	@Override
	public void display() {
		if(!isEmpty()) {
			System.out.print("Front ");
			for(int i = frontIndex; i != (backIndex + 1) % queue.length; i = (i + 1) % queue.length) {
				T data = queue[i];
				System.out.print(data + " ");
			}
			System.out.println("Back");
		}
	}
	
}
