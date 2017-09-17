package org.bwillard.ccsf.course.cs211s._13_immutable_class_with_annotations;

import java.util.ArrayList;
import java.util.List;

/**
 * Immutable class example. 
 * 
 * Notice adherence to the 5 rules:
 * 1) Mark the class as final so it can't be sub-classed
 * 2) Make all instance data variables private and final
 * 3) Do not allow compositional, mutable objects to be modified when passed by reference
 * 		i.e. this.bookList = new ArrayList<>(bookList); vs. this.bookList = bookList;
 * 4) Do not create any setter methods
 * 5) Force the getter(s) for any mutable instance data variables to create a brand new objects
 * 		rather than passing the existing object, again to avoid the caller from modifying the object
 * 
 * 
 * @author bradleywillard
 *
 */
public final class Author {

	/**
	 * Instance data - private and final
	 */
	private final String name;
	private final int firstYearPublished;
	private final double totalSales;
	private final List<Book> bookList;
	
	/**
	 * Constructor
	 * 
	 * @param name
	 * @param firstYearPublished
	 * @param totalSales
	 * @param bookList
	 */
	public Author(String name, int firstYearPublished, double totalSales, List<Book> bookList) {
		this.name = name;
		this.firstYearPublished = firstYearPublished;
		this.totalSales = totalSales;
		this.bookList = new ArrayList<>(bookList);
	}

	public String getName() {
		return name;
	}

	public int getFirstYearPublished() {
		return firstYearPublished;
	}

	public double getTotalSales() {
		return totalSales;
	}

	public List<Book> getBookList() {
		List<Book> getList = new ArrayList<>(bookList.size());
		for(Book b : bookList) {
			getList.add(new Book(b.getTitle(), b.getAuthor(), 
					b.getPublishYear(), b.getExpectedSales(), b.getActualSales(),
					b.getCost(), b.isAvailableDigital(), b.getBookType()));
		}
		return bookList;
	}
	
	
	
}
