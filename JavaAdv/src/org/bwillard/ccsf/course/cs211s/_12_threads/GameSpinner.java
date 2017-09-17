package org.bwillard.ccsf.course.cs211s._12_threads;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


/**
 * This program represents a game wheel, similar to Wheel of Fortune.  The purpose is to
 * showcase a very simple threading example, whereby we creates and start multiple spinner threads.  
 * Each thread creates a new Game Spinner - 
 * 		A wheel with however many sections and spins are passed into the constructor
 *  
 * @author bradleywillard
 *
 */
public class GameSpinner {
		
	/**
	 * Instance data
	 */
	private int numSections, numSpins;
	private List<Section> sections;
	private Random rand;

	/**
	 * Constructor - 
	 * 	Takes in two parameters: the number of sections on the spinner and the number of spins.
	 * 
	 * @param numSections
	 * @param numSpins
	 */
	public GameSpinner(int numSections, int numSpins) {
		this.numSections = numSections;
		this.numSpins = numSpins;
		sections = new ArrayList<>(numSections);
		for(int i = 0; i < numSections; i++) {
			sections.add(new Section(i * 10 + 1));
		}
		rand = new Random();
	}

	
	/**
	 * Randomly selects a space on the spinner the specified number of times and prints the output
	 */
	private synchronized void spin() {
		for(int i = 1; i <= numSpins; i++) {
			int secIdx = rand.nextInt(sections.size());
			Section winner = sections.get(secIdx);
			System.out.println("SPIN " + i + " Section " + winner.getId() + " at index " + secIdx + " is the winner!" );
		}
	}
	
	public Integer getNumSections() {
		return numSections;
	}
	
	public Integer getNumSpins() {
		return numSpins;
	}
	
	public List<Section> getSections() {
		return sections;
	}
	
	/**
	 * Helper class representing a section for the spin wheel
	 * 
	 * @author bradleywillard
	 *
	 */
	class Section {
		private int id;
		public Section(int id) {
			this.id = id;
		}
		public Integer getId() {
			return this.id;
		}
	}
	
	/**
	 * MAIN program runner
	 * @param args
	 */
	public static void main(String[] args) {
		
		//Passes in number of sections, and number of spins
		new Thread( () -> new GameSpinner(25, 5).spin() ).start();
		new Thread( () -> new GameSpinner(10, 5).spin() ).start();
		new Thread( () -> new GameSpinner(50, 5).spin() ).start();
		new Thread( () -> new GameSpinner(15, 5).spin() ).start();
		new Thread( () -> new GameSpinner(5, 5).spin() ).start();
		
		//PRE-LAMBDA... ANTIQUATED! NAH... J/K
		/*Thread spinner1 = new Thread(new GameSpinner(25, 5));
		Thread spinner2 = new Thread(new GameSpinner(10, 5));
		Thread spinner3 = new Thread(new GameSpinner(50, 5));
		Thread spinner4 = new Thread(new GameSpinner(15, 5));
		Thread spinner5 = new Thread(new GameSpinner(5, 5));
		
		spinner1.start();
		spinner2.start();
		spinner3.start();
		spinner4.start();
		spinner5.start();*/
		
		int programTimeCounter = 0;
		while(Thread.activeCount()>1) {
			System.out.println("TIME " + programTimeCounter);
			programTimeCounter++;
			try {
				Thread.sleep(1000);
			} catch(InterruptedException ex) {
				ex.printStackTrace();
			}
		}
		
		System.out.println("Program Time = " + programTimeCounter);
	}
}
