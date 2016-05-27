package org.bwillard.ccsf.course.cs211s.midTerm;

import java.util.ArrayList;
import java.util.List;

import static org.bwillard.ccsf.course.cs211s.midTerm.Student.StudentType;


public abstract class Department {

	private String name;
	protected List<Student> enrolledStudents;
	
	public abstract void addStudent(StudentType type, String name, String id, Major major, Object... otherInfo);
	
	public Department(String name) {
		this.name = name;
		this.enrolledStudents = new ArrayList<Student>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Student> getEnrolledStudents() {
		return enrolledStudents;
	}
	
	public void setEnrolledStudents(List<Student> enrolledStudents) {
		this.enrolledStudents = enrolledStudents;
	}

	public void printStudentsMajors() {
		for(Student s : enrolledStudents) {
			System.out.println("Name : " + s.getName() + "; Major : " + s.getMajor());
		}
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;
		Department other = (Department) obj;
		if (enrolledStudents == null && other.enrolledStudents != null) {
			return false;
		} else if (!enrolledStudents.equals(other.enrolledStudents))
			return false;
		if (name == null && other.name != null) {
			return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Department ["
				+ "name=" + name 
				+ ", enrollees=" + enrolledStudents
				+ ", hashCode()=" + hashCode()
				+ ", getClass()=" + getClass() + "]";
	}

}
