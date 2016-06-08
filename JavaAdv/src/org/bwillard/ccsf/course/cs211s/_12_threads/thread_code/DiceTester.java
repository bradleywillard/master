
import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Stream;

public class DiceTester {

	public static void main(String[] args) throws InterruptedException {
		
		int numPlayers = 1000;
		int numRolls = 100000;
		
		Instant start = Instant.now();
		Thread[] diceThreads = new Thread[numPlayers];
		for(int i=0; i<diceThreads.length; i++) {
			diceThreads[i] = new Thread( () -> {
				Random generator = new Random();
				int doublesCount = 0;
				for(int j=0; j<numRolls; j++) {
					int die1 = generator.nextInt(6);
					int die2 = generator.nextInt(6);
					if(die1==die2) doublesCount++;
				}
				//System.out.println(doublesCount);
			});
		}
		
		for(Thread diceRoller : diceThreads) {
			diceRoller.start();
		}
		System.out.println("There are " + Thread.activeCount() + " threads running");

		for(Thread diceRoller : diceThreads) {
			diceRoller.join();
		}
		
		long duration = Duration.between(start, Instant.now()).toMillis();
		System.out.println("Time for low-level threading: " + duration);	

		start = Instant.now();
		int numThreadsInPool = 10;
		ExecutorService executor = Executors.newFixedThreadPool(numThreadsInPool);
		//ExecutorService executor = Executors.newSingleThreadExecutor();
		for(int i=0; i<numPlayers; i++) {
			executor.execute( () -> {
				Random generator = new Random();
				int doublesCount = 0;
				for(int j=0; j<numRolls; j++) {
					int die1 = generator.nextInt(6);
					int die2 = generator.nextInt(6);
					if(die1==die2) doublesCount++;
				}
				//System.out.println(doublesCount);
			});
		}
				
		System.out.println("There are " + Thread.activeCount() + " threads running");
		executor.shutdown();
		duration = Duration.between(start, Instant.now()).toMillis();
		System.out.println("Time for executor threading: " + duration);	
		
		
		
	
	}

}
