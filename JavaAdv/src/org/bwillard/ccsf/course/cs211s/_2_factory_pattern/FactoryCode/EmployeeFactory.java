package org.bwillard.ccsf.course.cs211s._2_factory_pattern.FactoryCode;

/*
 * a Factory Class used to create Employees
 * 
 * this class would be a good solution when we want to separate
 * object creation from object processing AND when all of our
 * creator classes will be creating the same kinds and combinations
 * of products
 */
import java.util.*;
public class EmployeeFactory {

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
