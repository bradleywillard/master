package org.bwillard.ccsf.course.cs211s._5_mvc_swing_gui.guicode2.student_mvc;

/* the model */
public class Student {
	
	private String name, id;
	private boolean tuitionPaid;
	
	public Student(String name, String id, boolean tuitionPaid) {
		this.name = name;
		this.id = id;
		this.tuitionPaid = tuitionPaid;
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
	public boolean isTuitionPaid() {
		return tuitionPaid;
	}
	public void setTuitionPaid(boolean tuitionPaid) {
		this.tuitionPaid = tuitionPaid;
	}
	
	@Override
	public String toString() {
		return name + " (ID: " + id + "); Tuition Paid? " + tuitionPaid;
	}
	
	

}
