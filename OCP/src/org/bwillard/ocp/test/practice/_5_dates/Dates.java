package org.bwillard.ocp.test.practice._5_dates;

import java.time.*;
import java.time.temporal.ChronoUnit;
import java.util.Locale;

public class Dates {

	public static void main(String[] args) {
		System.out.println(LocalDate.now());
		System.out.println(LocalTime.now());
		System.out.println(LocalDateTime.now());
		System.out.println(ZonedDateTime.now());
		
		Month month = Month.JANUARY;
		//boolean b1 = month == 1;//DOES NOT COMPILE
		boolean b2 = month == Month.APRIL;//false
		
		LocalTime time1 = LocalTime.of(6, 15);
		LocalTime time2 = LocalTime.of(6, 15, 30);
		LocalTime time3 = LocalTime.of(6, 15, 30, 200);
		System.out.println(time1);
		System.out.println(time2);
		System.out.println(time3);
		
		LocalDate date1 = LocalDate.of(2016, Month.JULY, 14);
		LocalDateTime dateTime1 = LocalDateTime.of(date1, time1);
		System.out.println(dateTime1);
		
		String m1 = Duration.of(1, ChronoUnit.MINUTES).toString();
		String m2 = Duration.ofMinutes(1).toString();
		String s = Duration.of(60, ChronoUnit.SECONDS).toString();
		String d = Duration.ofDays(1).toString();
		String p = Period.ofDays(1).toString();
		
		System.out.println(m1 + " " + m2);
		System.out.println(d + " " + p);
		System.out.println(m1 == m2);
		System.out.println(m1.equals(m2));
		System.out.println(m1.equals(s));
		System.out.println(d == p);
		System.out.println(d.equals(p));
		
		LocalDate date = LocalDate.now();
		LocalTime time = LocalTime.now();
		LocalDateTime dateTime = LocalDateTime.now();
		ZoneId zoneId = ZoneId.systemDefault();
		ZonedDateTime zoneDateTime = ZonedDateTime.of(dateTime, zoneId);
		long epochSeconds = 0;
		Instant instant = Instant.now();
		Instant.ofEpochSecond(epochSeconds);
		zoneDateTime.toInstant();
		
		Locale l = new Locale.Builder()
				.setLanguage("en")
				.setRegion("US")
				.build();
		
		Locale l1 = new Locale("en");
		Locale l2 = new Locale("en", "US");
		
		System.out.println("l : " + l.getCountry() + " " + l.getLanguage());
		System.out.println("l1 : " + l1.getCountry() + " " + l1.getLanguage());
		System.out.println("l2 : " + l2.getCountry() + " " + l2.getLanguage());
		
		
	}
}
