package org.bwillard.ccsf.course.cs211s._12_threads;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.bwillard.ccsf.course.cs211s._12_threads.Book.BookType;

/**
 * Write an addBook(Book b) method that adds a book to the appropriate list.  
 * Write a removeBook(Book b) method that removes the book from the appropriate list.
 * Write a printBooks() method that prints both lists.
 * Write a separate thread class that is described by a BookList object, a Book, and a type (add or remove). The thread class is responsible for adding or removing the book to/from the list. 
 * Create several add and remove threads and start them up.
 * Make sure all methods are threadsafe. Consider two different ways you could do this.
 * 
 * @author bradleywillard
 *
 */
public class BookList {

	List<Book> fictionBooks;
	List<Book> nonFictionBooks;
	
	public BookList() {
		fictionBooks = Collections.synchronizedList(new ArrayList<>());
		nonFictionBooks = Collections.synchronizedList(new ArrayList<>());
	}

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
