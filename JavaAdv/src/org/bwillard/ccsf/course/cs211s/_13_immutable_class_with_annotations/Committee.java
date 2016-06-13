package org.bwillard.ccsf.course.cs211s._13_immutable_class_with_annotations;

import java.time.LocalDate;

/**
 * An immutable class.  
 * Final class cannot be sub-classed
 * Final members cannot be set after object construction
 * No setters
 * The otherwise mutable object 'Member' made immutable via instantiation of new in constructor
 * 	-This way, it cannot be pointed to or changed to another reference outside the class 
 * 
 * @author bradleywillard
 *
 */
public final class Committee {

	private final String name;
	private final int numMembers;
	private final Member committeeChair;
	private final LocalDate formationDate;

	/**
	 * Constructor
	 * 
	 * @param name
	 * @param numMembers
	 * @param m
	 * @param d
	 */
	public Committee(String name, int numMembers, Member m, LocalDate d) {
		this.name = name;
		this.numMembers = numMembers;
		this.committeeChair = new Member(m.getFirstName(), m.getLastName(), m.getAge(), m.getStatus());
		this.formationDate = d;
	}

	public String getName() {
		return name;
	}

	public int getNumMembers() {
		return numMembers;
	}

	public Member getCommitteeChair() {
		return new Member(
				committeeChair.getFirstName(), committeeChair.getLastName(), 
				committeeChair.getAge(), committeeChair.getStatus());
	}

	public LocalDate getFormationDate() {
		return formationDate;
	}
	
	
}
