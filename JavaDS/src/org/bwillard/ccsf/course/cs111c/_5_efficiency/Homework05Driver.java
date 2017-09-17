package org.bwillard.ccsf.course.cs111c.homework5;

import java.util.*;

public class Homework05Driver {

	public static void main(String[] args) {

		// I recommend starting with a small array to test that your methods
		// work properly.
		// You won't see a different in running time for small arrays.
		// Once you know your methods work, increase the size to see the
		// difference in run time!
		int arraySize = 5;
		int[] numbers = new int[arraySize];
		fillWithUnique(numbers);
		System.out.println("The array is: " + Arrays.toString(numbers));

		// timing code comes from the Projects section of Chapter 4
		Date current = new Date();
		long startTime = current.getTime();
		System.out.println("The missing integer O(n) is "
				+ findMissingIntegerN(numbers));
		current = new Date();
		long stopTime = current.getTime();
		long elapsedTime = stopTime - startTime;
		System.out.println("The linear method took " + elapsedTime
				+ " milliseconds.");

		startTime = current.getTime();
		fillWithUnique(numbers);
		System.out.println("The missing integer O(n^2) is"
				+ findMissingIntegerN2(numbers));
		current = new Date();
		stopTime = current.getTime();
		elapsedTime = stopTime - startTime;
		System.out.println("The quadratic method took " + elapsedTime
				+ " milliseconds.");

		/*
		 * testing extra credit int[] posNegNumbers = new int[arraySize];
		 * fillWithPosNeg(posNegNumbers);
		 * System.out.println(Arrays.toString(posNegNumbers));
		 * arrangeNegBeforePositive(posNegNumbers);
		 * System.out.println(Arrays.toString(posNegNumbers));
		 */
		int[] array = {8, -3, 2, 7, -6, -9, 4, -12, -33, 10, 16, -17, 22, -89, 31};
		System.out.println("The array before neg/pos rearrangement is: " + Arrays.toString(array));
		array = rearrangePosAndNegNumbers(array);
		System.out.println("The array after neg/pos rearrangement is: " + Arrays.toString(array));
	}

	private static int findMissingIntegerN(int[] arr) {
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
		}
		// the total sum of numbers between 1 and arr.length.
		int total = ((arr.length + 2) * (arr.length + 1)) / 2;
		return total - sum;
	}

	private static int[] rearrangePosAndNegNumbers(int[] array) {
		int[] negPosArray = new int[array.length];
		int negCount = 0, posCount = 0;
		for(int i = 0; i < array.length; i++) {
			if(array[i] < 0) {
				negCount++;
				negPosArray[negCount - 1] = array[i];
			} else {
				posCount++;
				negPosArray[negPosArray.length - posCount] = array[i];
			}
		}
		return negPosArray;
	}
	
	private static int findMissingIntegerN2(int[] numbers) {
		System.out.println("The array is: " + Arrays.toString(numbers));
		int missingInt = -1;
		boolean found = false;
		for (int expected = 1; expected <= numbers.length + 1; expected++) {
			for (int i = 0; i < numbers.length; i++) {
				if (numbers[i] == expected) {
					found = true;
				} 
			}
			if(!found) {
				missingInt = expected;
				return missingInt;
			} else {
				found = false;
			}
		}
		return missingInt;
	}

	/*private static int findMissingIntegerN(int[] numbers) {
		Arrays.sort(numbers);
		System.out.println("The sorted array is: " + Arrays.toString(numbers));
		int missingInt = -1;
		boolean found = false;
		//After sorting the numbers, this works...
		for (int i = 0; !found && i < numbers.length - 1; i++) {
			//if first number is not equal to '1'...
			if (numbers[0] == 2) {
				missingInt = 1;
				found = true;
			//if last number is not equal to 'n'...
			} else if(numbers[numbers.length - 1] != numbers.length + 1) {
				missingInt = numbers[numbers.length - 1] + 1;
				found = true;
			//if the current number is not equal to 1 less than the next number...
			} else if (numbers[i] != (numbers[i + 1] - 1)) {
				missingInt = numbers[i] + 1;
				found = true;
			}
		}
		return missingInt;
	}*/
	
	
	/*
	 * private static int findMissingIntegerN(int[] numbers) { int len =
	 * numbers.length; int sum = 0; for(int i = 0; i < len; i++) sum +=
	 * numbers[i]; int total = ((len + 1) * (len + 2)) / 2; int missingInt =
	 * total - sum;
	 * 
	 * return missingInt; }
	 */

	public static void arrangeNegBeforePositive(int[] array) {
		// YOUR CODE HERE FOR EXTRA CREDIT
	}

	// fills the array with unique values from 1 to n+1 with one missing value
	private static void fillWithUnique(int[] numbers) {

		ArrayList<Integer> possibleValues = new ArrayList<Integer>();
		for (int i = 1; i <= (numbers.length + 1); i++) {
			possibleValues.add(i); // fill an array list with all values 1 to
									// n+1
		}
		Collections.shuffle(possibleValues); // randomize the order

		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = possibleValues.get(i); // fill the array with the first
												// n values (will leave one
												// value missing)
		}
	}

	private static void fillWithPosNeg(int[] numbers) {
		Random generator = new Random();
		for (int i = 0; i < numbers.length; i++) {
			int number = generator.nextInt(101) - 50; // will fill with a random
														// number in the range
														// -50 to 50
			if (number != 0) {
				numbers[i] = number;
			} else {
				i--;
			}
		}
	}

}