package org.bwillard.ccsf.course.cs211s._2_factory_pattern;

public enum InstrumentType {
	
	//GUITARS...
	ELECTRIC("ELECTRIC GUITAR", "EL", 101),
	BASS("BASS GUITAR", "BA", 102),
	ACOUSTIC_BASS("ACOUSTIC BASS GUITAR", "AB", 103),
	STEEL_STRING("STEEL STRING ACOUSTIC GUITAR", "SS", 104), 
	NYLON_STRING("NYLON STRING ACOUSTIC GUITAR", "NS", 105),
	//VIOLINS...
	VIOLA("VIOLA", "VA", 201),
	VIOLIN("VIOLIN", "VI", 202), 
	CELLO("CELLO", "CE", 203),
	UPRIGHT_BASS("UPRIGHT BASS VIOLIN", "UB", 204),
	//PIANOS....
	GRAND("GRAND PIANO", "GR", 301),
	ORGAN("ORGAN", "OR", 302),
	UPRIGHT("UPRIGHT PIANO", "UP", 303),
	SQUARE("SQUARE PIANO", "SQ", 304),
	//DRUMS...
	DRUMS("DRUMS", "DR", 401);
	
	private String name;
	private String shortName;
	private int ordinal;
	
	private InstrumentType(String name, String shortName, int ordinal) {
		this.name = name;
		this.shortName = shortName;
		this.ordinal = ordinal;
	}

	public String getName() {
		return name;
	}

	public String getShortName() {
		return shortName;
	}

	public int getOrdinal() {
		return ordinal;
	}
	
}
