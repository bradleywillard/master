package org.bwillard.ccsf.course.cs111c._1_class_design4;

public interface BinaryTreeInterface<T> extends TreeInterface<T>, TreeIteratorInterface<T> {
	
	public void setTree(T rootData);
	
	public void setTree(T rootData, BinaryTreeInterface<T> leftTree, BinaryTreeInterface<T> rightTree);

}
