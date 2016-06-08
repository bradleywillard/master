package org.bwillard.ccsf.course.cs111c.labE;

public class LabEPartBDriver {

	public static void main(String args[]) {
		NoDupsDePrioritizeQueueInterface<String> testQueue = new NoDupsDePrioritizeArrayQueue<String>(5);
		
		/* first test that it still functions like a normal stack */
		System.out.println("Testing basic queue behavior:");
		System.out.println("Queue is currently empty: " + testQueue.isEmpty());
		testQueue.enqueue("ants");
		testQueue.enqueue("baboons");
		testQueue.enqueue("dogs");
		testQueue.enqueue("cockroaches");
		testQueue.enqueue("elephants");
		System.out.println("Queue is currently empty: " + testQueue.isEmpty());
		System.out.println("The queue should be: \nFront ants baboons dogs cockroaches elephants Back");
		testQueue.display();

		System.out.println("Should be dequeuing ants: " + testQueue.dequeue());
		System.out.println("Should be dequeuing baboons: " + testQueue.dequeue());
		System.out.println("Should be dequeuing dogs: " + testQueue.dequeue());
		System.out.println("Should be dequeuing cockroaches: " + testQueue.dequeue());
		System.out.println();
		System.out.println("Only 1 item in queue, test getFront should be elephants : " + testQueue.getFront());
		System.out.println("Should be dequeuing elephants: " + testQueue.dequeue());
		System.out.println("Queue is currently empty: " + testQueue.isEmpty());
		System.out.println("Attempting to dequeue an empty queue should be null: " + testQueue.dequeue());
		System.out.println("Attempting to getFront on an empty queue should be null: " + testQueue.getFront());
		System.out.println("Displaying empty queue: ");
		testQueue.display();
		
		/* next test that it won't add duplicates */
		System.out.println("\nTesting no duplicate functionality:");
		testQueue.enqueue("ants");
		testQueue.enqueue("baboons");
		testQueue.enqueue("dogs");
		testQueue.enqueue("cockroaches");
		testQueue.enqueue("elephants");
		System.out.println("The queue should be: \nFront ants baboons dogs cockroaches elephants Back");
		testQueue.display();
		testQueue.enqueue("dogs");
		System.out.println("The queue should be: \nFront ants baboons cockroaches elephants dogs Back");
		testQueue.display();
		testQueue.enqueue("ants");
		System.out.println("The queue should be: \nFront baboons cockroaches elephants dogs ants Back");
		testQueue.display();
		testQueue.enqueue("ants");
		System.out.println("The queue should be: \nFront baboons cockroaches elephants dogs ants Back");
		testQueue.display();
		testQueue.enqueue("elephants");
		System.out.println("The queue should be: \nFront baboons cockroaches dogs ants elephants Back");
		testQueue.display();
		testQueue.enqueue("panthers");
		System.out.println("The queue should be: \nFront baboons cockroaches dogs ants elephants panthers Back");
		testQueue.display();
		
		/* finally test the moveToBack method */
		System.out.println("\nTesting de-prioritization:");
		testQueue.moveToBack("dogs"); // middle element
		System.out.println("The queue should be: \nFront baboons cockroaches ants elephants panthers dogs Back");
		testQueue.display();
		testQueue.moveToBack("ants"); // bottom element
		System.out.println("The queue should be: \nFront baboons cockroaches elephants panthers dogs ants Back");
		testQueue.display();
		testQueue.moveToBack("ants"); // top element
		System.out.println("The queue should be: \nFront baboons cockroaches elephants panthers dogs ants Back");
		testQueue.display();
		testQueue.moveToBack("frogs"); // element not currently in stack
		System.out.println("The queue should be: \nFront baboons cockroaches elephants panthers dogs ants frogs Back");
		testQueue.display();
		
		//Just adding some more items...
		testQueue.enqueue("lions");
		testQueue.enqueue("tigers");
		testQueue.enqueue("wolves");
		System.out.println("The queue should be: \nFront baboons cockroaches elephants panthers dogs ants frogs lions tigers wolves Back");
		testQueue.display();
		
		testQueue.dequeue();
		testQueue.dequeue();
		testQueue.dequeue();
		testQueue.dequeue();
		System.out.println("The queue should be: \nFront dogs ants frogs lions tigers wolves Back");
		testQueue.display();
		
		testQueue.enqueue("bears");
		testQueue.enqueue("ocelots");
		testQueue.enqueue("giraffes");
		testQueue.enqueue("monkeys");
		System.out.println("The queue should be: \nFront dogs ants frogs lions tigers wolves bears ocelots giraffes monkeys Back");
		testQueue.display();
		
		//Testing deprioritization when the end of the queue has wrapped around past the beginning of the array
		System.out.println("\nTesting moveToFront when the end of the array has wrapped around to the beginning of the list");
		testQueue.moveToBack("bears");
		testQueue.moveToBack("giraffes");
		testQueue.moveToBack("ocelots");
		System.out.println("The queue should be: \nFront dogs ants frogs lions tigers wolves monkeys bears giraffes ocelots Back");
		testQueue.display();
		
		testQueue.enqueue("wolves");
		testQueue.enqueue("tigers");
		testQueue.enqueue("lions");
		System.out.println("The queue should be: \nFront dogs ants frogs monkeys bears giraffes ocelots wolves tigers lions Back");
		testQueue.enqueue("wolves");
		testQueue.display();
		
		//Test full queue behaves as expected...
		testQueue.moveToBack("ravens");
		testQueue.enqueue("eagles");
		testQueue.enqueue("hawks");
		System.out.println("The queue should be: \nFront dogs ants frogs monkeys bears giraffes ocelots wolves tigers lions ravens eagles hawks Back");
		testQueue.display();
		
		
	}
	

}