package org.bwillard.ccsf.course.cs111c.test2prep;

import org.bwillard.ccsf.course.cs111c.homework8.SortedLinkedList;
import org.bwillard.ccsf.course.cs111c.homework8.SortedListInterface;


public class Test2 {

	public static void main(String[] args) {
		countUpByInterval(13, 4);
		countUpByInterval(12, 2);
		countUpByInterval(5, 1);
		
		int[] a = {5, 2, 3, 6, 5, 1, 8};
		int n = countOddsInRange(a, 1, 4);// n stores 2
		int m = countOddsInRange(a, 0, 6);// m stores 4
		System.out.print("n should be 2 : " + n + "\n");
		System.out.print("m should be 4 : " + m + "\n");
		
		Node<Integer> node = new Test2().new Node<Integer>(-4);
		node.next = new Test2().new Node<Integer>(4);
		node.next.next = new Test2().new Node<Integer>(-5);
		node.next.next.next = new Test2().new Node<Integer>(1);
		node.next.next.next.next = new Test2().new Node<Integer>(-9);
		node.next.next.next.next.next = new Test2().new Node<Integer>(3);
		node.next.next.next.next.next.next = new Test2().new Node<Integer>(9);
		System.out.println("countPostive should be 4 : " + countPositive(node));
		
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
		
		System.out.println("countInRange should be 5 : " + countInRange(sList1, 3, 5));
		System.out.println(71%5);
	}
	
	public static void countUpByInterval(int stoppingPoint, int interval) {
		countUpByIntervalHelper(stoppingPoint, interval, 1);
		System.out.println();
	}
	private static void countUpByIntervalHelper(int stoppingPoint, int interval, int start) {
		if(start <= stoppingPoint) {
			System.out.print(start + " ");
			countUpByIntervalHelper(stoppingPoint, interval, start + interval);
		}
	}
	
	
	public static int countOddsInRange(int[] numbers, int start, int end) {
		if(start <= end) {
			if(numbers[start] == 1 || numbers[start] % 2 == 1) {
				return 1 + countOddsInRange(numbers, start + 1, end);
			} else {
				return countOddsInRange(numbers, start + 1, end);
			}
		} 
		return 0;
	}
	
	public static int countPositive (Node<Integer> node) {
		Node<Integer> current = node;
		if(current != null) {
			if(current.data > 0) {
				return 1 + countPositive(current.next);
			} else {
				return countPositive(current.next);
			}
		} else 
			return 0;
	}
	
	public static int countInRange(SortedListInterface<Integer> sList, int lowValue, int highValue) {
		int count = 0;
        if(sList == null || sList.getLength() == 0 || lowValue < 1 || highValue < 1) {
            return 0;
        } else {
            for(int index = 1; index < sList.getLength(); index++) {
            	Integer entry = sList.getEntry(index);
            	if(entry < lowValue) { 
            		continue;
            	} else if(entry > highValue) {
            		break;
            	} else if(entry >= lowValue && entry <= highValue) {
                	count++;
                }
            }
        }
        return count;
	}
	
	private class Node<T> {
		private T data; // Entry in list
		private Node next; // Link to next node

		private Node(T dataPortion) {
			data = dataPortion;
			next = null;
		} // end constructor

		private Node(T dataPortion, Node nextNode) {
			data = dataPortion;
			next = nextNode;
		} // end constructor
	} // end Node
}
