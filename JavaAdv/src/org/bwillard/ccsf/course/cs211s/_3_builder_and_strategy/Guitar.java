package org.bwillard.ccsf.course.cs211s._3_builder_and_strategy;


public class Guitar extends Instrument {
		
	private static final String PID_PREFIX = "GUI";
	
	private Guitar(GuitarBuilder builder) {
		super(builder);
		this.amplified = builder.amplified;
	}

	@Override
	boolean isStringInstrument() {
		return false;
	}

	@Override
	boolean isPercussive() {
		return false;
	}

	@Override
	boolean isAmplified() {
		return amplified;
	}
	
	public static class GuitarBuilder extends InstrumentBuilder {
		
		public GuitarBuilder(String brand, String model, InstrumentType type) {
			this.brand = brand;
			this.model = model;
			this.type = type;
			this.price = 00.00;
			this.amplified = true;
			this.pidPrefix = PID_PREFIX;
			this.player = new GuitarPlayer(brand, model, type);
		}
		
		@Override
		public Guitar build() {
			if(brand == null || model == null || type == null)
				throw new IllegalStateException();
			return new Guitar(this);
		}

	}

}
