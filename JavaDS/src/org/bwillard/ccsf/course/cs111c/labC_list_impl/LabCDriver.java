package org.bwillard.ccsf.course.cs111c.labC_list_impl;

import java.util.Random;

public class LabCDriver {

	private static final String LINE_SEPARATOR = "-----------------------------------------------";

	public static void main(String[] args) {
		// setting up Nodes to test
		System.out.println("TESTING ENTRIES");

		//Will test this at the end...
		boolean concernedAboutCapacity = true;
		EntryWayListImpl<Integer> list = new EntryWayListImpl<Integer>(concernedAboutCapacity);
		
		// 01 display an empty list
		System.out.println(LINE_SEPARATOR);
		System.out.println("01 - display an empty list: ");
		System.out.print("Should print ()\n\t\t");
		list.display();
		
		// 02 add five entries to the list- some at the head and some at the tail
		System.out.println();
		System.out.println(LINE_SEPARATOR);
		System.out.println("02 - add five entries to the list... ");
		System.out.println("Some at the head: ");
		// adds to items to the head of the list 3 -> 5
		list.insertHead(5);
		list.insertHead(3);
		System.out.print("call display() after insertHead(5), insertHead(3): should print (3, 5)\n\t\t");
		list.display();
		System.out.println("Some at the tail: ");
		// adds to items to the head of the list 7 -> 4 to make 3 -> 5 -> 7 -> 4
		list.insertTail(7);
		list.insertTail(4);
		System.out.print("call display() before insertHead(9): should print (3, 5, 7, 4)\n\t\t");
		list.display();
		list.insertHead(9);
		System.out.print("call display() after insertHead(9): should print (9, 3, 5, 7, 4)\n\t\t");
		list.display();
		
		// 03 remove the first entry
		System.out.println();
		System.out.println(LINE_SEPARATOR);
		System.out.println("04 - remove the first entry");
		System.out.print("call display() before deleteHead(): should print (9, 3, 5, 7, 4)\n\t\t");
		list.display();
		list.deleteHead();
		System.out.print("call display() after deleteHead(): should print (3, 5, 7, 4)\n\t\t");
		list.display();
		
		// 04 remove the last entry
		System.out.println();
		System.out.println(LINE_SEPARATOR);
		System.out.println("04 - remove the last entry");
		System.out.print("call display() before deleteTail(): should print (3, 5, 7, 4)\n\t\t");
		list.display();
		Integer deleted = list.deleteTail();
		System.out.println("deleteTail() should return 4 : " + deleted);
		System.out.print("call display() after deleteTail(): should print (3, 5, 7)\n\t\t");
		list.display();
		
		// 05 test to see if elements are in the list 
		System.out.println();
		System.out.println(LINE_SEPARATOR);
		System.out.println("05 - test to see if elements are in the list");
		System.out.println("contains(3) should return 1 : " + list.contains(3));
		System.out.println("contains(5) should return 2 : " + list.contains(5));
		System.out.println("contains(7) should return 3 : " + list.contains(7));
		System.out.println("05 - these elements should NOT be in the list");
		System.out.println("contains(8) should return -1 : " + list.contains(8));
		System.out.println("contains(1) should return -1 : " + list.contains(1));
		System.out.println("contains(-1) should return -1 : " + list.contains(-1));
		
		// 06 remove the last three elements in the list
		System.out.println();
		System.out.println(LINE_SEPARATOR);
		System.out.println("06 - remove the last three elements in the list");
		System.out.println("Adding 3 more elements to the list first just for fun: 8, 2, 0");
		System.out.print("call display() after insertHead(8), insertTail(2), insertHead(0):\nshould print (0, 8, 3, 5, 7, 2)\n\t\t");
		list.insertHead(8);
		list.insertTail(2);
		list.insertHead(0);
		list.display();
		System.out.println("Now remove the last 3 items from the list: ");
		list.deleteTail();
		list.deleteTail();
		list.deleteTail();
		System.out.print("call display() after calling deleteTail() 3 x's :\nshould print (0, 8, 3)\n\t\t");
		list.display();
		
		// 07 try to remove an element from the empty list
		System.out.println();
		System.out.println(LINE_SEPARATOR);
		System.out.println("07 try to remove an element from the empty list");
		System.out.println("First, clear the list so it's empty");
		while(!list.isEmpty()) {
			list.deleteHead();
		}
		System.out.print("call display() to check if list is empty. Should print ()\n\t\t");
		list.display();
		
		System.out.println(LINE_SEPARATOR);
		System.out.println("Now try to remove an element from the empty list\n"
				+ "using both deleteHead() and deleteTail()");
		try{
			list.deleteHead();
			list.deleteTail();
		} catch(Exception e) {
			System.out.print("Problem occurred while trying to "
					+ "deleteHead() or deleteTail() from an empty list ");
			e.printStackTrace();
		}
		System.out.println("Call display() to see what happens...");
		list.display();
		

		if(list.isConcernedAboutCapacity()) {
			System.out.println();
			System.out.println(LINE_SEPARATOR);
			System.out.println("isConcernedAboutCapacity() is : " + list.isConcernedAboutCapacity());
			System.out.println("Try to add more than MAX_CAPACITY items to the list");
			Random random = new Random();
			for(int i = 0; i < list.getMaxCapacity() + 10; i++) {
				list.insertTail(random.nextInt(100));
			}
			System.out.println("Try adding a few more items to see if it works: ");
			list.insertHead(random.nextInt(100));
			list.insertTail(random.nextInt(100));
			list.insertTail(random.nextInt(100));
			System.out.println("MAX_CAPACITY is: " + list.getMaxCapacity());
			System.out.println("Number of entries is: " + list.getNumberOfEntries());
			if(list.getMaxCapacity() == list.getNumberOfEntries()) {
				System.out.println("We're good!");
			} else {
				System.out.println("Something went wrong!");
			}
			
			long n = 100;
			
			//Algorithm A
			long startTime = System.currentTimeMillis();
			long sum = 0;
			for(long i = 1; i <= n; i++) {
				sum = sum + i;
				System.out.print(sum + ",");
			}
			long endTime = System.currentTimeMillis() - startTime;
			System.out.println(sum + " in " + endTime + "ms");
			
			//Algorithm B
			startTime = System.currentTimeMillis();
			sum = 0;
			for(long i = 1; i <= n; i++){
				for(long j = 1; j <= i; j++) {
					sum = sum + 1;
				}
			}
			endTime = System.currentTimeMillis() - startTime;
			System.out.println(sum + " in " + endTime + "ms");
			
			//Algorithm C
			startTime = System.currentTimeMillis();
			sum = n * (n + 1)/2;
			endTime = System.currentTimeMillis() - startTime;
			System.out.println(sum + " in " + endTime + "ms");
		}
	}
}
