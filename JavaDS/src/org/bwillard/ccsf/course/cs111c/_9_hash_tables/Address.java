package org.bwillard.ccsf.course.cs111c._9_hash_tables;

public class Address {

	private String streetAddress;
	private int zipCode;
	private String name;
	
	public Address(String sa, int z) {
		this.streetAddress = sa;
		this.zipCode = z;
	}
	
	public Address(String sa, int z, String n) {
		this.streetAddress = sa;
		this.zipCode = z;
		this.name = n;
	}


	public String getStreetAddress() {
		return streetAddress;
	}


	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}


	public int getZipCode() {
		return zipCode;
	}


	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}
	
	public String toString() {
		return name + " : (" + streetAddress + " " + zipCode + ")";
	}
	
}
