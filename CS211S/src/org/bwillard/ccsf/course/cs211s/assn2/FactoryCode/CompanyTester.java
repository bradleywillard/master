package org.bwillard.ccsf.course.cs211s.assn2.FactoryCode;

public class CompanyTester {

	public static void main(String[] args) {
	Department sales = new SalesDepartment();
	sales.addEmployee();
	
	Department it = new ITDepartment();
	it.addEmployee();

	}

}
