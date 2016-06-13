package org.bwillard.ccsf.course.cs211s._11_threads;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Simple threaded dice game that counts the most and least doubles thrown by a player
 * 
 * @author bradleywillard
 *
 */
public class DiceTester {

	/**
	 * User enters n number of players and for each player n number of rolls
	 * The program takes 
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException {
		Scanner scan = new Scanner(System.in);
		System.out.println("How many players?");
		int numPlayers = scan.nextInt();
		System.out.println("How many rolls?");
		int numRolls = scan.nextInt();
		
		Instant start = Instant.now();
		DicePlayer[] players = new DicePlayer[numPlayers];
		for(int i = 0; i < players.length; i++) {
			players[i] = new DicePlayer(i, numRolls);
		}
		
		// for each player in the array, start the thread
		for(DicePlayer dp : players) {
			dp.start();
		}
		
		// print to the console how many active threads you have
		System.out.println("\nActive thread count right after finished STARTING all threads (Each player rolling their dice on their own thread): " + Thread.activeCount());
		
		//Check for any active threads and join them to the main thread if needs be...
		for(DicePlayer dp : players) {
			//System.out.println("***" + dp.toString());
			if(dp.isAlive()) {
				System.out.println(dp.getName() + " is still alive... "
						+ "joining it to the " + Thread.currentThread().getName() + " thread!");
				dp.join();
			}
				
		}
		
		// Print to the console how many active threads you have
		System.out.println("Active thread count after joining all threads to the main thread should only be 1 now: " + Thread.activeCount() +"\n");
				
		// FOR THE RESULTS:
		// Make sure all threads have completed before printing out the results
		while(Thread.activeCount() > 1) {
			Thread.sleep(500);
			System.out.println("Waiting for thread's to finish...");
		}
		
		// Use streams to find the player with the most and least doubles (all in one line!)
		// Use the max method, which takes a Comparator as a parameter
		DicePlayer mostDoubles = Arrays.asList(players).stream()
				.max((p1, p2) -> Integer.compare(p1.getDoublesCount(), p2.getDoublesCount()))
				.get();
		System.out.println("The Most Doubles: " + mostDoubles);
		DicePlayer leastDoubles = Arrays.asList(players).stream()
				.min((p1, p2) -> Integer.compare(p1.getDoublesCount(), p2.getDoublesCount()))
				.get();
		System.out.println("The Least Doubles: " + leastDoubles +"\n");
		
		long duration = Duration.between(start, Instant.now()).toMillis();
		System.out.println("Time for threading: " + duration + "ms\n");
		
		//UNCOMMENT IF YOU WANT TO...
		//Print all doubles just to be sure the min and max doubles are correct...
		//NOT RECOMMENDED when more than 20 or however many players you feel like manually counting
		//Arrays.asList(players).stream().forEach(System.out::println);
		
	}

}
