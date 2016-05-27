package org.bwillard.ccsf.course.cs111c.homework2;

public class Student {

	private String id;
	private Name fullName;
	
	public Student(){
		fullName = new Name();
		id = "";
	}
	
	public Student(Name studentName, String studentId) {
		fullName = studentName;
		id = studentId;
	}
	
	public void setStudent(Name studentName, String studentId) {
		setFullName(studentName);
		setId(studentId);
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Name getFullName() {
		return fullName;
	}

	public void setFullName(Name fullName) {
		this.fullName = fullName;
	}
	
	public String toString() {
		return this.id + " " + this.fullName.toString();
	}
}
