package org.bwillard.ccsf.course.cs211s.midTerm;

public class BachSciStudent extends Student {

	private Double gpa;
	private String thesisTopic;
	
	public BachSciStudent(String id, String name, Major major, Double gpa, GradRequirement gradReq, String thesisTopic) {
		super(id, name, major, gradReq);
		this.gpa = gpa;
		this.thesisTopic = thesisTopic;
		if(GradRequirement.THESIS == gradReq) 
			this.graduator = new ThesisGraduator(thesisTopic);
		else if(GradRequirement.GPA == gradReq) 
			this.graduator = new GPAGraduator(gpa);
	}

	public void setGpa(Double gpa){
		this.gpa = gpa;
	}

	public Double getGpa() {
		return this.gpa;
	}
	
	public String getThesisTopic() {
		return thesisTopic;
	}

	public void setThesisTopic(String thesisTopic) {
		this.thesisTopic = thesisTopic;
	}

	@Override
	public void payTuition() {
		System.out.println("Paying full tuition for " + this.getClass().getSimpleName() + " " + getName());
	}
	
	@Override
	public String toString() {
		return "BachSciStudent ["
				+ " name=" + getName() 
				+ ", id=" + getId() 
				+ ", major=" + getMajor()
				+ ", gpa=" + gpa
				+ ", hashCode()=" + hashCode() 
				+ "]";
	}

}
