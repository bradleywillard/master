package org.bwillard.ccsf.course.cs111c.homework5;

import java.util.*;


public class EfficiencyExamples {

	public static void main(String[] args) {
		int arraySize = 1000000;
		int[] numbers = new int[arraySize];
		fillArray(numbers);
	//	System.out.println(Arrays.toString(numbers));

		
		// invoking and timing the getMiddleValue method
		Date currentTime = new Date();
		long startTime = currentTime.getTime();
		System.out.println("What's the middle value? " + getMiddleValue(numbers));
		currentTime = new Date();
		long endTime = currentTime.getTime();
		long elapsedTime = endTime - startTime;
		System.out.println("Constant algorithm ran in " + elapsedTime + " milliseconds.\n");
		
		currentTime = new Date();
		startTime = currentTime.getTime();
		System.out.println("What's the sum? " + calculateSum(numbers));
		currentTime = new Date();
		endTime = currentTime.getTime();
		elapsedTime = endTime - startTime;
		System.out.println("Linear algorithm ran in " + elapsedTime + " milliseconds.\n");
		
		currentTime = new Date();
		startTime = currentTime.getTime();
		System.out.println("Contains a duplicate? " + containsDuplicates(numbers));
		currentTime = new Date();
		endTime = currentTime.getTime();
		elapsedTime = endTime - startTime;
		System.out.println("Quadratic algorithm ran in " + elapsedTime + " milliseconds.\n");
		
	}
	
	// O(1)- running time is NOT dependent on n (which is the size of the array)
	// constant running time
	public static int getMiddleValue(int[] numbers) {
		int middleIndex = numbers.length/2;
		return numbers[middleIndex];
	}
	
	// O(n)- running time IS dependent on n in a linear way
	// as n increases, the running time increases linearly
	// the running time increases at the SAME RATE as you increase your problem size
	public static int calculateSum(int[] numbers) {
		int sum = 0;
		for(int i=0; i<numbers.length; i++) {
			sum += numbers[i];
		}
		
		/*
		 * consecutive loops do not change the efficiency
		int product = 1;
		for(int i=0; i<numbers.length; i++) {
			product *= numbers[i];
		}
		System.out.println(product);
		*/
		return sum;
	}
	
	// O(n^2)
	// (n- outer loop) * (~n- inner loop)
	// the running time is dependent on n- it increases as n increases
	// but it increases FASTER than linearly
	// if our problem size doubles (x2), the running time quadruples (x4 = 2^2)
	// our running time increases FASTER than we increase our problem size
	public static boolean containsDuplicates(int[] numbers) {
		boolean containsDup = false;
		for(int i=0; i<numbers.length; i++) { // loop is dependent on the size of the array
			int currentNumber = numbers[i];
			
			for(int j=i+1; j<numbers.length; j++) {
				if(currentNumber == numbers[j]) {  // loop is dependent on the size of the array
					containsDup = true;
				}
			}
		}
		return containsDup;
	}

	private static void fillArray(int[] numbers) {
		Random generator = new Random();
		int maxNumber = numbers.length * 2;
		for(int i=0; i<numbers.length; i++) {
			numbers[i] = generator.nextInt(maxNumber);
		}
	}
	
}