package org.bwillard.ccsf.course.cs111c.homework6;

public class MethodRecordExample {

	public static void main(String[] args) {
		int x = 2;
		String s = "hello";
		methodA(x, s);

		System.out.println(sumIntegers(5));
	}

	private static int sumIntegers(int num) {
		// base case
		if(num == 1) {
			return 1;
		} else {		// recursive case
			return num + sumIntegers(num-1);
		}

	}
	
	private static void methodA(int x, String s) {
		System.out.println("in method A, x is " + x + " and s is " + s);
		int y = x-1;
		String s1 = s.substring(0, s.length() - 1);
		methodB(y, s1);

	}

	private static void methodB(int x, String s) {
		System.out.println("in method B, x is " + x + " and s is " + s);
		int y = x-1;
		String s1 = s.substring(0, s.length() - 1);
		methodC(y, s1);

	}

	private static void methodC(int x, String s) {
		System.out.println("in method C, x is " + x + " and s is " + s);

	}
}
