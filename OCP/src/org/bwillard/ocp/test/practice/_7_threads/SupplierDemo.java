package org.bwillard.ocp.test.practice._7_threads;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SupplierDemo {

	
	public static void main(String[] args) {
		
		Stream.of("Mango", "Orange", "Banana")
		.filter(fruit -> {
			System.out.println("Fruit" + fruit);
			return true;
		});
		List<Integer> values = (List<Integer>)Arrays.asList(10,40,20,60,80,0,80,30,40)
				.stream().filter(value -> value > 18)
				.sorted()
				.sequential()
				.map(Integer::new)
				.distinct()
				.collect(Collectors.toCollection(ArrayList::new));
		System.out.println(values.toString());
		
		Function<String, Integer> length = (s) -> s.length();
		Function<Integer, Boolean> condition = (i) -> i < 10;
		Function<String, Boolean> function = length.andThen(condition);
		System.out.println("The outcome is: " + function.apply("Java 8"));
		
				
		List<String> names = new ArrayList<String>();
		names.add("Jack");
		names.add("Jill");
		names.add("Ram");
		
		//names.stream().forEach((name)-> { showSupplier(()->name); });
		
		System.out.println();
		//NOT TRULY AND IDENTITY VALUE w/stream()
		System.out.println(Arrays.asList("1", "2", "3", "4").stream().reduce("", String::concat));
		
		
 	}
	
	public static void showSuppplier(Supplier<String> name) {
		System.out.println("Welcome " + name);
	}
}
