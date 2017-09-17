package org.bwillard.ccsf.course.cs111c._8_sort_lists;

import java.util.HashMap;
import java.util.Map;


public class SortedLinkedList<T extends Comparable<? super T>> implements SortedListInterface<T>{

	Node firstNode;
	int numberOfEntries;
	
	public SortedLinkedList() {
		firstNode = null;
		numberOfEntries = 0;
	}
	
	public void display() {
		for(int i = 1; i < getLength(); i++) {
			System.out.println(getEntry(i) + ", ");
		}
	}
	
	@Override
	public void add(T entry) {
		Node newNode = new Node(entry);
		Node nodeBefore = getNodeBefore(entry);
		
		if(nodeBefore == null) {
			newNode.setNextNode(firstNode);
			firstNode = newNode;
		} else {
			Node nodeAfter = nodeBefore.getNextNode();
			newNode.setNextNode(nodeAfter);
			nodeBefore.setNextNode(newNode);
		}
		numberOfEntries++;
	}

	@Override
	public boolean remove(T anEntry) {
		int position = getPosition(anEntry);
		if(position >= 1) {
			T removed = remove(position);
			return removed != null ? true : false;
		}
		return false;
	}

	@Override
	public int getPosition(T anEntry) {
		int position = 1;
		int length = numberOfEntries;
		while(position <= length && 
				anEntry.compareTo(getEntry(position)) > 0) {
			position++;
		}
		if(position > length || 
			anEntry.compareTo(getEntry(position)) != 0) {
			position = -position;
		}
		
		return position;
	}

	@Override
	public T getEntry(int givenPosition) {
		if ((givenPosition >= 1) && (givenPosition <= numberOfEntries)) {
			return getNodeAt(givenPosition).getData();
		} else
			throw new IndexOutOfBoundsException(
					"Illegal position given to getEntry operation.");
	}

	private Node<T> getNodeAt(int givenPosition) {
		assert !isEmpty() && (1 <= givenPosition)
				&& (givenPosition <= numberOfEntries);
		Node currentNode = firstNode;

		// Traverse the chain to locate the desired node
		// (skipped if givenPosition is 1)
		for (int counter = 1; counter < givenPosition; counter++)
			currentNode = currentNode.getNextNode();

		assert currentNode != null;

		return currentNode;
	} // end getNodeAt
	
	private Node<T> getNodeBefore(T anEntry) {
		Node<T> currentNode = firstNode;
		Node<T> nodeBefore = null;
		
		while(currentNode != null && anEntry.compareTo(currentNode.getData()) > 0) {
			nodeBefore = currentNode;
			currentNode = currentNode.getNextNode();
		}
		return nodeBefore;
	}
	
	@Override
	public boolean contains(T anEntry) {
		Node<Comparable> current = firstNode;
		if(anEntry == null)
			return false;
		if(current != null) {
			if(current.data.compareTo(anEntry) == 0) {
				return true;
			} else if(current.data.compareTo(anEntry) > 0) {
				return false;
			}
			current = current.next;
		}
		return false;
	}
	

	@Override
	public T remove(int givenPosition) {
		if(givenPosition >= 1 && givenPosition <= getLength()) {
			Object data = null;
			if(givenPosition == 1) {
				data = firstNode.getData();
				firstNode = firstNode.next;
			} else {
				Node nodeToRemove = getNodeAt(givenPosition);
				data = nodeToRemove.data;
				Node nodeBefore = getNodeAt(givenPosition - 1);
				Node nodeAfter = nodeToRemove.next;
				nodeBefore.next = nodeAfter;
			}
			numberOfEntries--;
			return (T) data;
		} else {
			throw new IndexOutOfBoundsException(
					"Illegal position given to remove operation.");
		}
	}

	@Override
	public void clear() {
		firstNode = null;
		numberOfEntries = 0;
	}

	@Override
	public int getLength() {
		return numberOfEntries;
	}

	@Override
	public boolean isEmpty() {
		return numberOfEntries == 0;
	}

	@Override
	public T[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
