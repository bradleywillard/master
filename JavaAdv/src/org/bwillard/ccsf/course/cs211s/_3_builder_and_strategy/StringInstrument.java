package org.bwillard.ccsf.course.cs211s._3_builder_and_strategy;

/**
 * 
 * @author bradleywillard
 *
 */
public class StringInstrument extends Instrument {
	
	private static final String PID_PREFIX = "VIO";
	
	private StringInstrument(StringInstrumentBuilder builder) {
		super(builder);
		this.amplified = builder.amplified;
	}

	@Override
	boolean isAmplified() {
		return amplified;
	}

	@Override
	boolean isStringInstrument() {
		return true;
	}

	@Override
	boolean isPercussive() {
		return false;
	}
	
	/**
	 * Builder class for StringInstrument
	 * 
	 * @author bradleywillard
	 *
	 */
	public static class StringInstrumentBuilder extends InstrumentBuilder {
		
		public StringInstrumentBuilder(String brand, String model, InstrumentType type) {
			this.brand = brand;
			this.model = model;
			this.type = type;
			this.price = 00.00;
			this.amplified = true;
			this.pidPrefix = PID_PREFIX;
			//Strategy pattern here as well as the design principle known as Composition
			this.player = new StringInstrumentPlayer(brand, model, type);
		}
		
		@Override
		public StringInstrument build() {
			if(brand == null || model == null || type == null)
				throw new IllegalStateException();
			return new StringInstrument(this);
		}

	}

}
