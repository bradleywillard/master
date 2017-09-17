package org.bwillard.ccsf.course.cs111c.labE_stacks_and_queues;
/**
 * NoDupsPrioritizeArrayStack
 * CIS 111C - Fall 2015
 * LAB E - Stacks & Queues
 * Professor Masters
 * 
 * @author Bradley D. Willard
 *
 * @param <T>
 */
public class NoDupsPrioritizeArrayStack<T> extends ArrayStack<T> implements
		NoDupsPrioritizeStackInterface<T> {
	
	public NoDupsPrioritizeArrayStack() {
		this(DEFAULT_INITIAL_CAPACITY);
	} 

	public NoDupsPrioritizeArrayStack(int initialCapacity) {
		super(initialCapacity);
	} 
	
	@Override
	public void push(T newEntry) {
		moveToTop(newEntry);
	}

	@Override
	public void moveToTop(T entry) {
		int dupIndex = getDuplicateIndex(entry);
		//Duplicate exists!
		if(dupIndex > -1) {
			//Copy the duplicate item
			T item = stack[dupIndex];
			//Shift all items down 1 starting from one after the duplicate index
			for(int i = dupIndex; i < topIndex; i++) {
				stack[i] = stack[i + 1];
			}
			//Move item to the top
			stack[topIndex] = item;
		//Duplicate does not exist, proceed as normal...
		} else {
			topIndex++;
			if (topIndex >= stack.length) {// if array is full,
				doubleArray(); // expand array
			}
			stack[topIndex] = entry;
		}
	}

	private int getDuplicateIndex(T entry) {
		if (entry != null && stack != null && topIndex > 0) {
			for(int i = 0; i <= topIndex; i++){
				if(entry.equals(stack[i])) {
					return i;
				}
			}
		}
		
		return -1;
	}

	@Override
	public void display() {
		if(topIndex < 0) {
			System.out.println("The stack is empty!");
		} else {
			int i = topIndex;
			System.out.print("Top ");
			while(i >= 0) {
				System.out.print(stack[i] + " ");
				--i;
			}
			System.out.print("Bottom\n");
		}
	}
	
}
