package org.bwillard.ocp.test.practice._7_threads;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class LionPenManager {

	private void removeAnimals() { System.out.println("Removing animals"); }
	private void cleanPen() { System.out.println("Cleaning pen"); }
	private void addAnimals() { System.out.println("Adding animals"); }
	
	//public void performTask() {
	public void performTask(CyclicBarrier c1, CyclicBarrier c2) {
		try {
			removeAnimals();
			c1.await();
			cleanPen();
			c2.await();
			addAnimals();
		} catch (InterruptedException | BrokenBarrierException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args)  {
		ExecutorService service = null;
		try{
			service = Executors.newFixedThreadPool(4);
			LionPenManager manager = new LionPenManager();
			CyclicBarrier c1 = new CyclicBarrier(4);
			CyclicBarrier c2 = new CyclicBarrier(4, () -> System.out.println("*** Pen Cleaned!"));
			for(int i = 0; i < 4; i++) {
				//System.out.println("\nsubmitting..."); 
				service.submit(() -> manager.performTask(c1, c2));
				//service.wait(2000);
				//Thread.sleep(2000);
				
			}
		/*} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();*/
		} finally {
			if(service != null) service.shutdown();
		}

	}

}
