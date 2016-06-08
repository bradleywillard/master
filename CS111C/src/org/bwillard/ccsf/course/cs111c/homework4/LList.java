package org.bwillard.ccsf.course.cs111c.homework4;

import org.bwillard.ccsf.course.cs111c.homework6.AList;
import org.bwillard.ccsf.course.cs111c.homework6.ListInterface;

/**
 * A class that implements the ADT list by using a chain of linked nodes that
 * has a head reference.
 * 
 * @author Frank M. Carrano
 * @author Timothy M. Henry
 * @version 4.0
 */
public class LList<T extends Comparable> implements ListInterface<T> {

	public Node firstNode; // Reference to first node of chain
	private int numberOfEntries;

	public LList() {
		initializeDataFields();
	} // end default constructor

	public void clear() {
		initializeDataFields();
	} // end clear

	public void add(T newEntry) // OutOfMemoryError possible
	{
		Node newNode = new Node(newEntry);

		if (isEmpty())
			firstNode = newNode;
		else // Add to end of non-empty list
		{
			Node lastNode = getNodeAt(numberOfEntries);
			lastNode.setNextNode(newNode); // Make last node reference new node
		} // end if

		numberOfEntries++;
	} // end add

	public void add(int newPosition, T newEntry) {
		if ((newPosition >= 1) && (newPosition <= numberOfEntries + 1)) {
			Node newNode = new Node(newEntry);

			if (newPosition == 1) // Case 1: list is empty
			{
				newNode.setNextNode(firstNode);
				firstNode = newNode;
			} else // Case 2: list is not empty
			{ // and newPosition > 1
				Node nodeBefore = getNodeAt(newPosition - 1);
				Node nodeAfter = nodeBefore.getNextNode();
				newNode.setNextNode(nodeAfter);
				nodeBefore.setNextNode(newNode);
			} // end if
		

			numberOfEntries++;
		} else
			throw new IndexOutOfBoundsException(
					"Illegal position given to add operation.");
	} // end add

	public void display() {
		if(!isEmpty()) {
			int counter = 1;
			Node current = firstNode;
			while(current != null) {
				System.out.println(counter + "=" + current.data);
				counter++;
				current = current.next;
			}
		}
	}
	
	
	/**
	 * Adds all items from the given array of items to the existing list
	 * 
	 * @param items
	 */
	public void addAll(T[] items) {
		for(int i = 0; items != null && i < items.length; i++) {
			add(items[i]);
		}
	}
	
	/**
	 * Returns the position in the list for given entry.
	 * If entry is not in the list of entry is null, -1 is returned
	 * 
	 * @param entry
	 * @return the po
	 */
	public int getPosition(T entry) {
		Node current = firstNode;
		int position = 1;
		while(current != null) {
			if(current.data != null && current.data.equals(entry)) {
				return position;
			}
			current = current.next;
			position++;
		}
		return -1;
	}
	
	/**
	 * Removes the given entry from the list
	 * 
	 * @param entry
	 * @return true if the item was successfully remove, false otherwise
	 */
	public boolean remove(T entry) {
		int position = getPosition(entry);
		if(position >= 1) {
			T removed = remove(position);
			return removed != null ? true : false;
		}
		return false;
	}
	
	public T remove(int givenPosition) {
		T result = null; // Return value

		if ((givenPosition >= 1) && (givenPosition <= numberOfEntries)) {
			assert !isEmpty();

			if (givenPosition == 1) // Case 1: Remove first entry
			{
				result = firstNode.getData(); // Save entry to be removed
				firstNode = firstNode.getNextNode(); // Remove entry
			} else // Case 2: Not first entry
			{
				Node nodeBefore = getNodeAt(givenPosition - 1);
				Node nodeToRemove = nodeBefore.getNextNode(); // same as getNodeAt(givenPosition)
				result = nodeToRemove.getData(); // Save entry to be removed
				Node nodeAfter = nodeToRemove.getNextNode();
				nodeBefore.setNextNode(nodeAfter); // Remove entry // same as nodeBefore.setNextNode(noedBefore.getNextNode().getNextNode())
			} // end if

			numberOfEntries--; // Update count
			return result; // Return removed entry
		} else
			throw new IndexOutOfBoundsException(
					"Illegal position given to remove operation.");
	} // end remove

	public T replace(int givenPosition, T newEntry) {
		if ((givenPosition >= 1) && (givenPosition <= numberOfEntries)) {
			assert !isEmpty();

			Node desiredNode = getNodeAt(givenPosition);
			T originalEntry = desiredNode.getData();
			desiredNode.setData(newEntry);
			return originalEntry;
		} else
			throw new IndexOutOfBoundsException(
					"Illegal position given to replace operation.");
	} // end replace

	public T getEntry(int givenPosition) {
		if ((givenPosition >= 1) && (givenPosition <= numberOfEntries)) {
			assert !isEmpty();
			return getNodeAt(givenPosition).getData();
		} else
			throw new IndexOutOfBoundsException(
					"Illegal position given to getEntry operation.");
	} // end getEntry

