package org.bwillard.ccsf.course.cs211s._2_factory_pattern;

public class Piano extends Instrument {
		
	//Just a product id prefix used when creating the object
	//We could create a getter for this property someday if it's needed
	private static final String PID_PREFIX = "PIA";
	
	/**
	 * Constructor
	 * 
	 * @param type
	 * @param brand
	 * @param model
	 * @param price
	 * @param amplified
	 */
	public Piano(
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
		readMusic();
		solo();
		improvise();
	}

	@Override
	public void tune() {
		System.out.println("Tuning " + getType().getName() + ". Good luck!");
	}

	@Override
	public void repair() {
		System.out.println("Repairing " + getType().getName() + "? Who me??? I don't think so. Pay what's his face to do it!");
	}

	@Override
	boolean isString() {
		return false;
	}

	@Override
	boolean isPercussive() {
		return true;
	}
	
	@Override
	boolean isAmplified() {
		return amplified;
	}
	
	/**
	 * private methods for pianos and things they can do...
	 */
	private void solo() {
		System.out.println("Solo on " + getType().getName() + "! Show off your chops!");
	}
	
	private void readMusic() {
		System.out.println("Reading Music on " + getType().getName() + "! Read and play at the same time????  What a virtuoso!");
	}
	
	private void improvise() {
		System.out.println("Improvising on " + getType().getName() + "!  Forget reading the piece.  Do yo own thing!");
	}

}
