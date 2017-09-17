package org.bwillard.ccsf.course.cs211s._12_threads;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.bwillard.ccsf.course.cs211s._12_threads.Book.BookType;

/**
 * 
 * Class used for managing two lists for fiction and non-fiction books.  Includes thread-safe
 * methods to add/remove books
 * 
 * @author bradleywillard
 *
 */
public class BookList {

	/**
	 * Instance data
	 */
	List<Book> fictionBooks;
	List<Book> nonFictionBooks;
	
	/**
	 * Constructor - sets up our instance data with an initial step of thread-safety
	 */
	public BookList() {
		fictionBooks = Collections.synchronizedList(new ArrayList<>());
		nonFictionBooks = Collections.synchronizedList(new ArrayList<>());
	}

	/**
	 * Thread safe method add books
	 * 
	 * @param b
	 */
	public void addBook(Book b) {
		if(b != null) {
			if(b.getBookType() == BookType.FICTION) {
				synchronized(fictionBooks) {
					if(!fictionBooks.contains(b))
						fictionBooks.add(b);
				}
			} else if(b.getBookType() == BookType.NON_FICTION) {
				synchronized(nonFictionBooks) {
					if(!nonFictionBooks.contains(b))
						nonFictionBooks.add(b);
				}
			}
		}
	}
	
	/**
	 * Thread safe method to remove books
	 * @param b
	 */
	public void removeBook(Book b) {
		if(b != null) {
			if(b.getBookType() == BookType.FICTION) {
				synchronized(fictionBooks) {
					if(fictionBooks.contains(b))
						fictionBooks.remove(b);
				}
			} else if(b.getBookType() == BookType.NON_FICTION) {
				synchronized(nonFictionBooks) {
					if(nonFictionBooks.contains(b))
						nonFictionBooks.remove(b);
				}
			}
		}
	}
	
	public void printBooks() {
		System.out.println("\n--------------FICTION BOOKS--------------");
		fictionBooks.stream().forEach(System.out::println);
		System.out.println("\n--------------NON-FICTION BOOKS--------------");
		nonFictionBooks.stream().forEach(System.out::println);
	}
}
