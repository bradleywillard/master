package org.bwillard.ccsf.course.cs111c.homework15;

import org.bwillard.ccsf.course.cs111c.homework14.BinaryNode;
import org.bwillard.ccsf.course.cs111c.homework14.BinaryNodeInterface;
import org.bwillard.ccsf.course.cs111c.homework14.BinarySearchTree;
import org.bwillard.ccsf.course.cs111c.homework14.SearchTreeInterface;

public class AVLTree<T extends Comparable<? super T>> extends
		BinarySearchTree<T> implements SearchTreeInterface<T> {

	public AVLTree() {
		super();
	}
	
	public AVLTree(T rootEntry) {
		super(rootEntry);
	}
	
	private BinaryNodeInterface<T> rotateRight(BinaryNodeInterface<T> nodeN) {
		BinaryNodeInterface<T> nodeC = nodeN.getLeftChild();
		nodeN.setLeftChild(nodeC.getRightChild());
		nodeC.setRightChild(nodeN);
		return nodeC;
	}
	
	private BinaryNodeInterface<T> rotateLeft(BinaryNodeInterface<T> nodeN) {
		BinaryNodeInterface<T> nodeC = nodeN.getRightChild();
		nodeN.setRightChild(nodeC.getLeftChild());
		nodeC.setLeftChild(nodeN);
		return nodeC;
	}
	
	private BinaryNodeInterface<T> rotateRightLeft(BinaryNodeInterface<T> nodeN) {
		BinaryNodeInterface<T> nodeC = nodeN.getRightChild();
		nodeN.setRightChild(rotateRight(nodeC));
		return rotateLeft(nodeN);
	}
	
	private BinaryNodeInterface<T> rotateLeftRight(BinaryNodeInterface<T> nodeN) {
		BinaryNodeInterface<T> nodeC = nodeN.getLeftChild();
		nodeN.setLeftChild(rotateLeft(nodeC));
		return rotateRight(nodeN);
	}
	
	public BinaryNodeInterface<T> rebalance(BinaryNodeInterface<T> nodeN) {
		int heightDifference = getHeightDifference(nodeN);
		if(heightDifference > 1) {
			if(getHeightDifference(nodeN.getLeftChild()) < 0) {
				nodeN = rotateLeft(nodeN);
			} else {
				nodeN = rotateLeftRight(nodeN);
			}
		} else if (heightDifference < -1) {
			if(getHeightDifference(nodeN.getRightChild()) < 0) {
				nodeN = rotateLeft(nodeN);
			} else {
				nodeN = rotateRightLeft(nodeN);
			}
		}
		
		return nodeN;
	}
	
	private int getHeightDifference(BinaryNodeInterface<T> nodeN) {
		
		return 0;
	}
	
	public T add(T newEntry) {
		T result = null;
		if(isEmpty()) 
			setRootNode(new BinaryNode<T>(newEntry));
		else {
			BinaryNodeInterface<T> rootNode = getRootNode();
			result = addEntry(rootNode, newEntry);
			setRootNode(rebalance(rootNode));
		}
		return result;
	}
	
	private T addEntry(BinaryNodeInterface<T> rootNode, T newEntry) {
		
	}
}
