package org.bwillard.ccsf.course.cs211s._7_generics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * A class that illustrates a slightly more complex (looking) Generics implementation
 * 		
 * @author bradleywillard
 *
 * @param <T>
 */
public class RandomBox<T extends Comparable<T>> implements Comparable<RandomBox<T>> {

	private T winner;
	private List<T> entries;
	
	/**
	 * Constructor
	 */
	public RandomBox() {
		entries = new ArrayList<T>();
	}
	
	public void displayEntries() {
		for(T entry : entries) {
			System.out.println(entry.toString());
		}
	}
	
	/**
	 * Method that draws a singular winner, after having called the method
	 * that shuffles the box.  Just picks the first one.
	 * 
	 * @return
	 */
	public T drawWinner() {
		return drawWinners(1).get(0);
	}
	
	/**
	 * Method that shuffles the RandomBox contestants around, then draw a given number of winners
	 * 
	 * @param numWinners
	 * @return
	 */
	public List<T> drawWinners(int numWinners) {
		List<T> winners = new ArrayList<T>(numWinners);
		//If the box is empty... bail out
		if(getEntries() == null || getEntries().size() == 0) {
			try {
				throw new EmptyBoxException("Attempt to pick multiple winners failed.  Box was empty!");
			} catch (EmptyBoxException e) {
				System.out.println(e.getMessage());
			}
		} else {
			//If there are more items in the box than winners,
			//shuffle the items to make it a random order...
			if(getEntries().size() > numWinners) {
				Collections.shuffle(getEntries());
			}
			//Whatever the case pick the winners...
			for(int i = 0; i < numWinners; i++) {
				winners.add((T) getEntries().get(i));
			}
		}
		return winners;
	}
	
	public void addItem(T item) {
		entries.add(item);
	}

	public T getWinner() {
		return winner;
	}
	
	public int size() {
		return entries.size();
	}
	
	public List<T> getEntries() {
		return this.entries;
	}
	
	@Override
	public String toString() {
		/*if(winner == null && (entries == null || entries.size() == 0)) {
			return "There are no entries";
		} else if(winner == null) {
			return "No winner yet, but there are " + entries.size() + " entries";
		} else {
			return "And the winner is " + winner.toString() + " !!";
		}*/
		return ""+size();
	}

	@Override
	public int compareTo(RandomBox<T> o) {
		if(this.size() == o.size()) 
			return 0;
		else if(this.size() > o.size())
			return 1;
		else 
			return -1;
	}

	

}
