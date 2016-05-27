package org.bwillard.ccsf.course.cs211s.assn11;

public class ThreadRunner {

	public static void main(String[] args) throws InterruptedException {
		/*
		System.out.println(Thread.currentThread());
		int threadCount = Thread.activeCount();
		System.out.println(threadCount);
		// Thread.sleep example
		for(int i=0; i<5; i++) {
			System.out.println("Hello threaded world! before " + i);
			try {
				Thread.sleep(2000);
			} catch(InterruptedException ex) {}
			System.out.println("Hello threaded world! after " + i);

		}
		*/
	//	DatePrintNonThread datePrintNonThreaded = new DatePrintNonThread(2000,5);
	//	datePrintNonThreaded.run();
		
		Thread datePrinterThreaded = new DatePrintThread(2000, 5);
		datePrinterThreaded.start();

		Thread datePrintRunnable =
				new Thread(new DatePrintRunnable(2000, 5));
		datePrintRunnable.start();
		
	//	Thread.sleep(4000);
	//	datePrinterThreaded.interrupt();
		
		// tells the current thread (main) to wait until
		// datePrinterThreaded is done
		datePrinterThreaded.join(); 
	//	datePrintRunnable.join();
		
		
		System.out.println("done printing");

		
	
		

		

		

		
	
		
	}

}
