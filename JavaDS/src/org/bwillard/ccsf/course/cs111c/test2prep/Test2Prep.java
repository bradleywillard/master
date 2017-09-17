package org.bwillard.ccsf.course.cs111c.test2prep;

import org.bwillard.ccsf.course.cs111c._8_sort_lists.SortedLinkedList;
import org.bwillard.ccsf.course.cs111c._8_sort_lists.SortedListInterface;



public class Test2Prep {

	public static void main(String[] args) {
		System.out.println(recMethod1(5, 1));// Expect 4
		System.out.println(recFactorial1(4));// Expect 432124
		System.out.println(recFactorial2(4));// Expect 23424
		int[] a = {6, 2, 4, 6, 2, 1, 6, 2, 5};
		System.out.println(recMethod2(a, 2, 0));// Expect 3
		System.out.println(recMethod2(a, 2, 9));// Expect 0
		
		System.out.println(isEvenNumber(4));
		System.out.println(isEvenNumber(3));
		System.out.println("char b occured " + charOccurrenceCount("bradibobadibo", 'b', 0) + " x's");
		Node n1 = new Test2Prep().new Node(new Object());
		n1.next = new Test2Prep().new Node(new Object());
		n1.next.next = new Test2Prep().new Node(new Object());
		n1.next.next.next = new Test2Prep().new Node(new Object());
		System.out.println("node count should be 4 : " + nodeCount(n1));
		Node n2 = new Test2Prep().new Node(new Object());
		System.out.println("node count should be 1 : " + nodeCount(n2));
		Node n3 = null;
		System.out.println("node count should be 0 : " + nodeCount(n3));
		
		int[] array = {23, 2, 3, 45, 5, 7, 21, 0, 1, 71, 8, 9, 12, 14};
		System.out.println("number of items in array that are greater than 10 should be 6 : " + numGreaterThanKey(array, 10));
		
		String arr[] = {"A", "D", "H", "M", "X", "Y"};
		System.out.println("String M found at index : " + binarySearch(arr, "M", 0, arr.length - 1));
		System.out.println("String P found at index : " + binarySearch(arr, "P", 0, arr.length - 1));
		System.out.println("String A found at index : " + binarySearch(arr, "A", 0, arr.length - 1));
		
		System.out.println(hashcode());
		
		System.out.println(1/2);
		
		SortedListInterface<String> list1 = new SortedLinkedList<String>();
		list1.add("Brad");
		list1.add("Bartholomew");
		list1.add("Lina");
		list1.add("Alec");
		list1.add("Dylan");
		SortedListInterface<String> list2 = new SortedLinkedList<String>();
		list2.add("Barney");
		list2.add("Lynette");
		list2.add("Alex");
		list2.add("Dillon");
		SortedListInterface<String> mergedList = mergeLists(list1, list2);
		System.out.println();
		System.out.print("mergedList should be \n"
				+ "Alec, Alex, Barney, Bartholomew, Brad, Dillon, Dylan, Lina, Lynette \n");
		for(int i = 1; i <= mergedList.getLength(); i++) {
			System.out.print(mergedList.getEntry(i)+", ");
		}
		System.out.println("\n");
		
		SortedListInterface<String> sList = new SortedLinkedList<String>();
		sList.add("bird");//bird
		sList.add("bear");//bear, bird
		sList.add("hamster");//bear, bird, hamster
		sList.add("goat");//bear, bird, goat, hamster
		System.out.println("hamster : " + sList.getPosition("hamster"));//4
		System.out.println("zebra : " + sList.getPosition("zebra"));//-5
		sList.remove("bear");//bird, goat, hamster
		sList.add("zebra");//bird, goat, hamster, zebra
		System.out.println("zebra position : " + sList.getPosition("zebra"));//4
		System.out.println("bear position : " + sList.getPosition("bear"));//-5
		System.out.println();
		
		System.out.println("B occurs " + countSameFirstLetter(mergedList, "Brad") + " x's");
		System.out.println("D occurs " + countSameFirstLetter(mergedList, "Dylan") + " x's");

		SortedListInterface sList1 = new SortedLinkedList();
		sList1.add(11);
		sList1.add(1);
		sList1.add(5);
		sList1.add(3);
		sList1.add(5);
		sList1.add(4);
		sList1.add(5);
		sList1.add(2);
		sList1.add(10);
		sList1.add(11);
		System.out.println("number of times 5 occurs should be 3 : " + numberOfTimes(sList1, 5));
		System.out.println("number of times 11 occurs should be 2 : " + numberOfTimes(sList1, 11));
		System.out.println("number of times 7 occurs should be 0 : " + numberOfTimes(sList1, 7));
		
		Comparable[] intArr = {4,5,6,3,2,9,1,0,2,4,3,1,9};
		selectionSort(intArr);
		for(int i = 0; i < intArr.length; i++) {
			System.out.print(intArr[i] + ", ");
		}

	}

