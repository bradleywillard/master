package org.bwillard.ccsf.course.cs111c._9_hash_tables;

import java.util.*;

public class HomeworkW9Driver {

	public static void main(String[] args) {
		Integer[] unsortedNumbers = { 1, 4, 3, 2, 6, 7, 2, 4};
		Integer[] sortedNumbers = Arrays.copyOf(unsortedNumbers,
				unsortedNumbers.length);
		Arrays.sort(sortedNumbers);

		// Q7: recursive linear search on unsorted data
		System.out.println("Q7");
		System.out.println("contains 2 (true): "
				+ searchRecursiveLinearFromLast(unsortedNumbers, 2));
		System.out.println("contains 4 (true): "
				+ searchRecursiveLinearFromLast(unsortedNumbers, 4));
		System.out.println("contains 8 (false): "
				+ searchRecursiveLinearFromLast(unsortedNumbers, 8));
		System.out.println("");

		// Q8: recursive linear search on sorted data
		// note: you might want to add additional print statements to make sure
		// that your method is not only returning the correct value, but also
		// taking advantage of the list being sorted
		System.out.println("Q8");
		System.out.println("contains 1 (true): "
				+ searchRecursiveLinearSorted(sortedNumbers, 1));
		System.out.println("contains 4 (true): "
				+ searchRecursiveLinearSorted(sortedNumbers, 4));
		System.out.println("contains 7 (true): "
				+ searchRecursiveLinearSorted(sortedNumbers, 7));
		System.out.println("contains 8 (false): "
				+ searchRecursiveLinearSorted(sortedNumbers, 8));
		System.out.println("");

		// Q9: return all indices of the target; recursive
		System.out.println("Q9");		
		ArrayList<Integer> indices;
		indices = findIndicesUnsorted(unsortedNumbers, new Integer(1));
		System.out.println("1 is at [0]: " + indices.toString());
		indices = findIndicesUnsorted(unsortedNumbers, new Integer(2));
		System.out.println("2 is at [3, 6]: " + indices.toString());
		indices = findIndicesUnsorted(unsortedNumbers, new Integer(4));
		System.out.println("4 is at [1, 7]: " + indices.toString());
		indices = findIndicesUnsorted(unsortedNumbers, new Integer(5));
		System.out.println("5 is at []: " + indices.toString());
		System.out.println("");
		
		// Q10: return all indices of the target; recursive and efficient on sorted data
		// note: the order of the indices does not matter
		System.out.println("Q10");	
		indices = findIndicesRecursiveSorted(sortedNumbers, new Integer(1));
		System.out.println("1 is at [0]: " + indices.toString());
		indices = findIndicesRecursiveSorted(sortedNumbers, new Integer(7));
		System.out.println("7 is at [7]: " + indices.toString());
		indices = findIndicesRecursiveSorted(sortedNumbers, new Integer(2));		
		System.out.println("2 is at [1, 2]: " + indices.toString());
		indices = findIndicesRecursiveSorted(sortedNumbers, new Integer(4));
		System.out.println("4 is at [4, 5]: " + indices.toString());
		indices = findIndicesRecursiveSorted(sortedNumbers, new Integer(5));
		System.out.println("5 is at []: " + indices.toString());
		System.out.println("");
		
	}

	// Q7
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


	// Q8
	public static boolean searchRecursiveLinearSorted(Comparable[] array, Comparable target) {
		if(array == null || array.length == 0 && target == null) {
			return false;
		}
		return searchRecursiveLinearSortedHelper(array, target, 0, array.length - 1);
	}
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private static boolean searchRecursiveLinearSortedHelper(
			Comparable[] array, Comparable target, int index, int length) {
		
		if(target.compareTo(array[index]) == 0) {
			return true;
		} else if(target.compareTo(array[index]) > 0 && index < length) {
			return searchRecursiveLinearSortedHelper(array, target, index + 1, length);
		} else {
			return false;
		}		
	}
	
	/*private static boolean searchRecursiveLinearSortedHelper(Comparable[] array, Comparable target, int first, int last) {
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
	}*/

	// Q9
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
		
		//Base case... 
		if(first > last) {
			return list;
		} 

		int mid = (first + last) / 2;
		if (target.compareTo(array[mid]) == 0) {
			list.add(mid);
			if(mid + 1 < array.length && target.compareTo(array[mid + 1]) == 0)
				
			if(mid - 1 >= 0 && target.compareTo(array[mid - 1]) == 0)
				return findIndecesRecursiveSortedHelper(array, target, first - 1, last, list);
			return findIndecesRecursiveSortedHelper(array, target, first + 1, last, list);
		} else if(target.compareTo(array[mid]) > 0) {
			return findIndecesRecursiveSortedHelper(array, target, mid + 1, last, list); 
		} else if(target.compareTo(array[mid]) < 0) {
			return findIndecesRecursiveSortedHelper(array, target, first, mid - 1, list); 
		} 
		return null;
		
	}

	

}

