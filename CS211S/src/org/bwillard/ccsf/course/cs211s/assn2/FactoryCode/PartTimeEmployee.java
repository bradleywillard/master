package org.bwillard.ccsf.course.cs211s.assn2.FactoryCode;

/*
 * concrete product class
 */
public class PartTimeEmployee extends Employee{

	public PartTimeEmployee(int id) {
		super(id);
		// additional child class setup would go here
	}
	
	@Override
	public String toString() {
		return super.toString() + " (Part Time)";
	}
	
	@Override
	public void pay() {
		System.out.println("Paying part time employee " + super.getID());
	}
	
	@Override
	public void benefits() {
		System.out.println("Processing benefits for part time employee " + super.getID());
	}
	
}
