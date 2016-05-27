package org.bwillard.ccsf.course.cs211s.midTerm;

public class DocStudent extends Student {
	
	private String dissertationTopic;

	public DocStudent(String id, String name, Major major, String dissertationTopic) {
		super(id, name, major, GradRequirement.DISSERTATION);
		this.dissertationTopic = dissertationTopic;
		this.graduator = new ThesisGraduator(dissertationTopic);
	}

	@Override
	public void payTuition() {
		System.out.println("Paying no tuition but work in Research and as TA as " + this.getClass().getSimpleName()  + " " + getName());
	}
	
	public String getDissertationTopic() {
		return dissertationTopic;
	}

	public void setDissertationTopic(String dissertationTopic) {
		this.dissertationTopic = dissertationTopic;
	}

	@Override
	public String toString() {
		return "DocStudent ["
				+ " name=" + getName() 
				+ ", id=" + getId() 
				+ ", major=" + getMajor() 
				+ ", dissertation=" + dissertationTopic 
				+ ", hashCode()=" + hashCode() 
				+ "]";
	}
	
}
