package org.bwillard.ccsf.course.cs211s.midTerm;

public class ThesisGraduator implements Graduator {

	private String thesisTopic;
	
	public ThesisGraduator(String thesisTopic) {
		this.thesisTopic = thesisTopic;
	}
	
	@Override
	public void printGraduationRequirements(String type, String name) {
		StringBuilder sb = new StringBuilder()
		.append(type).append(" ").append(name)
		.append(" needs to present his/her thesis/dissertation topic : '")
		.append(thesisTopic).append("' in order to graduate.");
		
		System.out.println(sb.toString());
	}

}
