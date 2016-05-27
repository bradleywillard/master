package org.bwillard.ccsf.course.cs211s.midTerm;

public enum Major {
	
	COMPUTER_SCIENCE("Computer Science"),
	INFORMATION_SYSTEMS_MGMT("Information Systems Management"),
	ENGINEERING("Engineering"),
	KINESIOLOGY("Kinesiology"),
	PHYSICS("Physics"),
	BIOLOGY("Biologiy"),
	PHYSIOLOGY("Physiology"),
	PSYCHOLOGY("Psychology");
	
	private String displayName;
	
	private Major(String name) {
		this.displayName = name;
	}
	
	public String getDisplayName() {
		return displayName;
	}
	
}

