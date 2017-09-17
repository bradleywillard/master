package org.bwillard.ccsf.course.cs211s._13_immutable_class_with_annotations;

import java.util.Comparator;

public class Book implements Comparable<Book> {

	/**
	 * Instance data
	 */
	private String title, author;
	private int publishYear, expectedSales, actualSales;
	private double cost;
	private boolean availableDigital;
	private BookType bookType;
	
	enum BookType {FICTION, NON_FICTION}
	
	/**
	 * Constructor
	 * 
	 * @param title
	 * @param author
	 * @param publishYear
	 * @param expectedSales
	 * @param actualSales
	 * @param cost
	 * @param availableDigital
	 * @param bookType
	 */
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
	
}


