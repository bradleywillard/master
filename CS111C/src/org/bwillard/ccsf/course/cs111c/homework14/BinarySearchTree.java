package org.bwillard.ccsf.course.cs111c.homework14;

public class BinarySearchTree<T extends Comparable<? super T>> extends
		BinaryTree<T> implements SearchTreeInterface<T> {

	private BinaryNode<T> rootNode;
	
	public BinarySearchTree(){
		super();
	}
	
	public BinarySearchTree(T rootEntry) {
		super();
		setRootNode(new BinaryNode<T>(rootEntry));
	}
	
	private void setRootNode(BinaryNode<T> binaryNode) {
		this.rootNode = binaryNode;
		
	}

	private BinaryNode<T> getRootNode() {
		return rootNode;
	}
	
	public void setTree(T rootData) {
		throw new UnsupportedOperationException();
	}
	
	public void setTree(T rootData, BinaryTreeInterface<T> leftTree,
									BinaryTreeInterface<T> rightTree) {
		throw new UnsupportedOperationException();
	}
	@Override
	public boolean contains(T entry) {
		return getEntry(entry) != null;
	}

	@Override
	public T getEntry(T entry) {
		return findEntry(getRootNode(), entry);
	}

	private T findEntry(BinaryNodeInterface<T> rootNode, T entry) {
		T result = null;
		if(rootNode != null) {
			T rootEntry = rootNode.getData();
			if(entry.equals(rootEntry)) {
				result = rootEntry;
			} else if (entry.compareTo(rootEntry) < 0) {
				result = findEntry(rootNode.getLeftChild(), entry);
			} else {
				result = findEntry(rootNode.getRightChild(), entry);
			}
		}
		return result;
	}
	
	public T findMinValue(BinaryNodeInterface<T> rootNode) {
		if (rootNode.getLeftChild() == null)
            return rootNode.getData();
        return findMinValue(rootNode.getLeftChild());  
	}
	
	
	@Override
	public T add(T newEntry) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T remove(T entry) {
		// TODO Auto-generated method stub
		return null;
	}

}
