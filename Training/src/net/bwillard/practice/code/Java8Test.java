package net.bwillard.practice.code;

import java.io.FileReader;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.Predicate;
import java.util.stream.Stream;


public class Java8Test {

	public static void main(String[] args) {
		Predicate<String> filter = (c) -> {return c.indexOf("a")>0;};
		List<String> l = new ArrayList<String>();
		l.add("A");
		l.add("B");
		l.add("C");
		l.add("D");
		Instant start = Instant.now();
		l.forEach((s) -> System.out.println(s));
		Instant end = Instant.now();
		long duration = Duration.between(start, end).toMillis();
		List li = new ArrayList(1);
		li.add(5);
		li.add("A");
		li.add(new Integer(4));
		System.out.println(li);
		System.out.println(053==43);
		Map map = new HashMap<>();
		map.put("one", 1);
		TreeMap tm = new TreeMap(map);
		System.out.println("print " + tm.ceilingKey("O"));
		
		Stream ints = Stream.of(3,6,0,4);
		//ints.sorted().peek(System.out::peek).findFirst();
		
		float i = 4;
		float j = 5;
		float k = i + j;
		//double l = i + j;
		//Integer number = Integer.valueOf("808.1");
		//System.out.println(number);
		StringBuilder sb = new StringBuilder();
		//sb.concat("aslkj");
		System.out.println(LocalTime.now());
		LocalDate date = LocalDate.of(2015, 9, 23);
		System.out.println(date);
		Period p = Period.ofDays(1);
		System.out.println(date.plus(p));
		
		List<Integer> list = new ArrayList<Integer>();
		list.add(21);
		list.add(13);
		list.add(30);
		list.add(11);
		list.add(2);
		list.removeIf(e -> e%2 == 0);
		
		String s = "a";
		switch(s) {
			case "a" : System.out.print("Simple a "); 
			default : System.out.print("default "); 
			case "A" : System.out.print("Capital A \n"); 
		}
		
		int x = 0, y = 10;
		//y /= x;
		int[] a = {};
		boolean b = a instanceof Object;
		System.out.println(b);
		
		int[][] bc = {{1,2},{23,3,045},{4,4,4}};
		
		int $ = 4;
		int _8_ = 5;
		
		String st = "java SE 7";
		st.replaceAll("7","");
		
		int []n = {1,2,3};
		/*for(int p = 0; ++p < 4; p++) {
			System.out.println(n[x]);
		}*/
		
	}
	private void brad(int i, int j) throws ArithmeticException {}
	private void brad(int i, int j, int k) throws Exception {}
	
	
	
	class A {
		void method() {}
	}
	class B extends A {
		final void method() {}
	}
	
	interface C {
		
		String type = "A";
		void type();
		default String getType() {
			return type;
		}
	}
}
