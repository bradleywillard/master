package org.bwillard.ccsf.course.cs211s._8_collections;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.HashSet;

public class EvictionsReader {

	private static final String DELIMITER_REGEX = ",(?=(([^\"]*\"){2})*[^\"]*$)";
	private static final String DATE_REGEX = "(([0-9]{2})/){2}([0-9]{4})";
	private static final String ZIP_REGEX = "[0-9]{5}";
	private static final String ENCODING = "UTF-8";
	private static final String FILE_PATH = "src/org/bwillard/ccsf/course/cs211s/assn8/";
	private static final String FILE_NAME = "Eviction_Notices.csv";
	private static final String DATE_FMT = "MM/dd/uuuu";
	private static final DateTimeFormatter DTF = DateTimeFormatter.ofPattern(DATE_FMT).withLocale(Locale.ENGLISH);
	private static final DecimalFormat DF = new DecimalFormat("#.###");
	private static final int NUM_FIELDS = 30;
	
	private List<Eviction> evictionsList;
	private Map<String, Eviction> evictionsMap;
	
	/**
	 * Constructor
	 */
	private EvictionsReader() {
		evictionsList = new ArrayList<>();
		evictionsMap = new TreeMap<>();
		readFile();
	}
	
	/**
	 * Main method to run program
	 * @param args
	 */
	public static void main(String[] args) {
		EvictionsReader reader = new EvictionsReader();
		
		//Neigborhoods...
		long start = System.currentTimeMillis();
		Set<String> hoods = reader.getNeighborhoods();
		long end = System.currentTimeMillis();
		System.out.println("Fetched " + hoods.size() + " SF NEIGHBORHOODS "
							+ "in "+ (end - start)  + " milliseconds "
							+ "(" + DF.format((end - start) * .001) + " seconds) "
							+ "using " + hoods.getClass());
		System.out.println("See Below:\n" );
		for(String hood : hoods) {
			System.out.println(hood);
		}
		System.out.println("\n");
		
		//Get evictions by neighborhood
		String hood = "Noe Valley";
		int year = 2010;
		start = System.currentTimeMillis();
		Map<String, Eviction> nvEvict2010 = reader.getMapByNeighborhoodAndYear(hood, year);
		end = System.currentTimeMillis();
		System.out.println("Fetched " + nvEvict2010.size() + " EVICTIONS by NEIGHBORHOOD and YEAR" 
							+ " in " + hood + " in " + year 
							+ " in " + (end - start)  + " milliseconds"
							+ " (" + DF.format((end - start) * .001) + " seconds) "
							+ " using " + nvEvict2010.getClass());
		System.out.println("See Below:\n");
		for(String key : nvEvict2010.keySet()) {
			System.out.println(nvEvict2010.get(key));
		}
		System.out.println("\n");
		
		//Get evictions by street
		String street = "Red Rock";//my old street
		start = System.currentTimeMillis();
		Set<Eviction> rrStreetSet = reader.getEvictionsListByStreet(street);
		end = System.currentTimeMillis();
		System.out.println("Fetched " + rrStreetSet.size() + " EVICTIONS BY STREET " 
						+ " on " + street + " since 1997"
						+ " in " + (end - start)  + " milliseconds"
						+ " (" + DF.format((end - start) * .001) + " seconds)"
						+ " using " + rrStreetSet.getClass());
		System.out.println("See Below:\n");
		for(Eviction e : rrStreetSet) {
			System.out.println(e);
		}
		System.out.println("\n");

		//Get evictions by zip code and year
		int zip = 94112;
		year = 2002;
		start = System.currentTimeMillis();
		Map<String, Eviction> zipMap = reader.getEvictionsMapByZipCode(zip, year);
		end = System.currentTimeMillis();
		System.out.println("Fetched " + zipMap.size() + " EVICTIONS BY ZIP CODE" 
							+ " in " + zip + " in " + year
							+ " in " + (end - start)  + " milliseconds"
							+ " (" + DF.format((end - start) * .001) + " seconds) "
							+ " using " + zipMap.getClass());
		System.out.println("See Below:\n");
		for(String key : zipMap.keySet()) {
			System.out.println(zipMap.get(key));
		}
	
	}

