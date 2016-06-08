package org.bwillard.ccsf.course.cs211s._2_factory_pattern;

public class Drums extends Instrument {
	
	private static final String PID_PREFIX = "DRU";
	
	public Drums(
			String brand, 
			String model,
			double price) {
		super(InstrumentType.DRUMS, brand, model, PID_PREFIX, price);
		
	}
	
	@Override
	public void play() {
		System.out.println("Playing " + getBrand() + " " + getModel() + "! Here we go....");
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
		System.out.println("Tuning " + getType().getName() + ". Cake!");
	}

	@Override
	public void repair() {
		System.out.println("Repairing " + getType().getName() + ".  Shouldn't be too hard!");
	}
	
	private void kickKickDrum() {
		System.out.println("Kicking kick " + getType().getName() + "!");
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

	@Override
	boolean isAmplified() {
		return false;
	}

	@Override
	boolean isString() {
		return false;
	}

	@Override
	boolean isPercussive() {
		return true;
	}
	
}
