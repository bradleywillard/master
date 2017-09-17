package org.bwillard.ocp.test.practice._7_threads;

public class RecursivePractice {

	public static void main(String[] args) {
		System.out.println(factorial(10));
	}
	
	public static int factorial(int n) {
		if(n <= 1) {
			return 1;
		} else {
			return n * factorial(n - 1);
		}
	}
}
