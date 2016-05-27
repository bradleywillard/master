package org.bwillard.ccsf.course.cs211s.assn3;

public enum InstrumentType {
	
	//GUITARS...
	ELECTRIC("ELECTRIC GUITAR", "Electric Guitar", 101),
	BASS("BASS GUITAR", "Bass Guitar", 102),
	ACOUSTIC_BASS("ACOUSTIC BASS GUITAR", "Acoustic Bass Guitar", 103),
	STEEL_STRING("STEEL STRING ACOUSTIC GUITAR", "Steel String Acoustic Guitar", 104), 
	NYLON_STRING("NYLON STRING ACOUSTIC GUITAR", "Nylon String Acoustic Guitar", 105),
	//VIOLINS...
	VIOLA("VIOLA", "Viola", 201),
	VIOLIN("VIOLIN", "Violin", 202), 
	CELLO("CELLO", "Cello", 203),
	UPRIGHT_BASS("UPRIGHT BASS", "Upright Bass", 204),
	//PIANOS....
	GRAND("GRAND PIANO", "Grand Piano", 301),
	ORGAN("ORGAN", "Organ", 302),
	UPRIGHT("UPRIGHT PIANO", "Upright Piano", 303),
	SQUARE("SQUARE PIANO", "Square Piano", 304),
	//DRUMS...
	DRUMS("DRUMS", "Drums", 401);
	
	private String name;
	private String displayName;
	private int id;
	
	private InstrumentType(String name, String displayName, int id) {
		this.name = name;
		this.displayName = displayName;
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public String getDisplayName() {
		return displayName;
	}

	public int getId() {
		return id;
	}
	
}
