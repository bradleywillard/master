package org.bwillard.ccsf.course.cs211s._2_factory_pattern;

import java.util.Scanner;

/**
 * 
 * @author bradleywillard
 *
 */
public class InstrumentTester {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Would you like data for 14 instruments prefilled or enter yourself? (1=prefill/2=manual)");
		System.out.println("NOTE: It takes about 5 mins to manually enter data (See impls of Department.java code for ideas)");
		boolean automode = "1".equalsIgnoreCase(scanner.nextLine()) ? true : false;
		
		Department guitars = new GuitarDepartment();
		guitars.createInstrument(InstrumentType.ELECTRIC, automode);
		guitars.createInstrument(InstrumentType.STEEL_STRING, automode);
		guitars.createInstrument(InstrumentType.NYLON_STRING, automode);
		guitars.createInstrument(InstrumentType.BASS, automode);
		guitars.createInstrument(InstrumentType.ACOUSTIC_BASS, automode);
		System.out.println(guitars.toString());
		
		Department violins = new ViolinDepartment();
		violins.createInstrument(InstrumentType.VIOLIN, automode);
		violins.createInstrument(InstrumentType.VIOLA, automode);
		violins.createInstrument(InstrumentType.CELLO, automode);
		violins.createInstrument(InstrumentType.UPRIGHT_BASS, automode);
		System.out.println(violins.toString());
		
		Department pianos = new PianoDepartment();
		pianos.createInstrument(InstrumentType.GRAND, automode);
		pianos.createInstrument(InstrumentType.ORGAN, automode);
		pianos.createInstrument(InstrumentType.UPRIGHT, automode);
		pianos.createInstrument(InstrumentType.SQUARE, automode);
		System.out.println(pianos.toString());
		
		Department drums = new DrumsDepartment();
		drums.createInstrument(InstrumentType.DRUMS, automode);
		System.out.println(pianos.toString());
		
		scanner.close();
		
	}
	
}
