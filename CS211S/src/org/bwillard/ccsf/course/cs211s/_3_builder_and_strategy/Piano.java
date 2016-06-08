package org.bwillard.ccsf.course.cs211s.assn3;

public class Piano extends Instrument {
			
	private static final String PID_PREFIX = "PIA";
	
	private Piano(PianoBuilder builder) {
		super(builder);
		this.amplified = builder.amplified;
	}

	@Override
	boolean isStringInstrument() {
		return false;
	}

	@Override
	boolean isPercussive() {
		return true;
	}
	
	@Override
	boolean isAmplified() {
		return amplified;
	}
	
	public static class PianoBuilder extends InstrumentBuilder {
				
		public PianoBuilder(String brand, String model, InstrumentType type) {
			this.brand = brand;
			this.model = model;
			this.type = type;
			this.price = 00.00;
			this.amplified = false;
			this.pidPrefix = PID_PREFIX;
			this.player = new PianoPlayer(brand, model, type);			
		}

		@Override
		public Piano build() {
			if(brand == null || model == null || type == null)
				throw new IllegalStateException();
			return new Piano(this);
		}

	}
}
