package org.bwillard.ccsf.course.cs211s.assn7;

import java.util.*;

public class ArrayUtil {
	
	public static <T> ArrayList<T> findDuplicate(T[] array) {
		ArrayList<T> dupList = new ArrayList<>();
		for(int i=0; i<array.length-1; i++)  {
			T currentElement = array[i];
			for(int j=i+1; j<array.length; j++) {				
				if(currentElement.equals(array[j]) ){
					dupList.add(currentElement);
				}
			}
		}
		return dupList;
	}
	
	public static <T extends Comparable> Pair<T> findMinMax(T[] elements) {
		T min = elements[0];
		T max = elements[0];
		
		for(int i=0; i<elements.length; i++) {
			if(elements[i].compareTo(min) < 0) {
				min = elements[i];
			}
			if(elements[i].compareTo(max) > 0) {
				max = elements[i];
			}
		}
		Pair<T> minMax = new Pair<>(min, max);
		return minMax;
		
	}

	
	/*
	public static Pair<Integer> findMinMax(Integer[] numbers) {
		int min = numbers[0];
		int max = numbers[0];
		
		for(int i=0; i<numbers.length; i++) {
			if(min > numbers[i]) {
				min = numbers[i];
			}
			if(max < numbers[i]) {
				max = numbers[i];
			}
		}
		Pair<Integer> minMax = new Pair<>(min, max);
		return minMax;
		
	}
*/
}
