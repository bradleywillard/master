package org.bwillard.ccsf.course.cs211s._1_class_design;

/**
 * Pojo for guitar
 * 
 * @author bradleywillard
 *
 */
public class Guitar extends Stringed {

	//Does this guitar plug into an amp?
	private boolean amplified;
	
	//What type of guitar is it? acoustic, electric, etc...
	private GuitarType guitarType;
	
	/**
	 * Constructor
	 * 
	 * @param amplified
	 * @param numStrings
	 * @param price
	 * @param guitarType
	 * @param stringType
	 * @param productId
	 * @param brand
	 * @param model
	 */
	public Guitar(
			boolean amplified, 
			int numStrings, double price,
			GuitarType guitarType, StringType stringType, 
			String productId, String brand, String model) {
		super(numStrings, price, InstrumentType.GUITAR, stringType, productId, brand, model);
		this.amplified = amplified;
		this.guitarType = guitarType;
	}

	@Override
	public GuitarType getGuitarType() {
		return guitarType;
	}
	
	//IGNORE!!.....
	@Override
	ViolinType getViolinType() {
		return null;
	}
	
	@Override
	public boolean isAmplified() {
		return amplified;
	}
	
	@Override
	public void play() {
		pick();
		strum();
		shred();
		arpeggiate();
	}
	
	private void pick() {
	    System.out.println("Picking guitar!");	
	}
	
	private void strum() {
		System.out.println("Strumming guitar!");
	}
	
	private void shred() {
		System.out.println("Shredding a lead solo like a Rock God!");
	}
	
	private void arpeggiate() {
		System.out.println("Play with your fingers ONLY!  No picks!");
	}
	
	@Override
	public void tune() {
		System.out.println("Tuning guitar!");
	}

	@Override
	public void repair() {
		System.out.println("Repairing guitar... NOT. Taking it into Gary Brower's shop!");
	}
	
	@Override
	public String toString() {
		return "GUITAR - " + getProductId();
	}

}
