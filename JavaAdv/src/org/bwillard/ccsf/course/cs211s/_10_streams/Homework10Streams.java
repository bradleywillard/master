package org.bwillard.ccsf.course.cs211s._10_streams;

import java.io.*;
import java.nio.charset.*;
import java.nio.file.*;
import java.util.*;
import java.util.function.*;
import java.util.stream.*;

public class Homework10Streams {
	
	private static final String FILE_PATH = "src/org/bwillard/ccsf/course/cs211s/assn10/";

	public static void main(String[] args) throws Exception {

		List<Customer> customerList = new ArrayList<>();
		fillList(customerList);
		
		// Q1: How many customers in CA?
		System.out.print("Q1: Should print 20: ");
		long caCustomters = customerList.stream()
				.filter(customer -> "CA".equalsIgnoreCase(customer.getState()))
				.count(); // YOUR ANSWER HERE
		System.out.println(caCustomters);
		
		// Q2: Create a list of all priority customers in MA.
		System.out.println("\nQ2: Should print \n[ Sasin, Anna (ID:  AS1G) (Priority Customer),  Case, Justin (ID:  JCT1) (Priority Customer)]: ");
		List<Customer> maPriorityList = customerList.stream()
				.filter(c -> c.isPriority())
				.filter(c -> "MA".equalsIgnoreCase(c.getState()))
				.collect(Collectors.toCollection(ArrayList::new)); // YOUR ANSWER HERE
		System.out.println(maPriorityList);
		
		List<String> names = customerList.stream()
				.map(c -> c.getFirstName())
				.collect(Collectors.toCollection(ArrayList::new));

		// Q3: How much money have all customers spent (combined)?
		System.out.print("\nQ3: Should print 330518.0: ");
		double total = customerList.stream()
				.mapToDouble(c -> c.getAmountSpent())
				.sum(); // YOUR ANSWER HERE
		System.out.println(total);
		
		// Q4: How much money have all priority customers spent (combined)?
		System.out.print("\nQ4: Should print 226177.0: ");
		double priorityTotal = customerList.stream()
				.filter(c -> c.isPriority())
				.mapToDouble(c -> c.getAmountSpent())
				.sum(); // YOUR ANSWER HERE
		System.out.println(priorityTotal);
		
		// Q5: Create a map of all WY priority customers (key=id, value=customer)
		System.out.println("\nQ5: Should print\n{ PTC8= Turner, Paige (ID:  PTC8) (Priority Customer),  BS20= Seville, Barbara (ID:  BS20) (Priority Customer),  BCG5= Cade, Barry (ID:  BCG5) (Priority Customer),  LK71= King, Leigh (ID:  LK71) (Priority Customer)}");
		Map<String, Customer> wyCustomers = customerList.stream()
				.filter(c -> "WY".equalsIgnoreCase(c.getState()))
				.filter(c -> c.isPriority())
				.collect(Collectors.toMap(Customer::getId, Function.identity()));; // YOUR ANSWER HERE
		System.out.println(wyCustomers);
		
		// Q6a: What is the greatest amount of money spent by a NY priority customer?
		System.out.print("\nQ6: Should print 9799.0: ");
		double nyHighAmount = customerList.stream()
				.filter(c -> "NY".equalsIgnoreCase(c.getState()))
				.filter(c -> c.isPriority())
				.mapToDouble(Customer::getAmountSpent)
				.max()
				.getAsDouble();// YOUR ANSWER HERE
		System.out.println(nyHighAmount);
		//BRADASDFASDF
		
		//Q6b: Print the customers in sorted order by amount spent, then by last name
		System.out.println("\nQ6b: Should print the customers in sorted order by amount spent, then by last name");
		customerList.stream()
				.sorted(Comparator.comparingDouble(Customer::getAmountSpent).thenComparing(Customer::getLastName))
				.collect(Collectors.toList())
				.forEach(System.out::println);
		
		//Q7: Map the customers to a String "HIGH" or "LOW" based on their amount spent:
		// HIGH is >= 5000, LOW is < 5000
		// How many high spending customers are there?
		System.out.print("\nQ7: Should print 32:");
		long highCount = customerList.stream()
				.map(c -> c.getAmountSpent() >= 5000 ? "HIGH" : "LOW")
				.filter(s -> s.equals("HIGH"))
				.count();
		
		System.out.println(highCount);
		
		//Q8: Find any customer that has spent > 9800. 
		// Print the amount spent by the customer. If there is none, nothing should be printed.
		// Note: you can test your code with a lower amount, too.
		System.out.println("\nQ8: Should print nothing: ");
		
		// YOUR ANSWER HERE
		// YOU'LL ALSO HAVE TO ADD THE LINE TO MAKE IT PRINT!
		Optional<Customer> opCustomer = customerList.stream()
				.filter(c -> c.getAmountSpent() > 9800)
				.findAny();
		if(opCustomer.isPresent())
			System.out.println(opCustomer.get().getAmountSpent());
		
		// Q9: Find the sum of the numbers represented in an String array.
		String[] numWords = {"1", "2", "3", "4", "5", "6"};
		// YOUR ANSWER HERE
		int sum = Arrays.asList(numWords).stream()
				.map(Integer::parseInt)
				.mapToInt(i -> i)
				.sum(); 
		System.out.println("\nQ9: Sum is 21: " + sum);
		
		// Q10: Create a String of the numbers represented in the array, separated by semicolons.
		Integer[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		// YOUR ANSWER HERE
		String concat = Arrays.asList(nums).stream()
				.map(String::valueOf)
				.collect(Collectors.joining(";")); 
		System.out.println("\nQ10: Should print 1;2;3;4;5;6;7;8;9;10: " + concat);
		
		// Q11: Create an infinite stream of random integers in the range 1-100.
		// Keep only the numbers that are factors of 3.
		// Print the first 10 of these numbers.
		System.out.println("\nQ11: Will print 10 numbers that are factors of 3 between 1-100:");
		// YOUR ANSWER HERE
		IntStream.of(new Random().ints(1, 100).filter(i -> i % 3 == 0).limit(10).toArray())
			.forEach(System.out::println);
		
		// Q12: Print the top 9-highest-scoring scrabble word in the list.
		// Note: a method is provided below to convert from char to score.
		// Hint: you might consider writing another method to find the score of a word!
		List<String> scrabbleWords = 
				Files.readAllLines(Paths.get(FILE_PATH + "words.txt"), 
				Charset.forName("ISO-8859-1"));
		System.out.println("\nQ12 Should print: " 
				+"\n\tpizazz worth 35 points" +"\n\tjazzily worth 35 points" +
				"\n\tquizzed worth 35 points" + "\n\tjacuzzi worth 34 points" + 
				"\n\tquizzer worth 34 points" + "\n\tquizzes worth 34 points" + 
				"\n\tjazzy worth 33 points" + "\n\tjazzing worth 33 points" ); 
		
		scrabbleWords.stream()
			.sorted((w1, w2) -> wordToScore(w2).compareTo(wordToScore(w1)))
			.limit(9)
			.forEach(w -> System.out.println(w.concat(" worth ")
					.concat(String.valueOf(wordToScore(w)))
					.concat(" points")));	
}
	private static Integer wordToScore(String word) {
		int score = 0;
		for(int i = 0; i < word.length(); i++) {
			score += charToScore(word.charAt(i));
		}
		return score;
	}

	private static int charToScore(char c) {
		switch (c) {
			case 'a': case 'e': case 'i': case 'o': case 'u':
			case 'n': case 'r': case 't': case 'l': case 's':
				return 1;
			case 'g': case 'd': 
				return 2;
			case 'b': case 'c': case 'm': case 'p': 
				return 3;	
			case 'f': case 'h': case 'v': case 'w': case 'y':
				return 4;	
			case 'k': 
				return 5;
			case 'j': case 'x': 
				return 8;
			case 'q': case 'z': 
				return 10;		
			default:
				return -1;
		}
	}
	
	private static void fillList(List<Customer> list) {
		try (Scanner fileScan = new Scanner(
				new FileReader(new File(FILE_PATH + "Customers.csv")))) {
		
			while(fileScan.hasNext()) {
				String line = fileScan.nextLine();
				Scanner lineScan = new Scanner(line);
				lineScan.useDelimiter(",");
				String firstName = lineScan.next();
				String lastName = lineScan.next();
				String id = lineScan.next();
				String state = lineScan.next();
				boolean priority = Boolean.parseBoolean(lineScan.next());
				double amount = Double.parseDouble(lineScan.next());
				Customer c = new Customer(firstName, lastName, id, state, priority, amount);
				list.add(c);
			}
		} catch (IOException ex){
			ex.printStackTrace();
		}
	}
}