	public T[] toArray() {
		// The cast is safe because the new array contains null entries
		@SuppressWarnings("unchecked")
		T[] result = (T[]) new Comparable[numberOfEntries];

		int index = 0;
		Node currentNode = firstNode;
		while ((index < numberOfEntries) && (currentNode != null)) {
			result[index] = currentNode.getData();
			currentNode = currentNode.getNextNode();
			index++;
		} // end while

		return result;
	} // end toArray

	public boolean contains(T anEntry) {
		boolean found = false;
		Node currentNode = firstNode;

		while (!found && (currentNode != null)) {
			if (anEntry.equals(currentNode.getData()))
				found = true;
			else
				currentNode = currentNode.getNextNode();
		} // end while

		return found;
	} // end contains

	public void swap(int firstPosition, int secondPosition) {
		if(firstPosition >= 1 && firstPosition <= numberOfEntries &&
				secondPosition >=1 && secondPosition <= numberOfEntries) {
			Node firstToSwap = getNodeAt(firstPosition);
			Node secondToSwap = getNodeAt(secondPosition);
			
			T firstData = firstToSwap.getData();
			T secondData = secondToSwap.getData();
			
			T tmp = firstData;
			
			firstToSwap.setData(secondData);
			secondToSwap.setData(tmp);
			
		}
	}
	
	public LList getAllLessThan(Comparable entry) {
		LList smallerList = new LList();
		
		Node currentNode = firstNode;
		while(currentNode != null) {
			T currentData = currentNode.getData();
			if(entry.compareTo(currentData) > 0) {
				smallerList.add(currentData);
			}
			currentNode = currentNode.getNextNode();
		}
		
		// this will work! but it's VERY inefficient!!
		/*
		for(int i=1; i<numberOfEntries; i++) {
			T currentData = getEntry(i);
			if(entry.compareTo(currentData) > 0) {
				smallerList.add(currentData);
			}
		}
		*/
		return smallerList;
		

	}
	
	public int getLength() {
		return numberOfEntries;
	} // end getLength

	public boolean isEmpty() {
		boolean result;

		if (numberOfEntries == 0) // Or getLength() == 0
		{
			assert firstNode == null;
			result = true;
		} else {
			assert firstNode != null;
			result = false;
		} // end if

		return result;
	} // end isEmpty

	// Initializes the class's data fields to indicate an empty list.
	private void initializeDataFields() {
		firstNode = null;
		numberOfEntries = 0;
	} // end initializeDataFields

	// Returns a reference to the node at a given position.
	// Precondition: The chain is not empty;
	// 1 <= givenPosition <= numberOfEntries.
	private Node getNodeAt(int givenPosition) {
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
	
	public void printLinkedChain(Node currentNode) {
		if(currentNode != null) {
			
			printLinkedChain(currentNode.next);
			System.out.println(currentNode.data);
		}
	}
	
	 // Write code to traverse a linked list of Strings, headed by firstNode, and determine 
	//  if each String contains a specific character.
	//  Write a complete method that takes firstNode and the character as parameters and returns 
	//  the number of Strings that contain that character.
	public int getNodeCountWithChar(Node firstNode, char c) {
		int count = 0;
		Node currentNode = firstNode;
		while(currentNode != null) {
			if(currentNode.data instanceof String) {
				String s = (String) currentNode.data;
				String s1 = String.valueOf(c);
				if(s.contains(s1)) {
					count++;
				}
				
				currentNode = currentNode.next;
			}
		}
		return count;
	}
	
	public boolean containsRepeat() {
		Node current = firstNode;
		while(current != null) {
			if(current.next != null) {
				if(current.data.equals(current.next.data)) {
					return true;
				}
			}
			current = current.next;
		}
		return false;
	}
	
	
	private class Node {
		private T data; // Entry in list
		private Node next; // Link to next node

		private Node(T dataPortion) {
			data = dataPortion;
			next = null;
		} // end constructor

		private Node(T dataPortion, Node nextNode) {
			data = dataPortion;
			next = nextNode;
		} // end constructor

		private T getData() {
			return data;
		} // end getData

		private void setData(T newData) {
			data = newData;
		} // end setData

		private Node getNextNode() {
			return next;
		} // end getNextNode

		private void setNextNode(Node nextNode) {
			next = nextNode;
		} // end setNextNode
		
	} // end Node
	
	public static int countMultiples(ListInterface<Integer> bag, int number) {
		int count = 0;
		for(int i = 1; i <= bag.getLength(); i++) {
			Integer item = bag.getEntry(i);
			if(item % number == 0)
				count++;
		}
		
		return count;
	}
	
	public static void main(String[] args) {
		ListInterface<Integer> bag = new LList<Integer>();
		bag.add(5);
		bag.add(9);
		bag.add(25);
		bag.add(8);
		bag.add(10);
		bag.add(15);
		bag.add(76);
		bag.add(11);
		
		System.out.println("countMultiples should be 4 : " + countMultiples(bag, 5));
	}
} // end LList

