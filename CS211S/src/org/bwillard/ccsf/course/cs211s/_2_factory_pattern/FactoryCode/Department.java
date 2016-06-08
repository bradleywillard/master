package org.bwillard.ccsf.course.cs211s._2_factory_pattern.FactoryCode;

import java.util.*;

/*
 * our creator class- in charge of processing employees (the product) but doesn't
 * know (and doesn't need to know) the actual type of those employees
 */
public abstract class Department {

	private ArrayList<Employee> employeeList;
	
	public Department() {
		employeeList = new ArrayList<Employee>();
	}
	public abstract Employee createEmployee();
	
	public void addEmployee() {
		
		// rely on the concrete creator class to actually create the object
		Employee emp = createEmployee();
		
		// process the employee
		emp.pay();
		emp.review();
		emp.benefits();
	}
	
	/* version 2 addEmployee method- this uses the Factory Class 
	 * (different from the factory pattern)
	 
	public void addEmployee() {
		EmployeeFactory empFactory = new EmployeeFactory();
		Employee emp = empFactory.createEmployee();
		emp.pay();
		emp.review();
		emp.benefits();
	}
	*/
	
	/* original addEmployee method
	 * this couples together object creation and object 
	 * processing- not a great design approach if we
	 * want our system to be extensible and flexible
	public void addEmployee() {
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
		employeeList.add(emp);
		
		emp.pay();
		emp.benefits();
		emp.review();
		
		
	}
	*/
}
