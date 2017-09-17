package org.bwillard.ccsf.course.cs111c._11_queues;

public class Queue<T> implements QueueInterface<T> {

	private DequeInterface<T> deque;
	
	public Queue() {
		deque = new LinkedDeque<T>();
	}
	
	@Override
	public void enqueue(T newEntry) {
		deque.addToBack(newEntry);
	}

	@Override
	public T dequeue() {
		return deque.removeFront();
	}

	@Override
	public T getFront() {
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
