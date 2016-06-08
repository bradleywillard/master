import java.util.*;

import javax.swing.JButton;

public class GenericsTester {

	public static void main(String[] args) {
		Integer[] numbers = new Integer[100];
		fillArray(numbers);
		String[] twoLetterWords = getWordArray();	
		
		Pair<Integer> minMax = ArrayUtil.findMinMax(numbers);
		System.out.println("The min is " + minMax.getFirst());
		System.out.println("The max is " + minMax.getSecond());
		
		Pair<String> twoWords = new Pair<>("hi", "bye");
		Pair<JButton> twoButtons = new Pair<>(new JButton(), new JButton());
		
		ArrayList<Integer> dupNums = ArrayUtil.<Integer>findDuplicate(numbers);
		ArrayList<String> dupWords = ArrayUtil.findDuplicate(twoLetterWords);
		
		
		
		Pair<String> minMaxString = ArrayUtil.findMinMax(twoLetterWords);
		System.out.println("The min is " + minMaxString.getFirst());
		System.out.println("The max is " + minMaxString.getSecond());
	
		

	}
	
	public static void fillArray(Integer[] numbers) {
		Random generator = new Random();
		int maxNum = 1000;
		for(int i=0; i<numbers.length; i++) {
			numbers[i] = generator.nextInt(maxNum);
		}
	}
	
	public static String[] getWordArray(){
		String[] words = {"AA","AB","AD","AE","AG","AH","AI","AL","AM","AN","AR","AS","AT","AW","AX","AY","BA","BE","BI","BO","BY","DE","DO","ED","EF","EH","EL","EM","EN","ER","ES","ET","EX","FA","FE","GO","HA","HE","HI","HM","HO","ID","IF","IN","IS","IT","JO","KA","KI","LA","LI","LO","MA","ME","MI","MM","MO","MU","MY","NA","NE","NO","NU","OD","OE","OF","OH","OI","OM","ON","OP","OR","OS","OW","OX","OY","PA","PE","PI","QI","RE","SH","SI","SO","TA","TI","TO","UH","UM","UN","UP","US","UT","WE","WO","XI","XU","YA","YE","YO","ZA"};
		return words;
	}

}
