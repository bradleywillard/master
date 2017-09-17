package org.bwillard.ccsf.course.cs111c.labF_trees;

import java.util.*;

public class BinarySearchTreeWithDups<T extends Comparable<? super T>> extends BinarySearchTree<T>
		implements SearchTreeInterface<T>, java.io.Serializable {

	public BinarySearchTreeWithDups() {
		super();
	}

	public BinarySearchTreeWithDups(T rootEntry) {
		super(rootEntry);
		setRootNode(new BinaryNode<T>(rootEntry));
	}

	public int calculateLeftHeight() {
		if(getRootNode() != null) {
			return calculateHeight(getRootNode().getLeftChild());
		}
		return 0;
	}
	
	public int calculateRightHeight() {
		if(getRootNode() != null) {
			return calculateHeight(getRootNode().getRightChild());
		}
		return 0;
	}
	
	private int calculateHeight(BinaryNodeInterface<T> node) {
		int height = 0;
		if (node != null) {
		    height = 1 + Math.max(
		    		calculateHeight(node.getLeftChild()), 
		    		calculateHeight(node.getRightChild()));
		}
		return height;
	}
	
	
	@Override
	public T add(T newEntry) {
		T result = null;
		if (isEmpty())
			setRootNode(new BinaryNode<T>(newEntry));
		else
			result = addEntryHelper(newEntry);
		return result;
	}

	// ??? IMPLEMENT THIS METHOD
	//Adds entries to the tree.  If duplicate, the entry is added to the
	//appropriate place in the right subtree of the tree's existing duplicate entry.
	private T addEntryHelper(T newEntry) {
		BinaryNodeInterface<T> current = getRootNode();
		assert current != null;
		T result = null;
		boolean found = false;

		while (!found) {
			T currData = current.getData();
			int comparison = newEntry.compareTo(currData);

			if (comparison == 0) { // newEntry matches currentEntry;
				//Add duplicate entry to the rightChild if rightChild is null
				if(current.getRightChild() == null) {
					found = true;
					result = currData;
					current.setRightChild(new BinaryNode<T>(newEntry));
				//Otherwise, move the currentEntry to the right subtree
				//and let the current implementation add the duplicate where it belongs
				} else {
					current = current.getRightChild();
				}
				
			} else if (comparison < 0) {
				if (current.hasLeftChild())
					current = current.getLeftChild();
				else {
					found = true;
					current.setLeftChild(new BinaryNode<T>(newEntry));
				} // end if
			} else {
				assert comparison > 0;

				if (current.hasRightChild())
					current = current.getRightChild();
				else {
					found = true;
					current.setRightChild(new BinaryNode<T>(newEntry));
				}
			}
		}

		return result;
	}
	
	// ??? IMPLEMENT THIS METHOD
	public ArrayList<T> getAllEntriesIterative(T searchVal) {
		// this initial code is meant as a suggestion to get your started- feel
		// free to use it or delete it!
		BinaryNodeInterface<T> current = getRootNode();
		ArrayList<T> entryList = new ArrayList<T>();

		while(current != null) {
			T currData = current.getData();

			if (searchVal.compareTo(currData) == 0) {
				entryList.add(currData);
			}
			if (searchVal.compareTo(currData) < 0) {
				current = current.getLeftChild();
			} else {
				current = current.getRightChild();
			}
		}
		
		return entryList;
	}

	// ??? IMPLEMENT THIS METHOD
	public ArrayList<T> getAllEntriesRecursive(T searchVal) {
		// this initial code is meant as a suggestion to get your started- feel
		// free to use it or delete it!
		BinaryNodeInterface<T> rootNode = getRootNode();
		ArrayList<T> entryList = new ArrayList<T>();
		getAllEntriesHelper(searchVal, rootNode, entryList);

		return entryList;
	}

	private void getAllEntriesHelper(T searchVal, 
			BinaryNodeInterface<T> current, ArrayList<T> entryList) {
		if(current != null) {
			T currData = current.getData();
			int comparison = searchVal.compareTo(currData);
			if(comparison == 0) {
				entryList.add(searchVal);
			}
			if(searchVal.compareTo(currData) < 0)
				getAllEntriesHelper(searchVal, current.getLeftChild(), entryList);
			else 
				getAllEntriesHelper(searchVal, current.getRightChild(), entryList);
		}
	}
	
	// ??? IMPLEMENT THIS METHOD
	public ArrayList<T> getAllEntriesLessThanIterative(T searchVal) {
		// this initial code is meant as a suggestion to get your started- feel
		// free to use it or delete it!
		ArrayList<T> entryList = new ArrayList<T>();

		// Hint: consider using a stack to mimic recursion!
		Stack<BinaryNodeInterface<T>> nodeStack = new Stack<BinaryNodeInterface<T>>();
		BinaryNodeInterface<T> current = getRootNode();
		
		while(!nodeStack.isEmpty() || current != null) {
			//Push all left nodes (those less than the search value) onto the stack
			while(current != null) {
				if(searchVal.compareTo(current.getData()) > 0) {
					nodeStack.push(current);
				}
				//Advance current to the next left child
				current = current.getLeftChild();
			}

			if(!nodeStack.isEmpty()) {
				//Pop the stack...
				BinaryNodeInterface<T> nextNode = nodeStack.pop();
				if(nextNode != null) {
					//add the current node's data to the list...
					entryList.add(nextNode.getData());
					//make current the right child (if any), this will get handled above if not null
					current = nextNode.getRightChild();
				}
			}
		}
		
		return entryList;
	}

	// ??? IMPLEMENT THIS METHOD
	public ArrayList<T> getAllEntriesLessThanRecursive(T searchVal) {
		BinaryNodeInterface<T> rootNode = getRootNode();
		ArrayList<T> entryList = new ArrayList<T>();
		getAllEntriesLessThanHelper(searchVal, rootNode, entryList);
		
		return entryList;
	}

	private void getAllEntriesLessThanHelper(T searchVal, 
			BinaryNodeInterface<T> current, ArrayList<T> entryList) {
		if(current != null) {
			//Uses inorder traversal...
			//Traverse the left tree no matter what as values decrease...
			getAllEntriesLessThanHelper(searchVal, current.getLeftChild(), entryList);
			//If the search value is greater than the data from the current node...
			if(searchVal.compareTo(current.getData()) > 0) {
				//Add current data in between recursive calls (in-order)
				entryList.add(current.getData());
				//Traverse the right tree
				getAllEntriesLessThanHelper(searchVal, current.getRightChild(), entryList);
			}				
		}
		
	}

}