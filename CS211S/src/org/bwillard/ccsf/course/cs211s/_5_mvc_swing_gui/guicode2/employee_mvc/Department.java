package org.bwillard.ccsf.course.cs211s.assn5.guicode2.employee_mvc;

import java.util.*;

/* the model */
public class Department {

	private ArrayList<Employee> employeeList;
	
	public Department() {
		employeeList = new ArrayList<Employee>();
	}
	
	public boolean addEmployee(Employee s) {
		return employeeList.add(s);
	}
	
	public boolean removeEmployee(Employee s) {
		return employeeList.remove(s);
	}
	
	public ArrayList<Employee> getEmployeeList() {
		return employeeList;
	}
	
	public String runPayroll() {
		String payRoll = "";
		for(Employee e : employeeList) {
			payRoll += e + "\n\t" + e.pay() + "\n";
		}
		return payRoll;
	}
	
	public String toString() {
		String s = "";
		for(int i=0; i<employeeList.size(); i++) {
			s += employeeList.get(i) + "\n";
		}
		return s;
	}
}
