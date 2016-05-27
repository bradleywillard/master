package org.bwillard.ccsf.course.cs211s.assn14.code_from_class;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class CourseTest {
	
	Student s1, s2, s3;
	Course course;

	@Before
	public void setUp() throws Exception {
		System.out.println("setup code");
		course = new Course("Java");
		s1 = new Student("Sally Studier");
		s2 = new Student("Pat Procrastinator");
		s3 = new Student("Alan AsksALot");
	}

	@Test
	public void testAddStudent() {
		fail("Not yet implemented");
	}

	@Test
	public void testAddStudentToEmpty() {
		course.addStudent(s1);
		List<Student> studentList = course.getStudents();
		assertTrue(studentList.contains(s1));
	}
	
	@Test
	public void testRemoveStudentFromEmpty() {
		course.removeStudent(s1);
		List<Student> studentList = course.getStudents();
		assertNotNull(studentList);
		assertTrue(studentList.isEmpty());
	}

}
