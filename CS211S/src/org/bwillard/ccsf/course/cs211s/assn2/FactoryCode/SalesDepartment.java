package org.bwillard.ccsf.course.cs211s.assn2.FactoryCode;

import java.util.Scanner;

/* concrete creator class */
public class SalesDepartment extends Department {

	// this creator class decides what kind of products can be created
	public Employee createEmployee() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the user id: ");
		int id = scan.nextInt();
		scan.nextLine();
		System.out.println("Full time or part time?");
		String empType = scan.nextLine();
		Employee emp;
		if(empType.equalsIgnoreCase("full")) {
			emp = new FullTimeEmployee(id);
		} else {
			emp = new PartTimeEmployee(id);
		}
		return emp;
	}
}
