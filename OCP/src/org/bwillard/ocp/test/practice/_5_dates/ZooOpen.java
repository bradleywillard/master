package org.bwillard.ocp.test.practice._5_dates;

import java.time.Instant;
import java.time.ZoneId;
import java.util.Locale;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.Set;

public class ZooOpen {

	public static void main(String[] args) {
		Locale us = new Locale("en", "US");
		Locale france = new Locale("fr", "FR");
		Locale def = new Locale("");
		printProperties(us);
		/*System.out.println();
		printProperties(france);
		System.out.println();
		printProperties(def);*/
	}
	
	public static void printProperties(Locale locale) {
		ResourceBundle rb = ResourceBundle.getBundle("org.bwillard.ocp.test.practice._5_dates.Zoo", locale);
		System.out.println(rb.getString("hello"));
		System.out.println(rb.getString("open"));
		
		Set<String> keys = rb.keySet();
		keys.stream().map(k -> k + " " + rb.getString(k)).forEach(System.out::println);
		
		Properties props = new Properties();
		rb.keySet().stream().forEach(k -> props.put(k, rb.getString(k)));
		System.out.println("");
		props.keySet().stream().map(k -> k).forEach(System.out::println);
		System.out.println("");
		props.keySet().stream().map(k -> props.get(k)).forEach(System.out::println);
		
		/*System.out.println(props.getProperty("not"));
		System.out.println(props.getProperty("not", "123"));*/
		
		
		
	}
}
