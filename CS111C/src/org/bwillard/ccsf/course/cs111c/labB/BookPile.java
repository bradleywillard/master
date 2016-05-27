package org.bwillard.ccsf.course.cs111c.labB;

/**
 * This Interface is uses some similar concepts from java.util.Stack. I.E, 
 * push, pop, and peek.
 * 
 * @author bradleywillard
 *
 * @param <B> Book to be implemented
 */
public interface BookPile<B> {
	
	/**
	 * Pushes (adds) a book on top of the existing pile of books.  If no 
	 * books exist in the pile, this item will be the first and last book 
	 * on the pile until the next book is added (pushed).
	 * BookPile size is increased by 1
	 * 
	 * @param newBook to be pushed (added) on top of the pile
	 * @return the item added to the pile, null otherwise
	 */
	B pushBookToPile(B newBook);
	
	/**
	 * Pops (removes) and returns the topmost book from the pile.  
	 * BookPile size is decreased by 1.
	 * Returns null, if no books exists in the pile
	 * 
	 * @return the Book removed from the top of the pile, null otherwise
	 */
	B popTopBookFromPile();
	
	/**
	 * Peeks at and returns topmost book from the pile.  BookPile is unaffected.
	 * 
	 * @return Book from top of the pile, null if no books in pile
	 */
	B peekTopBookOnPile();
	
	/**
	 * Checks the pile to see if any books exist.
	 * 
	 * @return True if there is at least one book in the pile
	 */
	boolean hasBooksInPile();
	
	/**
	 * Removes (clears) all books (if any) from the pile.
	 */
	void clearPile();
}
