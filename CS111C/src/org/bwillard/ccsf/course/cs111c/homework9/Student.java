package org.bwillard.ccsf.course.cs111c.homework9;

public class Student {
	
	private int id;
	private String name;
	
	public Student(int id, String name) {
		setID(id);
		setName(name);
	}
	public int getID() {
		return id;
	}
	public void setID(int id) {
		if(0 < id && id <= 99999) {
			this.id = id;
		}
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String toString() {
		return name + " (ID: " + id + ")";
	}
	
	
}
