package org.bwillard.ccsf.course.cs211s._5_mvc_swing_gui.instruments;

public class DrumsPlayer implements Player {
	
	private String brand, model;
	private InstrumentType type;
	
	public DrumsPlayer(String brand, String model, InstrumentType type) {
		this.brand = brand;
		this.model = model;
		this.type = type;
	}
	
	@Override
	public void play() {
		System.out.println("Playing "  + type.getDisplayName() + " " + brand + " " + model + "! Here we go....");
		kickKickDrum();
		hitSnare();
		hitHighHat();
		hitTom1();
		hitTom2();
		hitFloorTom();
		hitCrash();
		hitSplash();
		hitRide();
	}

	@Override
	public void tune() {
		System.out.println("Tuning " + brand + " " + model + ". Cake!");
	}

	@Override
	public void repair() {
		System.out.println("Repairing " + brand + " " + model + ".  Shouldn't be too hard!");
	}
	
	private void kickKickDrum() {
		System.out.println("Kicking kick " + brand + " " + model + "!");
	}
	
	private void hitSnare() {
		System.out.println("Hitting snare!");
	}
	
	private void hitHighHat() {
		System.out.println("Hitting High Hat!");
	}
	
	private void hitCrash() {
		System.out.println("Crash!");
	}
	
	public void hitSplash() {
		System.out.println("Splash!");
	}
	
	public void hitRide() {
		System.out.println("Hitting Ride!");
	}
	
	private void hitTom1() {
		System.out.println("Hitting Tom 1!");
	}
	
	private void hitTom2() {
		System.out.println("Hitting Tom 2!");
	}
	
	private void hitFloorTom() {
		System.out.println("Hitting Floor Tom!");
	}

}
