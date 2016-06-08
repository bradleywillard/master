package org.bwillard.ccsf.course.cs111c.labC;

/**
 * An interface for the ADT list. The methods in this list will only 
 * access the beginning or ending elements.  Elements anywhere in the 
 * middle of the list will not be accessible. Entries in a list have 
 * positions that begin with 1.
 * 
 * @author Bradley D. Willard 
 * 	 (modeled after ListInterface by Frank M. Carrano and Timothy M. Henry)
 * @version 1.0
 */
public interface EntryWayListInterface<T> {
	
	/**
	 * Amount of entries allocated by default to the list size, 
	 * unless otherwise specified.
	 */
	static final int DEFAULT_CAPACITY = 100;
	
	/**
	 * Inserts a new entry to the head (beginning) of this list.
     * Entries currently in the list are shifted right and their
     * respective indexes are incremented by 1.
     * The list's size is increased by 1.
     *
	 * @param newEntry The object to be added as a new entry. 
	 * @return True if the insert was successful, false otherwise
	 */
	boolean insertHead(T newEntry);
	
	
	/**
	 * Inserts a new entry to the tail (end) of this list.
	 * Entries currently in the list are unaffected.
	 * The list's size is increased by 1.
	 * 
	 * @param newEntry  The object to be added as a new entry.
	 * @return True if the insert was successful, false otherwise
	 */
	boolean insertTail(T newEntry);
	
	
	/**
	 * Deletes the first entry at the head (beginning) of the list. 
	 * Entries currently in the list are shifted right and their 
	 * respective indexes are decremented by 1. If there is
	 * only 1 item in the list, this method is interchangeable 
	 * with (does the same thing as) the deleteTail() method.
	 * This lists size decreases by 1.
	 * 
	 * @return the object that has been deleted, null if list is empty
	 */
	T deleteHead();
	
	
	/** 
	 * Deletes the last entry at the tail (end) of the list. 
	 * Entries currently in the list are unaffected.  If there is
	 * only 1 item in the list, this method is interchangeable 
	 * with (does the same thing as) the deleteHead() method.
	 * This lists size decreases by 1.
	 * 
	 * @return the object that has been deleted, null if list is empty
	 */
	T deleteTail();
	
	
	/**
	 * Prints out all entries in the list in the order in 
	 * which they occur in the list.
	 */
	void display();
	
	
	/**
	 * Sees whether this list contains a given entry.
	 * 
	 * @param anEntry The object that is the desired entry.
	 * @return the position (index) of the entry that was found, -1 if not found
	 */
	int contains(T anEntry); 
	
	
	/**
	 * Sees whether this list is empty.
	 * 
	 * @return  True if the list is empty, false otherwise.
	 */
	boolean isEmpty();
	
	
	/**
	 * Sees whether this list has reached the default or initial capacity 
	 * defined when the list was first created.
	 * 
	 * @return True if the list is full (has reached capacity), false otherwise.
	 */
	boolean isFull();

}
