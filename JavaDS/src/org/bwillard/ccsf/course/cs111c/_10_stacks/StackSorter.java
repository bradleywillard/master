package org.bwillard.ccsf.course.cs111c._10_stacks;

import java.util.Random;
import java.util.Stack;


public class StackSorter {

	public static Stack<Integer> sort(Stack<Integer> s) {
		if (s.isEmpty()) {
			return s;
		}
		int pivot = s.pop();

		// partition
		Stack<Integer> left = new Stack<Integer>();
		Stack<Integer> right = new Stack<Integer>();
		while (!s.isEmpty()) {
			int y = s.pop();
			if (y < pivot) {
				left.push(y);
			} else {
				right.push(y);
			}
		}
		sort(left);
		sort(right);

		// merge
		Stack<Integer> tmp = new Stack<Integer>();
		while (!right.isEmpty()) {
			tmp.push(right.pop());
		}
		tmp.push(pivot);
		while (!left.isEmpty()) {
			tmp.push(left.pop());
		}
		while (!tmp.isEmpty()) {
			s.push(tmp.pop());
		}
		return s;
	}

	public static void main(String[] args) {
		Random rand = new Random();
		Stack<Integer> stack = new Stack<Integer>();
		for (int i = 0; i < 10000; i++) {
			stack.push(rand.nextInt());
		}

		long start = System.currentTimeMillis();
		sort(stack);
		long end = System.currentTimeMillis();

		while (!stack.isEmpty()) {
			System.out.println(stack.pop());
		}

		System.out.print("\nTime to sort: " + (end - start) + "ms");
		
	}
	

}
