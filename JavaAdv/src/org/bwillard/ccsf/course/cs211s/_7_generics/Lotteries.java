package org.bwillard.ccsf.course.cs211s._7_generics;

import java.util.*;

/**
 * Class that tests our Generics RandomBox class with multiple types put into the RandomBox
 * 		i.e. String, Integer, Employee, etc...
 * 
 * @author bradleywillard
 *
 */
public class Lotteries {

	public static void main(String[] args) {
		RandomBox<String> nameDrawing = new RandomBox<>();
		fillNames(nameDrawing);
		System.out.println("Random Name Drawing!");
		System.out.println(nameDrawing);
		nameDrawing.displayEntries();
		System.out.println("Winner: " + nameDrawing.drawWinner());
		
		RandomBox<Integer> lottery = new RandomBox<>();
		fillNumbers(lottery, 100);
		System.out.println("\nLottery!");
		lottery.displayEntries();
		System.out.println(lottery);		
		System.out.println("Winner: " + lottery.drawWinner());
		
		RandomBox<Employee> lotteryEmp = new RandomBox<>();
		fillEmployees(lotteryEmp, 100);
		System.out.println("\nLottery!");
		lotteryEmp.displayEntries();
		System.out.println(lotteryEmp);		
		System.out.println("Winner: " + lotteryEmp.drawWinner());
		
		System.out.println("\nLottery Sorting!");
		RandomBox<Integer> lotteryEasy = new RandomBox<>();
		fillNumbers(lotteryEasy, 10);
				
		RandomBox<Integer> lotteryBig = new RandomBox<>();
		fillNumbers(lotteryBig, 1000);
		
		RandomBox<Integer> lotteryHuge = new RandomBox<>();
		fillNumbers(lotteryHuge, 10000);
		
		RandomBox<Integer> lotteryCrazySize = new RandomBox<>();
		fillNumbers(lotteryCrazySize, 100000);
		
		List<RandomBox<Integer>> lotteryList = new ArrayList<>();
		lotteryList.add(lotteryCrazySize);
		lotteryList.add(lotteryHuge);
		lotteryList.add(lotteryBig);
		lotteryList.add(lottery);
		lotteryList.add(lotteryEasy);
		System.out.println("The lotteries are in random order.");
		Collections.shuffle(lotteryList);
		System.out.println(lotteryList);
		System.out.println("The lotteries should be ordered 10, 100, 1000, 10000, and then 1000000.");
		Collections.sort(lotteryList);
		System.out.println(lotteryList);
		
		System.out.println("\nMultiple Winners!");
		
		List<String> nameWinners = pickMultipleWinners(nameDrawing, 5);
		System.out.println(nameWinners);
		List<Integer> numberWinners = pickMultipleWinners(lottery, 3);
		System.out.println(numberWinners);	
		List<Employee> numberEmployees = pickMultipleWinners(lotteryEmp, 4);
		System.out.println(numberEmployees);
		 
	}
	
	public static void fillNames(RandomBox<String> wordBox) {
		// subset taken from http://ethanwiner.com/funnames.html
		wordBox.addItem("Adam Zapel"); wordBox.addItem("Al Dente"); wordBox.addItem("Al Fresco"); wordBox.addItem("Al K. Seltzer"); wordBox.addItem("Alf A. Romeo"); wordBox.addItem("Amanda Lynn"); wordBox.addItem("Anita Job"); wordBox.addItem("Anna Conda"); wordBox.addItem("Anna Graham"); wordBox.addItem("Anna Prentice "); wordBox.addItem("Anna Sasin"); wordBox.addItem("Anne Teak"); wordBox.addItem("B.A. Ware"); wordBox.addItem("Barb Dwyer"); wordBox.addItem("Barb E. Dahl"); wordBox.addItem("Barbara Seville"); wordBox.addItem("Barry Cade"); wordBox.addItem("Bea Minor"); wordBox.addItem("Dee Major"); wordBox.addItem("Beau Tye"); wordBox.addItem("Bill Board"); wordBox.addItem("Cara Van"); wordBox.addItem("Chris P. Bacon"); wordBox.addItem("Constance Noring"); wordBox.addItem("Crystal Ball"); wordBox.addItem("Crystal Glass"); wordBox.addItem("Earl Lee Riser"); wordBox.addItem("Easton West "); wordBox.addItem("Ferris Wheeler"); wordBox.addItem("Flint Sparks"); wordBox.addItem("Franklin Stein "); wordBox.addItem("Gene Poole"); wordBox.addItem("Heidi Clare"); wordBox.addItem("Helen Back"); wordBox.addItem("Helen Wiells"); wordBox.addItem("Holly McRell"); wordBox.addItem("Holly Wood"); wordBox.addItem("Jack Pott"); wordBox.addItem("Joe Kerr"); wordBox.addItem("Joy Rider"); wordBox.addItem("Justin Case"); wordBox.addItem("Justin Time"); wordBox.addItem("Kandi Apple"); wordBox.addItem("Laura Norder"); wordBox.addItem("Leigh King "); wordBox.addItem("Luke Warm"); wordBox.addItem("Marsha Mellow"); wordBox.addItem("Marshall Law"); wordBox.addItem("Marty Graw"); wordBox.addItem("Olive Branch"); wordBox.addItem("Paige Turner"); wordBox.addItem("Pepe Roni"); wordBox.addItem("Price Wright"); wordBox.addItem("Rocky Beach"); wordBox.addItem("Sandy Beach"); wordBox.addItem("Sal A. Mander"); wordBox.addItem("Stanley Cupp"); wordBox.addItem("Tom Morrow"); wordBox.addItem("Warren Peace"); wordBox.addItem("Will Power"); wordBox.addItem("X. Benedict");
	}
	
	public static void fillNumbers(RandomBox<Integer> numbersBox, int numberOfNumbers) {
		Random generator = new Random();
		int maxNumber = numberOfNumbers * 100;
		for(int i=0; i<numberOfNumbers; i++) {
			numbersBox.addItem(generator.nextInt(maxNumber));
		}
	}
	 
	/**
	 * Fill the box with some employees, however many you want
	 * 
	 * @param employeesBox
	 * @param numEmployees
	 */
	public static void fillEmployees(RandomBox<Employee> employeesBox, int numEmployees) {
		for(int i = 0; i < numEmployees; i++) {
			employeesBox.addItem(new FullTimeEmployee(i));
		}
	}
	/**
	 * Pick multiple random winners from the RandomBox
	 * 
	 * @param box
	 * @param numWinners
	 * @return
	 * @throws EmptyBoxException
	 */
	@SuppressWarnings("unchecked")
	public static <T> List<T> pickMultipleWinners(RandomBox<? super T> box, int numWinners) {
		return (List<T>) box.drawWinners(numWinners);
	}


}