package org.bwillard.ccsf.course.cs111c._1_class_design4;

import java.util.Iterator;

public interface SearchTreeInterface<T extends Comparable<? super T>> extends TreeInterface<T> {
	public boolean contains(T entry);
	public T getEntry(T entry);
	public T add(T newEntry);
	public T remove(T entry);
	public Iterator<T> getInorderIterator();
}