	static void selectionSort(Comparable[] arr) {
		for(int index = 0; index < arr.length; index++) {
			Comparable currentMin = arr[index];
			int indexOfMin = index;
			for(int j = index + 1; j < arr.length; j++){
				if(currentMin.compareTo(arr[j]) > 0) {
					currentMin = arr[j];
					indexOfMin = j;
				}
			}
			Comparable temp = arr[index];
			arr[index] = arr[indexOfMin];
			arr[indexOfMin] = temp;
		}
	}
	
	
	/*int size = 0, i = 1, j = 1;
	if(sList1.getLength() > sList2.getLength()) {
		size = sList1.getLength();
	} else {
		size = sList2.getLength();
	}
	for(int index = 0; index < (size * 2); index++) {
		String itemToAdd = null;
		String iEntry = sList1.getEntry(i);
		String jEntry = sList2.getEntry(j);
		if(iEntry != null) {
			if(jEntry != null) {
				if(iEntry.compareTo(jEntry) < 0) {
					itemToAdd = iEntry;
					i++;
				} else {
					itemToAdd = jEntry;
					j++;
				}
			} else {
				itemToAdd = iEntry;
			}
		} else if(jEntry != null) {
			itemToAdd = jEntry;
		}
		newList.add(itemToAdd);
	}*/
	
	public static int numberOfTimes(SortedListInterface<Integer> sList, Integer num) {
		int count = 0;
		if(sList == null || sList.getLength() == 0 || num == null) {
			return 0;
		} else {
			int index = sList.getPosition(num);
			while(index > 0 && index <= sList.getLength()) {
				if(num.compareTo(sList.getEntry(index)) == 0)
					count++;
				else if(num.compareTo(sList.getEntry(index)) < 0) {
					return count;
				}
				index++;
			}
		}
		return count;
	}
	
	public static int countSameFirstLetter(SortedListInterface<String> sList, String word) {
		if(sList == null || sList.getLength() == 0 || word == null || word.length() == 0) {
			return 0;
		}
		int count = 0;
		Character wordFirstLetter = word.charAt(0);
		for(int i = 1; i <= sList.getLength(); i++) {
			Character firstLetter = sList.getEntry(i).charAt(0);
			if(wordFirstLetter.compareTo(firstLetter) == 0) {
				count++;
			} else if(wordFirstLetter.compareTo(firstLetter) < 0) {
				return count;
			}
		} 
		return count;
	}
	
	public static SortedListInterface mergeLists(
			SortedListInterface<String> sList1, SortedListInterface<String> sList2) {
		SortedListInterface<String> newList = new SortedLinkedList<String>();
		for(int i = 1; i <= sList1.getLength(); i++) {
			newList.add(sList1.getEntry(i));
		}
		for(int i = 1; i <= sList2.getLength(); i++) {
			newList.add(sList2.getEntry(i));
		}
		
		return newList;
	}
	
	
	static int hashcode() {
		String phoneNumber = "415-555-1212";
		String suffix = phoneNumber.substring(phoneNumber.lastIndexOf("-") + 1);
		return Integer.parseInt(suffix);
	}
	
