package org.bwillard.ocp.test.practice._7_threads;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.SortedSet;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ParallelStreams {

	public static void main(String[] args) {
		Stream<Integer> stream = Arrays.asList(1,2,3,4,5,6).stream();
		Stream<Integer> parallelStream = stream.parallel();
		
		Stream<Integer> parallelStream2 = Arrays.asList(1,2,3,4,5,6).parallelStream();
		
		
		//serial stream
		System.out.println();
		Arrays.asList(1,2,3,4,5,6).stream().forEach(s -> System.out.print(s + " "));
		
		//parallel stream
		System.out.println();
		Arrays.asList(1,2,3,4,5,6).parallelStream().forEach(s -> System.out.print(s + " "));
		
		//forEachOrdered on a parallel stream
		System.out.println();
		Arrays.asList(1,2,3,4,5,6).parallelStream().forEachOrdered(s -> System.out.print(s + " "));
		
		
		//Independent Operations
		System.out.println();
		Arrays.asList("jackal", "kangaroo", "lemur").parallelStream()
			.map(s -> s.toUpperCase())
			.forEach(System.out::println);
		
		System.out.println();
		Arrays.asList("jackal", "kangaroo", "lemur").parallelStream()
		.map(s -> {System.out.println(s); return s.toUpperCase();})
		.forEach(System.out::println);
		
		System.out.println();
		List<Integer> data = Collections.synchronizedList(new ArrayList<>());
		Arrays.asList(1,2,3,4,5,6).parallelStream()
			.map(i -> {data.add(i); return i;})//AVOID STATEFUL LAMBDA EXPRESSIONS
			.forEachOrdered(i -> System.out.print(i + " "));
		
		System.out.println();
		for(Integer e : data) {
			System.out.print(e + " ");
		}
		
		System.out.println();
		System.out.println(Arrays.asList(1,2,3,4,5,6).stream().findAny().get());
		
		System.out.println();
		System.out.println(Arrays.asList(1,2,3,4,5,6).parallelStream().findAny().get());
		
		System.out.println();
		Arrays.asList(1,2,3,4,5,6).stream().unordered().forEach(i -> System.out.print(i + " "));
		
		System.out.println();
		Arrays.asList(1,2,3,4,5,6).stream().unordered().parallel().forEach(i -> System.out.print(i + " "));
		
		//Reduce
		System.out.println();
		System.out.println(Arrays.asList('w', 'o', 'l', 'f')
				.stream()
				.reduce("", (c,s1) -> c + s1, (s2,s3) -> s2 + s3));
		
		
		System.out.println();
		//NOT AN ASSOCIATIVE ACCUMULATOR
		System.out.println(Arrays.asList(50,1).parallelStream().reduce(0, (a,b) -> (a-b)));
		
		System.out.println();
		//NOT TRULY AND IDENTITY VALUE w/parallelStream()
		System.out.println(Arrays.asList("w", "o", "l", "f").parallelStream().reduce("X", String::concat));
		
		System.out.println();
		//NOT TRULY AND IDENTITY VALUE w/stream()
		System.out.println(Arrays.asList("w", "o", "l", "f").stream().reduce("X", String::concat));
		
		System.out.println();
		Stream<String> stream1 = Stream.of( "w", "o", "l", "f").parallel();
		SortedSet<String> set = stream1.collect(ConcurrentSkipListSet::new, Set::add, Set::addAll);
		System.out.println(set);// [f, l, o, w]
		
		System.out.println();
		//ONe argument collect() method
		Stream<String> stream2 = Stream.of("w", "o", "l", "f").parallel();
		Set<String> set2 = stream2.collect(Collectors.toSet());
		System.out.println(set2);
		
		System.out.println();
		//Parellel reduction with collect()
		Stream<String> ohMy = Stream.of("lions", "tigers", "bears").parallel();
		ConcurrentMap<Integer, String> map = ohMy
				.collect(Collectors.toConcurrentMap(String::length, k -> k, (s1, s2) -> s1 + ", " + s2));
		System.out.println(map);//{5=lions, bears, 6=tigers}
		System.out.println(map.getClass());//java.util.concurrent.ConcurrentHashMap
		
		System.out.println();
		//Parellel reduction with collect()
		Stream<String> ohMy2 = Stream.of("lions", "tigers", "bears").parallel();
		ConcurrentMap<Integer, List<String>> map2 = ohMy2
				.collect(Collectors.groupingByConcurrent(String::length));
		System.out.println(map2);//{5=lions, bears, 6=tigers}
		System.out.println(map2.getClass());//java.util.concurrent.ConcurrentHashMap
		
		
		
	}
}
