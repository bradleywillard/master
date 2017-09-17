package org.bwillard.ccsf.course.cs211s._2_factory_pattern;

/**
 * 
 * @author bradleywillard
 *
 */
public class Violin extends Instrument {
	
	//Just a product id prefix used when creating the object
	//We could create a getter for this property someday if it's needed
	private static final String PID_PREFIX = "VIO";
	
	/**
	 * Constructor
	 * 
	 * @param type
	 * @param brand
	 * @param model
	 * @param price
	 * @param amplified
	 */
	public Violin(
			InstrumentType type,
			String brand, 
			String model,
			double price,
			boolean amplified) {
		super(type, brand, model, PID_PREFIX, price);
		this.amplified = amplified;
	}
	
	@Override
	public void play() {
		System.out.println("Playing " + getBrand() + " " + getModel() + "! Here we go....");
	}
	
	@Override
	public void tune() {
		System.out.println("Tuning " + getType() + "!");
	}

	@Override
	public void repair() {
		System.out.println("Repairing " + getType() + "... OOPS!");
	}

	@Override
	boolean isAmplified() {
		return amplified;
	}

	@Override
	boolean isString() {
		return true;
	}

	@Override
	boolean isPercussive() {
		return false;
	}

}
