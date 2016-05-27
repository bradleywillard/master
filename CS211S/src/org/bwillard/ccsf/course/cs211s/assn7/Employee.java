package org.bwillard.ccsf.course.cs211s.assn7;

/* our product class */
public abstract class Employee implements Comparable<Employee>{
	
	private int id;
	
	//private final static int DEFAULT_ID = 0;
	
	public Employee(int id) {
		this.id = id;
	}
	/*
	public Employee() {
		this(DEFAULT_ID);
	}
	*/
	public int getID() {
		return id;
	}
	public void setID(int id) {
		if(id >= 0) {	
			this.id = id;
		} 
	}
	
	@Override
	public String toString() {
		return "EMP" + id;
	}
	
	@Override
	public boolean equals(Object object) {
		if(object instanceof Employee) {
			Employee otherEmployee = (Employee) object;
			return this.id == otherEmployee.id;
		} else {
			return false;
		}
	}
	
	@Override
	public int compareTo(Employee otherEmployee) {
		if(this.id < otherEmployee.id) {
			return -1;
		} else if(this.id > otherEmployee.id) {
			return 1;
		} else {
			return 0;
		}
		// return this.id - otherEmployee.id;
		// return this.firstName.compareTo(otherEmployee.firstName);
	}
	
	public abstract void pay();
	public void review() {
		System.out.println("Reviewing employee " + id);
	}
	public abstract void benefits();
}
