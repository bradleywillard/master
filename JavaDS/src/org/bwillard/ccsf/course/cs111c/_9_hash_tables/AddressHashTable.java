package org.bwillard.ccsf.course.cs111c._9_hash_tables;

public class AddressHashTable {

	private Address[] hashTable;
	private int tableSize;
	
	public AddressHashTable(int size) {
		hashTable = new Address[size];
		tableSize = size;
	}
	
	// two private helper methods to find the hash code
	private int findHashFunction(Address a) {
		String streetAddress = a.getStreetAddress();
		return findHashFunction(streetAddress);
	}
	
	private int findHashFunction(String streetAddress) {
		int addressId = 0;
		for(int i = 0; i < streetAddress.length(); i++) {
			int c = streetAddress.charAt(i);
			addressId += c;
		}
		int hashCode = addressId % tableSize;
		System.out.println(streetAddress + "'s attempted hashCode : " + hashCode);
		return hashCode;
	}
	

	public boolean addAddress(Address addressToAdd) {
		System.out.println("Adding " + addressToAdd.getName() + "...");
		int hashCode = findHashFunction(addressToAdd);
		int hashLocation = hashCode;
		int counter = 0;
		boolean added = false;
		
		while(hashTable[hashLocation] != null && counter < tableSize) {
			System.out.println("\tCollision at position " + hashLocation);
			hashLocation++;
			hashLocation = hashLocation % tableSize;
			System.out.println("\tTrying position " + hashLocation);
			counter++;
		}
		
		if(counter < tableSize) {
			hashTable[hashLocation] = addressToAdd;
			System.out.println("\tAdded at position " + hashLocation);
			added = true;
		} else {
			System.out.println("\tTable full! " + addressToAdd + " not added");
		}
		
		printTable();
		
		return added;
	}
	
	public Address findAddress(String addressToFind) {
		System.out.println("Looking for location with streetAddress " + addressToFind + "...");
		int hashLocation = findHashFunction(addressToFind);
		int counter = 0;
		while(hashTable[hashLocation] != null && counter < tableSize) {
			Address addressAtHashLocation = hashTable[hashLocation];
			String streetAddress = addressAtHashLocation.getStreetAddress();
			if(streetAddress.compareTo(addressToFind) == 0) {
				System.out.println("\tAddress found at position " + hashLocation);
				return addressAtHashLocation;
			} else {
				System.out.println("\tCorrect address not found at position " + hashLocation);
				hashLocation++;
				hashLocation = hashLocation % tableSize;
				System.out.println("\tTrying location " + hashLocation);
			}
			counter++;
		}
		System.out.println("\tAddress not found.");
		return null;
	}
	
	public boolean removeAddress(String streetAddress) {
		Address addressToRemove = findAddress(streetAddress);
		boolean removed = false;
		if(addressToRemove == null) {
			System.out.println("Can't remove address: " + streetAddress + " as it was not found.");
		} else {
			int hashLocation = findHashFunction(streetAddress);
			addressToRemove = hashTable[hashLocation];
			if(addressToRemove != null) {
				hashTable[hashLocation] = null;
				System.out.println("Removed address: " + streetAddress + " at hashLocation" + hashLocation);
				removed = true;
				printTable();
			}
		}
		
		return removed;
	}
	
	
	private void printTable() {
		System.out.println();
		for(int i=0; i<tableSize; i++) {
			System.out.println("\t" + i + "\t\t" + hashTable[i]);
		}
		System.out.println();
		
	}
}
