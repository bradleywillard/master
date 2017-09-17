package org.bwillard.ccsf.course.cs111c.labA_generics;

public class TrioTester {

	public static void main(String[] args) {
		
		Trio<Integer> trio1 = new Trio<Integer>(3, 4, 5);
		System.out.println("Should print a text representation:");
		System.out.println(trio1);
		System.out.println("Item 1 should be 3: " + trio1.getItem1());
		System.out.println("Item 2 should be 4: " + trio1.getItem2());
		System.out.println("Item 3 should be 5: " + trio1.getItem3());
		System.out.println("Contains 4? Should be true: " + trio1.contains(4));
		System.out.println("Contains 7? Should be false: " + trio1.contains(7));
		System.out.println("Items are the same? Should be false: " + trio1.sameItems());
		trio1.setItem1(6);
		trio1.setItem2(6);
		System.out.println("Item 1 should be 6: " + trio1.getItem1());
		System.out.println("Item 2 should be 6: " + trio1.getItem2());
		System.out.println("Items are the same? Should be false: " + trio1.sameItems());
		trio1.setItem3(6);
		System.out.println("Item 3 should be 6: " + trio1.getItem2());
		System.out.println("Items are the same? Should be true: " + trio1.sameItems());
		System.out.println();
		/* 
		 * un-comment the line of code below and it should cause a compiler error 
		 * because numberTrio1 should only accept Integers, not Strings
		 */
		//trio1.setItem1("hello");
		
		Trio<String> wordTrio = new Trio<String>("hello", "goodbye", "nice knowing you");
		System.out.println(wordTrio);
		System.out.println("Item 1 should be hello: " + wordTrio.getItem1());
		System.out.println("Item 2 should be goodbye: " + wordTrio.getItem2());
		System.out.println("Item 3 should be nice knowing you: " + wordTrio.getItem3());
		System.out.println("Contains hello? Should be true: " + wordTrio.contains("hello"));
		System.out.println("Contains hi? Should be false: " + wordTrio.contains("hi"));
		System.out.println("Items are the same? Should be false: " + wordTrio.sameItems());
		wordTrio.setItem2("hello");
		System.out.println("Items are the same? Should be false: " + wordTrio.sameItems());
		wordTrio.setItem3("hello");
		System.out.println("Items are the same? Should be true: " + wordTrio.sameItems());
		System.out.println();
		
		/* 
		 * un-comment the line of code below and it should cause a compiler error 
		 * because wordTrio should only accept Strings
		 */
		//wordTrio.setItem2(3);

		
		Trio<Integer> numberTrio2 = new Trio<Integer>(5, 6, 8);
		Trio<Integer> numberTrio3 = new Trio<Integer>(8, 5, 6);
		System.out.println("Trios the same? Should be true: " + numberTrio2.equals(numberTrio3));
		numberTrio2.setItem2(5);
		System.out.println("Trios the same? Should be false: " + numberTrio2.equals(numberTrio3));
		System.out.println("Trios the same? Should be false: " + numberTrio2.equals(wordTrio));
		System.out.println();
		Trio<Integer> numberTrio4 = new Trio<Integer>(1, 1, 2);
		Trio<Integer> numberTrio5 = new Trio<Integer>(1, 2, 2);
		System.out.println("Trios the same? Should be false: " + numberTrio4.equals(numberTrio5));
		
		/* un-comment if completing the extra credit */
		/**/
		Trio<Integer> numberTrio6 = new Trio<Integer>(5, 6, 8);
		Trio<Integer> numberTrio7 = new Trio<Integer>(7, 2, 5);
		System.out.println("Trio6 is larger- should be a positive number: " + numberTrio6.compareTo(numberTrio7));
		Trio<Integer> numberTrio8 = new Trio<Integer>(9, 8, 1);
		Trio<Integer> numberTrio9 = new Trio<Integer>(2, 8, 3);
		System.out.println("Trio8 is smaller- should be a negative number: " + numberTrio8.compareTo(numberTrio9));
		Trio<Integer> numberTrio10 = new Trio<Integer>(4, 6, 2);
		Trio<Integer> numberTrio11 = new Trio<Integer>(2, 3, 7);
		System.out.println("Trio10 is not smaller or larger- should be 0: " + numberTrio10.compareTo(numberTrio11));		
		//bwillard - Added a few more tests...
		Trio<Integer> numberTrio12 = new Trio<Integer>(4, 6, 6);
		Trio<Integer> numberTrio13 = new Trio<Integer>(7, 2, 7);
		System.out.println("Trio12 is larger- should be a positive number: " + numberTrio12.compareTo(numberTrio13));
		Trio<Integer> numberTrio14 = new Trio<Integer>(9, 9, 1);
		Trio<Integer> numberTrio15 = new Trio<Integer>(2, 8, 8);
		System.out.println("Trio14 is smaller- should be a negative number: " + numberTrio14.compareTo(numberTrio15));
		Trio<Integer> numberTrio16 = new Trio<Integer>(7, 7, 7);
		Trio<Integer> numberTrio17 = new Trio<Integer>(7, 7, 7);
		System.out.println("Trio16 is not smaller or larger- should be 0: " + numberTrio16.compareTo(numberTrio17));
	}

}