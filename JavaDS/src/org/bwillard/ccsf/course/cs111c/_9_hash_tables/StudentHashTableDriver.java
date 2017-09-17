package org.bwillard.ccsf.course.cs111c._9_hash_tables;

public class StudentHashTableDriver {

	public static void main(String[] args) {

		Student s1 = new Student(123, "Sam Studier");
		Student s2 = new Student(514, "Pat Procrastinator");
		Student s3 = new Student(7180, "Ollie Overachiever");
		Student s4 = new Student(99, "Sid Slacker");
		Student s5 = new Student(4914, "Alex Asksalot");
		Student[] theStudents = {s1, s2, s3, s4, s5};
		
		StudentHashTable studentTable = new StudentHashTable(11);
		
		for(Student s : theStudents) {
			studentTable.addStudent(s);
		}
		
		Student s = studentTable.findStudent(99);
		System.out.println(s);
				
		s = studentTable.findStudent(43);
		
	}
	
}
