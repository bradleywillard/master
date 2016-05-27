package org.bwillard.ccsf.course.cs211s.assn7;

/* concrete product class */
public class FullTimeEmployee extends Employee{

	public FullTimeEmployee(int id) {
		super(id);
		// additional child class setup would go here
	}
	
	@Override
	public String toString() {
		return super.toString() + " (Full Time)";
	}
	
	@Override
	public void pay() {
		System.out.println("Paying full time employee " + super.getID());
	}
	
	@Override
	public void benefits() {
		System.out.println("Processing benefits for full time employee " + super.getID());
	}
	
	public void vacation() {
		System.out.println("Full time employee taking vacation!");
	}
}
