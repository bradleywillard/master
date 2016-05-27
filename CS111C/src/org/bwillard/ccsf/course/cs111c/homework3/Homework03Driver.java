package org.bwillard.ccsf.course.cs111c.homework3;

import java.util.Arrays;

public class Homework03Driver {

	public static void main(String[] args) {

			
		// setting up an ArrayBag to test
		System.out.println("TESTING BAG");
		ArrayBag<Integer> numbersBag = new ArrayBag<Integer>();
		numbersBag.add(1);
		numbersBag.add(2);
		numbersBag.add(1);
		numbersBag.add(4);
		numbersBag.add(3);
		System.out.println("The bag contains[1, 2, 1, 4, 3] \n\t\t"
				+ Arrays.toString(numbersBag.toArray()));

		// Q4 replace method
		// NOTE: The description does not specify that you must replace the last
		// element in the array, so your output might be different- that's okay
		System.out.println("\n***Q4***");
		numbersBag.replace(6);
		System.out.println("The bag contains[1, 2, 1, 4, 6] \n\t\t"
				+ Arrays.toString(numbersBag.toArray()));
		numbersBag.replace(8);
		System.out.println("The bag contains[1, 2, 1, 4, 8] \n\t\t"
				+ Arrays.toString(numbersBag.toArray()));

		// Q5 removeEvery method
		// NOTE: bags are unordered, so the order of your array might be
		// different- that's okay as long as the contents match what is listed below
		System.out.println("\n***Q5***");
		numbersBag.add(1);
		numbersBag.removeEvery(1);
		System.out.println("The bag contains[8, 2, 4] (any order) \n\t\t"
				+ Arrays.toString(numbersBag.toArray()));
		numbersBag.removeEvery(3);
		System.out.println("The bag contains[8, 2, 4] (any order) \n\t\t"
				+ Arrays.toString(numbersBag.toArray()));

		// Q6: getAllLessThan method
		// NOTE: bags are unordered, so the order of your array might be
		// different- that's okay as long as the contents match what is listed below
		System.out.println("\n***Q6***");
		numbersBag.add(5);
		numbersBag.add(6);
		numbersBag.add(2);
		BagInterface<Integer> smallerNumbersBag = numbersBag.getAllLessThan(5);
		System.out.println("The smaller bag contains[2, 4, 2] (any order) \n\t\t\t"
						+ Arrays.toString(smallerNumbersBag.toArray()));
		System.out.println("The original bag contains [8, 2, 4, 5, 6, 2] (any order) \n\t\t\t  "
						+ Arrays.toString(numbersBag.toArray()));

		// Q7: union
		System.out.println("\n***Q7***");
		ResizableArrayBag<Integer> firstResizableBag = new ResizableArrayBag<Integer>();
		firstResizableBag.add(8);
		firstResizableBag.add(2);
		firstResizableBag.add(4);
		firstResizableBag.add(5);
		firstResizableBag.add(6);
		firstResizableBag.add(2);
		ResizableArrayBag<Integer> secondResizableBag = new ResizableArrayBag<Integer>();
		secondResizableBag.add(3);
		secondResizableBag.add(1);
		secondResizableBag.add(2);
		BagInterface<Integer> unionBag = firstResizableBag
				.union(secondResizableBag);
		System.out.println("Bag1 contains   [8, 2, 4, 5, 6, 2] \n\t\t"
				+ Arrays.toString(firstResizableBag.toArray()));
		System.out.println("Bag2 contains   [3, 1, 2] \n\t\t"
				+ Arrays.toString(secondResizableBag.toArray()));
		System.out.println("Union Bag contains [8, 2, 4, 5, 6, 2, 3, 1, 2] (any order) \n\t\t   "
						+ Arrays.toString(unionBag.toArray()));

		// Q8: intersection
		System.out.println("\n***Q8***");
		firstResizableBag.add(2);
		secondResizableBag.add(2);
		secondResizableBag.add(4);
		BagInterface<Integer> intersectionBag = firstResizableBag.intersection(secondResizableBag);
		System.out.println("Bag1 contains   [8, 2, 4, 5, 6, 2, 2] \n\t\t"
				+ Arrays.toString(firstResizableBag.toArray()));
		System.out.println("Bag2 contains   [3, 1, 2, 2, 4] \n\t\t"
				+ Arrays.toString(secondResizableBag.toArray()));
		System.out.println("Union Bag contains [2, 4, 2] (any order) \n\t\t   "
				+ Arrays.toString(intersectionBag.toArray()));

		// setting up AList to test
		System.out.println("\nTESTING LIST");
		AList<String> produceList = new AList<String>();
		produceList.add("banana");
		produceList.add("date");
		produceList.add("grape");
		produceList.add("eggplant");
		produceList.add("jicama");
		produceList.add("grape");

		// Q9: getPosition
		// Note: this driver assumes you return -1 if an element is not in the list;
		// it would also be valid to throw an exception
		System.out.println("\n***Q9***");
		System.out.println("Position is 1: " + produceList.getPosition("banana"));
		System.out.println("Position is 3: " + produceList.getPosition("grape"));
		System.out.println("Position is -1: " + produceList.getPosition("mango"));

		//Q10: moveToBeginning
		System.out.println("\n***Q10***");
		System.out.println("List contains [banana, date, grape, eggplant, jicama, grape] \n\t\t   "
						+ Arrays.toString(produceList.toArray()));
		produceList.moveToBeginning();
		System.out.println("List contains [grape, banana, date, grape, eggplant, jicama] \n\t\t   "
				+ Arrays.toString(produceList.toArray()));
		produceList.clear();
		produceList.moveToBeginning();
		System.out.println("List contains [] \n\t\t   "
				+ Arrays.toString(produceList.toArray()));
	
		// Q11: equals
		System.out.println("\n***Q11***");
		produceList.add("banana");
		produceList.add("potato");
		produceList.add("jicama");
		produceList.add("grape");
		AList<String> foodList = new AList<String>();
		foodList.add("banana");
		foodList.add("potato");
		foodList.add("jicama");
		System.out.println("Result is false: " + produceList.equals(foodList));
		foodList.add("grape");
		System.out.println("Result is true: " + produceList.equals(foodList));
		foodList.add("squash");
		System.out.println("Result is false: " + produceList.equals(foodList));
		foodList.replace(1, "jicama");
		foodList.replace(3, "banana");
		System.out.println("Result is false: " + produceList.equals(foodList));
		System.out.println("The list contains[banana, potato, jicama, grape] \n\t\t "
						+ Arrays.toString(produceList.toArray()));
		System.out.println("The second list contains[jicama, potato, banana, grape, squash] \n\t\t\t"
						+ Arrays.toString(foodList.toArray()));
		
		String entry = "banana";
		System.out.println("contains exactly one: " +  entry + ": " + produceList.containsExactlyOne(produceList, "banana"));
		produceList.add("banana");
		System.out.println("contains exactly one: " +  entry + ": " + produceList.containsExactlyOne(produceList, "banana"));
		System.out.println("contains exactly one: " +  entry + ": " + produceList.containsExactlyOne(produceList, "rabana"));

		/*foodList.removeBetween(foodList, 2, 3);
		System.out.println("The second list contains[jicama, grape, squash] \n\t\t\t"
				+ Arrays.toString(foodList.toArray()));*/
		
		//System.out.println(produceList.getLength() + " : " + Math.round(Math.random() * produceList.getLength()));
		
		
	}

}