package org.bwillard.ccsf.course.cs111c._1_class_design1;

public class Stack<T> implements StackInterface<T> {

	private DequeInterface<T> deque;
	
	public Stack() {
		deque = new LinkedDeque<T>();
	}
	
	@Override
	public void push(T newEntry) {
		deque.addToFront(newEntry);
	}

	@Override
	public T pop() {
		return deque.removeFront();
	}

	@Override
	public T peek() {
		return deque.getFront();
	}

	@Override
	public boolean isEmpty() {
		return deque.isEmpty();
	}

	@Override
	public void clear() {
		deque.clear();

	}

}
