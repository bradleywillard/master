package org.bwillard.ccsf.course.cs111c._1_class_design0;

import java.util.*;

public class HomeworkW10Driver {

    public static void main(String[] args) {   
    	        
        // Q6 print in order
        StackInterface s = new LinkedStack();
        System.out.println("Q6");
        System.out.println("Should print cat, dog, hamster, zebra");
        s.push("cat");
        s.push("dog");
        s.push("hamster");
        s.push("zebra");
        printInAddOrder(s);
        System.out.println();
    	
        // Q7 palindromes     	 
        System.out.println("Q7");
    	String p = "anna";
		System.out.println(p + " is a palindrome? " + isPalindrome(p));
		p = "ana";
		System.out.println(p + " is a palindrome? " + isPalindrome(p));
		p = "a";
		System.out.println(p + " is a palindrome? " + isPalindrome(p));
		p = "amanaplanacanalpanama";
		System.out.println(p + " is a palindrome? " + isPalindrome(p));
		p = "ababb";
		System.out.println(p + " is a palindrome? " + isPalindrome(p));
		p = "ab";
		System.out.println(p + " is a palindrome? " + isPalindrome(p));
		System.out.println();
		
		// Q8 fibonacci numbers
		System.out.println("Q8");
		int fibNum = 9;
    	System.out.println("Fib recursive should be the same as Fib using stacks (" + fibonacciRecursive(fibNum)  +
    			"): " + fibonacciStack(fibNum));
    	System.out.println();
    	
    	fibNum = 0;
    	System.out.println("Fib recursive should be the same as Fib using stacks (" + fibonacciRecursive(fibNum)  +
    			"): " + fibonacciStack(fibNum));
    	System.out.println();
    	
    	fibNum = 1;
    	System.out.println("Fib recursive should be the same as Fib using stacks (" + fibonacciRecursive(fibNum)  +
    			"): " + fibonacciStack(fibNum));
    	System.out.println();
    	
    	fibNum = 2;
    	System.out.println("Fib recursive should be the same as Fib using stacks (" + fibonacciRecursive(fibNum)  +
    			"): " + fibonacciStack(fibNum));
    	System.out.println();
    	
    	fibNum = -1;
    	int result = -1;
    	int comparison = -1;
    	System.out.print("Fib recursive should be the same as Fib using stacks (" + fibNum + ") ");
		try {
			comparison = fibonacciRecursive(fibNum);
			result = fibonacciStack(fibNum);
		} catch(Exception e) {
			System.out.print(e + ". Negative #s like " + fibNum + " are not acceptable.");
		}
    	System.out.println(comparison + " : " + result);
    	
    	fibNum = 20;
    	System.out.println("Fib recursive should be the same as Fib using stacks (" + fibonacciRecursive(fibNum)  +
    			"): " + fibonacciStack(fibNum));
    	System.out.println();
    	
    	fibNum = -9;
    	System.out.println("Fib recursive should be the same as Fib using stacks (" + fibonacciRecursive(fibNum)  +
    			"): " + fibonacciStack(fibNum));
    	System.out.println();
    	
    	fibNum = -20;
    	System.out.println("Fib recursive should be the same as Fib using stacks (" + fibonacciRecursive(fibNum)  +
    			"): " + fibonacciStack(fibNum));
    	System.out.println();
    	
    	// Q9 display methods
    	System.out.println("Q9");
    	LinkedStack<String> displayLinkedStack = new LinkedStack();
    	System.out.println("Should give a message that the stack is empty.");
    	displayLinkedStack.display();
    	displayLinkedStack.push("Alaska");
    	displayLinkedStack.push("Delaware");
    	displayLinkedStack.push("Iowa");
    	displayLinkedStack.push("New York");
    	System.out.println("Should print New York, Iowa, Delaware, Alaska");
    	displayLinkedStack.display();
    	
    	ArrayStack<String> displayArrayStack = new ArrayStack();
    	System.out.println("Should give a message that the stack is empty.");
    	displayArrayStack.display();
    	displayArrayStack.push("California");
    	displayArrayStack.push("Florida");
    	displayArrayStack.push("Georgia");
    	displayArrayStack.push("Hawaii");
    	System.out.println("Should print Hawaii, Georgia, Florida, California");
    	displayArrayStack.display();
    	System.out.println();
    	
    	
    	// QEC1 peek2 in LinkedStack
    	System.out.println("Q10EC");
    	LinkedStack peekStackLinked = new LinkedStack();
    	System.out.println("Should print null/throw exception: ");
    	try{
    		peekStackLinked.peek2();
    	} catch(EmptyStackException e) {
    		System.out.println("The stack is completely empty! " + e);
    	}
    	peekStackLinked.push("hello");
    	System.out.println("Should print null/throw exception: ");
    	try {
    		peekStackLinked.peek2();
    	} catch(EmptyStackException e) {
    		System.out.print("No second item in stack! " + e + "\n");
    	}
    	peekStackLinked.push("goodbye");
    	System.out.println("Should print hello: " + peekStackLinked.peek2());
    	peekStackLinked.push("and good night");
    	System.out.println("Should print goodbye: " + peekStackLinked.peek2());
    	System.out.println();
    	
    	//QEC2 peek2 in ArrayStack
    	System.out.println("Q11EC");
    	ArrayStack peekStackArray = new ArrayStack();
    	System.out.println("Should print null/throw exception: ");
    	try {
    		peekStackArray.peek2();
    	} catch (EmptyStackException e) {
    		System.out.println("The stack is completely empty! " + e);
    	}
    	peekStackArray.push("hello");
    	System.out.println("Should print null/throw exception: ");
    	try {
    		peekStackArray.peek2();
    	} catch(EmptyStackException e) {
    		System.out.print("No second item in stack! " + e + "\n");
    	}
    	peekStackArray.push("goodbye");
    	System.out.println("Should print hello: " + peekStackArray.peek2());
    	peekStackArray.push("and good night");
    	System.out.println("Should print goodbye: " + peekStackArray.peek2());
    	System.out.println(); 
    	
    	BalanceChecker bc = new BalanceChecker();
    	System.out.println("checkBalance([5(4*5{3+9}(34)]) : should be false :" + bc.checkBalance("[5(4*5{3+9}(34)]"));
    	System.out.println("checkBalance([5(4*5){3+9}(34)]) : should be true :" + bc.checkBalance("[5(4*5){3+9}(34)]"));
    }       
    
