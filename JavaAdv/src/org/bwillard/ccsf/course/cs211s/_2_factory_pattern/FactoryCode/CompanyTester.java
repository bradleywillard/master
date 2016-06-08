package org.bwillard.ccsf.course.cs211s._2_factory_pattern.FactoryCode;

public class CompanyTester {

	public static void main(String[] args) {
	Department sales = new SalesDepartment();
	sales.addEmployee();
	
	Department it = new ITDepartment();
	it.addEmployee();

	}

}
