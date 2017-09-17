package org.bwillard.ocp.test.practice._7_threads;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class AddData {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService service = null;
		
		try {
			service = Executors.newSingleThreadExecutor();
			Future<Integer> result = service.submit(() -> 30 + 11);
			System.out.println(result.get());
			
			service.submit(() -> {Thread.sleep(1000); return null;});//COMPILES
			//service.submit(() -> {Thread.sleep(1000); });//DOES NOT COMPILE
		} finally {
			if(service != null) service.shutdown();
		}
	}

}
