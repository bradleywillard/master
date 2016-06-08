package org.bwillard.ccsf.course.cs111c.homework4;

import java.util.Arrays;

import org.bwillard.ccsf.course.cs111c.homework3.BagInterface;

public class Homework04Driver {

	public static void main(String[] args) {

		// setting up Nodes to test
		System.out.println("TESTING NODES");

		Node<Integer> node5 = new Node<Integer>(new Integer(6));
		Node<Integer> node4 = new Node<Integer>(new Integer(4), node5);
		Node<Integer> node3 = new Node<Integer>(new Integer(2), node4);
		Node<Integer> node2 = new Node<Integer>(new Integer(8), node3);
		Node<Integer> node1 = new Node<Integer>(new Integer(3), node2);
		// sets up the chain 3 -> 8 -> 2 -> 4 -> 6

		// Q5 print every other
		System.out.println("Should print 3, 2, 6");
		printEveryOther(node1);
		node5.next = new Node<Integer>(new Integer(11));
		// sets up the chain 3 -> 8 -> 2 -> 4 -> 6 -> 11
		System.out.println("Should still print 3, 2, 6");
		printEveryOther(node1);

		// Q6 determine if divisible
		System.out.println("Are all divisible by 2? false: "
				+ isDivisibleBy(node1, 2));
		node1.data = 4;
		// sets up the chain 4 -> 8 -> 2 -> 4 -> 6 -> 11
		System.out.println("Are all divisible by 2? false: "
				+ isDivisibleBy(node1, 2));
		node5.next.data = 6;
		// sets up the chain 3 -> 8 -> 2 -> 4 -> 6 -> 6
		System.out.println("Are all divisible by 2? true: "
				+ isDivisibleBy(node1, 2));
		
		// setting up an LinkedBag to test
		System.out.println("\nTESTING BAG");
		LinkedBag<Integer> numbersBag = new LinkedBag<Integer>();
		numbersBag.add(1);
		numbersBag.add(2);
		numbersBag.add(1);
		numbersBag.add(4);
		numbersBag.add(3);
		System.out.println("The bag contains[3, 4, 1, 2, 1]  (any order)\n\t\t"
				+ Arrays.toString(numbersBag.toArray()));

		// Q9 replace method
		// NOTE: The description does not specify which element to replace,
		// so your output might be different- that's okay
		numbersBag.replace(6);
		System.out.println("The bag contains[6, 4, 1, 2, 1]  (any order)\n\t\t"
				+ Arrays.toString(numbersBag.toArray()));
		numbersBag.replace(8);
		System.out.println("The bag contains[8, 4, 1, 2, 1]  (any order)\n\t\t"
				+ Arrays.toString(numbersBag.toArray()));
		
		// Q7 getMin method
		System.out.println("The min in the bag is 1: " + numbersBag.getMin());
		numbersBag.add(0);
		System.out.println("The bag contains[0, 8, 4, 1, 2, 1]  (any order)\n\t\t"
				+ Arrays.toString(numbersBag.toArray()));
		System.out.println("The min in the bag is 0: " + numbersBag.getMin());

		numbersBag.add(5);
		numbersBag.add(7);
		System.out.println("The bag contains[7, 5, 0, 8, 4, 1, 2, 1]  (any order)\n\t\t"
				+ Arrays.toString(numbersBag.toArray()));
		System.out.println("The min in the bag is 0: " + numbersBag.getMin());
		
		// Q8 union
		LinkedBag<Integer> firstBag = new LinkedBag<Integer>();
		firstBag.add(8);
		firstBag.add(2);
		firstBag.add(4);
		firstBag.add(5);
		firstBag.add(6);
		firstBag.add(2);
		LinkedBag<Integer> secondBag = new LinkedBag<Integer>();
		secondBag.add(3);
		secondBag.add(1);
		secondBag.add(2);
		BagInterface<Integer> unionBag = firstBag.union(secondBag);
		System.out.println("Bag1 contains   [2, 6, 5, 4, 2, 8]  (any order)\n\t\t"
						+ Arrays.toString(firstBag.toArray()));
		System.out.println("Bag2 contains   [2, 1, 3]  (any order)\n\t\t"
						+ Arrays.toString(secondBag.toArray()));
		System.out.println("Union Bag contains [3, 1, 2, 8, 2, 4, 5, 6, 2] (any order) \n\t\t   "
						+ Arrays.toString(unionBag.toArray()));

		LinkedBag<Integer> thirdBag = new LinkedBag<Integer>();
		thirdBag.add(8);
		thirdBag.add(2);
		thirdBag.add(4);
		LinkedBag<Integer> fourthBag = new LinkedBag<Integer>();
		fourthBag.add(3);
		fourthBag.add(1);
		fourthBag.add(2);
		fourthBag.add(5);
		fourthBag.add(6);
		fourthBag.add(2);
		BagInterface<Integer> unionBag2 = thirdBag.union(fourthBag);
		System.out.println("Bag3 contains   [4, 2, 8]  (any order)\n\t\t"
						+ Arrays.toString(thirdBag.toArray()));
		System.out.println("Bag4 contains   [2, 6, 5, 2, 1, 3]  (any order)\n\t\t"
						+ Arrays.toString(fourthBag.toArray()));
		System.out.println("Union Bag contains [3, 1, 2, 8, 2, 4, 5, 6, 2] (any order) \n\t\t   "
						+ Arrays.toString(unionBag2.toArray()));
		
		fourthBag.remove(1);

		System.out.println("Bag4 contains   [2, 6, 5, 2, 3]  (any order) after removing 1 \n\t\t"
				+ Arrays.toString(fourthBag.toArray()));
		
		fourthBag.remove(7);
		System.out.println("Bag4 contains   [2, 6, 5, 2, 3]  (any order) after removing 7 \n\t\t"
				+ Arrays.toString(fourthBag.toArray()));
		
		int freq = fourthBag.getFrequencyOf(2);
		System.out.println("Bag4 should contain 2 twice \n\t\t" + freq + " "
				+ Arrays.toString(fourthBag.toArray()));
		freq = fourthBag.getFrequencyOf(5);
		System.out.println("Bag4 should contain 5 once \n\t\t" + freq + " "
				+ Arrays.toString(fourthBag.toArray()));
		freq = fourthBag.getFrequencyOf(3);
		System.out.println("Bag4 should contain 3 once \n\t\t" + freq + " "
				+ Arrays.toString(fourthBag.toArray()));
		freq = fourthBag.getFrequencyOf(6);
		System.out.println("Bag4 should contain 6 once \n\t\t" + freq + " "
				+ Arrays.toString(fourthBag.toArray()));
		freq = fourthBag.getFrequencyOf(7);
		System.out.println("Bag4 should contain 7 none \n\t\t" + freq + " "
				+ Arrays.toString(fourthBag.toArray()));
		
		
		// setting up LList to test
		System.out.println("\nTESTING LIST");
		LList<String> produceList = new LList<String>();
		String[] stringArray = { "banana", "date", "grape", "eggplant",
				"jicama", "grape" };

		// Q10 addAll method
		produceList.addAll(stringArray);
		System.out.println("The list contains[banana, date, grape, eggplant, jicama, grape] \n\t\t "
						+ Arrays.toString(produceList.toArray()));

		// Q11 getPosition method
		System.out.println("Position is 1: " + produceList.getPosition("banana"));
		System.out.println("Position is 3: " + produceList.getPosition("grape"));
		System.out.println("Position is -1: " + produceList.getPosition("mango"));

		// Q12 remove(T) method
		System.out.println("Result is false: " + produceList.remove("pear"));
		System.out.println("Result is true: " + produceList.remove("date"));
		System.out.println("The list contains[banana, grape, eggplant, jicama, grape] \n\t\t "
						+ Arrays.toString(produceList.toArray()));
		System.out.println("Result is true: " + produceList.remove("grape"));
		System.out.println("The list contains[banana, eggplant, jicama, grape] \n\t\t "
						+ Arrays.toString(produceList.toArray()));
		/*produceList.remove("banana");
		produceList.remove("eggplant");
		produceList.remove("jicama");
		produceList.remove("grape");
		produceList.remove("something");
		System.out.println("The list is empty \n\t\t " + Arrays.toString(produceList.toArray()));
	*/

		produceList.printLinkedChain(produceList.firstNode);
		
		Node firstNode = new Node(5);
		firstNode.next = new Node(3);
		firstNode.next.next = new Node(2);
		firstNode.next.next.next = new Node(4);
		firstNode.next.next.next.next = new Node(1);
		firstNode.next.next.next.next.next = new Node(9);
		firstNode.next.next.next.next.next.next = new Node(7);
		recMethod(firstNode);
		
		//question 1
		char c = 'a';
		int count = produceList.getNodeCountWithChar(produceList.firstNode, c);
		System.out.println();
		System.out.println("count with " + c + "=" + count);
		
		//question 2
		System.out.println("contains repeat: " + produceList.containsRepeat());
		int index = produceList.getPosition("banana");
		produceList.add(index, "banana");
		System.out.println("added banana next to another banana");
		System.out.println("contains repeat: " + produceList.containsRepeat());
		
		System.out.println("Result of running display() method: ");
		produceList.display();
		
		Node first = new Node(49);
		first.next = new Node(24);
		first.next.next = new Node(37);
		first.next.next.next = null;
		whatIsIt(first);
	}

