package org.bwillard.ccsf.course.cs211s.assn2;

public class Violin extends Instrument {
	
	private static final String PID_PREFIX = "VIO";
	
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
