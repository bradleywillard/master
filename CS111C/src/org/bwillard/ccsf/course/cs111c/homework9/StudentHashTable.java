package org.bwillard.ccsf.course.cs111c.homework9;

public class StudentHashTable {

	private Student[] hashTable;
	private int tableSize;
	
	public StudentHashTable(int size) {
		hashTable = new Student[size];
		tableSize = size;
	}
	
	public void addStudent(Student studentToAdd) {
		System.out.println("Adding " + studentToAdd.getName() + "...");
		int hashCode = findHashFunction(studentToAdd);
		int hashLocation = hashCode;
		
		while(hashTable[hashLocation] != null) {
			System.out.println("\tCollision at position " + hashLocation);
			hashLocation++;
			hashLocation = hashLocation % tableSize;
			System.out.println("\tTrying position " + hashLocation);
		}
		
		hashTable[hashLocation] = studentToAdd;
		System.out.println("\tAdded at position " + hashLocation);
		printTable();
	}
	
	// two private helper methods to find the hash code
	private int findHashFunction(Student s) {
		int studentID = s.getID();
		return findHashFunction(studentID);
	}
	private int findHashFunction(int studentID) {
		int hashCode = studentID % tableSize;
		return hashCode;
	}
	
	public Student findStudent(int studentIDToFind) {
		System.out.println("Looking for student with ID " + studentIDToFind + "...");
		int hashLocation = findHashFunction(studentIDToFind);
		if(hashTable[hashLocation] == null) {
			System.out.println("\tStudent not found.");
			return null;
		} else {
					
			while(hashTable[hashLocation] != null) {
				Student studentAtHashLocation = hashTable[hashLocation];
				
				if(studentAtHashLocation.getID() == studentIDToFind) {
					System.out.println("\tStudent found at position " + hashLocation);
					return studentAtHashLocation;
				} else {
					System.out.println("\tCorrect student not found at position " + hashLocation);
					hashLocation++;
					hashLocation = hashLocation % tableSize;
					System.out.println("\tTrying location " + hashLocation);
				}
			
			}
			System.out.println("\tStudent not found.");
			return null;
		}
	}

	private void printTable() {
		System.out.println();
		for(int i=0; i<tableSize; i++) {
			System.out.println("\t" + i + "\t\t" + hashTable[i]);
		}
		System.out.println();
		
	}
	
	
	
}
