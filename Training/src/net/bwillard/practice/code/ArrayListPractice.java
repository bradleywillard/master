package net.bwillard.practice.code;

import java.util.ArrayList;
import java.util.List;

public class ArrayListPractice {

	
	public static void main(String[] args) {
		ArrayListPractice alp = new ArrayListPractice();
		List<String> list = new ArrayList<String>(); 
		list.add("Brad");
		list.add("David");
		list.add("Brian");
		list.add("Mary");
		list.add("Lina");
		System.out.println(list);//Should print all
		alp.modifyList(list, 'r', "David");
		System.out.println(list);//Should print all but David
		alp.modifyList(list,  'a', "Submarine");
		System.out.println(list);//Should print all adding Submarine 
	}
	
	/**
	 * 
	 * @param list
	 */
	public <T> void modifyList(List<T> list, char action, T item) {
		if('r' == action)
			list.remove(item);
		else if('a' == action) {
			list.add(item);
		}
	}
}
