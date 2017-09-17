package org.bwillard.ccsf.course.cs111c.homework6;

import java.util.*;

import org.bwillard.ccsf.course.cs111c._3_array_bags.ArrayBag;
import org.bwillard.ccsf.course.cs111c._3_array_bags.BagInterface;
import org.bwillard.ccsf.course.cs111c._4_linked_nodes.LinkedBag;

public class Homework06Driver {

	public static void main(String[] args) {


		// Q1 and Q2
		String s = "stressed";
		System.out.print(s + " backwards is ");
		printBackwards1(s);
		System.out.println();
		System.out.print(s + " backwards is still ");
		printBackwards2(s);
		System.out.println();
		
		
		// Q3
		String p = "radar";
		System.out.println(p + " is a palindrome? " + isPalindrome(p));
		p = "anna";
		System.out.println(p + " is a palindrome? " + isPalindrome(p));
		p = "brad";
		System.out.println(p + " is a palindrome? " + isPalindrome(p));
		p = "ana";
		System.out.println(p + " is a palindrome? " + isPalindrome(p));
		p = "a";
		System.out.println(p + " is a palindrome? " + isPalindrome(p));
		p = "amanaplanacanalpanama";
		System.out.println(p + " is a palindrome? " + isPalindrome(p));
		p = "ababb";
		System.out.println(p + " is a palindrome? " + isPalindrome(p));
		p = "ab";
		System.out.println(p + " is a palindrome? " + isPalindrome(p));
		

		// Q4
		int arraySize = 10;
		int[] numsToSum = new int[arraySize];
		for (int i = 0; i < arraySize; i++)
			numsToSum[i] = i * 3;

		int sum1 = sumArray1(numsToSum, 0, arraySize - 1);
		int sum2 = sumArray2(numsToSum, 0, arraySize - 1);
		System.out.println("The sum of the array with all three methods should be the same: ");
		System.out.println(sum1);
		System.out.println(sum2);
		
		arraySize = 9;
		numsToSum = new int[arraySize];
		for (int i = 0; i < arraySize; i++)
			numsToSum[i] = i * 3;
		sum1 = sumArray1(numsToSum, 0, arraySize - 1);
		sum2 = sumArray2(numsToSum, 0, arraySize - 1);
		System.out.println("The sum of the array with all three methods should be the same: ");
		System.out.println(sum1);
		System.out.println(sum2);
		
		int[] numsToSum2 = {2, 8, 12, 15, 23, 5, 16, 69, 27};//177
		
		int sum3 = sumArray1(numsToSum2, 0, numsToSum2.length - 1);
		int sum4 = sumArray2(numsToSum2, 0, numsToSum2.length - 1);
		System.out.println("The sum of the array with all three methods should be the same: ");
		System.out.println(sum3);
		System.out.println(sum4);
		
		// Q5
		int[] randomNums = new int[arraySize];
		Random generator = new Random();
		for(int i=0; i<randomNums.length; i++) {
			randomNums[i] = generator.nextInt(100);
		}
		System.out.print("Here are the numbers in the array:\t");
		for(int i=0; i<randomNums.length; i++) {
			System.out.print(randomNums[i] + "  ");
		}
		System.out.println();
		int smallest = findSmallest(randomNums);
		System.out.println("The smallest element is " + smallest);
		
		smallest = findSmallest(null);
		System.out.println("The smallest element is (null) " + smallest);

		// Note: you need to use a revised ArrayBag and LinkedBag classes to test these methods
		// Q8
		ArrayBag<Integer> numbersArrayBag = new ArrayBag<Integer>();
		numbersArrayBag.add(1);
		numbersArrayBag.add(2);
		numbersArrayBag.add(1);
		numbersArrayBag.add(4);
		numbersArrayBag.add(3);
		System.out.println("The bag contains[1, 2, 1, 4, 3] \n\t\t"	+ Arrays.toString(numbersArrayBag.toArray()));
		System.out.println("Should be 2: " + numbersArrayBag.getFrequencyOf(1));
		System.out.println("Should be 1: " + numbersArrayBag.getFrequencyOf(4));
		System.out.println("Should be 0: " + numbersArrayBag.getFrequencyOf(5));
		
		// Q9
		LinkedBag<Integer> numbersLinkedBag = new LinkedBag<Integer>();
		numbersLinkedBag.add(1);
		numbersLinkedBag.add(2);
		numbersLinkedBag.add(1);
		numbersLinkedBag.add(4);
		numbersLinkedBag.add(3);
		System.out.println("The bag contains[3, 4, 1, 2, 1] \n\t\t"	+ Arrays.toString(numbersLinkedBag.toArray()));
		System.out.println("Should be 2: " + numbersLinkedBag.getFrequencyOf(1));
		System.out.println("Should be 1: " + numbersLinkedBag.getFrequencyOf(4));
		System.out.println("Should be 0: " + numbersLinkedBag.getFrequencyOf(5));		
		
		// Q10
		// this is a private method- so you'll have to test it internally!
		
		// Q11- try it with both AList and LList!
		ListInterface<Integer> numbersList = new AList<Integer>(); // swap this out for an LList- your code should still work!
		numbersList.add(4);
		numbersList.add(1);
		numbersList.add(3);
		numbersList.add(2);
		numbersList.add(0);
		numbersList.add(9);
		
		System.out.println("Sum is 19: " + sumList(numbersList));
		
		//Extra Credit- try it with both ArrayBag and LinkedBag!
		BagInterface<Integer> numbersBag = new ArrayBag<Integer>(); // swap this out for LinekdBag- your code should still work!
		numbersBag.add(2);
		numbersBag.add(-1);
		numbersBag.add(3);
		numbersBag.add(5);
		numbersBag.add(-2);
		numbersBag.add(-4);
		numbersBag.add(1);
		System.out.println("The bag contains[2, -1, 3, 5, -2, -4, 1] \n\t\t"	+ Arrays.toString(numbersBag.toArray()));
		System.out.println("There are 4 positives: " + countPositives(numbersBag));
		System.out.println("The bag still contains  [2, -1, 3, 5, -2, -4, 1] \n\t\t\t"	+ Arrays.toString(numbersBag.toArray()));
		
		
		int[] array = {11, 4, 9, 5, 7, 6};
		int a = 1, b = 4;
		recMethod(array, a, b);
		
		
	}
	
