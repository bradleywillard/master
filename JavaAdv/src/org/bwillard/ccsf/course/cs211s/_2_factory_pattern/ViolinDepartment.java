package org.bwillard.ccsf.course.cs211s._2_factory_pattern;

import java.util.Scanner;


public class ViolinDepartment extends Department {

	@Override
	public Instrument createInstrument(InstrumentType type, boolean automode) {
		Instrument violin = null;
		if(automode) {
			violin = makeDummyInstrument(type);
		} else {
			Scanner scan = new Scanner(System.in);
			System.out.println("\nWhich brand of " + type.getName() + "?");
			String brand = scan.nextLine();
			System.out.println("Which model of " + type.getName() + "?");
			String model = scan.nextLine();
			System.out.println("What's the price?");
			String priceStr = scan.nextLine();
			double price = isNumeric(priceStr) ? Double.parseDouble(priceStr) : 00.00;
			System.out.println("Does this " + type.getName() + " plug into an amp? (y/n)");
			boolean amplified = "y".equalsIgnoreCase(scan.nextLine()) ? true : false;
			
			violin = new Violin(type, brand, model, price, amplified);
		}
		
		addInstrument(violin);
		return violin;
		
	}
	
	private Instrument makeDummyInstrument(InstrumentType type) {
		String brand = "", model = "";
		double price = 0;
		boolean amplified = false;
		if(InstrumentType.VIOLIN == type) {
			brand = "Stradivarius";
			model = "Alexander Richard 1920";
			price = 3799.00;
			amplified = false;
		} else if(InstrumentType.VIOLA == type) {
			brand = "Mendini";
			model = "Student";
			price = 2299.00;
			amplified = true;
		} else if(InstrumentType.CELLO == type) {
			brand = "Stentor";
			model = "YoYoMA Special";
			price = 7499.00;
			amplified = true;
		} else if(InstrumentType.UPRIGHT_BASS == type) {
			brand = "Bellafina";
			model = "Prodigy";
			price = 1899.00;
			amplified = false;
		} 
		
		return new Violin(type, brand, model, price, amplified);
	}

}
