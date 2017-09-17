package org.bwillard.ccsf.course.cs211s._15_stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * This class acts just like an old school Stack with push, pop and peek methods only.
 * It uses composition with a Deque as the underlying data structure.
 * We could use ArrayDeque (and we will as our underlying data structure)
 * However, ArrayDeque allows removal of items from the rear of the Deque, and some
 * other operations Stack does not allow, which we do not want!
 * 
 * @author bradleywillard
 *
 * @param <T>
 */
abstract class MyStack<E> implements MyStackInterface<E> {

	protected Deque<E> stack;
	
	public MyStack() {
		this.stack = new ArrayDeque<E>();
	}
	
	@Override
	public void push(E element) {
		stack.push(element);
	}

	@Override
	public E pop() {
		return stack.pop();
	}

	@Override
	public E peek() {
		return stack.peek();
	}
	
	public boolean isEmpty() {
		return stack.isEmpty();
	}

}
