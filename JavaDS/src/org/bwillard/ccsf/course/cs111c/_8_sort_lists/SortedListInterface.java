package org.bwillard.ccsf.course.cs111c._8_sort_lists;

public interface SortedListInterface<T extends Comparable<? super T>> {
	
	public void add(T entry);
	
	public boolean remove(T anEntry);
	
	public int getPosition(T anEntry);
	
	public T getEntry(int givenPosition);
	
	public boolean contains(T anEntry);
	
	public T remove(int givenPosition);
	
	public void clear();
	
	public int getLength();
	
	public boolean isEmpty();
	
	public T[] toArray();

}
