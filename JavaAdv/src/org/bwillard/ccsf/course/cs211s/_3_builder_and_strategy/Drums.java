package org.bwillard.ccsf.course.cs211s._3_builder_and_strategy;

/**
 * 
 * @author bradleywillard
 *
 */
public class Drums extends Instrument {
	
	private static final String PID_PREFIX = "DRU";
	
	private Drums(DrumsBuilder builder) {
		super(builder);
		
	}

	@Override
	boolean isAmplified() {
		return false;
	}

	@Override
	boolean isStringInstrument() {
		return false;
	}

	@Override
	boolean isPercussive() {
		return true;
	}
	
	/**
	 * Builder class for Drums
	 * 
	 * @author bradleywillard
	 *
	 */
	public static class DrumsBuilder extends InstrumentBuilder {
		
		public DrumsBuilder(String brand, String model, InstrumentType type) {
			this.brand = brand;
			this.model = model;
			this.type = type;
			this.price = 00.00;
			this.amplified = true;
			this.pidPrefix = PID_PREFIX;
			//Strategy pattern here as well as the design principle known as Composition
			this.player = new DrumsPlayer(brand, model, type);
		}
		
		@Override
		public Drums build() {
			if(brand == null || model == null || type == null)
				throw new IllegalStateException();
			return new Drums(this);
		}

	}
}
