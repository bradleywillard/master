package org.bwillard.ocp.test.practice._7_threads;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class CheckResults2 {

	private static int counter = 0;
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService service = null;
		try {
			service = Executors.newSingleThreadExecutor();
			Future<?> result = service.submit(() -> {
				for(int i = 0; i < 500; i++) CheckResults2.counter++;
			});
			//Thread.sleep(1);
			if(!result.isDone()) System.out.println("NOt Done!");
			result.get(10, TimeUnit.MILLISECONDS);
			if(result.isDone()) System.out.println("Done!");
			System.out.println("Reached!");
		} catch (TimeoutException e) {
			System.out.println("Not reached in time");
		} finally {
			if(service != null) service.shutdown();
		}
	}
}
