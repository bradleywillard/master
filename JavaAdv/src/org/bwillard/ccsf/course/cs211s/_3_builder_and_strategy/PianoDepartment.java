package org.bwillard.ccsf.course.cs211s._3_builder_and_strategy;

import java.util.Scanner;

/**
 * 
 * @author bradleywillard
 *
 */
public class PianoDepartment extends Department {

	@Override
	public Instrument createInstrument(InstrumentType type, boolean automode) {
		if(automode) {
			return makeDummyInstrument(type);
		} else {
			Scanner scan = new Scanner(System.in);
			System.out.println("\nWhich brand of " + type.getName() + "?");
			String brand = scan.nextLine();
			System.out.println("Which model of " + type.getName() + "?");
			String model = scan.nextLine();
			System.out.println("What's the price?");
			String priceStr = scan.nextLine();
			double price = isNumeric(priceStr) ? Double.parseDouble(priceStr) : 00.00;
			
			boolean amplified = InstrumentType.ORGAN == type ? true : false;
			
			return new Piano.PianoBuilder(brand, model, type)
					.price(price)
					.amplified(amplified)
					.build();
		}
	}
	
	
	private Instrument makeDummyInstrument(InstrumentType type) {
		String brand = "", model = "";
		double price = 0;
		boolean amplified = false;
		switch(type) {
			case GRAND :
				brand = "Steinway";
				model = "Fully Rebuilt Model C 1890";
				price = 82500.00;
				break;
			case ORGAN :
				brand = "Hammond";
				model = "B3 Rebuilt 1969";
				price = 9800.00;
				amplified = true;
				break;
			case UPRIGHT :
				brand = "Baldwin";
				model = "Model UPR 1966";
				price = 4500.00;
				break;
			case SQUARE :
				brand = "Chickering";
				model = "Rosewood Grand";
				price = 10900.00;
				break;
		} 
		
		return new Piano.PianoBuilder(brand, model, type)
				.price(price)
				.amplified(amplified)
				.build();
	}
	
	

}
