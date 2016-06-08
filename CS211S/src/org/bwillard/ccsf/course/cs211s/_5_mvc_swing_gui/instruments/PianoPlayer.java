package org.bwillard.ccsf.course.cs211s.assn5.instruments;

public class PianoPlayer implements Player {
	
	private String brand, model;
	InstrumentType type;
	
	public PianoPlayer(String brand, String model, InstrumentType type) {
		this.brand = brand;
		this.model = model;
		this.type = type;
	}
	
	@Override
	public void play() {
		System.out.println("Playing "  + type.getDisplayName() + " " + brand + " " + model + "! Here we go....");
		readMusic();
		solo();
		improvise();
	}

	@Override
	public void tune() {
		System.out.println("Tuning " + type.getName() + ". Good luck!");
	}

	@Override
	public void repair() {
		System.out.println("Repairing " + type.getName() + "? Who me??? I don't think so. Pay what's his face to do it!");
	}
	
	private void solo() {
		System.out.println("Solo on " + type.getName() + "! Show off your chops!");
	}
	
	private void readMusic() {
		System.out.println("Reading Music on " + type.getName() + "! Read and play at the same time????  What a virtuoso!");
	}
	
	private void improvise() {
		System.out.println("Improvising on " + type.getName() + "!  Forget reading the piece.  Do yo own thing!");
	}

}
