package org.bwillard.ccsf.course.cs211s._1_class_design;

/**
 * Main runner class used to build instruments and run the program
 * 
 * @author bradleywillard
 *
 */
public class InstrumentDriver {

	public static void main(String[] args) {
		
		Stringed g = new Guitar(true, 6, 1199.99, 
				GuitarType.ELECTRIC, StringType.ELECTRIC, 
				"GUI-77-551", "Gibson", "Les Paul");
		System.out.println("Instrument Type GUITAR : " + g.getType());
		System.out.println("Type ELECTRIC : " + g.getGuitarType());
		System.out.println("String Type ELECTRIC : " + g.getStringType());
		System.out.println("isAmplified() true : " + g.isAmplified());
		System.out.println("# of Strings 6 : " + g.getNumStrings());
		System.out.println("Product ID GUI-77-551 : " + g.getProductId());
		System.out.println("Brand Gibson : " + g.getBrand());
		System.out.println("Model Les Paul : " + g.getModel());
		System.out.println("Price 1199.99 : " + g.getPrice());
		System.out.print("Invoking play() method : ");
		g.play();
		System.out.print("Invoking tune() method : ");
		g.tune();
		System.out.print("Invoking repair() method : ");
		g.repair();
		System.out.println("Invoking toString() : " + g.toString());
		System.out.println();
		
		g = new Guitar(true, 4, 1499.99, 
				GuitarType.BASS, StringType.BASS, 
				"GUI-55-621", "Fender", "American Standard");
		System.out.println("Instrument Type GUITAR : " + g.getType());
		System.out.println("Type BASS : " + g.getGuitarType());
		System.out.println("String Type BASS : " + g.getStringType());
		System.out.println("isAmplified() true : " + g.isAmplified());
		System.out.println("# of Strings 4 : " + g.getNumStrings());
		System.out.println("Product ID GUI-55-621 : " + g.getProductId());
		System.out.println("Brand Fender : " + g.getBrand());
		System.out.println("Model American Standard : " + g.getModel());
		System.out.println("Price 1499.99 : " + g.getPrice());
		System.out.print("Invoking play() method : ");
		g.play();
		System.out.print("Invoking tune() method : ");
		g.tune();
		System.out.print("Invoking repair() method : ");
		g.repair();
		System.out.println("Invoking toString() : " + g.toString());
		System.out.println();
		
		g = new Guitar(false, 6, 2999.99, 
				GuitarType.ACOUSTIC, StringType.STEEL, 
				"GUI-57-969", "Breedlove", "Bradley D. Willard Special");
		System.out.println("Instrument Type GUITAR : " + g.getType());
		System.out.println("Type ACOUSTIC : " + g.getGuitarType());
		System.out.println("String Type STEEL : " + g.getStringType());
		System.out.println("isAmplified() false : " + g.isAmplified());
		System.out.println("# of Strings 6 : " + g.getNumStrings());
		System.out.println("Product ID GUI-57-969 : " + g.getProductId());
		System.out.println("Brand Breedlove : " + g.getBrand());
		System.out.println("Model Bradley D. Willard Special : " + g.getModel());
		System.out.println("Price 2999.99 : " + g.getPrice());
		System.out.print("Invoking play() method : ");
		g.play();
		System.out.print("Invoking tune() method : ");
		g.tune();
		System.out.print("Invoking repair() method : ");
		g.repair();
		System.out.println("Invoking toString() : " + g.toString());
		System.out.println();
		
		Percussive p = new Piano(
				88, 81499.99, PianoType.GRAND, "PIA-62-098", "Steinway", "Classic");
		System.out.println("Instrument Type PIANO : " + p.getType());
		System.out.println("Type GRAND : " + p.getPianoType());
		System.out.println("# of Keys 88 : " + p.getNumKeys());
		System.out.println("Product ID PIA-62-098 : " + p.getProductId());
		System.out.println("Brand Steinway : " + p.getBrand());
		System.out.println("Model Classic : " + p.getModel());
		System.out.println("Price 81499.99 : " + p.getPrice());
		System.out.print("Invoking play() method : ");
		p.play();
		System.out.print("Invoking tune() method : ");
		p.tune();
		System.out.print("Invoking repair() method : ");
		p.repair();
		System.out.println("Invoking toString() : " + p.toString());
		System.out.println();
		
		Instrument d = new Drums(849.99, InstrumentType.DRUMS, "DRU-12-450", "Pearl", "Export");
		System.out.println("Instrument Type DRUMS : " + d.getType());
		System.out.println("Product ID DRU-12-450 : " + d.getProductId());
		System.out.println("Brand Pearl : " + d.getBrand());
		System.out.println("Model Export : " + d.getModel());
		System.out.println("Price 849.99 : " + d.getPrice());
		System.out.print("Invoking play() method : ");
		d.play();
		System.out.print("Invoking tune() method : ");
		d.tune();
		System.out.print("Invoking repair() method : ");
		d.repair();
		System.out.println("Invoking toString() : " + d.toString());
		System.out.println();
		
	}
}
