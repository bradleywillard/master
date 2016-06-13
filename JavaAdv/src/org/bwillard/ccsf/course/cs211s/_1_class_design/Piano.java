package org.bwillard.ccsf.course.cs211s._1_class_design;

/**
 * Pojo to hold data for piano
 * 
 * @author bradleywillard
 *
 */
public class Piano extends Percussive {
	
	/**
	 * number of keys, i.e. 44, 66 or 88
	 */
	private int numKeys;
	
	/**
	 * Upright, Organ, Square, Grand, etc...
	 */
	private PianoType pianoType;
	
	/**
	 * Constructor
	 * 
	 * @param numKeys
	 * @param price
	 * @param pianoType
	 * @param productId
	 * @param brand
	 * @param model
	 */
	public Piano(
			int numKeys, double price,
			PianoType pianoType,
			String productId, String brand, String model) {
		super(price, InstrumentType.PIANO, productId, brand, model);
		this.numKeys = numKeys;
		this.pianoType = pianoType;
	}

	@Override
	public int getNumKeys() {
		return numKeys;
	}

	@Override
	public PianoType getPianoType() {
		return this.pianoType;
	}
	
	@Override
	public void play() {
		System.out.println("Playing piano. This takes practice!");
		readMusic();
		solo();
		improvise();
	}

	@Override
	public void tune() {
		System.out.println("Tuning piano. Good luck!");
	}

	@Override
	public void repair() {
		System.out.println("Repairing piano? Who me??? I don't think so.  Pay what's his face to do it!");
	}

	private void solo() {
		System.out.println("Soloing! Oh so sophisticated!");
	}
	
	private void readMusic() {
		System.out.println("Read and play at the same time????  You're such a virtuoso");
	}
	
	private void improvise() {
		System.out.println("Forget reading the piece.  Do yo own thing!");
	}
	
	@Override
	public String toString() {
		return "PIANO - " + getProductId();
	}
}