	static int binarySearch(String[] arr, String target, int first, int last) {
		int mid = (first + last) / 2;
		
		if(first <= last) {
			if(target.compareTo(arr[mid]) == 0) {
				return mid;
			} else if(target.compareTo(arr[mid]) > 0) {
				return binarySearch(arr, target, mid + 1, last);
			} else {
				return binarySearch(arr, target, first, mid - 1);
			}
		} else {
			return -1;
		}
	}
	
	static int recMethod1(int x, int y) {
		if (x == y)
			return 0;
		else
			return recMethod1(x - 1, y) + 1;
	}

	static int recFactorial1(int x) {
		System.out.print(x);
		if (x > 1)
			return x * recFactorial1(x - 1);
		else
			return 1;
	}

	static int recFactorial2(int x) {
		if (x > 1) {
			int fac = x * recFactorial2(x - 1);
			System.out.print(x);
			return fac;
		} else
			return 1;
	}

	static int recMethod2(int[] arr, int b, int j) {
		if (j < arr.length)
			if (arr[j] != b)
				return recMethod2(arr, b, j + 1);
			else
				return 1 + recMethod2(arr, b, j + 1);
		else
			return 0;
	}

	/*
	 * Write a complete recursive method to take a positive integer parameter 
	 * and return true if the integer is even and false if the integer is odd
	 */
	static boolean isEvenNumber(int number) {
		if (number < 0 || number % 2 == 1) {
			return false;
		} else {
			return isEvenNumber(number - 1);
		}
	}
	
	/*
	 * Write a complete recursive method to take three parameters (a String, a 
	 * character, and an initial index) and return the number of times the 
	 * character appears in the string (starting at the initial index)
	 */
	static int charOccurrenceCount(String s, char c, int startIndex) {
		if(startIndex == s.length()) {
			return 0;
		} else {
			if(s.charAt(startIndex) == c) {
				return 1 + charOccurrenceCount(s, c, startIndex + 1);
			} else {
				return charOccurrenceCount(s, c, startIndex + 1);
			}
		}
	}
	
	/*
	 * Write a complete recursive method to take one Node parameter that represents 
	 * the head of a list and returns a count for how many elements are in the chain
	 */
	static int nodeCount(Node node) {
		Node current = node;
		if(current == null) {
			return 0;
		} else if(current.next == null) {
			return 1;
		} else {
			return 1 + nodeCount(current.next);
		}
	}
	
	/*
	 * Write a complete recursive method to take an array of integers and an integer 
	 * key and return the number of elements in the array that are greater than the key
	 */
	static int numGreaterThanKey(int[] array, int key) {
		return numGreaterThanKey(array, key, 0);
	}
	static int numGreaterThanKey(int[] array, int key, int index) {
		if(index == array.length) {
			return 0;
		} else if(array[index] > key) {
			return 1 + numGreaterThanKey(array, key, index + 1);
		} else {
			return numGreaterThanKey(array, key, index + 1);
		}
	}
	
	
	private class Node {
		private Object data; // Entry in list
		private Node next; // Link to next node

		private Node(Object dataPortion) {
			data = dataPortion;
			next = null;
		} // end constructor

		private Node(Object dataPortion, Node nextNode) {
			data = dataPortion;
			next = nextNode;
		} // end constructor

		private Object getData() {
			return data;
		} // end getData

		private void setData(Object newData) {
			data = newData;
		} // end setData

		private Node getNextNode() {
			return next;
		} // end getNextNode

		private void setNextNode(Node nextNode) {
			next = nextNode;
		} // end setNextNode
	} // end Node
}
