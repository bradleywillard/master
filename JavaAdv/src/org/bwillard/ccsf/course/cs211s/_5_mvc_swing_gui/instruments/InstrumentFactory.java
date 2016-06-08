package org.bwillard.ccsf.course.cs211s._5_mvc_swing_gui.instruments;

import java.util.ArrayList;
import java.util.List;

public class InstrumentFactory {

	protected List<Instrument> instruments;

	public InstrumentFactory() {
		instruments = new ArrayList<Instrument>();
	}

	public Instrument createInstrument(String brand, String model, InstrumentType type, double price) {
		if(Guitar.FAMILY_NAME.equals(type.getFamily())) {
			return new Guitar.GuitarBuilder(brand, model, type)
				.price(price)
				.build();
		} else if(Piano.FAMILY_NAME.equals(type.getFamily())) {
			return new Piano.PianoBuilder(brand, model, type)
				.price(price)
				.build();
		} else if(StringInstrument.FAMILY_NAME.equals(type.getFamily())) {
			return new StringInstrument.StringInstrumentBuilder(brand, model, type)
				.price(price)
				.build();
		} else if(Drums.FAMILY_NAME.equals(type.getFamily())) {
			return new Drums.DrumsBuilder(brand, model, type)
				.price(price)
				.build();
		} else {
			return null;
		}
	}
	
	public void addInstrument(Instrument inst) {
		System.out.println("Adding : " + inst.toString());
		instruments.add(inst);
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		int quantity = 0;
		double total = 0;
		for (Instrument inst : instruments) {
			quantity++;
			total += inst.getPrice();
			sb.append(inst.getType().getFamily()).append(" : ");
			sb.append(inst.getType().getDisplayName()).append(" : ");
			sb.append(inst.getBrand()).append(" : ");
			sb.append(inst.getModel()).append(" : ");
			sb.append(inst.getProductId()).append(" : ");
			sb.append(Instrument.currencyFormat(inst.getPrice())).append("\n");
		}
		sb.append("-----------------------------------------------\n");
		sb.append(quantity + " instruments totalling " + Instrument.currencyFormat(total));
		return sb.toString();
	}

	/**
	 * Utility method to check if String is a numeric value
	 * @param str
	 * @return
	 */
	public static boolean isNumeric(String str) {
		try {
			double d = Double.parseDouble(str);
		} catch (NumberFormatException nfe) {
			return false;
		}
		return true;
	}

}