    public static void printInAddOrder(StackInterface stack) {
    	StackInterface tempStack = new LinkedStack();
    	while(!stack.isEmpty()) {
    		Object item = stack.pop();
    		tempStack.push(item);
    	}
    	while(!tempStack.isEmpty()) {
    		Object item = tempStack.pop();
    		System.out.println(item);
    		stack.push(item);
    	}
    }
    
    public static boolean isPalindrome(String s) {
    	int len = s.length();
    	
    	//Validation
    	if(s == null || len < 1) {
    		return false;
    	}
    	//One character words are palindromes
    	if(len == 1) {
    		return true;
    	}
    	
    	//StackInterface<Character> tempStack = new LinkedStack<Character>();
    	Stack<Character> tempStack = new Stack<Character>();
    	//Push the first half of the word onto the stack...
    	for(int i = 0; i < len / 2; i++) {
    		tempStack.push(s.charAt(i));
    	}
    	//If the word has an uneven number of chars, 
    	//throw out the one in the middle
    	int start = len / 2;
    	if(len % 2 == 1) {
    		start += 1;
    	}
    	//We'll through the last half of the string, and verify
    	//that every character matches each pop of the stack
    	for(int i = start; i < len; i++) {
    		if(!tempStack.pop().equals(s.charAt(i))) {
    			return false;
    		}
    	}
    	
    	return true;
    }   
    
    public static int fibonacciRecursiveNeg(int n) {
    	if(n >= 0) {
    		return fibonacciRecursive(n);
    		//throw new IllegalArgumentException();
    	} else if(n == -1 || n == -2) {
    		return -1;
    	} else {
    		return fibonacciRecursive(n+1) + fibonacciRecursive(n+2);
    	}
    }
    
    public static int fibonacciRecursive(int n) {
    	if(n < 0) {
    		return fibonacciRecursiveNeg(n);
    		//throw new IllegalArgumentException();
    	} else if(n == 0) {	
    		return 0;
    	} else if(n==1 || n==2) {
    		return 1;
    	} else {
    		return fibonacciRecursive(n-1) + fibonacciRecursive(n-2);
    	}
    }
    
    public static int fibonacciStack(int n) {
    	if(n < 0) {
    		return fibonacciStackNeg(n);
    		//throw new IllegalArgumentException();
    	} else if(n == 0) {
    		return 0;
    	} else if(n == 1 || n == 2) {
    		return 1;
    	}
    	StackInterface<Integer> tempStack = new LinkedStack<Integer>();
    	for(int i = 0; i <= n; i++) {
    		if(i == 0) {
    			tempStack.push(0);
    		} else if(i == 1 || i == 2) {
	    		tempStack.push(1);
	    	} else {
	    		int first = tempStack.pop();
	    		int second = tempStack.peek();
	    		tempStack.push(first);
	    		tempStack.push(first + second);
	    	}
    	}
    	return tempStack.pop();
    }
    
    public static int fibonacciStackNeg(int n) {
    	if(n >= 0) {
    		return fibonacciStack(n);
    		//throw new IllegalArgumentException();
    	} else if(n == -1 || n == -2) {
    		return -1;
    	}
    	StackInterface<Integer> tempStack = new LinkedStack<Integer>();
    	for(int i = 0; i >= n; i--) {
    		if(i == 0) {
    			tempStack.push(0);
    		} else if(i == -1 || i == -2) {
	    		tempStack.push(-1);
	    	} else {
	    		int first = tempStack.pop();
	    		int second = tempStack.peek();
	    		tempStack.push(first);
	    		tempStack.push(first + second);
	    	}
    	}
    	return tempStack.pop();
    }
    
}