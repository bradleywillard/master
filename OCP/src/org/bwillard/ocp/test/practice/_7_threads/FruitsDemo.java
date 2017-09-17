package org.bwillard.ocp.test.practice._7_threads;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class FruitsDemo {

	
	public static void main(String[] args) {
		List<String> fruits = new ArrayList<String>();
		fruits.add("Mango");
		fruits.add("Orange");
		fruits.add("Banana");
		Stream<String> fruitStream = fruits.parallelStream();
		fruitStream.filter(fruit -> {
			System.out.println("Fruit:" + fruit);
			return false;
		})
		.forEach(fruit -> {});
		
	}
}
