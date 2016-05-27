package org.bwillard.ccsf.course.cs211s.last;

import java.util.concurrent.ConcurrentHashMap;

import org.bwillard.ccsf.course.cs211s.last.Book.BookType;


/**
 * This thread class that is described by a BookList object, a Book, and a type (add or remove). 
 * This thread class is responsible for adding or removing the book to/from the list. 
 * Create several add and remove threads and start them up.
 * Make sure all methods are threadsafe. Consider two different ways you could do this.
 * 
 * @author bradleywillard
 *
 */
public class BookListThread implements Runnable {

	private BookList bookList;
	private Book book;
	private Type type;
	
	private enum Type {ADD,REMOVE};
	 
	public BookListThread(BookList bookList, Book book, Type type) {
		this.bookList = bookList;
		this.book = book;
		this.type = type;
	}

	@Override
	public void run() {
		if(type == Type.ADD) {
			bookList.addBook(book);
		} else if(type == Type.REMOVE) {
			bookList.removeBook(book);
		}
		
	}

	public static void main(String[] args) {
		Book mainBook = new Book("The Buck Stops Here with Bruce", "Brose Wullard", 1997, 100, 975, 29.99, false, BookType.NON_FICTION);
		BookList bookList = new BookList();
		Thread mainThread = new Thread(new BookListThread(bookList, mainBook, Type.ADD));
		mainThread.start();
		
		Book book1 = new Book("Close Joe", "Joe Electrician", 1997, 20000, 975000, 2500.00, false, BookType.NON_FICTION);
		Thread addThread1 = new Thread(new BookListThread(bookList, book1, Type.ADD));
		addThread1.start();
		
		Book book2 = new Book("My Lips Are Super Chapped", "Ander Castarstaslopaghi", 2003, 31000, 32000, 501.50, true, BookType.NON_FICTION);
		Thread addThread2 = new Thread(new BookListThread(bookList, book2, Type.ADD));
		addThread2.start();
		
		Book book3 = new Book("Look What You Did To My Hair!", "Cheech Marin", 1973, 500, 900, 200.14, false, BookType.FICTION);
		Thread addThread3 = new Thread(new BookListThread(bookList, book3, Type.ADD));
		addThread3.start();
		
		//Book bookRemove1 = new Book("Close Joe", "Joe Electrician", 1997, 20000, 975000, 2500.00, false, BookType.NON_FICTION);
		Thread removeThread1 = new Thread(new BookListThread(bookList, book1, Type.REMOVE));
		removeThread1.start();
		
		Book book4 = new Book("Responsible Construction Truck Man", "Helmet Richards", 2001, 4000, 70000, 5.00, true, BookType.FICTION);
		Thread addThread4 = new Thread(new BookListThread(bookList, book4, Type.ADD));
		addThread4.start();
		
		Book book5 = new Book("Helmet Man", "Shameless Will", 2015, 42009, 65181, 100.02, true, BookType.NON_FICTION);
		Thread addThread5 = new Thread(new BookListThread(bookList, book5, Type.ADD));
		addThread5.start();
		
		Book book6 = new Book("Hook Nose Octagon: The Best Damn Player on the Team", "Bradley D. Willard", 1998, 5900, 2900029, 100.94, false, BookType.NON_FICTION);
		Thread addThread6 = new Thread(new BookListThread(bookList, book6, Type.ADD));
		addThread6.start();
		
		Book book7 = new Book("Awww, Poor Doggy Woggy", "Bradley D. Willard", 2007, 9902, 98723498, 1000.44, true, BookType.NON_FICTION);
		Thread addThread7 = new Thread(new BookListThread(bookList, book7, Type.ADD));
		addThread7.start();
		
		Book book8 = new Book("Poor Little Baby", "Oops Johnson", 2013, 18999, 723498, 120.10, false, BookType.NON_FICTION);
		Thread addThread8 = new Thread(new BookListThread(bookList, book8, Type.ADD));
		addThread8.start();
		
		Book book9 = new Book("When Chipmunk Bites", "Woofers McWaggers", 2015, 182, 598, 69.50, true, BookType.FICTION);
		Thread addThread9 = new Thread(new BookListThread(bookList, book9, Type.ADD));
		addThread9.start();
		
		//Book bookRemove6 = new Book("Hook Nose Octagon: The Best Damn Player on the Team", "Bradley D. Willard", 1998, 5900, 2900029, 100.94, false, BookType.NON_FICTION);
		Thread removeThread2 = new Thread(new BookListThread(bookList, book6, Type.REMOVE));
		removeThread2.start();
		
		Book book10 = new Book("The Adventures of Barkie McWaffles", "Woofers McMaggor", 2007, 763, 123467, 250.27, true, BookType.FICTION);
		Thread addThread10 = new Thread(new BookListThread(bookList, book10, Type.ADD));
		addThread10.start();
		
		Book book11 = new Book("Making Excuses Again", "Bradley D. Willard", 2015, 0, 9, 20.27, false, BookType.FICTION);
		Thread addThread11 = new Thread(new BookListThread(bookList, book11, Type.ADD));
		addThread11.start();
		
		Book book12 = new Book("Minus Jones", "Ander Castarstaslopaghi", 2000, 3000, 3000, 16.65, true, BookType.FICTION);
		Thread addThread12 = new Thread(new BookListThread(bookList, book12, Type.ADD));
		addThread12.start();
		
		Book book13 = new Book("A Futile Activity", "Budley D. Williams", 2012, 3000, 2950, 21.29, true, BookType.FICTION);
		Thread addThread13 = new Thread(new BookListThread(bookList, book13, Type.ADD));
		addThread13.start();
		
		Book book14 = new Book("Trying to Go Somplace Else", "Willabra Whiplash", 2000, 3091, 3087, 10.29, true, BookType.FICTION);
		Thread addThread14 = new Thread(new BookListThread(bookList, book14, Type.ADD));
		addThread14.start();
		
		bookList.printBooks();
		
		//Book book15 = new Book("The Adventures of Barkie McWaffles", "Woofers McMaggor", 2007, 763, 123467, 250.27, true, BookType.FICTION);
		Thread removeThread15 = new Thread(new BookListThread(bookList, book10, Type.REMOVE));
		removeThread15.start();
		
		//Book book16 = new Book("Minus Jones", "Ander Castarstaslopaghi", 2000, 3000, 3000, 16.65, true, BookType.FICTION);
		Thread removeThread16 = new Thread(new BookListThread(bookList, book12, Type.REMOVE));
		removeThread16.start();
		
		//Book book17 = new Book("Awww, Poor Doggy Woggy", "Bradley D. Willard", 2007, 9902, 98723498, 1000.44, true, BookType.NON_FICTION);
		Thread removeThread17 = new Thread(new BookListThread(bookList, book7, Type.REMOVE));
		removeThread17.start();
		
		//Book book18 = new Book("Poor Little Baby", "Oops Johnson", 2013, 18999, 723498, 120.10, false, BookType.NON_FICTION);
		Thread removeThread8 = new Thread(new BookListThread(bookList, book8, Type.REMOVE));
		removeThread8.start();
		
		ConcurrentHashMap<String, String> gradeMap = new ConcurrentHashMap<>();
		String grade = gradeMap.get("CS211S");
		if(grade != null) {
			gradeMap.put("CS211S", "Grade 95 (A)");
		}
		
		bookList.printBooks();
	}
	
}
