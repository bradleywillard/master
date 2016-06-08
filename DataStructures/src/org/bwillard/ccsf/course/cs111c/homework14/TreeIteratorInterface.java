package org.bwillard.ccsf.course.cs111c._1_class_design4;

import java.util.Iterator;

public interface TreeIteratorInterface<T> {
	public Iterator<T> getPreorderIterator();
	public Iterator<T> getPostorderIterator();
	public Iterator<T> getInorderIterator();
	public Iterator<T> getLevelOrderIterator();
}
