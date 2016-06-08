package org.bwillard.ccsf.course.cs211s.assn1;

public abstract class Stringed extends Instrument {

	private int numStrings;
	private StringType stringType;
	
	public Stringed(
			int numStrings, double price, 
			InstrumentType type, StringType stringType, 
			String productId, String brand, String model) {
		super(price, type, productId, brand, model);
		this.numStrings = numStrings;
		this.stringType = stringType;
	}

	abstract boolean isAmplified();
	abstract GuitarType getGuitarType();
	abstract ViolinType getViolinType();

	public int getNumStrings() {
		return numStrings;
	}

	//This returns the type of strings used on the instrument...
	public StringType getStringType() {
		return stringType;
	}

	@Override
	public void play() {
		System.out.println("Playing String Instrument!");
	}

	@Override
	public void tune() {
		System.out.println("Tuning String Instrument!");
	}

	@Override
	public void repair() {
		System.out.println("Repairing String Instrument!");
	}
	
	@Override
	public String toString() {
		return "String Instrument - ProductId: " + getProductId();
	}
}
