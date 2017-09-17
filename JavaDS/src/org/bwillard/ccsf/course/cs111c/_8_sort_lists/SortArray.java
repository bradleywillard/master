package org.bwillard.ccsf.course.cs111c._8_sort_lists;

public class SortArray {
	
	private static int MIN_SIZE = 5;

	public static void main(String[] args) {
		Integer[] myArr = {8, 1, 5, 2, 7, 6, 3, 9, 4};
		selectionSort(myArr, myArr.length);
		System.out.print(myArr);
	}

	public static <T extends Comparable<? super T>> void selectionSort(T[] a, int n) {
		
		for(int index = 0; index < n - 1; index++) {
			int indexOfNextSmallest = getIndexOfSmallest(a, index, n - 1);
			swap(a, index, indexOfNextSmallest);
		}
	}
	
	private static <T extends Comparable<? super T>> int getIndexOfSmallest(T[] a, int first, int last) {
		T min = a[first];
		int indexOfMin = first;
		for(int index = first + 1; index <= last; index++) {
			if(a[index].compareTo(min) < 0) {
				min = a[index];
				indexOfMin = index;
			}
		}
		return indexOfMin;
	}

	private static void swap(Object[] a, int i, int j) {
		Object temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	
	public static <T extends Comparable<? super T>> void insertionSort(T[] a, int first, int last) {
		if(first < last) {
			insertionSort(a, first, last -1);
			//insertInOrder(a[last], a, first, last - 1);
		}
	}
	
	/*private <T> void insertInOrder(T item, int a, int first, int last) {
		T nodeToInsert = item;
		Node currentNode = firstNode;
		Node previousNode = null;
		
		while(currentNode != null && item.compareTo(currentNode.getData()) > 0) {
			previousNode = currentNode;
			currentNode = currentNode.getNextNode();
		}
		
		if(previousNode != null) {
			previousNode.setNextNode(nodeToInsert);
			nodeToInsert.setNextNode(currentNode);
		} else {
			nodeToInsert.setNextNode(firstNode);
			firstNode = nodeToInsert;
		}
	}*/
	
	public static <T extends Comparable<? super T>> void quickSort(T[] a, int first, int last) {
		
		if(last - first + 1 < MIN_SIZE) {
			insertionSort(a, first, last);
		} else {
			int pivotIndex = partition(a, first, last);
			
			quickSort(a, first, pivotIndex - 1);
			quickSort(a, pivotIndex + 1, last);
		}
	}
	
	private static <T extends Comparable<? super T>> void sortFirstMiddleLast(T[] a, int first, int mid, int last) {
		order(a, first, mid);
		order(a, mid, last);
		order(a, first, mid);
	}
	
	private static <T extends Comparable<? super T>> void order(T[] a, int i, int j) {
		if(a[i].compareTo(a[j]) > 0) {
			swap(a, i, j);
		}
	}
	
	private static <T extends Comparable<? super T>> int partition(T[] a, int first, int last) {
		int mid = (first + last) / 2;
		sortFirstMiddleLast(a, first, mid, last);
		
		swap(a, mid, last -1);
		int pivotIndex = last - 1;
		T pivot = a[pivotIndex];
		
		int indexFromLeft = first + 1;
		int indexFromRight = last - 2;
		
		boolean done = false;
		while(!done) {
			while(a[indexFromLeft].compareTo(pivot) < 0) {
				indexFromLeft++;
			}
			
			while(a[indexFromRight].compareTo(pivot) > 0) {
				indexFromRight--;
			}
			
			assert a[indexFromLeft].compareTo(pivot) >= 0 &&
					a[indexFromRight].compareTo(pivot) <= 0;
			
			if(indexFromLeft < indexFromRight) {
				swap(a, indexFromLeft, indexFromRight);
				indexFromLeft++;
				indexFromRight--;
			} else {
				done = true;
			}
			
		}
		swap(a, pivotIndex, indexFromLeft);
		pivotIndex = indexFromLeft;
		
		return pivotIndex;
	}
	
	public boolean isSorted(Comparable[] array) {
		if(array == null && array.length == 0)
			return false;
		else if(array.length == 1) {
			return true;
		}
		
		for(int i = 0; i < array.length - 1; i++) {
			if(array[i].compareTo(array[i + 1] ) > 0) {
				return false;
			}       
		}
		
		return true;
	}
	
}
