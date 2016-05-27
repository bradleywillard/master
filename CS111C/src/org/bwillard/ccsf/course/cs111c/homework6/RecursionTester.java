package org.bwillard.ccsf.course.cs111c.homework6;

import java.util.Scanner;

public class RecursionTester {

	public static void main(String[] args) {
		
		countUp(10);
		
		int[] arr = {1,3,5,7,11,13,17,19,23,29,31,37,41};
		printArr(arr, 0);
		System.out.println();
		
		ListInterface<Integer> list = new AList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(2);
		list.add(4);
		System.out.println(list.contains(1));
		System.out.println(list.contains(4));
		System.out.println(list.contains(2));
		System.out.println(list.contains(5));

		recursiveCountDown(15);
		/*int[] nums = { 4, 7, 1, 11, 12, 14, 5, 4 };
		printArray(nums);
		printArrayReverse(nums);

		lineSkipper(100, 2);
		drawConcentricCircles(5, 2, 25);
		long start = System.currentTimeMillis();
		// countUp(2000);
		long end = System.currentTimeMillis() - start;
		// System.out.println(end);

		System.out.println(sumOf(3));

		counter(5);

		int[] arr = { 111, 2, 4, 3, 89, 0, 23 };
		printArray(arr);

		System.out.println();
		System.out.println("= " + fibRecursive(13));// (0+1)(1+1)(1+2)(2+3)(3+5)
		// 0,1,1,2,3,5,8,13,21,34,55,89,

		char ch = 'a';
		String word = "bananarama";
		System.out
				.println("countChars('" + ch + "') = " + countChars(word, ch));

		System.out.println();
		System.out.println(recMethod(10, 1));
		
		System.out.println();
		System.out.println( " = " + recFactorial1(5));
		//System.out.println( " = " + recFactorial2(5));
		
		int numberOfDisks = 3, startPole = 0, tempPole = 0, endPole = 0;
		solveTowers(numberOfDisks, startPole, tempPole, endPole);
		System.out.println("numberOfDisks = " + numberOfDisks);
		System.out.println("startPole = " + startPole);
		System.out.println("tempPole = " + tempPole);
		System.out.println("endPole = " + endPole);
		
		System.out.println();
		System.out.print("Enter number of discs: ");
	    Scanner scanner = new Scanner(System.in);
	    int discs = scanner.nextInt();
	    System.out.println("Moved discs in " +
	    		solve(discs, "Pole A", "Pole B", "Pole C") + " moves");
	    
	    */
		
		System.out.println("\n" +recFactorial1(4));
		
	}

	public static int solve(int n, String start, String aux, String end) {
		int counter = 0;
		if (n == 1) {
			System.out.println(start + " -> " + end);
			counter += 1;
		} else {
           counter += 1 + solve(n - 1, start, end, aux);
           System.out.println(start + " -> " + end);
           counter += 1 + solve(n - 1, aux, start, end);
       	}
		return counter;
   }
	
	public static void solveTowers(int numberOfDisks, int startPole, 
									int tempPole, int endPole) {
		if(numberOfDisks > 0) {
			/*
			 * Move all but the bottom disk from startPole to tempPole
			 * Move disk from startPole to endPole
			 * Move all disks from tempPole to endPole
			 */
			solveTowers(numberOfDisks - 1, startPole, endPole, tempPole);
			//Move disk from startPole to endPole
			solveTowers(numberOfDisks - 1, tempPole, startPole, endPole);
		}
	}
	
	public static int recFactorial1(int x) {
		System.out.print(x);
		if (x > 1) {
			return x * recFactorial1(x - 1);
		} else
			return 1;
	}

	public static int recFactorial2(int x) {
		if (x > 1) {
			int fac = x * recFactorial2(x - 1);
			System.out.print(x);
			return fac;
		} else {
			return 1;
		}
	}

	public static int recMethod(int x, int y) {
		int result;
		if (x == y)
			result = 0;
		else
			result = 1 + recMethod(x - 1, y);
		return result;
	}

	public static int countChars(String s, char c) {
		int count = 0;
		if (s.length() == 1) {
			if (s.charAt(0) == c) {
				count = 1;
			} else {
				count = 0;
			}
		} else if (s.length() > 1) {
			if (s.charAt(0) == c) {
				count = 1 + countChars(s.substring(1), c);
			} else {
				count = countChars(s.substring(1), c);
			}
		}
		return count;
	}

	public static int fibRecursive(int n) {
		if (n <= 1)
			return 1;
		else {
			int fib1 = fibRecursive(n - 1);
			int fib2 = fibRecursive(n - 2);
			System.out.println("n = " + n + " and fibRecursive(n - 1) = "
					+ fib1 + " and fibRecursive(n - 2) = " + fib2);
			return fib1 + fib2;
		}

	}

	public static void lineSkipper(int max, int n) {
		System.out.println(n);
		n += n;
		if (n <= max)
			lineSkipper(max, n);
		System.out.println(n);
	}

	public static void countUp2(int n) {
		if (n > 1) {
			countUp2(n - 1);
		}
		System.out.println(n);
	}

	public static int sumOf(int n) {
		int sum;
		if (n == 1)
			sum = 1;
		else {
			int sumOf = sumOf(n - 1);
			System.out.println("In sumOf method " + sumOf);
			sum = sumOf + n;
		}
		return sum;
	}