	static void recMethod(int[] array, int a, int b) {
		if(b > a) {
			//print the array
			System.out.println(Arrays.toString(array));
			array[b] *= 2; 
			recMethod(array, a, b - 1);
			//print the array
			System.out.println(Arrays.toString(array));
		}
	}
	
	
	public static boolean isPalindrome(String s) {
		if(s != null && s.length() > 0) {
			int n = s.length();
			char first = s.charAt(0);
			char last = s.charAt(n - 1);
			if(first != last) {
				return false;
			//If string is only 1 or 2 characters and it also didn't pass the above test
			} else if(n == 1 || n == 2) {
				return true;
			} else {//Chop the first and last letters of the string and recurse
				return isPalindrome(s.substring(1, n - 1));
			}
		}
		return false;
	}
	
	public static void printBackwards1(String s) {
		if(s != null && s.length() > 0) {
			System.out.print(s.charAt(s.length() - 1));
			printBackwards1(s.substring(0, s.length() - 1));
		}
	}

	public static void printBackwards2(String s) {
		if(s != null && s.length() > 0) {
			printBackwards2(s.substring(1, s.length()));
			System.out.print(s.charAt(0));
		}
	}

	
	/*public static boolean isPalindrome(String s) {
		int n = s.length();
		int cycles = (n / 2);
		for (int i = 0; i < cycles; ++i) {
			char c1 = s.charAt(i);
			char c2 = s.charAt(n - i - 1);
			if (c1 != c2) {
		         return false;
		    }
		}

		return true;
	}*/

	/**
	 * This recursive approach sums from both ends and moves towards the middle.
	 * 
	 * @param array
	 * @param first
	 * @param last
	 * @return the sum of all the elements for the array
	 */
	public static int sumArray1(int[] array, int first, int last) {
		int sum = 0;
		if(array != null && array.length > 0) {
			if(first == last) {
				sum += array[first];
			} else if(array.length == 2 || last - first == 1) {
				sum += array[first] + array[last];
			} else {
				sum += array[first] + array[last];
				sum += sumArray1(array, first + 1, last - 1);
			}
		}
		return sum;
	}

	public static int sumArray2(int[] array, int first, int last) {
		if(array != null && array.length > 0)
			if (last == 0) {
		        return array[last];
			} else {
		        return array[last] + sumArray2(array, first, last - 1);
			}
		return 0;
	}

	public static int findSmallest(int[] numbers) {
		if(numbers != null && numbers.length > 0) {
			return findSmallestHelper(numbers, 0, numbers.length - 1);
		}
		//This should never happen
		return -111111111;//A very strange number that will hopefully call enough attn
	}

	private static int findSmallestHelper(int[] numbers, int first, int last) {
		if(numbers != null) {
			if(first == last) {
				return numbers[first];
			} 
			int contender = findSmallestHelper(numbers, first + 1, last);
			return contender < numbers[first] ? contender : numbers[first];
		}
		//This should never happen
		return -111111111;//A very strange number that will hopefully call enough attn
	}
	
	public static int sumList(ListInterface<Integer> list) {
		if(list != null && list.getLength() > 0) {
			int headItem = list.remove(1);
			return headItem + sumList(list);
		}
		return 0;
	}
	
	public static int countPositives(BagInterface<Integer> bag) {
		if(bag != null && !bag.isEmpty()) {
			//To keep the original bag in tact:
			//1) Remove each item from bag and put into bag2 and temp
			BagInterface<Integer> bag2 = new ArrayBag<Integer>(bag.getCurrentSize());
			BagInterface<Integer> temp = new ArrayBag<Integer>(bag.getCurrentSize());
			while(!bag.isEmpty()) {
				Integer integer = bag.remove();
				bag2.add(integer);
				temp.add(integer);
			}
			//2) When done, take everything out of temp and put back into bag
			while(!temp.isEmpty()) {
				bag.add(temp.remove());
			}
			return countPositivesHelper(bag2, 0);
		}
		return 0;
	}
	
	private static int countPositivesHelper(BagInterface<Integer> bag, int index) {
		if(!bag.isEmpty()) {
			Integer item = bag.remove();
			if(item > 0)
				return 1 + countPositivesHelper(bag, index + 1);
			else
				return countPositivesHelper(bag, index + 1);
		}
		return 0;
	}
	
	
}