package org.bwillard.ccsf.course.cs211s._2_factory_pattern;

import java.text.DecimalFormat;

public abstract class Instrument implements Comparable<Instrument> {

	private InstrumentType type;
	private String brand;
	private String model;
	private String pidPrefix;
	private double price;
	private int quantity;
	
	protected boolean amplified;
	
	abstract void play();
	abstract void tune();
	abstract void repair();
	abstract boolean isAmplified();
	abstract boolean isString();
	abstract boolean isPercussive();
	
	public Instrument(
			InstrumentType type,
			String brand, 
			String model,
			String pidPrefix,
			double price) {
		this.type = type;
		this.brand = brand;
		this.model = model;
		this.pidPrefix = pidPrefix;
		this.price = price;
		this.quantity = 1;
	}
	
	/*
	 * Common to all instruments.
	 */
	protected void sell(int quantity) {
		this.quantity = quantity;
		String total = valueWithCurrency(price * quantity);
		System.out.println("Sold " + quantity + " " + brand + " " + model + "'s" + " at $" + price + " = " + total);
	}
	
	public String valueWithCurrency(double value) {
		DecimalFormat format = new DecimalFormat("$#.00");
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
		return pidPrefix + "-" + getType().getOrdinal() + "-" + hashCode();
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
				valueWithCurrency(getPrice());
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
