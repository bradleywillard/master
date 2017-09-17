package org.bwillard.ocp.test.practice._7_threads;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ThreadPractice implements Runnable {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
		//Self test #3
		/*ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
		service.scheduleWithFixedDelay(() -> {//w1
			System.out.println("Open Zoo");
			//return null;//w2
		}, 0, 1, TimeUnit.MINUTES);
		Future<?> result = service.submit(() -> System.out.println("Wake Staff"));//w3
		System.out.println(result.get());//w4
		
		//Self-test #4
		AtomicLong value1 = new AtomicLong(0);
		final long[] value2 = {0};
		IntStream.iterate(1, i -> 1).limit(100).parallel().forEach(i -> value1.incrementAndGet());
		IntStream.iterate(1, i -> 1).limit(100).parallel().forEach(i -> ++value2[0]);
		System.out.println(value1 + " " + value2[0]);*/
		
		//Self-test #7
		List<Integer> l1 = Arrays.asList(1, 2, 3);
		List<Integer> l2 = new CopyOnWriteArrayList<>(l1);
		//List<Integer> l3 = l2;
		Set<Integer> s3 = new ConcurrentSkipListSet<>();
		s3.addAll(l1);
		
		/*for(Integer i : s3) {
			System.out.print(i + " ");
		}*/
		for(Integer item : l2) l2.add(4); //x1
		for(Integer item : s3) s3.add(5); //x2
		System.out.println(l1.size() + " " + l2.size() + " " + s3.size());
		/*for(Integer i : s3) {
			System.out.print(i + " ");
		}
		System.out.println(l3 == l2);//tax id 271346767*/
		
		/*System.out.println("\nSelft-Test #8");
		Integer i1 = Arrays.asList(1,2,3,4,5).stream().findAny().get();
		synchronized(i1) {
			Integer i2 = Arrays.asList(6,7,8,9,10).stream().sorted().findAny().get();
			System.out.println(i1 + " " + i2);
		}
		
		System.out.println("\nSelft-Test #10");
		System.out.println(Arrays.asList("duck", "chicken", "flamingo", "pelican")
				.parallelStream().parallel()
				.reduce(0, 
						(c1, c2) -> c1.length() + c2.length(),
						(s1, s2) -> s1 + s2));
						
		
		Object o1 = new Object();
		Object o2 = new Object();
		ExecutorService service = Executors.newFixedThreadPool(2);
		Future<?> f1 = service.submit(() -> {
			synchronized(o1) {
				synchronized(o2) { System.out.println("Tortoise"); } // t1
			}
		});
		Future<?> f2 = service.submit(() -> {
			synchronized(o2) {
				synchronized(o1) { System.out.println("Here"); } // t2
			}
		});
		f1.get();
		f2.get();
		
		//Chap 7, Self-Test #13
		//This just prints out the one's that do start with the letter 'p',
		//followed by the one's that don't
		Stream<String> cats = Stream.of("leopard", "lynx", "ocelot", "puma").parallel();
		Stream<String> bears = Stream.of("panda", "grizzly", "polar").parallel();
		ConcurrentMap<Boolean, List<String>> data = Stream.of(cats, bears)
				.flatMap(s -> s)
				.collect(Collectors.groupingByConcurrent(s -> !s.startsWith("p")));
		System.out.println(data.get(false).size() + " " + data.get(true).size());
		
		Function<Integer, Stream<Integer>> f = x -> Stream.iterate(1, y -> y + 1).limit(x);
		Stream<Integer> stream = Stream.iterate(1, x -> x + 1);
		Stream<Integer> stream2 = stream.limit(5).flatMap(f);
		System.out.println(stream2.collect(Collectors.toList()));*/
		
		//Chap 7, Self-Test #14
		ThreadPractice tp = new ThreadPractice();
		tp.addAndPrintItems(new LinkedBlockingDeque<Integer>());
	}
	
	public void addAndPrintItems(BlockingDeque<Integer> deque) throws InterruptedException {
		deque.offer(103);
		deque.offerFirst(20, 1, TimeUnit.SECONDS);
		deque.offerLast(85,7, TimeUnit.HOURS);
		System.out.println(deque);
		System.out.print(deque.pollFirst(200, TimeUnit.NANOSECONDS));
		System.out.print(" " + deque.pollLast(1, TimeUnit.MINUTES));
	}

	@Override
	public void run() {
		//() -> System.out.println("Hello World!");
	}

}

/* Chap 7, Self Test
 * 
 * 1. D, F
 * 2. A, B, C, D, F
 * 3. B, E
 * 4. 
 */

