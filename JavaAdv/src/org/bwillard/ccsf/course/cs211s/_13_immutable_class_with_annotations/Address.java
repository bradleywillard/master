package org.bwillard.ccsf.course.cs211s._13_immutable_class_with_annotations;

import java.lang.reflect.Field;

/**
 * Custom Annotation class example
 * 
 * @author bradleywillard
 *
 */
public class Address {
	
	private static final String STR_FMT = "%s characters for %s is too %s: %s, %s is %s";		
	
	@ProperLength
	private String street;
	private String street2;
	@ProperLength
	private String city;
	@ProperLength(minLength = 2, maxLength = 2)
	private String state;
	@ProperLength(minLength = 5, maxLength = 5)
	private String zip;

	public Address(String street, String street2, String city, String state, String zip) {
		this.street = street;
		this.street2 = street2;
		this.city = city;
		this.state = state;
		this.zip = zip;
		
		validateLengths();
	}
	
	private void validateLengths() {
		/* some pseudocode in case it helps:
		 * get the current class
		 * get all fields in this class
		 * 	  NOTE: use the method myClass.getDeclaredFields() to access private fields;
		 *      (getFields() only accesses public fields)
		 * check if the ProperLength annotation is present for that field
		 * if it is, get the annotation object
		 * then get the value for that field
		 *      NOTE: the method myField.get(myObject) can be used to obtain the value of a field for a particular object;
		 *      note that this returns an Object, so you'll need to cast it
		 * check that the length of the value matches the specifications of the annotation
		 * if the length isn't valid, throw an exception     
		 */
		Class<? extends Address> clazz = getClass();
		Field[] fields = clazz.getDeclaredFields();
		for(Field field : fields) {
			if (field.isAnnotationPresent(ProperLength.class)) {
				ProperLength pl = field.getAnnotation(ProperLength.class);
				String name = field.getName();
				try {
					String fVal = (String)field.get(this);
					if(fVal == null || fVal.length() == 0) {
						throw new IllegalArgumentException(name + " can't be null or empty, but it is!");
					} else if(fVal.length() > pl.maxLength()) {
						throw new IllegalArgumentException(String.format(STR_FMT, fVal.length(), name, "long", fVal, "limit", pl.maxLength()));
					} else if(fVal.length() < pl.minLength()) {
						throw new IllegalArgumentException(String.format(STR_FMT, fVal.length(), name, "short", fVal, "min", pl.maxLength()));
					}
				} catch (IllegalArgumentException | IllegalAccessException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	@Override
	public String toString() {
		String s = street + 
				(street2.length()>0 ? "\n"+street2 : "") +
				"\n" + city + ", " + state + " " + zip;
		return s;
				
	}

	
	

}
