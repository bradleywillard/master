package org.bwillard.ocp.test.practice._7_threads;

import java.util.concurrent.Callable;
import java.util.function.Supplier;
import java.io.IOException;

/**
 * Ambiguous Lambda Expressions: Callable vs. Supplier
 * This class illustrates that if the functional interface's method does not throw
 * and exception, throwing one in the lambda expression will not compile
 * 
 * @author bradleywillard
 *
 */
public class AmbiguousLambdaSample {

	public static void useCallable(Callable<Integer> expression) {}
	public static void useSupplier(Supplier<Integer> expression) {}
	public static void use(Supplier<Integer> expression) {}
	public static void use(Callable<Integer> expression) {}

	public static void main(String[] args) {
		useCallable(() -> { throw new IOException(); });//COMPILES
		//useSupplier(() -> { throw new IOException(); });//DOES NOT COMPILE
		//use(() -> { throw new IOException(); });//DOES NOT COMPILE
		use((Callable<Integer>)() -> { throw new IOException(); });//COMPILES
	}

}
