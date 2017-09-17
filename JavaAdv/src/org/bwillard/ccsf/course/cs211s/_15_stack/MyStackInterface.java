package org.bwillard.ccsf.course.cs211s._15_stack;

/**
 * This interface was built to mimic and enforce the old Stack functionality
 * of LIFO with ONLY push(), pop() and peek(), isEmpty(), display() and clear() methods
 * 
 * @author bradleywillard
 *
 */
public interface MyStackInterface<T> {
	void push(T item);
	T pop();
	T peek();
	boolean isEmpty();
	void display();
	void clear();
	
}
