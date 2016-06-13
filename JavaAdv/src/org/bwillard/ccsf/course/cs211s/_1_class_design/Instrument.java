package org.bwillard.ccsf.course.cs211s._1_class_design;

/**
 * 
 * @author bradleywillard
 *
 */
public abstract class Instrument {

	private double price;
	private InstrumentType type;
	private String productId;
	private String brand;
	private String model;
	
	/**
	 * play the instrument
	 */
	abstract void play();
	
	/**
	 * tune the instrument
	 */
	abstract void tune();
	
	/**
	 * repair a broken instrument
	 */
	abstract void repair();
	
	/**
	 * Default constructor
	 */
	public Instrument() {
		
	}
	
	/**
	 * Constructor
	 * 
	 * @param price
	 * @param type
	 * @param productId
	 * @param brand
	 * @param model
	 */
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
