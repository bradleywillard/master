package org.bwillard.ccsf.course.cs211s._3_builder_and_strategy;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author bradleywillard
 *
 */
public abstract class Department {

	private static List<Instrument> instruments;

	public Department() {
		instruments = new ArrayList<Instrument>();
	}

	public abstract Instrument createInstrument(InstrumentType type, boolean automode);

	public void addInstrument(InstrumentType type, int quantity, boolean automode) {
		Instrument inst = createInstrument(type, automode);
		System.out.println(inst.toString());
		inst.player.tune();
		inst.player.play();
		inst.sell(quantity);
		inst.player.repair();
		System.out.println();
		instruments.add(inst);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("--- Instrument List Sales Summary --- \n");
		for (Instrument inst : instruments) {
			double totPrice = inst.getPrice() * inst.getQuantity();
			String total = inst.currencyFormat(totPrice);
			sb.append(inst.getType()).append(" : ");
			sb.append(inst.getBrand()).append(" : ");
			sb.append(inst.getModel()).append(" : ");
			sb.append(inst.getProductId()).append(" : ");
			sb.append("Sold " + inst.getQuantity() + " @ " + inst.currencyFormat(inst.getPrice()) + " = " + total);
			sb.append("\n");
		}
		sb.append("--- End Instrument List Sales Summary --- \n");
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
