package org.bwillard.ccsf.course.cs211s._5_mvc_swing_gui.instruments;

public abstract class InstrumentBuilder {
	protected String brand, model, pidPrefix;
	protected InstrumentType type;
	protected double price;
	protected boolean amplified;
	protected Player player;
	
	public abstract Instrument build();
	
	public InstrumentBuilder brand(String brand) {
		this.brand = brand;
		return this;
	}
	
	public InstrumentBuilder model(String model) {
		this.model = model;
		return this;
	}
	
	public InstrumentBuilder type(InstrumentType type) {
		this.type = type;
		return this;
	}
	
	public InstrumentBuilder price(double price) {
		this.price = price;
		return this;
	}

	public InstrumentBuilder player(Player player) {
		this.player = player;
		return this;
	}
	
	public InstrumentBuilder amplified(boolean amplified) {
		this.amplified = amplified;
		return this;
	}

}
