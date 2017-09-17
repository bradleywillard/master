package org.bwillard.ccsf.course.cs111c.labF_trees;


public interface TreeInterface<T> {

	public T getRootData();
	public int getHeight();
	public int getNumberOfNodes();
	public boolean isEmpty();
	public void clear();
	
}
