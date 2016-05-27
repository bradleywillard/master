package org.bwillard.ccsf.course.cs211s.assn6.code_from_classes;

import java.util.Scanner;

public class ExceptionTester {

	public static void main(String[] args) {
		System.out.println("Enter two numbers:");
		Scanner scan = new Scanner(System.in);
		
		try {
			String userNumber1 = scan.nextLine();
			int n1 = Integer.parseInt(userNumber1);

			String userNumber2 = scan.nextLine();
			int n2 = Integer.parseInt(userNumber2);
		
			int intDivision = n1/n2;
		
			System.out.println("Division is " + intDivision);
		} catch(ArithmeticException ex) {
			System.out.println("You cannot divide by zero.");
		} catch(NumberFormatException ex) {
			System.out.println("That is not a number.");
		} 
		

	}

}
