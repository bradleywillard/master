package org.bwillard.ccsf.course.cs211s.midTerm;

public class MastersStudent extends Student {

	private String thesisTopic;
	
	public MastersStudent(String id, String name, Major major, String thesisTopic) {
		super(id, name, major, GradRequirement.THESIS);
		this.thesisTopic = thesisTopic;
		this.graduator = new ThesisGraduator(thesisTopic);
	}

	@Override
	public void payTuition() {
		System.out.println("Paying half tuition and working as TA as " + this.getClass().getSimpleName()  + " " + getName());
	}

	public void setThesisTopic(String thesisTopic) {
		this.thesisTopic = thesisTopic;
	}

	public String getThesisTopic(){
		return this.thesisTopic;
	}
	
	@Override
	public String toString() {
		return "MastersStudent ["
				+ " name=" + getName() 
				+ ", id=" + getId() 
				+ ", major=" + getMajor() 
				+ ", thesis=" + thesisTopic 
				+ ", hashCode()=" + hashCode() 
				+ "]";
	}
	
}
