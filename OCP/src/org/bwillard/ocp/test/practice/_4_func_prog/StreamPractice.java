package org.bwillard.ocp.test.practice._4_func_prog;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.OptionalDouble;
import java.util.OptionalLong;
import java.util.Random;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class StreamPractice {

	public static void main(String[] args) {
		List<Integer> numbers = new ArrayList<>();
		List<Character> letters = new ArrayList<>();
		numbers.add(1);
		letters.add('a');
		Stream<List<?>> stream = Stream.of(numbers, letters);
		stream.map(List::size).forEach(System.out::print);
		System.out.println("\n");
		
		//This is stupid code.  It updates a StringBuilder object while streaming, but
		//does not affect the result of the stream.  Try appending multiple times 
		//and watch that nothing happens to the stream result, but the StringBuilder changes
		StringBuilder builder = new StringBuilder();
		Stream<List<?>> good = Stream.of(numbers, letters);
		good.peek(l -> builder.append(l).append(l))
			.map(List::size).forEach(System.out::println);
		System.out.println(builder + "\n");
		
		
		Stream.generate(() -> "Elsa")
			.filter(n -> n.length() == 4)
			.limit(2)
			.sorted()
			.forEach(System.out::println);//Elsa Elsa
		
		//Hangs
		/*Stream.generate(() -> "Elsa Johnson")
		.filter(n -> n.length() == 4)
		.limit(2)
		.sorted()
		.forEach(System.out::println);*/
		
		System.out.println();
		Stream<Integer> infinite = Stream.iterate(1,  x -> x + 1);
		infinite.limit(5)
				.filter(x -> x % 2 == 1)
				.forEach(System.out::print);
		
		System.out.println();
		Stream<Integer> infinite2 = Stream.iterate(1,  x -> x + 1);
		infinite2.limit(5)
				.peek(System.out::print)
				.filter(x -> x % 2 == 1)
				.forEach(System.out::print);//11233455
		
		System.out.println();
		Stream<Integer> infinite3 = Stream.iterate(1,  x -> x + 1);
		infinite3.filter(x -> x % 2 == 1)
				.limit(5)
				.forEach(System.out::print);//13579
		
		System.out.println();
		Stream<Integer> infinite4 = Stream.iterate(1,  x -> x + 1);
		infinite4.filter(x -> x % 2 == 1)
				.peek(System.out::print)
				.limit(5)
				.forEach(System.out::print);//1133557799
		
		/*System.out.println();
		Stream<Integer> infinite5 = Stream.iterate(1,  x -> x + 1);
		infinite5.filter(x -> x % 2 == 1)
				//.limit(5)
				.forEach(System.out::print);*///goes on infinitely, don't do it!
		
		System.out.println("\n");
		Stream<String> s = Stream.of("brad", "lina", "eric", "jessica", "brad");
		//s.forEach(System.out::println);//Terminal/Destructive to stream
		System.out.println(s.collect(Collectors.toList()));
		//System.out.println(s.collect(Collectors.toSet()));
		
		System.out.println("\n");
		List<String> l = Arrays.asList("brad", "lina", "eric", "jessica", "brad", "count");
		Stream<String> strm = Stream.of("brad", "lina", "eric", "jessica", "brad", "count");
		strm.peek(System.out::println).count();
		//strm.limit(3).forEach(System.out::println);
		//System.out.println(strm.stream().collect(StringBuilder::new, StringBuilder::append, StringBuilder::append));
		
		System.out.println("\n");
		Stream<Integer> stream2 = Stream.of(1,2,3,4,5,6);
		//System.out.println(stream2.reduce(0, (s1, n1) -> s1 + n1));
		System.out.println(stream2.mapToInt(x -> x).sum());
		
		IntStream is = IntStream.of(1,2,3,4,5);
		OptionalDouble avg = is.average();
		System.out.println(avg);
		
		
		System.out.println();
		DoubleStream random = DoubleStream.generate(Math::random);
		DoubleStream fractions = DoubleStream.iterate(.5, d -> d / 2);
		random.limit(3).forEach(System.out::println);
		System.out.println();
		fractions.limit(3).forEach(System.out::println);
		
		Random r = new Random();
		IntStream is2 = r.ints().filter(x -> x > 0);
		is2.limit(5).forEach(System.out::println);
		
		System.out.println();
		IntStream count = IntStream.iterate(1,  n -> n + 1).limit(5);
		count.forEach(System.out::println);
		
		System.out.println();
		IntStream range = IntStream.range(5,10);
		range.forEach(System.out::println);
		
		System.out.println();
		IntStream range2 = IntStream.rangeClosed(5,10);
		range2.forEach(System.out::println);
		
		DoubleStream ds = DoubleStream.of(1.2, 2.3, 2.8, 8.5);
		
		System.out.println("\npage 209");
		IntStream stream4 = IntStream.rangeClosed(1, 10);
		OptionalDouble optional = stream4.average();
		optional.ifPresent(System.out::println);
		System.out.println(optional.getAsDouble());
		System.out.println(optional.orElseGet(() -> Double.NaN));
		
		Stream<String> stream1 = Stream.iterate("", (s1) -> s1 + "1");
		System.out.println(stream1.limit(2).map(x -> x + "2"));
		
		Predicate<? super String> predicate = sp -> sp.startsWith("g");
		Stream<String> sp1 = Stream.generate(() -> "growl! ");
		
		//Chap 4 #7
		List<String> copy = Arrays.asList("brad", "lina", "katrina", "ballerina", "chad", "dad", "fred");
		copy.stream()
			.sorted((a, b) -> b.compareTo(a))
			.collect(Collectors.toList())
			.forEach(System.out::println);
		
		//Chap 4 #8
		IntStream is8 = IntStream.empty();
		//System.out.println("\n is8.average() : " + is8.average());
		//System.out.println("\n is8.findAny() : " + is8.findAny());
		System.out.println("\n is8.sum() : " + is8.sum());
		
		LongStream ls = LongStream.of(1, 2, 3);
		OptionalLong opt = ls.map(n -> n * 10).filter(n -> n < 5).findFirst();
		//if(opt.isPresent()) System.out.println(opt.getAsLong());
		opt.ifPresent(System.out::println);
		
		//Chap 4 #10
		Stream.generate(() -> "1")
			//.filter(x -> x.length() > 1)
			.limit(10)
			.forEach(System.out::println);
			//.peek(System.out::println);
		
		//Chap 4 #11
		System.out.println(Stream.iterate(1,  x -> ++x).limit(5).map(x -> "" + x).collect(Collectors.joining()));
	
		//Chap 4 #12
		Supplier<String> x = String::new;
		Consumer<String> x2 = String::new;//Compiles but not included in the answer
		BiConsumer<String, String> y = (a, b) -> System.out.println();
		UnaryOperator<String> z = a -> a + a;
		
		//Chap 4 #13
		List<Integer> l1 = Arrays.asList(1, 2, 3);
		List<Integer> l2 = Arrays.asList(4, 5, 6);
		List<Integer> l3 = Arrays.asList();
		Stream.of(l1, l2, l3)//
			.flatMap(xm -> xm.stream())
			.map(xm -> xm + 1)
			.forEach(System.out::println);
		
		
		//Chap 4 #14
		Stream<Integer> si = Stream.of(1);
		IntStream isi = si.mapToInt(xsi -> xsi);
		DoubleStream dsi = isi.mapToDouble(xsi -> xsi);
		//Stream<Integer> si2 = dsi.mapToInt(xsi -> xsi);
		
		//Chap 4 #15
		Map<Boolean, List<String>> ml = 
				Stream.of("I", "Love", "StackOverflow")
			      .collect(Collectors.partitioningBy(so -> so.length() > 3));
			      //.forEach((k, v) -> System.out.println(k+" => "+v));
		
		//Chap 4 #16
		Stream<String> s16 = Stream.empty();
		Stream<String> s162 = Stream.empty();
		Map<Boolean, List<String>> p = s16.collect(Collectors.partitioningBy(b -> b.startsWith("c")));
		Map<Boolean, List<String>> g = s162.collect(Collectors.groupingBy(b -> b.startsWith("c")));
		System.out.println(p + " " + g);
		
		//Chap 4 #17
		//UnaryOperator<Integer> u = x17 -> x17 * x17;
		//System.out.println(u.apply(5));
		Function<Integer, Integer> f17 = x17 -> x17 * x17;
		System.out.println(f17.apply(5));
		
		//Chap 5 #18
		DoubleStream ds18 = DoubleStream.of(1.2, 2.4);
		ds18.peek(System.out::println).filter(x18 -> x18 > 2).count();
		
		//Chap 5 #20
		List<Integer> l20 = IntStream.range(1,  6)
				.mapToObj(i -> i).collect(Collectors.toList());
		l20.forEach(System.out::println);
		//Rewrite the above code...
		IntStream.range(1, 6).forEach(System.out::println);
	}

}
