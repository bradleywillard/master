package org.bwillard.ccsf.course.cs111c.homework4;

import java.util.Random;

import org.bwillard.ccsf.course.cs111c.homework3.BagInterface;

/**
 * A class of bags whose entries are stored in a chain of linked nodes. The bag
 * is never full.
 * 
 * @author Frank M. Carrano
 * @author Timothy M. Henry
 * @author Bradley D. Willard
 * 
 * @version 4.0.BDW
 */
public final class DoubleLinkedBag<T extends Comparable> implements BagInterface<T> {

	private DoubleNode firstNode; // Reference to first node
	private int numberOfEntries;

	public DoubleLinkedBag() {
		firstNode = null;
		numberOfEntries = 0;
	} // end default constructor

	/**
	 * Sees whether this bag is empty.
	 * Same as in LinkedBag
	 * 
	 * @return True if this bag is empty, or false if not.
	 */
	public boolean isEmpty() {
		return numberOfEntries == 0;
	} // end isEmpty

	/**
	 * Gets the capacity of this bag.
	 * Same as in LinkedBag
	 * 
	 * @return The integer number of entries that this bag can hold.
	 */
	public int getCapacity() {
		return Integer.MAX_VALUE;
	} // end getCapacity

	/**
	 * Gets the number of entries currently in this bag.
	 * Same as in LinkedBag
	 * 
	 * @return The integer number of entries currently in this bag.
	 */
	public int getCurrentSize() {
		return numberOfEntries;
	} // end getCurrentSize

	/**
	 * Gets the smallest object in the bag
	 * 
	 * @return the smallest object
	 */
	@SuppressWarnings("unchecked")
	public T getMin() {
		DoubleNode current = firstNode;
		T smallest = current.data;
		while(current != null) {
			if(current.next != null && 
			   current.data.compareTo(current.next.data) > 0 &&
			   smallest.compareTo(current.next.data) > 0) {
				smallest = current.next.data;
			} else if(smallest.compareTo(current.data) >  0){
				smallest = current.data;
			}
			current = current.next;
		}
		return smallest;
	}
	
	/**
	 * Combines the items from two bags together into one bag
	 * 
	 * @param anotherBag
	 * @return
	 */
	public BagInterface<T> union(BagInterface<T> anotherBag) {
		int thisSize = getCurrentSize();
		int thatSize = anotherBag.getCurrentSize();
		DoubleLinkedBag<T> union = null, outer = null, inner = null;
		DoubleNode current = null, innerCurrent = null;
		//Need to ascertain which bag is larger in size
		//and make that the bag that controls the loop...
		if(anotherBag instanceof DoubleLinkedBag) {
			union = new DoubleLinkedBag<T>();
			if(thisSize >= thatSize) {
				inner = (DoubleLinkedBag<T>)anotherBag;
				current = firstNode;
				innerCurrent = inner.firstNode;
			} else {
				outer = (DoubleLinkedBag<T>)anotherBag;
				current = outer.firstNode;
				innerCurrent = firstNode;
			}
			while(current != null) {
				union.add(current.data);
				current = current.next;
				if(innerCurrent != null) {
					union.add(innerCurrent.data);
					innerCurrent = innerCurrent.next;
				}
			}
		}
		return union;
	}
	
	/**
	 * Replaces any item in the bag with the given replacement item
	 * 
	 * @param replacementItem
	 * @return
	 */
	public T replace(T replacementItem) {
		DoubleNode current = firstNode;
		T returnItem = current.data;
		current.data = replacementItem;
		return returnItem;
	}
	
	
	/**
	 * Adds a new entry to this bag.
	 * 
	 * @param newEntry
	 *            The object to be added as a new entry
	 * @return True if the addition is successful, or false if not.
	 */
	public boolean add(T newEntry) // OutOfMemoryError possible
	{
		// Add to beginning of chain:
		DoubleNode newNode = new DoubleNode(newEntry);
		newNode.next = firstNode; // Make new node reference rest of chain
									// (firstNode is null if chain is empty)
		firstNode = newNode; // New node is at beginning of chain
		numberOfEntries++;

		return true;
	} // end add

	/**
	 * Retrieves all entries that are in this bag.
	 * 
	 * @return A newly allocated array of all the entries in this bag.
	 */
	public T[] toArray() {
		// The cast is safe because the new array contains null entries
		@SuppressWarnings("unchecked")
		T[] result = (T[]) new Comparable[numberOfEntries]; // Unchecked cast

		int index = 0;
		DoubleNode currentNode = firstNode;
		while ((index < numberOfEntries) && (currentNode != null)) {
			result[index] = currentNode.data;
			index++;
			currentNode = currentNode.next;
		} // end while

		return result;
	} // end toArray

