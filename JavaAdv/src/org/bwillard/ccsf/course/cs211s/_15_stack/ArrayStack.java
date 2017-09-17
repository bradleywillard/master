package org.bwillard.ccsf.course.cs211s._15_stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * This class mimics the behavior of the old school java.util.Stack.
 * It uses an ArrayDeque as it's underlying data structure, but it 
 * hides some of the things ArrayDeque can do like remove() items from 
 * the bottom of the stack!
 * 
 * NOTE: we could wrap our ArrayDeque object in the Collections.asLifoQueue()
 * wrapper, but there's no real need for that as this class provides an API 
 * consistent with only the same mutability that Stack provides - push(), pop()
 * 
 * 
 * @author bradleywillard
 *
 * @param <E>
 */
public class ArrayStack<E> implements MyStackInterface<E> {
	
	/**
	 * Our underlying and encapsulated data structure
	 */
	private Deque<E> stack;
	
	/**
	 * Constructor
	 * 
	 * @param initialCapacity
	 */
	public ArrayStack() {
		stack = new ArrayDeque<E>();
	}
	
	/**
	 * Clear all items off the stack
	 */
	public void clear() {
		stack.clear();
	}

	@Override
	public void display() {
		if(stack.isEmpty()) {
			System.out.println("The stack is empty!");
		} else {
			stack.forEach(System.out::println);
		}
	}

	@Override
	public void push(E item) {
		if(item != null) {
			stack.push(item);
		}
	}

	@Override
	public E pop() {
		if(!isEmpty()) {
			return stack.pop();
		}
		return null;
	}

	@Override
	public E peek() {
		return stack.peek();
	}

	@Override
	public boolean isEmpty() {
		return stack.isEmpty();
	}


}
