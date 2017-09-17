package org.bwillard.ccsf.course.cs211s._1_class_design;

/**
 * Pojo to hold data for percussive instruments: drums, piano, etc...
 * 
 * @author bradleywillard
 *
 */
public abstract class Percussive extends Instrument {

	public Percussive(
			double price, 
			InstrumentType type, 
			String productId, String brand, String model) {
		super(price, type, productId, brand, model);
	}

	abstract PianoType getPianoType();
	abstract int getNumKeys();
	
	@Override
	public void play() {
		System.out.println("Playing percussive instrument!");
	}

	@Override
	public void tune() {
		System.out.println("Tuning percussive instrument!");
	}

	@Override
	public void repair() {
		System.out.println("Repairing percussvie instrument!");
	}
	
	@Override
	public String toString() {
		return "Percussive Instrument - ProductId: " + getProductId();
	}
	
}
