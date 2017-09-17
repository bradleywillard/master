package org.bwillard.ccsf.course.cs111c._2_bags;

public class Name {
	
	private String first;
	private String last;
	public String getFirst() {
		return first;
	}
	public void setFirst(String first) {
		this.first = first;
	}
	public String getLast() {
		return last;
	}
	public void setLast(String last) {
		this.last = last;
	}
	
	public String toString() {
		return this.first + " " + this.last;
	}

}
