package org.bwillard.ccsf.course.cs211s.assn2.FactoryCode;

import java.util.Scanner;

/*
 * concrete creator class
 */
public class ITDepartment extends Department {

	//this creator class decides what kind of products can be created
	public Employee createEmployee() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the user id: ");
		int id = scan.nextInt();
		Employee emp = new FullTimeEmployee(id);
		return emp;
	}
}
