package org.bwillard.ocp.test.practice._7_threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SheepManagerNotThreadSafeAtAll {

	private int sheepCount = 0;
	
	private void incrementAndReport() {
		System.out.print((++sheepCount)+" ");
	}
	
	public static void main(String[] args) {
		ExecutorService service = null;
		try {
			service = Executors.newFixedThreadPool(20);
			SheepManagerNotThreadSafeAtAll manager = new SheepManagerNotThreadSafeAtAll();
			for(int i = 0; i < 10; i++) {
				service.submit(() -> manager.incrementAndReport());
			}
		} finally {
			if(service != null) service.shutdown();
		}
		
	}

}
