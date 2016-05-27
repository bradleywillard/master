package org.bwillard.ccsf.course.cs211s.midTerm;

import static org.bwillard.ccsf.course.cs211s.midTerm.Student.StudentType;

public class EnglishDepartment extends Department {

	private static final String ENGLISH_DEPARTMENT = "English Department";

	public EnglishDepartment() {
		super(ENGLISH_DEPARTMENT);
	}

	@Override
	public void addStudent(StudentType type, String name, String id, Major major, Object... otherInfo) {
		if(type == StudentType.BACHELOR_ARTS) {
			Double gpa = (Double)otherInfo[0];
			BachArtsStudent student = new BachArtsStudent(id, name, major, gpa);
			addStudent(student);
		} else if(type == StudentType.MASTERS) {
			String thesis = (String)otherInfo[0];
			MastersStudent student = new MastersStudent(id, name, major, thesis);
			addStudent(student);
		} else if(type == StudentType.PHD) {
			String dissertation = (String)otherInfo[0];
			DocStudent student = new DocStudent(id, name, major, dissertation);
			addStudent(student);
		}
	}
	
	private void addStudent(Student student) {
		this.enrolledStudents.add(student);
	}

}
