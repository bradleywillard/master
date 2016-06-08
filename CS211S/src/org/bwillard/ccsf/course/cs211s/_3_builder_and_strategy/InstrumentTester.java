package org.bwillard.ccsf.course.cs211s.assn3;

import java.util.Scanner;


public class InstrumentTester {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Would you like data for 14 instruments prefilled or enter yourself? (1=prefill/2=manual)");
		System.out.println("NOTE: It takes about 5 mins to manually enter data (See impls of Department.java code for ideas)");
		boolean automode = "1".equalsIgnoreCase(scanner.nextLine()) ? true : false;
		
		Department guitars = new GuitarDepartment();
		guitars.addInstrument(InstrumentType.ELECTRIC, 2, automode);
		guitars.addInstrument(InstrumentType.STEEL_STRING, 3, automode);
		guitars.addInstrument(InstrumentType.NYLON_STRING, 2, automode);
		guitars.addInstrument(InstrumentType.BASS, 5, automode);
		guitars.addInstrument(InstrumentType.ACOUSTIC_BASS, 1, automode);
		System.out.println(guitars.toString());
		
		Department stringInstruments = new StringInstrumentDepartment();
		stringInstruments.addInstrument(InstrumentType.VIOLIN, 1, automode);
		stringInstruments.addInstrument(InstrumentType.VIOLA, 1, automode);
		stringInstruments.addInstrument(InstrumentType.CELLO, 2, automode);
		stringInstruments.addInstrument(InstrumentType.UPRIGHT_BASS, 2, automode);
		System.out.println(stringInstruments.toString());
		
		Department pianos = new PianoDepartment();
		pianos.addInstrument(InstrumentType.GRAND, 10, automode);
		pianos.addInstrument(InstrumentType.ORGAN, 2, automode);
		pianos.addInstrument(InstrumentType.UPRIGHT, 4, automode);
		pianos.addInstrument(InstrumentType.SQUARE, 5, automode);
		System.out.println(pianos.toString());
		
		Department drums = new DrumsDepartment();
		drums.addInstrument(InstrumentType.DRUMS, 2, automode);
		System.out.println(pianos.toString());
		
		scanner.close();
		
	}
	
}
