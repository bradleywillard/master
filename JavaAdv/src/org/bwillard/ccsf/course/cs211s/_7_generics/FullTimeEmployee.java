package org.bwillard.ccsf.course.cs211s._7_generics;


public class FullTimeEmployee extends Employee{

	public FullTimeEmployee(int id) {
		super(id);
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
