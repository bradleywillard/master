package org.bwillard.ccsf.course.cs211s._5_mvc_swing_gui.instruments;

public class StringInstrumentPlayer implements Player {
	
	private String brand, model;
	private InstrumentType type;
	
	public StringInstrumentPlayer(String brand, String model, InstrumentType type) {
		this.brand = brand;
		this.model = model;
		this.type = type;
	}
	
	@Override
	public void play() {
		System.out.println("Playing " + type.getDisplayName() + " " + brand + " " + model + "! Here we go....");
	}
	
	@Override
	public void tune() {
		System.out.println("Tuning " + brand + " " + model + "!");
	}

	@Override
	public void repair() {
		System.out.println("Repairing " + brand + " " + model + "... OOPS!");
	}

}
