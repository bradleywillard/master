package org.bwillard.ccsf.course.cs211s.midTerm;

public class BachArtsStudent extends Student {

	private Double gpa;
	
	public BachArtsStudent(String id, String name, Major major, Double gpa) {
		super(id, name, major, GradRequirement.GPA);
		this.gpa = gpa;
		this.graduator = new GPAGraduator(gpa);
	}

	public void setGpa(Double gpa){
		this.gpa = gpa;
	}

	public Double getGpa() {
		return this.gpa;
	}
	
	@Override
	public void payTuition() {
		System.out.println("Paying full tuition for " + this.getClass().getSimpleName() + " " + getName());
	}
	
	@Override
	public String toString() {
		return "BachArtsStudent ["
				+ " name=" + getName() 
				+ ", id=" + getId() 
				+ ", major=" + getMajor()
				+ ", gpa=" + gpa
				+ ", hashCode()=" + hashCode() 
				+ "]";
	}
}
