package org.bwillard.ccsf.course.cs111c._1_class_design4;

public interface TreeInterface<T> {

	public T getRootData();
	public int getHeight();
	public int getNumberOfNodes();
	public boolean isEmpty();
	public void clear();
}
