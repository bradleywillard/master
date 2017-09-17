package org.bwillard.ocp.test.practice._7_threads;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.function.Predicate;

public class FindMin extends MyTask {

	private Integer[] elements;
	private int a;
	private int b;
	
	public FindMin(Integer[] elements, int a, int b) {
		this.elements = elements;
		this.a = a;
		this.b = b;
	}
	
	public static void main(String[] args) throws ParseException {
		/*Integer[] elements = new Integer[] { 8, -3, 2, -54 };
		MyTask task = new FindMin(elements, 0, elements.length - 1);
		ForkJoinPool pool = new ForkJoinPool(1);
		Integer sum = pool.invoke(task);
		System.out.println("Min: " + sum);*/
		
		
		Predicate<Integer> p = new Predicate<Integer>(){

			@Override
			public boolean test(Integer t) {
				// TODO Auto-generated method stub
				return false;
			}
			
		};
		LocalDateTime dt = LocalDateTime.now();
		System.out.println(dt);
		
		SimpleDateFormat f = new SimpleDateFormat("dd-MMM-yyyy");
		System.out.println(f.parse("02-03-2015"));
		
		List<String> l = new ArrayList<String>();
		l.forEach(System.out::println);
	}

	
	

}
