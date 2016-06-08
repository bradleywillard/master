package org.bwillard.ccsf.course.cs211s._13_immutable_class_with_annotations;

import java.util.ArrayList;
import java.util.List;

/**
 * Write an immutable class called Author. 
 * 
 * @author bradleywillard
 *
 */
public final class Author {

	private final String name;
	private final int firstYearPublished;
	private final double totalSales;
	private final List<Book> bookList;
	
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
