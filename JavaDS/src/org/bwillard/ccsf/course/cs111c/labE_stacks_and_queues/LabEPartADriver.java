package org.bwillard.ccsf.course.cs111c.labE_stacks_and_queues;

public class LabEPartADriver {

	public static void main(String args[]) {
		NoDupsPrioritizeStackInterface<String> testStack = new NoDupsPrioritizeArrayStack<String>(5);
		
		/* first test that it still functions like a normal stack */
		System.out.println("Testing basic stack behavior:");
		System.out.println("Stack is currently empty: " + testStack.isEmpty());
		testStack.push("ants");
		testStack.push("baboons");
		testStack.push("dogs");
		testStack.push("cockroaches");
		testStack.push("elephants");
		System.out.println("Stack is currently empty: " + testStack.isEmpty());
		System.out.println("The stack should be: \nTop elephants cockroaches dogs baboons ants Bottom");
		testStack.display();

		System.out.println("Should be popping elephants: " + testStack.pop());
		System.out.println("Should be popping cockroaches: " + testStack.pop());
		System.out.println("Should be popping dogs: " + testStack.pop());
		System.out.println("Should be popping baboons: " + testStack.pop());
		System.out.println("Should be popping ants: " + testStack.pop());
		System.out.println("Stack is currently empty: " + testStack.isEmpty());
		System.out.println("Attempting to pop() on empty stack shold be null : " + testStack.pop());
		System.out.println("Attempting to peek() on empty stack shold be null : " + testStack.peek());

		/* next test that it won't add duplicates */
		System.out.println("\nTesting no duplicate functionality:");
		testStack.push("ants");
		testStack.push("baboons");
		testStack.push("dogs");
		testStack.push("cockroaches");
		testStack.push("elephants");
		System.out.println("The stack should be: \nTop elephants cockroaches dogs baboons ants Bottom");
		testStack.display();
		testStack.push("dogs");
		System.out.println("The stack should be: \nTop dogs elephants cockroaches baboons ants Bottom");
		testStack.display();
		
		/* finally test the moveToTop method */
		System.out.println("\nTesting prioritization:");
		testStack.moveToTop("dogs"); // middle element
		System.out.println("The stack should be: \nTop dogs elephants cockroaches baboons ants Bottom");
		testStack.display();
		testStack.moveToTop("ants"); // bottom element
		System.out.println("The stack should be:  \nTop ants dogs elephants cockroaches baboons Bottom");
		testStack.display();
		testStack.moveToTop("ants"); // top element
		System.out.println("The stack should be:  \nTop ants dogs elephants cockroaches baboons Bottom");
		testStack.display();
		testStack.moveToTop("baboons"); // top element
		System.out.println("The stack should be:  \nTop baboons ants dogs elephants cockroaches Bottom");
		testStack.display();
		testStack.moveToTop("frogs"); // element not currently in stack
		System.out.println("The stack should be: \nTop frogs baboons ants dogs elephants cockroaches Bottom");
		testStack.display();
		
		/* now push some more items to test if the array expands*/
		testStack.push("gorillas");
		testStack.push("zebras");
		testStack.push("rhinos");
		testStack.push("hyenas");
		testStack.push("wildebeests");
		testStack.push("crocodiles");
		testStack.push("entrees");
		testStack.push("comedians");
		System.out.println("The stack should be: \nTop comedians entrees crocodiles wildebeests hyenas rhinos zebras gorillas frogs baboons ants dogs elephants cockroaches Bottom");
		testStack.display();
	}

}