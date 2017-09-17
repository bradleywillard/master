package org.bwillard.ccsf.course.cs211s._2_factory_pattern;

import java.util.Scanner;

/**
 * 
 * @author bradleywillard
 *
 */
public class GuitarDepartment extends Department {
	
	@Override
	public Instrument createInstrument(InstrumentType type, boolean automode) {
		Instrument guitar = null;
		if(automode) {
			guitar = makeDummyInstrument(type);
		} else {
			Scanner scan = new Scanner(System.in);
			System.out.println("\nWhich brand of " + type + " guitar?");
			String brand = scan.nextLine();
			System.out.println("Which model of guitar?");
			String model = scan.nextLine();
			System.out.println("What's the price?");
			String priceStr = scan.nextLine();
			double price = isNumeric(priceStr) ? Double.parseDouble(priceStr) : 00.00;
			
			//Assume guitars are amplified, unless otherwise specified by acoustics below... 
			boolean amplified = true;
			switch(type) {
				case STEEL_STRING :
				case NYLON_STRING :
				case ACOUSTIC_BASS :
					System.out.println("Does this " + type.getName() + " plug into an amp? (y/n)");
					amplified = "y".equalsIgnoreCase(scan.nextLine()) ? true : false;
					break;
				default :
					amplified = true;
					break;
			}
						
			guitar = new Guitar(type, brand, model, price, amplified);
			
		}
		
		addInstrument(guitar);
		return guitar;
		
	}
	
	private Instrument makeDummyInstrument(InstrumentType type) {
		String brand = "", model = "";
		double price = 0.00;
		boolean amplified = true;
		switch(type) {
			case ELECTRIC:
				brand = "Gibson";
				model = "Les Paul";
				price = 2499.00;
				break;
			case BASS:
				brand = "Gibson";
				model = "Thunderbird";
				price = 2299.00;
				break;
			case STEEL_STRING:
				brand = "Breedlove";
				model = "Exotic Fingerstylist";
				price = 7999.00;
				break;
			case NYLON_STRING:
				brand = "Takemine";
				model = "TC132SC";
				price = 1399.00;
				amplified = false;
				break;
			case ACOUSTIC_BASS:
				brand = "Martin";
				model = "Performing Artist BCPA4";
				price = 1999.00;
				break;
		}
		
		return new Guitar(type, brand, model, price, amplified);
	}

}
