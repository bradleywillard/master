package org.bwillard.ccsf.course.cs111c._8_sort_lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Homework08Driver {

	public static void main(String[] args) {
		
		LinkedGroup<Integer> lg = new LinkedGroup<Integer>();
		System.out.println(lg.toString());
		
		lg.firstNode = new Node<Comparable>(23);
		Node<Comparable> compareNode1 = new Node<Comparable>(21);
		lg.firstNode.setNextNode(compareNode1);
		Node<Comparable> compareNode2 = new Node<Comparable>(2);
		compareNode1.setNextNode(compareNode2);
		Node<Comparable> compareNode3 = new Node<Comparable>(19);
		compareNode2.setNextNode(compareNode3);
		Node<Comparable> compareNode4 = new Node<Comparable>(87);
		compareNode3.setNextNode(compareNode4);
		lg.length = 5;
		
		System.out.println("node compare is sorted: s/b false: " + lg.isSorted(lg.firstNode));
		lg.insertionSort();
		System.out.println("node compare is sorted: s/b true: " + lg.isSorted(lg.firstNode));
		
		
		lg.firstNode = new Node(4);
		Node next1 = new Node(2);
		lg.firstNode.setNextNode(next1);
		Node next2 = new Node(9);
		next1.setNextNode(next2);
		Node next3 = new Node(1);
		next2.setNextNode(next3);
		Node next4 = new Node(8);
		next3.setNextNode(next4);
		Node next5 = new Node(7);
		next4.setNextNode(next5);
		Node next6 = new Node(3);
		next5.setNextNode(next6);
		Node next7 = new Node(6);
		next6.setNextNode(next7);
		
		Node countNode = lg.firstNode;
		while(countNode != null) {
			lg.length++;
			countNode = countNode.next;
		}
		
		lg.insertionSort();
		Node current = lg.firstNode;
		while(current != null) {
			if(current.next == null)
				System.out.print(current.data);
			else
				System.out.print(current.data + ",");
			current = current.next;
		}
		
		Integer[] intArr = {26, 19, 21, 12, 4, 24, 9, 11};//{34, 3, 32, 1, 5, 55, 7, 98, 2, 73, 64, 122, 3, 88};
		for(int i = 0; i < intArr.length; i++) {
			if(i == intArr.length -1)
				System.out.print(intArr[i] + ",");
			else
				System.out.print(intArr[i] + ",");
		}
		SortArray sa = new SortArray();
		System.out.println("\nintArr should not be sorted: " + sa.isSorted(intArr));
		SortArray.quickSort(intArr, 0, intArr.length - 1);
		
		Arrays.sort(intArr);
		for(int i = 0; i < intArr.length; i++) {
			if(i == intArr.length -1)
				System.out.print(intArr[i] + ",");
			else
				System.out.print(intArr[i] + ",");
		}
		System.out.println("intArr should be sorted: " + sa.isSorted(intArr));
		
		SortedListInterface<Integer> sList = new SortedLinkedList<Integer>();
		sList.add(5);
		sList.add(9);
		sList.add(9);
		sList.add(7);
		sList.add(7);
		sList.add(9);
		sList.add(7);
		sList.add(5);
		sList.add(5);
		sList.add(5);
		sList.add(12);
		sList.add(2);
		System.out.println("Mode is: " + getMode(sList));
	}
	
	public static int getMode(SortedListInterface<Integer> sList) {
		int mode = 0, modeCount = 0;
		for(int position = 1; position <= sList.getLength(); position++) {
			int entryCount = 1;
			Integer current = sList.getEntry(position);
			int j;
			for(j = position; j < sList.getLength(); j++) {
				Integer nextInt = sList.getEntry(j + 1);
				if(current.compareTo(nextInt) == 0) {
					entryCount++;
				} else {
					break;
				}
			}
			System.out.println("current: " + current + ", count=" + entryCount);
			position = j;
			if(entryCount > modeCount) {
				mode = current;
				modeCount = entryCount;
			}
		}
		
		return mode;
	}

}
