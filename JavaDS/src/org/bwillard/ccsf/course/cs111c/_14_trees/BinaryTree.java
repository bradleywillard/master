package org.bwillard.ccsf.course.cs111c._14_trees;

import java.util.Iterator;

public class BinaryTree<T> implements BinaryTreeInterface<T> {

	private BinaryNodeInterface<T> root;
	private BinaryNodeInterface<T> left;
	private BinaryNodeInterface<T> right;
	
	public BinaryTree(){
		root = null;
	}
	
	public BinaryTree(T rootData) {
		root = new BinaryNode<T>(rootData);
	}
	
	public BinaryTree(T rootData, BinaryTree<T> leftTree, BinaryTree<T> rightTree){
		privateSetTree(rootData, leftTree, rightTree);
	}
	
	@Override
	public T getRootData() {
		if(root != null) {
			return root.getData();
		}
		return null;
	}


	@Override
	public boolean isEmpty() {
		return root == null;
	}

	@Override
	public void clear() {
		root = null;
	}

	@Override
	public Iterator<T> getPreorderIterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<T> getPostorderIterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<T> getInorderIterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<T> getLevelOrderIterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setTree(T rootData) {
		root = new BinaryNode<T>(rootData);
	}

	@Override
	public void setTree(T rootData, BinaryTreeInterface<T> leftTree, BinaryTreeInterface<T> rightTree) {
		privateSetTree(rootData, (BinaryTree<T>)leftTree, (BinaryTree<T>)rightTree);
	}

	private void privateSetTree(T rootData, BinaryTree<T> leftTree, BinaryTree<T> rightTree) {
		root = new BinaryNode<T>(rootData);
		if(leftTree != null) {
			root.setLeftChild(leftTree.root);
		}
		if(rightTree != null) {
			root.setRightChild(rightTree.root);
		}
	}

	@Override
	public int getHeight() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getNumberOfNodes() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public int count(T entry) {
		return countHelper(root, entry);
	}
	
	private int countHelper(BinaryNodeInterface<T> node, T entry) {
		int count = 0;
		if(node == null) {
			return count;
		} else if(entry.equals(node.getData())) {
			count += 1;
		}
	    if (node.getLeftChild() != null) {
	    	BinaryNodeInterface<T> leftNode = node.getLeftChild();
	    	if(entry.equals(leftNode.getData())) {
	            count += (1 + countHelper(leftNode, entry));
	        } else {
	        	count += countHelper(leftNode, entry);
	        }
	    }

	    if (node.getRightChild() != null) {
	    	BinaryNodeInterface<T> rightNode = node.getRightChild();
	    	if (entry.equals(rightNode.getData())) {
	            count += (1 + countHelper(rightNode, entry));
	        } else {
	        	count += countHelper(rightNode, entry);
	        }
	    }
	    return count;
	}
}
