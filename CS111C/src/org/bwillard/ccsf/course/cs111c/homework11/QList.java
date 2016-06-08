package org.bwillard.ccsf.course.cs111c._1_class_design1;

import org.bwillard.ccsf.course.cs111c.homework6.ListInterface;
import org.bwillard.ccsf.course.cs111c.homework6.LList;

public class QList<T> implements QueueInterface<T> {

	private ListInterface<T> list;
	
	public QList() {
		list = new LList<T>();
	}
	
	@Override
	public void enqueue(T newEntry) {
		list.add(newEntry);
	}

	@Override
	public T dequeue() {
		return list.remove(1);
	}

	@Override
	public T getFront() {
		return list.getEntry(1);
	}

	@Override
	public boolean isEmpty() {
		return list.isEmpty();
	}

	@Override
	public void clear() {
		list.clear();
	}

}
