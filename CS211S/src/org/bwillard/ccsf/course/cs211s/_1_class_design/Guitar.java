package org.bwillard.ccsf.course.cs211s.assn1;

public class Guitar extends Stringed {

	private boolean amplified;
	private GuitarType guitarType;
	
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
