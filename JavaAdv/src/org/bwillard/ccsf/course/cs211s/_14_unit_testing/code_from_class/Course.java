package org.bwillard.ccsf.course.cs211s.assn14.code_from_class;

import java.util.*;

public class Course {
	
	private String name;
	private List<Student> students;
	
	public Course(String name) {
		this.name = name;
		this.students = new ArrayList<>();
	}
	
	public boolean addStudent(Student s) {
		return students.add(s);
	}
	
	public boolean removeStudent(Student s) {
		return students.remove(s);
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Student> getStudents() {
		return students;
	}
	

	@Override
	public String toString() {
		return name + "\n\t" + students;
	}
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Course) {
			Course otherCourse = (Course) obj;
			return name.equalsIgnoreCase(otherCourse.name) &&
					students.equals(otherCourse.students);
		} else {
			return false;
		}
	}
	
	

}
