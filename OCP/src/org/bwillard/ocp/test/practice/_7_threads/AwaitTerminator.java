package org.bwillard.ocp.test.practice._7_threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class AwaitTerminator {

	public static void main(String[] args) throws InterruptedException {
		ExecutorService service = null;
		try {
			service = Executors.newSingleThreadExecutor();
		} finally {
			if(service != null) service.shutdown();
		}
		if(service != null) {
			service.awaitTermination(1, TimeUnit.MINUTES);
			// Check whether all tasks are finished
			if(service.isTerminated())
				System.out.println("All tasks finished");
			else
				System.out.println("At least one task is still running");
		}

	}

}
