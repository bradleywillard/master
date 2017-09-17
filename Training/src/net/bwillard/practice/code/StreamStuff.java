package net.bwillard.practice.code;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class StreamStuff {

	public static void main(String[] args) {
		int[] ints = {1,2,3,5,7,8,9,10,12,13,14,15};
		int[] evens = numEven(ints);
		 System.out.print("The even numbers in your array are: ");
		for(Integer i : evens) {
			System.out.println(i + ",");
		}


	}
	
	public static int[] numEven(int list[]){
		return IntStream.of(list).filter(i -> i % 2 == 0).toArray();
	}

}
