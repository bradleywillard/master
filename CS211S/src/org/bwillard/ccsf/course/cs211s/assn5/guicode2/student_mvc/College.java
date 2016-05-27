package org.bwillard.ccsf.course.cs211s.assn5.guicode2.student_mvc;

/* the model */
import java.util.*;

public class College {
	
	private ArrayList<Student> studentList;
	
	public College() {
		studentList = new ArrayList<Student>();
	}
	
	public boolean addStudent(Student s) {
		return studentList.add(s);
	}
	
	public boolean removeStudent(Student s) {
		return studentList.remove(s);
	}
	
	@Override
	public String toString() {
		String s = "";
		for(Student student : studentList) {
			s += student.toString() + "\n";
		}
		return s;
	}

}
