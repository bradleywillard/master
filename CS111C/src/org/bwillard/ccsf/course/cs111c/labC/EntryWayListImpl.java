package org.bwillard.ccsf.course.cs111c.labC;

/**
 * 
 * @author Bradley D. Willard
 *
 * @param <T>
 */
public class EntryWayListImpl<T extends Comparable> implements EntryWayListInterface<T> {
	
	private Node firstNode; // Reference to first node of chain
	private int numberOfEntries;
	private static final int MAX_CAPACITY = 20;
	private boolean concernedAboutCapacity = false;
	
	public EntryWayListImpl() {
		this(false);
	}// end default constructor
	
	public EntryWayListImpl(boolean cares) {
		firstNode = null;
		numberOfEntries = 0;
		concernedAboutCapacity = cares;
	} 
	

	@Override
	public boolean insertHead(T newEntry) {
		if(!isFull()) {
			Node newNode = new Node(newEntry);
			newNode.next = firstNode;							
			firstNode = newNode;
			numberOfEntries++;
			return true;
		} 
		return false;
	}

	@Override
	public boolean insertTail(T newEntry) {
		if(!isFull()) {
			Node newNode = new Node(newEntry);
			if(firstNode == null && newEntry != null) {
				firstNode = newNode;
				return true;
			} else {
				Node current = firstNode;
				while(current != null) {//traverse the list to the end node
					if(current.next == null) {//if true, we're at the last node
						current.next = newNode;
						newNode.next = null;
						numberOfEntries++;
						return true;
					}
					current = current.next;
				}
			}
		}
		
		return false;
	}

	@Override
	public T deleteHead() {
		if(!isEmpty()) {
			Node deleted = firstNode;
			firstNode = firstNode.next;
			numberOfEntries--;
			return deleted.data;
		}
		return null;
	}

	@Override
	public T deleteTail() {
		if(!isEmpty()) {
			Node current = firstNode;
			Node previous = firstNode;
			T deleted = null;
			while(current != null) {
				if(current.next == null) {
					deleted = current.data;
					previous.next = null;
					numberOfEntries--;
					return deleted;
				}
				previous = current;
				current = current.next;
			}
		}
		return null;
	}

	@Override
	public void display() {
		Node current = firstNode;
		System.out.print("(");
		while(current != null) {
			System.out.print(current.data);
			if(current.next != null) {
				System.out.print(", ");
			}
			current = current.next;
		}
		System.out.print(")\n");
	}

	@Override
	public int contains(T anEntry) {
		Node current = firstNode;
		int counter = 0;
		while(current != null) {
			counter++;
			if(anEntry.equals(current.data)){
				return counter;
			}
			current = current.next;
		}
		return -1;
	}

	@Override
	public boolean isEmpty() {
		return numberOfEntries == 0;
	}

	@Override
	public boolean isFull() {
		if(isConcernedAboutCapacity())
			return numberOfEntries == MAX_CAPACITY;
		else
			return false;
	}

	//Extra getters and setters inspired by the optional isFull() 
	//not always being false thing
	public boolean isConcernedAboutCapacity() {
		return concernedAboutCapacity;
	}

	public int getMaxCapacity() {
		return MAX_CAPACITY;
	}
	
	public int getNumberOfEntries() {
		return numberOfEntries;
	}//End extra getters and setters inspired by the
	//optional isFull() not always being false thing
	
	private class Node {
		private T data; // Entry in bag
		private Node next; // Link to next node

		private Node(T dataPortion) {
			this(dataPortion, null);
		} // end constructor

		private Node(T dataPortion, Node nextNode) {
			data = dataPortion;
			next = nextNode;
		} // end constructor
	} // end Node

}
