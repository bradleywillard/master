package org.bwillard.ccsf.course.cs211s._5_mvc_swing_gui.guicode2.employee_mvc;

/* the model */
public class Employee {
	private String name, id;
	private Payer payer;
	
	enum PayType { SALARY, HOURLY };
	
	public Employee(String name, String id, Payer payer) {
		this.name = name;
		this.id = id;
		this.payer = payer;
	}
	public Employee(String name, String id) {
		this(name, id, new SalaryPayer());
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public String pay() {
		return payer.runPayroll();
	}
	
	public String toString() {
		return name + " (" + id + ")";
	}
	
	
}
