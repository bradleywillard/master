package org.bwillard.ocp.test.practice._7_threads;

import java.util.function.Consumer;

public class ConsumerDemo {

	
	public static void main(String[] args) {
		Consumer<String> c = ConsumerDemo::showConsumer;
		c.accept("Jack");
		c.accept("Jill");
		c.accept("Ram");
 	}
	
	public static void showConsumer(String name) {
		System.out.println("Welcome " + name);
	}
}