	/**
	 * Counts the number of times a given entry appears in this bag.
	 * 
	 * @param anEntry
	 *            The entry to be counted.
	 * @return The number of times anEntry appears in this bag.
	 */
	public int getFrequencyOf(T anEntry) {
		int frequency = 0;

		int counter = 0;
		DoubleNode currentNode = firstNode;
		while ((counter < numberOfEntries) && (currentNode != null)) {
			if (anEntry.equals(currentNode.data)) {
				frequency++;
			} // end if

			counter++;
			currentNode = currentNode.next;
		} // end while

		return frequency;
	} // end getFrequencyOf

	/**
	 * Tests whether this bag contains a given entry.
	 * 
	 * @param anEntry
	 *            The entry to locate.
	 * @return True if the bag contains anEntry, or false otherwise.
	 */
	public boolean contains(T anEntry) {
		boolean found = false;
		DoubleNode currentNode = firstNode;

		while (!found && (currentNode != null)) {
			if (anEntry.equals(currentNode.data))
				found = true;
			else
				currentNode = currentNode.next;
		} // end while

		return found;
	} // end contains

	// Locates a given entry within this bag.
	// Returns a reference to the node containing the entry, if located,
	// or null otherwise.
	private DoubleNode getReferenceTo(T anEntry) {
		boolean found = false;
		DoubleNode currentNode = firstNode;

		while (!found && (currentNode != null)) {
			if (anEntry.equals(currentNode.data))
				found = true;
			else
				currentNode = currentNode.next;
		} // end while

		return currentNode;
	} // end getReferenceTo

	/** Removes all entries from this bag. */
	public void clear() {
		while (!isEmpty())
			remove();
	} // end clear

	/**
	 * Removes one unspecified entry from this bag, if possible.
	 * Same as LinkedBag
	 * 
	 * @return Either the removed entry, if the removal was successful, or null.
	 */
	public T remove() {
		T result = null;
		if (firstNode != null) {
			result = firstNode.data;
			firstNode = firstNode.next; // Remove first node from chain
			numberOfEntries--;
		} // end if

		return result;
	} // end remove

	/**
	 * Removes one occurrence of a given entry from this bag, if possible.
	 * 
	 * @param anEntry
	 *            The entry to be removed.
	 * @return True if the removal was successful, or false otherwise.
	 */
	public boolean remove(T anEntry) {
		boolean result = false;
		DoubleNode nodeN = getReferenceTo(anEntry);

		if (nodeN != null) {
			
			nodeN.data = firstNode.data; // Replace located entry with entry in
											// first node

			firstNode = firstNode.next; // Remove first node
			numberOfEntries--;

			result = true;
		} // end if

		return result;
	} // end remove

	public T removeRandom() {
		Random generator = new Random();
		int position = generator.nextInt(numberOfEntries);
		DoubleNode currentNode = firstNode;
		int i=0;
		while(i < position) {
			currentNode = currentNode.next;
			i++;
		}
		T randomDataToRemove = currentNode.data;
		remove(randomDataToRemove);
		return randomDataToRemove;
	}
	
	// for this equals method, two LinkedBags are equal
	// if and only if their contents are the same and in
	// the same order
	// NOTE: this is different from how we implemented it
	// in ArrayBag and is really only for an example
	// of using linked nodes
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof DoubleLinkedBag) {
			DoubleLinkedBag<T> otherBag = (DoubleLinkedBag) obj;
			
			if(numberOfEntries == otherBag.numberOfEntries) {
				
				DoubleNode currentNodeThisBag = firstNode;
				DoubleNode currentNodeOtherBag = otherBag.firstNode;
				
				while(currentNodeThisBag != null && currentNodeOtherBag != null) {
					T currentDataThisBag = currentNodeThisBag.data;
					T currentDataOtherBag = currentNodeOtherBag.data;
					if(!currentDataThisBag.equals(currentDataOtherBag)) {
						return false;
					}
					currentNodeThisBag = currentNodeThisBag.next;
					currentNodeOtherBag = currentNodeOtherBag.next;
				}
				return true;
				
			} else {
				return false;
			}
			
		} else {
			return false;
		}
		
	}
	
	private class DoubleNode {
		private T data; // entry in bag
		private DoubleNode next; // link to next node
		private DoubleNode previous; // link to the previous node

		private DoubleNode(T dataPortion) {
			this(dataPortion, null, null);
		}

		private DoubleNode(T dataPortion, DoubleNode nextNode, DoubleNode previousNode) {
			data = dataPortion;
			next = nextNode;
			previous = previousNode;
		}
	}
} // end DoubleLinkedBag

