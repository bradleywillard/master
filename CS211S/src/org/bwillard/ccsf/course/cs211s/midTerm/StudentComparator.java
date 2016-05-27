package org.bwillard.ccsf.course.cs211s.midTerm;

import java.util.Comparator;

public class StudentComparator implements Comparator<Student> {

	@Override
	public int compare(Student s1, Student s2) {
		//If the subclass implementations of student are not of the same type...
		if(s1 == null || s2 == null) 
			return 0;
		String s1Type = s1.getClass().getSimpleName();
		String s2Type = s2.getClass().getSimpleName();
		if(s1Type.compareTo(s2Type) != 0) 
			return s1Type.compareTo(s2Type);
		else
			return s1.getId().compareTo(s1.getId());
	}

}
