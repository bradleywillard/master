package org.bwillard.ccsf.course.cs111c.homework9;

import java.util.*;

public class HomeworkW9EC {

	private static Hashtable<String, ABCounts> hashTable;
	private static int numberOfUserChoices, numberCorrect, numberIncorrect;
	private static Random generator;

	public static void main(String[] args) {
		hashTable = new Hashtable<String, ABCounts>();
		numberOfUserChoices = 0;
		numberCorrect = 0;
		numberIncorrect = 0;
		generator = new Random();

		Scanner scan = new Scanner(System.in);
		boolean keepPlaying = true;

		while (keepPlaying) {
			System.out.println("Think of either A or B, and I will guess your choice.(Type QUIT to exit.)");
			String userResponse = scan.nextLine().toUpperCase();
			numberOfUserChoices++;
			if (!userResponse.equals("QUIT")) {
				char myGuess = makeComputerGuess();

				System.out.print("I guess that you chose " + myGuess + "; am I right? ");
				userResponse = scan.nextLine();

				if (userResponse.toLowerCase().charAt(0) == 'y') {
					numberCorrect++; // program guess is right
					addUserChoice(myGuess); // user choice is same as program guess
				} else {
					numberIncorrect++; // program guess is wrong
					// user choice is opposite program guess
					if (myGuess == 'A')
						addUserChoice('B');
					else
						addUserChoice('A');
				} 
				System.out.println("Score: " + numberCorrect + " correct. " + numberIncorrect + " incorrect.\n");

			} else {
				keepPlaying = false;
			}
		} 
		System.out.println("Bye!");
	}

	public static char makeComputerGuess() {
		if (numberOfUserChoices < 5) {
			return makeRandomGuess();
		} else {
			// YOUR CODE HERE
			// use the hashtable to make a smart guess (when possible)
			return 'A';
		} 
	} 

	public static void addUserChoice(char choice) {
		// YOUR CODE HERE
		// update your hashtable based on whatever the user just guessed

	} 
	private static char makeRandomGuess() {
		int randomInteger = generator.nextInt();
		if (randomInteger % 2 == 0)
			return 'A';
		else
			return 'B';
	}	

}
