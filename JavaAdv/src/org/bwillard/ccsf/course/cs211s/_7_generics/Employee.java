package org.bwillard.ccsf.course.cs211s._7_generics;

public abstract class Employee implements Comparable<Employee>{
	
	private int id;
		
	public Employee(int id) {
		this.id = id;
	}
	
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
	}
	
	
	public void review() {
		System.out.println("Reviewing employee " + id);
	}
	
	/**
	 * abstract methods
	 */
	public abstract void pay();
	public abstract void benefits();
}
