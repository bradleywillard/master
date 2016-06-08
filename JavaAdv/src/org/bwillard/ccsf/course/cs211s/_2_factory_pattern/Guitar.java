package org.bwillard.ccsf.course.cs211s._2_factory_pattern;

public class Guitar extends Instrument {
		
	private static final String PID_PREFIX = "GUI";
	
	public Guitar(
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
		pick();
		strum();
		arpeggiate();
		shred();
	}
	
	@Override
	public String getProductId() {
		return "GUI-" + getType().getOrdinal() + "-" + hashCode();
	}
	
	private void pick() {
	    System.out.println("Picking " + getBrand() + " " + getModel() + "!");	
	}
	
	private void strum() {
		System.out.println("Strumming " + getBrand() + " " + getModel() + "!");
	}
	
	private void shred() {
		System.out.println("Shredding a lead solo on " + getBrand() + " " + getModel() + " like a God!");
	}
	
	private void arpeggiate() {
		System.out.println("Arpeggiating " + getBrand() + " " + getModel() + " with your fingers ONLY!  No picks!");
	}
	
	@Override
	public void tune() {
		System.out.println("Tuning " + getBrand() + " " + getModel() + "! Tune it or die!");
	}

	@Override
	public void repair() {
		System.out.println("Repairing " + getBrand() + " " + getModel() + "... ME? NO!! I'll take it to Gary Brower's shop!");
	}

	@Override
	boolean isString() {
		return true;
	}

	@Override
	boolean isPercussive() {
		return false;
	}

	@Override
	boolean isAmplified() {
		return amplified;
	}

}
