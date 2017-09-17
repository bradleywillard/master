package org.bwillard.ccsf.course.cs111c._14_trees;

public interface TreeInterface<T> {

	public T getRootData();
	public int getHeight();
	public int getNumberOfNodes();
	public boolean isEmpty();
	public void clear();
}
