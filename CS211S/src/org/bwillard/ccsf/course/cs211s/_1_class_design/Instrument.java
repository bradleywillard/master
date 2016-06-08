package org.bwillard.ccsf.course.cs211s.assn1;

public abstract class Instrument {

	private double price;
	private InstrumentType type;
	private String productId;
	private String brand;
	private String model;
	
	abstract void play();
	abstract void tune();
	abstract void repair();
	
	public Instrument() {
		
	}
	
	public Instrument(
			double price, 
			InstrumentType type, 
			String productId, String brand, String model) {
		this.price = price;
		this.type = type;
		this.productId = productId;
		this.brand = brand;
		this.model = model;
	}
	
	/*
	 * Common to all instruments.
	 */
	protected void sell(int quantity, Stringed productId, double price) {
		double total = quantity * price;
		System.out.println("Sold " + quantity + " " + productId + " at $" + price + " = " + total);
	}
	
	public double getPrice() {
		return price;
	}
	public String getProductId() {
		return productId;
	}
	public String getBrand() {
		return brand;
	}
	public String getModel() {
		return model;
	}
	public InstrumentType getType() {
		return type;
	}
	
	@Override
	public String toString() {
		return getType() + " - " + getBrand() + " " + getModel() + " " + getProductId() + " " + getPrice();
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof Instrument) 
			return this.productId.equals(((Instrument)o).productId);
		else 
			return false;
	}
	
	@Override
	public int hashCode(){
		int code = 0;
		for(int i = 0; i < productId.length(); i++) {
			code += productId.charAt(i);
		}
		return code;
	}
}