	public static void counter(int i) {
		System.out.println("before " + i);
		if (i > 1)
			counter(i - 1);
		System.out.println("after " + i);

	}

	/**
	 * Takes in a parameter with number of circles to draw Decrements numCircs
	 * by one with each call Each circle draws 4/3 larger than the previous
	 * 
	 * @param numCircs
	 */
	public static void drawConcentricCircles(int numCircs, float diameter,
			int point) {

		// paint that circle
		if (numCircs > 0) {
			diameter = diameter * 4 / 3;
			// Draw circle...
			System.out.println("Diameter is " + diameter + " and " + numCircs
					+ '\n');
			drawConcentricCircles(numCircs - 1, diameter, point);
		}
	}

	public static boolean listContains(ListInterface list, Object item) {
		return listContainsHelper(list, item, 1, list.getLength());
	}

	private static boolean listContainsHelper(ListInterface list, Object item,
			int start, int end) {
		if (start <= end) { // recursive case
			Object currentItem = list.getEntry(start);
			if (currentItem.equals(item)) {
				return true;
			} else {
				return listContainsHelper(list, item, start + 1, end);
			}

		} else { // base case: start > end
			return false;
		}
	}

	public static int charCounter(String text, char letter) {
		return charCounterHelper(text, letter, 0, text.length() - 1);

	}

	private static int charCounterHelper2(String text, char letter,
			int firstCharIndex, int lastCharIndex) {
		int charCount = 0;
		if (firstCharIndex == lastCharIndex) { // base case
			char c = text.charAt(firstCharIndex);
			if (c == letter) {
				charCount = 1;
			} else {
				charCount = 0;
			}
		} else { // recursive case
			char c = text.charAt(firstCharIndex);
			if (c == letter) {
				charCount = 1 + charCounterHelper2(text, letter,
						firstCharIndex + 1, lastCharIndex);
			} else {
				charCount = 0 + charCounterHelper2(text, letter,
						firstCharIndex + 1, lastCharIndex);
			}
		}
		return charCount;
	}

	private static int charCounterHelper(String text, char letter,
			int firstCharIndex, int lastCharIndex) {
		if (firstCharIndex == lastCharIndex) { // base case
			char c = text.charAt(firstCharIndex);
			if (c == letter) {
				return 1;
			} else {
				return 0;
			}
		} else { // recursive case
			char c = text.charAt(firstCharIndex);
			if (c == letter) {
				return 1 + charCounterHelper(text, letter, firstCharIndex + 1,
						lastCharIndex);
			} else {
				return 0 + charCounterHelper(text, letter, firstCharIndex + 1,
						lastCharIndex);
			}
		}
	}

	public static int recursiveReadInRange() {
		System.out.println("Enter a value between 1 and 10:");
		Scanner scan = new Scanner(System.in);
		int userNumber = scan.nextInt();

		if (userNumber >= 1 && userNumber <= 10) { // base case
			return userNumber;
		} else { // recursive case
			System.out.println("Bad input.");
			return recursiveReadInRange();
		}
	}

	public static int iterativeReadInRange() {
		System.out.println("Enter a value between 1 and 10:");
		Scanner scan = new Scanner(System.in);
		int userNumber = scan.nextInt();
		while (userNumber < 1 || userNumber > 10) {
			System.out.println("Bad input.");
			System.out.println("Enter a value between 1 and 10:");
			userNumber = scan.nextInt();
		}
		return userNumber;
	}

	public static void printArrayReverse(int[] numbers) {
		printArrayReverseHelper(numbers, 0, numbers.length - 1);
	}

	private static void printArrayReverseHelper(int[] numbers, int first,
			int last) {
		if (first == last) {
			System.out.println(numbers[first]);
		} else {
			System.out.println(numbers[last]);
			printArrayReverseHelper(numbers, first, last - 1);
		}
	}

	public static void printArray(int[] numbers) {
		printArrayHelper(numbers, 0, numbers.length - 1);
	}

	private static void printArrayHelper(int[] numbers, int first, int last) {
		// base case
		if (first == last) {
			System.out.println(numbers[first]);
		} else { // recursive case
			System.out.println(numbers[first]);
			printArrayHelper(numbers, first + 1, last); // moving us towards the
														// base case since first
														// is incremented
		}
	}

	// we assume this method is invoked with a non-negative number
	public static void recursiveCountDown(int n) {
		// base case
		if (n == 0) {
			System.out.println(n + "... Blast off!");
		} else {
			// recursive case- should reduce problem size and move us towards
			// the base case
			System.out.print(n + " "); // solve a small part now
			recursiveCountDown(n - 1); // reduced problem size that i'm passing
										// to solve later
		}
	}

	public static void iterativeCountDown(int n) {
		while (n > 0) {
			System.out.println(n);
			n--;
		}
		System.out.println(n + " ... Blast off!");
	}
	
	public static void countUp(int upTo) {
		if(upTo > 1) {
			countUp(upTo - 1);
		}
		System.out.print(upTo + " ");
	}
	
	public static void printArr(int[] arr, int index) {
		if(index < arr.length) {
			System.out.print(arr[index] + " ");
			printArr(arr, index + 1);
		}
	}

	public static int recFatorial1(int x) {
		if(x > 1) {
			System.out.println(x + " ");
			return x * recFactorial2(x - 1);
		} else {
			return 1;
		}
	}
	
	
}
