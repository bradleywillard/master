package org.bwillard.ccsf.course.cs211s.midTerm;

public class GPAGraduator implements Graduator {

	private Double gpa;
	
	public GPAGraduator(Double gpa) {
		this.gpa = gpa;
	}
	
	@Override
	public void printGraduationRequirements(String type, String name) {
		
		StringBuilder sb = new StringBuilder()
			.append(type).append(" ").append(name);
		if(gpa < 2.0) {
			sb.append(" has not met the requirements to graduate.  Reason: GPA < 2.0, GPA = ").append(gpa);
		} else {
			sb.append(" has met the requirement to graduate. GPA > 2.0, GPA = ").append(gpa);
		}
		
		System.out.println(sb.toString());
	}

}
