package org.bwillard.ccsf.course.cs211s._3_builder_and_strategy;

/**
 * A class that leverages the Strategy pattern
 * 
 * @author bradleywillard
 *
 */
public class GuitarPlayer implements Player {
	
	private String brand, model;
	private InstrumentType type;
	
	public GuitarPlayer(String brand, String model, InstrumentType type) {
		this.brand = brand;
		this.model = model;
		this.type = type;
	}
	
	@Override
	public void play() {
		System.out.println("Playing " + type.getDisplayName() + " " + brand + " " + model + "! Here we go....");
		pick();
		strum();
		arpeggiate();
		shred();
	}

	@Override
	public void tune() {
		System.out.println("Tuning " + brand + " " + model + "! Tune it or die!");
	}
	
	@Override
	public void repair() {
		System.out.println("Repairing " + brand + " " + model + "... ME? NO!! I'll take it to Gary Brower's shop!");
	}
	
	private void pick() {
	    System.out.println("Picking " + brand + " " + model + "!");	
	}
	
	private void strum() {
		System.out.println("Strumming " + brand + " " + model + "!");
	}
	
	private void shred() {
		System.out.println("Shredding a lead solo on " + brand + " " + model + " like a God!");
	}
	
	private void arpeggiate() {
		System.out.println("Arpeggiating " + brand + " " + model + " with your fingers ONLY!  No picks!");
	}

}
