package org.bwillard.ccsf.course.cs111c._1_class_design1;

import java.util.*;

public class HomeworkW11Driver {

	public static void main(String[] args) {

		// Q5 palindromes
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
		p = null;
		System.out.println(p + " is a palindrome? " + isPalindrome(p));
		System.out.println();
		

		// Q6 splice client
		QueueInterface<Integer> q1 = new LinkedQueue<Integer>();
		q1.enqueue(4);
		q1.enqueue(8);
		q1.enqueue(9);
		q1.enqueue(2);
		QueueInterface<Integer> q2 = new LinkedQueue<Integer>();
		q2.enqueue(1);
		q2.enqueue(3);
		q2.enqueue(7);
		q2.enqueue(6);
		splice(q1, q2);
		System.out.println("q1 contains: \n4 8 9 2 1 3 7 6");
		((LinkedQueue)q1).display();
		System.out.println("q2 still contains: \n1 3 7 6");
		((LinkedQueue)q2).display();
		
		// Q7 splice ArrayQueue
		ArrayQueue<Integer> aq1 = new ArrayQueue<Integer>();
		aq1.enqueue(4);
		aq1.enqueue(8);
		aq1.enqueue(9);
		aq1.enqueue(2);
		ArrayQueue<Integer> aq2 = new ArrayQueue<Integer>();
		System.out.println("ArrayQueue time...");
		aq2.enqueue(1);
		aq2.enqueue(3);
		aq2.enqueue(7);
		aq2.enqueue(6);
		aq1.splice(aq2);
		System.out.println("q1 contains: \n4 8 9 2 1 3 7 6");
		aq1.display();
		System.out.println("q2 still contains: \n1 3 7 6");
		aq2.display();
		
		ArrayQueue<String> aq3 = new ArrayQueue<String>();
		aq3.enqueue("Brad");
		aq3.enqueue("Lina");
		aq3.enqueue("David");
		aq3.enqueue("Torgier");
		aq3.enqueue("Baaaaaahhhh");
		ArrayQueue<String> aq4 = new ArrayQueue<String>();
		aq4.enqueue("Darb");
		aq4.enqueue("Anil");
		aq4.enqueue("Divad");
		aq4.enqueue("Reigrot");
		aq4.enqueue("haaaabbbb");
		aq3.splice(aq4);
		System.out.println("q3 contains: \nBrad Lina David Torgier Baaaaaahhhh Darb Anil Divad Reigrot haaaabbbb");
		aq3.display();
		System.out.println("q4 still contains: \nDarb Anil Divad Reigrot haaaabbbb");
		aq4.display();
		aq3.dequeue();
		aq3.dequeue();
		aq3.display();
		aq3.splice(aq4);
		aq3.display();
		
		// Q8 splice LinkedQueue
		LinkedQueue<Integer> lq1 = new LinkedQueue<Integer>();
		lq1.enqueue(4);
		lq1.enqueue(8);
		lq1.enqueue(9);
		lq1.enqueue(2);
		LinkedQueue<Integer> lq2 = new LinkedQueue<Integer>();
		lq2.enqueue(1);
		lq2.enqueue(3);
		lq2.enqueue(7);
		lq2.enqueue(6);
		lq1.splice(lq2);
		System.out.println("q1 contains: \n4 8 9 2 1 3 7 6");
		lq1.display();
		System.out.println("q2 still contains: \n1 3 7 6");
		lq2.display();
		
		QueueInterface<Integer> queue = new Queue<Integer>();
		System.out.println("queue.isEmpty() should be true : " + queue.isEmpty());
		queue.enqueue(1);
		System.out.println("queue.getFront() should be 1 : " + queue.getFront());
		System.out.println("queue.dequeue() should be 1 : " + queue.dequeue());
		System.out.println("queue.isEmpty() should be true : " + queue.isEmpty());
		queue.enqueue(5);
		queue.enqueue(7);
		queue.enqueue(2);
		System.out.println("queue.isEmpty() should be false : " + queue.isEmpty());
		System.out.println("queue.getFront() should be 5 : " + queue.getFront());
		System.out.println("queue.dequeue() should be 5 : " + queue.dequeue());
		System.out.println("queue.getFront() should be 7 : " + queue.getFront());
		queue.clear();
		System.out.println("after queue.clear(), queue should be empty : " + queue.isEmpty());
		System.out.println("queue.getFront() should return null : " + queue.getFront());
		System.out.println("queue.dequeue() should return null : " + queue.dequeue());
		
		StackInterface<String> stack = new Stack<String>();
		System.out.println("\n\nstack.isEmpty() should be true : " + stack.isEmpty());
		stack.push("Hornet");
		System.out.println("stack.peek() should be Hornet : " + stack.peek());
		System.out.println("stack.pop() should be Hornet : " + stack.pop());
		System.out.println("stack.isEmpty() should be true : " + stack.isEmpty());
		stack.push("Wasp");
		stack.push("Bumble Bee");
		stack.push("Honey Bee");
		System.out.println("stack.pop() should be Honey Bee : " + stack.pop());
		System.out.println("stack.pop() should be Bumble Bee : " + stack.pop());
		System.out.println("stack.peek() should be Wasp : " + stack.peek());
		stack.clear();
		System.out.println("after stack.clear(), stack.isEmpty() should be true : " + stack.isEmpty());
		System.out.println("stack.peek() should be null : " + stack.peek());
		System.out.println("stack.pop() should be null : " + stack.pop());
		
		QueueInterface<Integer> qi = new QList<Integer>();
		System.out.println("\n\nqi.isEmpty() should be true : " + qi.isEmpty());
		qi.enqueue(5);
		qi.enqueue(3);
		qi.enqueue(23);
		System.out.println("qi.getFront() should be 5 : " + qi.getFront());
		System.out.println("qi.dequeue should be 5 : " + qi.dequeue());
		System.out.println("qi.dequeue should be 3 : " + qi.dequeue());
		System.out.println("qi.isEmpty() should be false before qi.clear() : " + qi.isEmpty());
		qi.clear();
		System.out.println("qi.isEmpty() should be true after qi.clear() : " + qi.isEmpty());
	}

	public static boolean isPalindrome(String s) {
		if(s == null || s.length() == 0)
			return false;
		else if(s.length() == 1) 
			return true;
		DequeInterface<Character> ld = new LinkedDeque<Character>();
		DequeInterface<Character> ld2 = new LinkedDeque<Character>();
		for(int i = 0; i < s.length(); i++) {
			ld.addToBack(s.charAt(i));
			ld2.addToBack(ld.getBack());
		}
		
		while(!(ld.isEmpty() && ld2.isEmpty())) {
			if(!ld.removeFront().equals(ld2.removeBack())) {
				return false;
			}
		}
		
		return true;
	}

	public static void splice(QueueInterface firstQueue, QueueInterface secondQueue) {
		QueueInterface tempQueue = new LinkedQueue();
		if(firstQueue != null && secondQueue != null && !secondQueue.isEmpty()) {
			while(!secondQueue.isEmpty()) {
				Object t = secondQueue.dequeue();
				firstQueue.enqueue(t);
				tempQueue.enqueue(t);
			}
			while(!tempQueue.isEmpty()) {
				secondQueue.enqueue(tempQueue.dequeue());
			}
		}
	}

}