	/**
	 * Read file and populate the data structures to store the data
	 * acquired from the file
	 */
	private void readFile() {
		int index = 0;
        long start = System.currentTimeMillis();
		try(InputStream is = new FileInputStream(new File(FILE_PATH + FILE_NAME));
			InputStreamReader isr = new InputStreamReader(is, ENCODING);
			BufferedReader br = new BufferedReader(isr);
			){
			String line;
			boolean headerSkipped = false;
			while ((line = br.readLine()) != null) {
				String[] fields = line.split(DELIMITER_REGEX);
				//first is the header, ignore it...
				if(index == 0 && !headerSkipped) {
					headerSkipped = true;
					continue;
				}
				//if line is corrupted or missing fields, ignore it...
			    if(fields.length < NUM_FIELDS){
			    	continue;
			    }
			    
			    Eviction e = new Eviction();
			    e.setEvictionId(fields[0]);
			    e.setAddress(fields[1]);
			    e.setCity(fields[2]);
			    e.setState(fields[3]);
			    e.setZip(fields[4]);
			    LocalDate fileDate = fields[5].matches(DATE_REGEX) ? LocalDate.parse(fields[5], DTF) : null;
			    e.setFileDate(fileDate);
			    e.setNonPayment(Boolean.parseBoolean(fields[6]));
			    e.setBreach(Boolean.parseBoolean(fields[7]));
			    e.setNuisance(Boolean.parseBoolean(fields[8]));
			    e.setIllegalUse(Boolean.parseBoolean(fields[9]));
			    e.setFailureToSignRenewal(Boolean.parseBoolean(fields[10]));
			    e.setAccessDenial(Boolean.parseBoolean(fields[11]));
			    e.setUnapprovedSubtenant(Boolean.parseBoolean(fields[12]));
			    e.setOwnerMoveIn(Boolean.parseBoolean(fields[13]));
			    e.setDemolition(Boolean.parseBoolean(fields[14]));
			    e.setCapitalImprovement(Boolean.parseBoolean(fields[15]));
			    e.setSubstantialRehab(Boolean.parseBoolean(fields[16]));
			    e.setEllisActWithdrawl(Boolean.parseBoolean(fields[17]));
			    e.setCondoConversion(Boolean.parseBoolean(fields[18]));
			    e.setRoommateSameUnit(Boolean.parseBoolean(fields[19]));
			    e.setOtherCause(Boolean.parseBoolean(fields[20]));
			    e.setLatePayments(Boolean.parseBoolean(fields[21]));
			    e.setLeadRemediation(Boolean.parseBoolean(fields[22]));
			    e.setDevelopment(Boolean.parseBoolean(fields[23]));
			    e.setGoodSamaritanEnds(Boolean.parseBoolean(fields[24]));
			    e.setConstraints(Boolean.parseBoolean(fields[25]));
			    LocalDate constraintsDate = fields[26].matches(DATE_REGEX) ? LocalDate.parse(fields[26], DTF) : null;
			    e.setConstraintsDate(constraintsDate);
			    e.setSupervisorDistrict(fields[27]);
			    e.setNeighborhood(fields[28]);
			    e.setLocation(fields[29]);
			    
			    evictionsList.add(e);
			    evictionsMap.put(e.getEvictionId(), e);
			    
			    index++;
			}
			long end = System.currentTimeMillis();
			System.out.println("There have been " +  evictionsList.size() + " evictions in San Francisco since 1997");
			System.out.println("Fetched them all in " + (end - start) 
					+ " milliseconds (" + DF.format((end - start) * .001) + " seconds)"
					+ " using " + evictionsList.getClass() + " & " + evictionsMap.getClass() + "\n");
			
		} catch (FileNotFoundException e) {
			System.out.println(FILE_PATH + FILE_NAME + " was not found : " +e.getMessage());
		} catch (IOException e) {
			System.out.println("ERROR occured trying to read in a line from the file " + FILE_NAME + ": " + e.getMessage());
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("ERROR occured at index " + index + " while trying to read file : " + e.getMessage());
		} catch (DateTimeParseException e) {
			System.out.println("ERROR occured at index " + index + " while trying to parse a date : " + e.getMessage());
		}
	}
	
	/**
	 * Get evictions by street name.  Street name is extrapolated from address
	 * 
	 * @param street
	 * @return
	 */
	public Set<Eviction> getEvictionsListByStreet(String street) {
		if(street == null) return null;
		SortedSet<Eviction> eSet = new TreeSet<>();
		for(int i = 0; i < evictionsList.size(); i++) {
			Eviction e = evictionsList.get(i);
			if(e.getAddress().contains(street)) {
				eSet.add(e);
			}
		}
		return eSet;
	}
	
	/**
	 * Get evictions by zip code
	 * 
	 * @param zipCode
	 * @param year
	 * @return
	 */
	private Map<String, Eviction> getEvictionsMapByZipCode(int zipCode, int year) {
		SortedMap<String, Eviction> zipMap = new TreeMap<>();
		for(String key : evictionsMap.keySet()) {
			Eviction e = evictionsMap.get(key);
			if(e != null) {
				String zip = e.getZip();
				if(zip != null && zip.matches(ZIP_REGEX) && zip.equals(String.valueOf(zipCode))) {
					LocalDate date = e.getFileDate();
					if(date != null && date.getYear() == year) {
						zipMap.put(e.getEvictionId(), e);
					}
				}
			}
		}
		return zipMap;
	}
	
	/**
	 * Get evictions by neighborhood and year
	 * 
	 * @param hood
	 * @param year
	 * @return
	 */
	private Map<String, Eviction> getMapByNeighborhoodAndYear(String hood, int year) {
		if(hood == null) return null;
		SortedMap<String, Eviction> eMap = new TreeMap<>();
		for(String key : evictionsMap.keySet()) {
			Eviction e = evictionsMap.get(key);
			if(hood.equals(e.getNeighborhood())) {
				LocalDate date = e.getFileDate();
				if(date != null && year == date.getYear()) {
					eMap.put(e.getEvictionId(), e);
				}
			}
		}
		return eMap;
	}
	
	/**
	 * Get neighborhoods from the csv file.  Does not necessarily reflect every neighborhood in SF.
	 * 
	 * @return
	 */
	private Set<String> getNeighborhoods() {
		SortedSet<String> hoods = new TreeSet<>();
		for(int i = 0; i < evictionsList.size(); i++) {
			String hood = evictionsList.get(i).getNeighborhood();
			//Some hoods came up as numbers in the csv file... how lame
			String goodHood = hood.replaceAll("[0-9]", "");
			if(!"".equals(goodHood))
				hoods.add(goodHood);
		}
		return hoods;
	}
}
