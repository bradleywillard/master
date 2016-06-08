package org.bwillard.ccsf.course.cs211s._2_factory_pattern;

import java.util.Scanner;

public class DrumsDepartment extends Department {

	
	@Override
	public Instrument createInstrument(InstrumentType type, boolean testmode) {
		Instrument drums = null;
		if(testmode) {
			drums = makeDummyInstrument(type);
		} else {
			Scanner scan = new Scanner(System.in);
			System.out.println("\nWhich brand of " + type + " drums?");
			String brand = scan.nextLine();
			System.out.println("Which model of drums?");
			String model = scan.nextLine();
			System.out.println("What's the price?");
			String priceStr = scan.nextLine();
			double price = isNumeric(priceStr) ? Double.parseDouble(priceStr) : 00.00;
			drums = new Drums(brand, model, price);
		}
		
		return drums;
	}
	
	private Instrument makeDummyInstrument(InstrumentType type) {
		String brand = "", model = "";
		double price = 0;
		if(InstrumentType.DRUMS == type) {
			brand = "Pearl";
			model = "Export Double Bass";
			price = 1159.00;
		} 
		
		return new Drums(brand, model, price);
	}

}
