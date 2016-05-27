package org.bwillard.ccsf.course.cs211s.assn5.instruments;

import java.text.DecimalFormat;

public abstract class Instrument implements Comparable<Instrument> {

	private InstrumentType type;
	private String brand;
	private String model;
	private String pidPrefix;
	private double price;
	private int quantity;
	
	protected Player player;
	protected boolean amplified;
	
	abstract boolean isAmplified();
	abstract boolean isStringInstrument();
	abstract boolean isPercussive();
	
	public Instrument(InstrumentBuilder builder) {
		this.type = builder.type;
		this.brand = builder.brand;
		this.model = builder.model;
		this.pidPrefix = builder.pidPrefix;
		this.price = builder.price;
		this.player = builder.player;
	}
	
	/**
	 * Utility method to format double value for currency
	 * @param value
	 * @return
	 */
	public static String currencyFormat(double value) {
		DecimalFormat format = new DecimalFormat("$#,###.00");
		return format.format(value);
	}
	
	public InstrumentType getType() {
		return type;
	}
	public String getBrand() {
		return brand;
	}
	public String getModel() {
		return model;
	}
	public String getProductId() {
		return pidPrefix + "-" + getType().getId() + "-" + hashCode();
	}
	public double getPrice() {
		return price;
	}
	public int getQuantity() {
		return quantity;
	}
	
	@Override
	public String toString() {
		return getType().getName() + " : " + 
				getBrand() + " - " + 
				getModel() + " : " + 
				getProductId() + " : " + 
				currencyFormat(getPrice());
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof Instrument) 
			return this.getProductId().equals(((Instrument)o).getProductId());
		else 
			return false;
	}
	
	/*
	 * Hash code is mode up of ints from the characters in the InstrumentType name, 
	 * i.e. STEEL STRING ACOUSTIC GUITAR comes out as 
	 * This ensures all STEEL STRING ACOUSTIC GUITARs are in the same bucket (share same hashcode)
	 */
	@Override
	public int hashCode(){
		int code = 0;
		for(int i = 0; i < getType().getName().length(); i++) {
			code += getType().getName().charAt(i);
		}
		return code;
	}
	
	@Override
	public int compareTo(Instrument o) {
		return this.getProductId().compareTo(o.getProductId());
	}
}
