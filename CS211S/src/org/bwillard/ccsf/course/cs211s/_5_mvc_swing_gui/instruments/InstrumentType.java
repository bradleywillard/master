package org.bwillard.ccsf.course.cs211s.assn5.instruments;

public enum InstrumentType {
	
	//GUITARS...
	ELECTRIC("ELECTRIC GUITAR", "Electric Guitar", "Guitar", 101),
	BASS("BASS GUITAR", "Bass Guitar", "Guitar", 102),
	ACOUSTIC_BASS("ACOUSTIC BASS GUITAR", "Acoustic Bass Guitar", "Guitar", 103),
	STEEL_STRING("STEEL STRING ACOUSTIC GUITAR", "Steel String Acoustic Guitar", "Guitar", 104), 
	NYLON_STRING("NYLON STRING ACOUSTIC GUITAR", "Nylon String Acoustic Guitar", "Guitar", 105),
	//STRING INSTRUMENTS...
	VIOLA("VIOLA", "Viola", "StringInstrument", 201),
	VIOLIN("VIOLIN", "Violin", "StringInstrument", 202), 
	CELLO("CELLO", "Cello", "StringInstrument", 203),
	UPRIGHT_BASS("UPRIGHT BASS", "Upright Bass", "StringInstrument", 204),
	//PIANOS....
	GRAND("GRAND PIANO", "Grand Piano", "Piano", 301),
	ORGAN("ORGAN", "Organ", "Piano", 302),
	UPRIGHT("UPRIGHT PIANO", "Upright Piano", "Piano", 303),
	SQUARE("SQUARE PIANO", "Square Piano", "Piano", 304),
	//DRUMS...
	DRUMS("DRUMS", "Drums", "Drums", 401);
	
	private String name;
	private String displayName;
	private String family;
	private int id;
	
	private InstrumentType(String name, String displayName, String family, int id) {
		this.name = name;
		this.displayName = displayName;
		this.family = family;
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public String getDisplayName() {
		return displayName;
	}

	public String getFamily() {
		return family;
	}
	
	public int getId() {
		return id;
	}
	
	/**
	 * Returns the InstrumentType object if a valid displayName like 'Electric Guitar' is passed in
	 * 
	 * @param displayName
	 * @return
	 */
	public static InstrumentType getByDisplayName(String displayName) {
		for(InstrumentType type : InstrumentType.values()) {
			if(type.getDisplayName().equals(displayName))
				return type;
		}
		return null;
	}
	
	public static String getInstrumentFamilyByType(InstrumentType type) {
		if(type == InstrumentType.ELECTRIC || 
			type == InstrumentType.BASS ||
			type == InstrumentType.ACOUSTIC_BASS ||
			type == InstrumentType.STEEL_STRING ||
			type == InstrumentType.NYLON_STRING) {
			return Guitar.FAMILY_NAME;
		} else if(type == InstrumentType.GRAND || 
			type == InstrumentType.ORGAN ||
			type == InstrumentType.UPRIGHT ||
			type == InstrumentType.SQUARE) {
			return Piano.FAMILY_NAME;
		} else if(type == InstrumentType.VIOLA || 
			type == InstrumentType.VIOLIN ||
			type == InstrumentType.CELLO ||
			type == InstrumentType.UPRIGHT_BASS) {
			return StringInstrument.FAMILY_NAME;
		} else if(type == InstrumentType.GRAND || 
			type == InstrumentType.DRUMS) {
			return Drums.FAMILY_NAME;
		}
		return null;
	}
}
