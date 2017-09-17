package net.bwillard.practice.code;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ExceptionsTester {

	public ExceptionsTester() {
		List<? super IOException> exceptions = new ArrayList<Exception>();
		//exceptions.add(new Exception());
		exceptions.add(new FileNotFoundException());
	}
	
	public static void addNumbers(List<? super Integer> list) {
	    for (int i = 1; i <= 10; i++) {
	        list.add(i);
	    }
	}
	
	public static void main(String[] args) {
		Number n1 = 2345;
		Number n2 = 12322;
		Number n3 = 9494;
		Number n4 = 987;
		Number n5 = 55;
		List<? super Integer> list = new ArrayList<Number>();
		list.add((Integer) n1);
		System.out.println(list.get(0).getClass());
	}

}
