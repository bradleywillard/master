package org.bwillard.ccsf.course.cs211s.assn2;

import java.util.ArrayList;
import java.util.List;

public abstract class Department {

	private static List<Instrument> instruments;

	public Department() {
		instruments = new ArrayList<Instrument>();
	}

	public abstract Instrument createInstrument(Instrument instrument);

	public void addInstrument(Instrument instrument) {
		instruments.add(instrument);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("--- Instrument List Sales Summary --- \n");
		for (Instrument inst : instruments) {
			double totPrice = inst.getPrice() * inst.getQuantity();
			String total = inst.valueWithCurrency(totPrice);
			sb.append(inst.getType()).append(" : ");
			sb.append(inst.getBrand()).append(" : ");
			sb.append(inst.getModel()).append(" : ");
			sb.append(inst.getProductId()).append(" : ");
			sb.append("Sold " + inst.getQuantity() + " @ " + inst.valueWithCurrency(inst.getPrice()) + " = " + total);
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
