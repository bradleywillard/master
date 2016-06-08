package org.bwillard.ccsf.course.cs211s.last;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Book implements Comparable<Book> {

	private String title, author;
	private int publishYear, expectedSales, actualSales;
	private double cost;
	private boolean availableDigital;
	private BookType bookType;
	
	enum BookType {FICTION, NON_FICTION}
	
	public Book(String title, String author, int publishYear, int expectedSales, 
			int actualSales, double cost, boolean availableDigital,
			BookType bookType) {
		this.title = title;
		this.author = author;
		this.publishYear = publishYear;
		this.expectedSales = expectedSales;
		this.actualSales = actualSales;
		this.cost = cost;
		this.availableDigital = availableDigital;
		this.bookType = bookType;
	}

	
	public final String getTitle() {
		return title;
	}


	public final String getAuthor() {
		return author;
	}


	public final Integer getPublishYear() {
		return publishYear;
	}


	public final Integer getExpectedSales() {
		return expectedSales;
	}


	public final Integer getActualSales() {
		return actualSales;
	}


	public final Double getCost() {
		return cost;
	}


	public final Boolean isAvailableDigital() {
		return availableDigital;
	}

	
	public final BookType getBookType() {
		return bookType;
	}


	@Override
	public int compareTo(Book o) {
		//First compare on title...
		if(this.getTitle().compareTo(o.getTitle()) == 0) {
			//If titles are the same, then compare on publisher year
			if(this.getPublishYear().compareTo(o.getPublishYear()) == 0) {
				//And if publisher years are also the same, compare finally on Author...
				if(this.getAuthor().compareTo(o.getAuthor()) == 0) {
					//And if that too is the same, we have an equal object....
					return 0;
				} else if(this.getAuthor().compareTo(o.getAuthor()) > 0) {
					return 1;
				} else {
					return -1;
				}
			} else if(this.getPublishYear().compareTo(o.getPublishYear()) > 0) {
				return 1;
			} else {
				return -1;
			}
		} else if(this.getTitle().compareTo(o.getTitle()) > 0) {
			return 1;
		} else {
			return -1;
		}
	}
	
	class BookCostComparator implements Comparator<Book> {
		@Override
	    public int compare(Book b1, Book b2) {
	    	//First compare by cost...
	        if (b1.getCost().compareTo(b2.getCost()) == 0) {
	        	//..and if cost is the same, compare by publish year
	        	if(b1.getPublishYear().compareTo(b2.getPublishYear()) == 0) {
	        		//..and if that's the same, too, then the object is equal
	        		return 0;
	        	} else if(b1.getPublishYear().compareTo(b2.getPublishYear()) > 0) {
	        		return 1;
	        	} else {
	        		return -1;
	        	}
	        } else if (b1.getCost().compareTo(b2.getCost()) > 0) {
	        	return 1;
	        } else {
	        	return -1;
	        }
	    }
	}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + actualSales;
		result = prime * result + ((author == null) ? 0 : author.hashCode());
		result = prime * result + (availableDigital ? 1231 : 1237);
		result = prime * result
				+ ((bookType == null) ? 0 : bookType.hashCode());
		long temp;
		temp = Double.doubleToLongBits(cost);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + expectedSales;
		result = prime * result + publishYear;
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		if (actualSales != other.actualSales)
			return false;
		if (author == null) {
			if (other.author != null)
				return false;
		} else if (!author.equals(other.author))
			return false;
		if (availableDigital != other.availableDigital)
			return false;
		if (bookType != other.bookType)
			return false;
		if (Double.doubleToLongBits(cost) != Double
				.doubleToLongBits(other.cost))
			return false;
		if (expectedSales != other.expectedSales)
			return false;
		if (publishYear != other.publishYear)
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Book [title=" + title + ", author=" + author + ", publishYear="
				+ publishYear + ", expectedSales=" + expectedSales
				+ ", actualSales=" + actualSales + ", cost=" + cost
				+ ", availableDigital=" + availableDigital + ", bookType="
				+ bookType + "]";
	}


	public static void main(String[] args) {
		List<Book> books = new ArrayList<Book>();
		books.add(new Book("Close Joe", "Joe Electrician", 1997, 20000, 975000, 2500.00, false, BookType.NON_FICTION));
		books.add(new Book("My Lips Are Super Chapped", "Ander Castarstaslopaghi", 2003, 31000, 32000, 501.50, true, BookType.NON_FICTION));
		books.add(new Book("Aboomba Boomba", "Cheech Marin", 1973, 500, 900, 200.14, false, BookType.FICTION));
		books.add(new Book("Responsible Construction Truck Man", "Helmet Richards", 2001, 4000, 70000, 5.00, true, BookType.FICTION));
		books.add(new Book("Helmet Man", "Shameless Will", 2015, 42009, 65181, 100.02, true, BookType.NON_FICTION));
		books.add(new Book("Hook Nose Octagon: The Best Damn Player on the Team", "Bradley D. Willard", 1998, 5900, 2900029, 100.94, false, BookType.NON_FICTION));
		books.add(new Book("Awww, Poor Doggy Woggy", "Bradley D. Willard", 2007, 9902, 98723498, 1000.44, true, BookType.NON_FICTION));
		books.add(new Book("Poor Little Baby", "Oops Johnson", 2013, 18999, 723498, 120.10, false, BookType.NON_FICTION));
		books.add(new Book("When Chipmunk Bites", "Woofers McWaggers", 2015, 182, 598, 69.50, true, BookType.FICTION));
		books.add(new Book("The Adventures of Barkie McWaffles", "Woofers McMaggor", 2007, 763, 123467, 250.27, true, BookType.FICTION));
		books.add(new Book("Making Excuses Again", "Bradley D. Willard", 2015, 0, 9, 20.27, false, BookType.FICTION));
		books.add(new Book("Minus Jones", "Ander Castarstaslopaghi", 2000, 3000, 3000, 16.65, true, BookType.FICTION));
		books.add(new Book("A Futile Activity", "Budley D. Williams", 2012, 3000, 2950, 21.29, true, BookType.FICTION));
		books.add(new Book("Trying to Go Somplace Else", "Willabra Whiplash", 2000, 3091, 3087, 10.29, true, BookType.FICTION));
		
		//books.sort
		//Lambda
		books.sort((b1, b2) -> {
	        if (b1.getActualSales().compareTo(b2.getActualSales()) == 0) {
	            return b1.getExpectedSales().compareTo(b2.getExpectedSales());
	        } else {
	        	return b1.getActualSales().compareTo(b2.getActualSales());
	        }
	        
	    });
		
		
		books.stream().forEach(System.out::println);
		System.out.println();
	
		
		//Streams
		books.stream()
			.sorted(Comparator.comparing(Book::getActualSales).thenComparing(Book::getExpectedSales))
			.forEach(System.out::println);
		
		//#5 the number of unique authors in the list
		System.out.println("# of distinct authors: " + books.stream().map(b -> b.getAuthor()).distinct().count());
		
		//#5 print the title of every book available digitally, sorted by title
		System.out.println("\nDigitally Available: ");
		books.stream()
			.filter(Book::isAvailableDigital)
			.sorted(Comparator.comparing(Book::getTitle))
			.forEach(System.out::println);
		
		//#5 the average cost of all fiction books published in 2015
		double avg = books.stream()
			.filter(b -> b.getBookType().equals(BookType.FICTION))
			.filter(b -> b.getPublishYear() == 2015)
			.mapToDouble(Book::getCost)
			.average().getAsDouble();
		System.out.println("\nAverage cost of all fiction books published in 2015: " + avg);
		
		
		//#5 the most expensive book published in 2015
		double mostExp = books.stream()
				.filter(b -> b.getPublishYear() == 2015)
				.mapToDouble(b -> b.getCost())
				.max().getAsDouble();
		
		//books.stream().max(Book::getHeight).get();
		System.out.println("\nMost expensive book published in 2015: " + mostExp);
		
		//#5 whether or not there are any digital, non-fiction books published in 2015
		boolean exists = books.stream()
				.filter(b -> b.isAvailableDigital())
				.filter(b -> b.getBookType() == BookType.FICTION)
				.findAny()
				.isPresent();
		System.out.println("\nAny digital, non-fiction books published in 2015? " + exists);
		
		//#5 generate a list of authors (not books!) for all books whose expected sales were higher than their actual sales
		System.out.println("\nAuthors whose books expected sales were > than actual sales :-(");
		books.stream()
			.filter(b -> b.getExpectedSales() > b.getActualSales())
			.map(Book::getAuthor)
			.distinct()
			.forEach(System.out::println);
			
		
		//#5 generate a map of books by author (key = author, value = list of books)
		/*books.stream()
				.collect(Collectors.toMap(Book::getAuthor, Function.identity()))
				.forEach((author, b) -> System.out.format("Author %s: %s\n", author, b));*/
		Map<String, List<Book>> map = books.stream().collect(Collectors.groupingBy(Book::getAuthor));
		map.forEach((author, bookList) -> {
			bookList.forEach(book -> System.out.format("AUTHOR: " + author + ", TITLE: %s\n", book.getTitle()));
		});
		
		
	}
	
}