	static void whatIsIt(Node firstNode) {
		Node currentNode = firstNode;

		while (currentNode.next != null) {
			System.out.print(currentNode.next.data + " ");
			currentNode = currentNode.next;
		}
	}
	
	static void recMethod(Node node) {
		//print the chain of nodes
		System.out.println();
		Node current = node;
		while(current != null) {
			System.out.print(current.data);
			if(current.next != null)
				System.out.print(" -> ");
			current = current.next;
		}
		if(node.next != null) {
			Object data = node.data;
			if(data instanceof Integer) {
				int dataInt = (Integer) data * 2;
				node.data = dataInt;
			}
			
			recMethod(node.next.next);
		}
	}
	
	/**
	 * Prints every other node in a chain of nodes
	 * 
	 * @param firstNode
	 */
	@SuppressWarnings("rawtypes")
	public static void printEveryOther(Node firstNode) {
		
		Node current = firstNode;
		
		int counter = 0;
		while(current != null) {
			if(counter % 2 == 0) {
				System.out.println(current.data);
			}
			current = current.next;
			counter++;
		}
	}

	/**
	 * See if every node in a chain of integer nodes is divisible by 
	 * a given divisor
	 * 
	 * @param firstNode
	 * @param divisor
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static boolean isDivisibleBy(Node<Integer> firstNode, int divisor) {
		if(firstNode == null)
			return false;
		Node<Integer> current = firstNode;
		while(current != null) {
			if(!(current.data % divisor == 0)) {
				return false;
			}
			current = current.next;
		}
		
		return true;
	}

	

}
