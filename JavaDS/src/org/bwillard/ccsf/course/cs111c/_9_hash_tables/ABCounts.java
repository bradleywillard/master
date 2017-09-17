package org.bwillard.ccsf.course.cs111c._9_hash_tables;

public class ABCounts {
	int aCount;
	int bCount;

	public ABCounts() {
		aCount = 0;
		bCount = 0;
	}

	public int getACount() {
		return aCount;
	} 

	public int getBCount() {
		return bCount;
	} 

	public void updateCount(char choice) {
		if (Character.toUpperCase(choice) == 'A')
			aCount++;
		else if (Character.toUpperCase(choice) == 'B')
			bCount++;
		else
			throw new RuntimeException("Illegal choice");
	} 
	public String toString() {
		return "A: " + aCount + "\tB: " + bCount;
	}
} 
