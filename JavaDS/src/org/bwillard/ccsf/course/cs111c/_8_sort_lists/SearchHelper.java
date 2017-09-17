package org.bwillard.ccsf.course.cs111c._8_sort_lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SearchHelper {
	
	public static int binarySearch(Integer[] numbers, int target) {
		int first = 0, last = numbers.length - 1;
		while(first <= last) {
			int mid = (first + last) / 2;
			if(numbers[mid] == target) {
				return mid;
			} else if (numbers[mid] < target) {
				first = mid + 1;
			} else {
				last = mid - 1;
			}
		}
		return -1;
	}
	
	public static Object binarySearch(Integer[] array, int first, int last, Integer target) {
		
		while(first <= last) {
			int mid = (first + last) / 2;
			if(target.compareTo(array[mid]) == 0) {
				return mid;
			} else if(target.compareTo(array[mid]) > 0) {
				return binarySearch(array, mid + 1, last, target);
			} else {
				return binarySearch(array, first, mid - 1, target);
			}
		}
		return null;
	}
	
	public int binarySearch(int[] numbers, int target) {
		int first = 0, last = numbers.length - 1;
		while(first <= last) {
			int mid = (first + last) / 2;
			if(numbers[mid] == target) {
				return mid;
			} else if(numbers[mid] < target) {
				first = mid + 1;
			} else {
				last = mid - 1;
			}
		}
		return -1;
	}
	
	public static boolean searchRecursiveLinearFromLast(Object[] array, Object target) {
		if(array == null || array.length == 0 || target == null) {
			return false;
		}
		return searchRecursiveLinearFromLastHelper(array, target, array.length - 1);
	}

	private static boolean searchRecursiveLinearFromLastHelper(Object[] array, Object target, int index) {
		if(index < array.length && index >= 0) {
			if(target.equals(array[index])) {
				return true;
			} else {
				return searchRecursiveLinearFromLastHelper(array, target, index - 1);
			}
		}
		return false;
	}
	
	public static boolean searchRecursiveLinearSorted(Comparable[] array, Comparable target) {
		if(array == null || array.length == 0 && target == null) {
			return false;
		}
		return searchRecursiveLinearSortedHelper(array, target, 0, array.length - 1);
	}
	
	private static boolean searchRecursiveLinearSortedHelper(Comparable[] array, Comparable target, int first, int last) {
		int mid = (first + last) / 2;
		if(first <= last) {
			if(target.compareTo(array[mid]) == 0) {
				return true;
			} else if(target.compareTo(array[mid]) > 0) {
				return searchRecursiveLinearSortedHelper(array, target, mid + 1, last);
			} else {
				return searchRecursiveLinearSortedHelper(array, target, first, mid - 1); 
			}
		} 
		
		return false;
	}
	
	
	public static ArrayList<Integer> findIndicesUnsorted(Object[] array, Object target) {
		if(array == null || array.length == 0 && target == null) {
			return null;
		} else {
			ArrayList<Integer> list = new ArrayList<Integer>();
			for(int i = 0; i < array.length; i++) {
				if(target.equals(array[i])) {
					list.add(i);
				}
			}
			return list;
		}
	}
	
	// Q10
		public static ArrayList<Integer> findIndicesRecursiveSorted(Comparable[] array, Comparable target) {
			if(array == null || array.length == 0 && target == null) {
				return null;
			} else {
				return findIndecesRecursiveSortedHelper(array, target, 0, array.length - 1, null);
			}
		}
		
		private static ArrayList<Integer> findIndecesRecursiveSortedHelper(
				Comparable[] array, Comparable target, int first, int last, ArrayList<Integer> list) {
			
			if(list == null) {
				list = new ArrayList<Integer>();
			}
			
			int mid = (first + last) / 2;
			
			//Base case... 
			if(first > last) {
				return list;
			}
			
			if(target.compareTo(array[first]) == 0) {
				list.add(first);
			}
			
			if(target.compareTo(array[mid]) > 0) {
				first = mid;
			} else if(target.compareTo(array[mid]) < 0) {
				last = mid - 1;
			} 
			
			first++;
			
			return findIndecesRecursiveSortedHelper(array, target, first, last, list); 
			
		}
	
	
	public static void main(String[] args) {
		//Integer[] nums = {5, 32, 23, 59, 9, 82, 98, 13, 7, 24, 6, 18, 87, 2, 4, 7, 5, 21};
		Integer[] nums = {3, 5, 8, 9, 12, 14, 18, 19, 21, 23, 24, 26};
		Arrays.sort(nums);
		for(int i = 0; i < nums.length; i++) {
			if(i == nums.length - 1)
				System.out.print(nums[i]);
			else
				System.out.print(nums[i] + ",");
		}
		System.out.println("\n" + binarySearch(nums, 24));
		
		System.out.println("\n" + binarySearch(nums, 0, nums.length -1, 5));
		
		System.out.println("\n" + binarySearch(nums, 15));
		
		Object[] array = {8, 9, 8, 3, 2, 1, 2, 6, 9, 9, 9};
		System.out.println("findIndicesUnsorted: should be [1, 8, 9, 10] - " + findIndicesUnsorted(array, 9));
		
		System.out.println("searchRecursiveLinearFromLast: should be false - " + searchRecursiveLinearFromLast(array, 10));
		System.out.println("searchRecursiveLinearFromLast: should be true - " + searchRecursiveLinearFromLast(array, 9));
		
		Integer[] intArray = {1, 2, 3, 5, 5, 8, 8, 8, 8, 13, 13, 13, 20, 20, 20, 40, 40, 40, 40, 40, 100};
		System.out.println("searchRecursiveLinearSorted: should be true - " + searchRecursiveLinearSorted(intArray, 13));
		System.out.println("searchRecursiveLinearSorted: should be true - " + searchRecursiveLinearSorted(intArray, 100));
		System.out.println("searchRecursiveLinearSorted: should be false - " + searchRecursiveLinearSorted(intArray, 41));
		
		System.out.println("findIndicesRecursiveSorted: should be [3, 4]" + findIndicesRecursiveSorted(intArray, 5));
		System.out.println("findIndicesRecursiveSorted: should be [5, 6, 7, 8]" + findIndicesRecursiveSorted(intArray, 8));
		System.out.println("findIndicesRecursiveSorted: should be [9, 10, 11]" + findIndicesRecursiveSorted(intArray, 13));
		System.out.println("findIndicesRecursiveSorted: should be [12, 13, 14]" + findIndicesRecursiveSorted(intArray, 20));
		System.out.println("findIndicesRecursiveSorted: should be [15, 16, 17, 18, 19]" + findIndicesRecursiveSorted(intArray, 40));
		System.out.println("findIndicesRecursiveSorted: should be [20]" + findIndicesRecursiveSorted(intArray, 100));
		
	}

}
