package org.bwillard.ocp.test.practice._7_threads;

import java.util.concurrent.Callable;
import java.util.function.Supplier;

public class CallablePractice<V> implements Callable<V> {

	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	//Help understand chap 7, question 15
	@Override
	public V call() throws Exception {
		//Callable<?> c = (a -> {return 10;});//A - takes no parameters and 'a' is a parameter
		//Runnable r = a -> {return 10;};//A - same as above
		//Callable<?> c1 = () -> {String s = "";};//B - doesn't return anything, doesn't work for Callable
		Runnable r1 = () -> {String s = "";};//B - works fine for runnable
		Callable<?> c2 = () -> 5;//C
		//Callable c3 = () -> {return null};//D - needs semi-colon
		Callable<?> c4 = () -> "The" + "Zoo";//E
		//Callable<?> c5 = (int count) -> count+1;//F - takes a parameter.  NO
		//Runnable r2 = (int count) -> count+1;//F 
		Callable<?> c6 = () -> {System.out.println("Giraffe"); return 10;};
		
		return null;
	}

}
