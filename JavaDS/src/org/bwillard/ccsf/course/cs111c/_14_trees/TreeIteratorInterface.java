package org.bwillard.ccsf.course.cs111c._14_trees;

import java.util.Iterator;

public interface TreeIteratorInterface<T> {
	public Iterator<T> getPreorderIterator();
	public Iterator<T> getPostorderIterator();
	public Iterator<T> getInorderIterator();
	public Iterator<T> getLevelOrderIterator();
}