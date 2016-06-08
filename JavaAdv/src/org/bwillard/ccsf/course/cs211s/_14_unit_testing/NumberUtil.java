package org.bwillard.ccsf.course.cs211s.assn14;

import java.util.*;

public class NumberUtil {
	
	public static final String EMPTY_MSG = "numberList in " + NumberUtil.class + " cannot be empty";
	private List<Integer> numberList;
	
	public NumberUtil(List<Integer> numberList) {
		this.numberList = numberList;
	}
	
	public void setNumberList(List<Integer> numberList) {
		this.numberList = numberList;
	}
	
	public int max() {
		if(numberList.isEmpty()) 
			throw new IllegalStateException(EMPTY_MSG);
		return numberList.stream().mapToInt(i -> i).max().getAsInt();
	}
	

	public int sum() {
		if(numberList.isEmpty()) 
			throw new IllegalStateException(EMPTY_MSG);
		return numberList.stream().mapToInt(i -> i).sum();
	}

}