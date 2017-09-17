package org.bwillard.ccsf.course.cs211s._1_class_design;

/**
 * Pojo for Drums
 * 
 * @author bradleywillard
 *
 */
public class Drums extends Instrument {
	
	/**
	 * Constructor
	 * 
	 * @param price
	 * @param type
	 * @param productId
	 * @param brand
	 * @param model
	 */
	public Drums(
			double price, InstrumentType type,
			String productId, String brand, String model) {
		super(price, InstrumentType.DRUMS, productId, brand, model);
		
	}
	
	@Override
	public void play() {
		System.out.println("Playing drums!");
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
		System.out.println("Tuning drums. Cake!");
	}

	@Override
	public void repair() {
		System.out.println("Repairing drums.  Shouldn't be too hard!");
	}
	
	private void kickKickDrum() {
		System.out.println("Kicking kick drum!");
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
