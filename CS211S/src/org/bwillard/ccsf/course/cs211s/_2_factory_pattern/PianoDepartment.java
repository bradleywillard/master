package org.bwillard.ccsf.course.cs211s.assn2;

import java.util.Scanner;

public class PianoDepartment extends Department {

	@Override
	public Instrument createInstrument(InstrumentType type, boolean automode) {
		Instrument piano = null;
		if(automode) {
			piano = makeDummyInstrument(type);
		} else {
			Scanner scan = new Scanner(System.in);
			System.out.println("\nWhich brand of " + type + " piano?");
			String brand = scan.nextLine();
			System.out.println("Which model of piano?");
			String model = scan.nextLine();
			System.out.println("What's the price?");
			String priceStr = scan.nextLine();
			double price = isNumeric(priceStr) ? Double.parseDouble(priceStr) : 00.00;
			boolean amplified = InstrumentType.ORGAN == type ? true : false;
			piano = new Piano(type, brand, model, price, amplified);
		}
		return piano;
	}
	
	
	private Instrument makeDummyInstrument(InstrumentType type) {
		String brand = "", model = "";
		double price = 0;
		boolean amplified = false;
		if(InstrumentType.GRAND == type) {
			brand = "Steinway";
			model = "Fully Rebuilt Model C 1890";
			price = 82500.00;
		} else if(InstrumentType.ORGAN == type) {
			brand = "Hammond";
			model = "B3 Rebuilt 1969";
			price = 9800.00;
			amplified = true;
		} else if(InstrumentType.UPRIGHT == type) {
			brand = "Baldwin";
			model = "Model UPR 1966";
			price = 4500.00;
		} else if(InstrumentType.SQUARE == type) {
			brand = "Chickering";
			model = "Rosewood Grand";
			price = 10900.00;
		} 
		
		return new Piano(type, brand, model, price, amplified);
	}
	
	

}
