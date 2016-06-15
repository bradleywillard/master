package org.bwillard.ccsf.course.cs211s._9_lambdas;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;


/**
 * This class builds off of what was done in the _8_collections project.  
 * 		It also reads in a csv file, puts the dataset into multiple types of collections
 * 		i.e. Set, List, Map and displays some interesting data about the dataset.
 * 		Only difference is this time we're using Lambdas to do it
 * 		In this case our datq happens to be all Evictions in San Francisco since 1997
 * 
 * Purpose: Illustrate uses of Java 8 Lambdas
 * 
 * @author bradleywillard
 *
 */
public class EvictionsReader {

	private static final String DELIMITER_REGEX = ",(?=(([^\"]*\"){2})*[^\"]*$)";
	private static final String DATE_REGEX = "(([0-9]{2})/){2}([0-9]{4})";
	private static final String ZIP_REGEX = "[0-9]{5}";
	private static final String ENCODING = "UTF-8";
	private static final String FILE_PATH = "src/org/bwillard/ccsf/course/cs211s/_9_lambdas/";
	private static final String FILE_NAME = "Eviction_Notices.csv";
	private static final String DATE_FMT = "MM/dd/uuuu";
	private static final String EXTRACT_STREET_FROM_ADDRESS_REGEX = "^[0-9]* Block of ";
	private static final DateTimeFormatter DTF = DateTimeFormatter.ofPattern(DATE_FMT).withLocale(Locale.ENGLISH);
	private static final DecimalFormat DF = new DecimalFormat("#.###");
	private static final int NUM_FIELDS = 30;
	
	
	/**
	 * Constructor
	 */
	private EvictionsReader() {
	}
	
	/**
	 * Main method to run program
	 * @param args
	 */
	public static void main(String[] args) {
		EvictionsReader reader = new EvictionsReader();
		List<Eviction> evictions = reader.readFile();
		
		//Natural ordering using Comparable
		int start = evictions.size()/2;
		int stop = start + 50;
		System.out.println("EVICTIONS SORTED BY NATURAL ORDERING (FILE DATE) -  Records " + start + " - " + stop + " = " + (stop - start) + " total");
		//HERE IT IS, THE NATURAL ORDERING USING THE CLASSES DEFAULT COMPARABLE IMPLEMENTATION
		Collections.sort(evictions);
		for(int i = start; i < stop ; i++) {
			System.out.println(evictions.get(i).toString());
		}
		System.out.println();
		
		//Sort by street name using Comparator via Lambdas and 
		//a cool regex pattern to extract the street name
		start = evictions.size()/3;
		stop = start + 50;
		System.out.print("EVICTIONS SORTED BY STREET");
		System.out.println(" - Records " + start + " - " + stop + " = " + (stop - start) + " total");
		System.out.println("***Parses street out of address field without fancy regex, just String split method.***");
		//HERE IT IS, THE LAMBDA COMPARATOR SORT BY STREET....
		Collections.sort(evictions, (e1, e2) -> {
			return e1.getStreet().compareTo(e2.getStreet());
		});
		for(int i = start; i < stop; i++) {
			System.out.println(evictions.get(i).toString());
		}
		System.out.println();
		
		//Sort by neighborhood using Comparator via Lambdas
		start = evictions.size()/4;
		int skip = 100;
		stop = start + (50 * skip);
		System.out.print("EVICTIONS SORTED BY NEIGHBORHOOD");
		System.out.println(" - Records " + start + " - " + stop + " = " + (stop - start) + " total, but...");
		System.out.println("***This only shows every "+ skip + "th record so you can see diff hoods. So only " + (stop - start)/skip + " records total***");
		//HERE IT IS, THE LAMBDA COMPARATOR SORT BY NEIGHBORHOOD...
		Collections.sort(evictions, (e1, e2) -> e1.getNeighborhood().compareTo(e2.getNeighborhood()));
		for(int i = start; i < stop; i+=skip) {
			System.out.println(evictions.get(i).toString());
		}
		System.out.println();
		
	}

	/**
	 * Read file and populate the data structures to store the data
	 * acquired from the file
	 */
	private List<Eviction> readFile() {
		List<Eviction> evictions = new ArrayList<>();
		int numEvictions = 0, nullStreetCount = 0, nullNeighborhoodCount = 0;
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
				if(numEvictions == 0 && !headerSkipped) {
					headerSkipped = true;
					continue;
				}
				//if line is corrupted or missing fields, ignore it...
			    if(fields.length < NUM_FIELDS){
			    	continue;
			    }
			    if(fields[0] == null || fields[1] == null || fields[4] == null || fields[5] == null) {
			    	continue;
			    }
			    numEvictions++;
			    Eviction e = new Eviction();
			    e.setEvictionId(fields[0]);
			    e.setAddress(fields[1]);
			    //Parse the street out of the address field.
			    //If it isn't there, skip the record; we don't care for records without streets!
			    //Still count them towards the number of evictions though!
			    String a = e.getAddress();
			    String[] aArr = null;
			    if(a != null && a.length() > 0) {
			    	aArr = a.split(" ");
			    	if(aArr.length < 4 || aArr[3] == null || "".equals(aArr[3])) {
			    		nullStreetCount++;
			    		continue;
			    	} else {
			    		e.setStreet(aArr[3]);
			    	}
			    } else {
			    	nullStreetCount++;
			    	continue;
			    }
			    
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
			    //Enforce neighborhood validation...
			    //Don't want records without neighborhoods anymore since we're sorting by them now...
			    if(fields[28] != null && !"".equals(fields[28])) {
			    		e.setNeighborhood(fields[28]);
			    } else {
			    	nullNeighborhoodCount++;
			    	continue;
			    }
			    e.setLocation(fields[29]);
			    
			    evictions.add(e);			    
			}
			long end = System.currentTimeMillis();
			System.out.println("There have been " +  numEvictions + " evictions in San Francisco since 1997");
			System.out.println("Fetched them all in " + (end - start) 
					+ " milliseconds (" + DF.format((end - start) * .001) + " seconds)"
					+ " using " + evictions.getClass());
			System.out.println("Number of records without streets skipped : " + nullStreetCount);
			System.out.println("Number of records without neighborhoods skipped : " + nullNeighborhoodCount);
			System.out.println("Number of evictions put into our list : " + evictions.size());
			System.out.println();
		} catch (FileNotFoundException e) {
			System.out.println(FILE_PATH + FILE_NAME + " was not found : " +e.getMessage());
		} catch (IOException e) {
			System.out.println("ERROR occured trying to read in a line from the file " + FILE_NAME + ": " + e.getMessage());
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("ERROR occured at index " + numEvictions + " while trying to read file : " + e.getMessage());
		} catch (DateTimeParseException e) {
			System.out.println("ERROR occured at index " + numEvictions + " while trying to parse a date : " + e.getMessage());
		}
		
		return evictions;
	}
}
