package org.bwillard.ccsf.course.cs211s._11_threads;

import java.util.Random;

public class DicePlayer extends Thread {
	
	private Random generator;
	private int numDoubles;
	private int timesToRoll;
	private int playerNum;
	
	public DicePlayer(int playerNum, int timesToRoll) {
		this.timesToRoll = timesToRoll;
		this.playerNum = playerNum;
		generator = new Random();
		numDoubles = 0;
	}
	
	public int getDoublesCount() {
		return numDoubles;
	}
	
	@Override
	public String toString() {
		//add one to the playerNum for display output since it's based on the array index
		return "Player " + (playerNum + 1) + " with " + numDoubles + " doubles";
	}
	
	private synchronized void roll() {
		// Roll two dice and update the doubles count if necessary
		int dice1 = generator.nextInt((6 - 1) + 1) + 1;
		int dice2 = generator.nextInt((6 - 1) + 1) + 1;
		if (dice1 == dice2) { 
			numDoubles++;
		}
	}
	
	public void run() {
		// YOUR CODE HERE (roll the dice the times specified by timesToRoll)
		for(int i = 0; i < timesToRoll; i++) {
			roll();
		}
	}

}
