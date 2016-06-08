package org.bwillard.ccsf.course.cs111c.homework3;

import org.bwillard.ccsf.course.cs111c.labB.BookPile;

public class BookPileImpl<B> implements BookPile<B> {
	
	private ListInterface<B> list;
	private int numberOfBooks;
	
	public BookPileImpl() {
		list = new AList<B>();
		numberOfBooks = 0;
	}
	
	@Override
	public B pushBookToPile(B newBook) {
		if(newBook != null) {
			list.add(newBook);
			numberOfBooks++;
		}
		return newBook;
	}

	@Override
	public B popTopBookFromPile() {
		B book = list.remove(numberOfBooks);
		if(book != null){
			numberOfBooks--;
		}
		return book;
	}

	@Override
	public B peekTopBookOnPile() {
		B book = list.getEntry(numberOfBooks);
		if(book != null)
			return book;
		return null;
	}

	@Override
	public boolean hasBooksInPile() {
		return !list.isEmpty();
	}

	@Override
	public void clearPile() {
		list.clear();
	}

}
