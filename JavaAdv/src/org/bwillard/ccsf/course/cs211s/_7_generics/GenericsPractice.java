package org.bwillard.ccsf.course.cs211s._7_generics;

import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.TreeSet;
import java.util.Vector;


public class GenericsPractice {

	public enum ListEnums {
		TEST("test1"),
	    TEST2("test2");
	    
		private final String txt;
	    
		ListEnums(String str){
	        txt = str;
	    }
		
		public String getTxt() {
			return txt;
		}
		
	}
	    
	public static void main(String[] args) {
		
		//Set<Integer> hs = new HashSet<Number>();//Nope
		//Set<Number> hs = new HashSet<Integer>();//Nope, too
		Set<? super ClassCastException> cce = new HashSet<Exception>();//Sure!
		List<String> list = new Vector<String>();
		//List<Object> list2 = new ArrayList<? extends Object>();//DOES NOT COMPILE
		//List<Object> lo = new HashSet<Object>();//Are you kidding me? Heck no!
		Map<String, ? extends Number> hm = new HashMap<String, Integer>();//Sure!
		
		//Chap 3 #7 
		Set<Number> numSet = new HashSet<>();
		numSet.add(new Integer(86));
		numSet.add(75);
		numSet.add(new Integer(86));
		numSet.add(null);
		numSet.add(39L);
		Iterator iter = numSet.iterator();
		while(iter.hasNext())
			System.out.print(iter.next());
		System.out.println();
		//This code compiles successfully, but it's output is indeterminate.
		
		TreeSet<String> tree = new TreeSet<String>();
		tree.add("lone");
		tree.add("Lone");
		tree.add("LONE");
		tree.add("loner");
		tree.add("Loner");
		tree.add("LONER");
		tree.add("Lo");
		
		System.out.println(tree);//LONE, LONER, Lone, Loner, lone, loner
		System.out.println(tree.ceiling("Lo"));//Lone
		System.out.println(tree.higher("Lo"));//Lone
		System.out.println(tree.lower("Lo"));//LONER
		System.out.println(tree.floor("Lo"));//Lone
		
		Comparator<Integer> c = (o1, o2) -> o2 - o1;
		List<Integer> intList = Arrays.asList(5, 4, 7, 1);
		Collections.sort(intList, c);
		System.out.println(intList);
		System.out.println(Collections.binarySearch(intList, 1));//Tricky, binarySearch precondition is ascending order sort!
		//so change the Comparator logic and try again...
		c = (o1, o2) -> o1 - o2;
		Collections.sort(intList, c);
		System.out.println(intList);
		System.out.println(Collections.binarySearch(intList, 5));
		
		class A {}
		class B extends A {}
		class C extends B {}
		class D<C> {
			A a1 = new A();
			A a2 = new B();
			//A a3 = new C();//NOPE, not when C is also the letter used the generic type
			//C c1 = new A();//NOPE, A is not a C, though C is an A
			//C c2 = new B();//NOPE, B is not a C, though C is a B
			//C c3 = new C();//NOPE, not when C is also the letter used as the generic type
		}
		
		//Queue vs List behavior for LinkedList
		System.out.println("\nQueue vs List behavior for LinkedList");
		List<Integer> q = new LinkedList<>();
		q.add(10);
		q.add(12);
		q.remove(1);
		System.out.println(q);
		//then try it with Queue as declared type
		Queue<Integer> q2 = new LinkedList<>();
		q2.add(10);
		q2.add(12);
		q2.remove(1);
		System.out.println(q2);
		//Queue only has remove by OBJECT, where List has remove by INDEX
		q2.remove(10);
		System.out.println(q2);
		
		//HashMap practice, not really a gererics problem here
		Map m = new HashMap();
		m.put(123, "456");
		m.put("abc", "def");
		//System.out.println(m.contains("123"));//NOPE, compiler error, expects containsKey or containsValue
	
		
		List<String> list1 = Arrays.asList("1", "2", "3");
		Iterator iter1 = list1.iterator();
		while(iter1.hasNext())
			System.out.print(iter1.next() + " ");
		
		//Quick little ancillary lambda test with the obove list
		//list1.removeIf(c1 -> c1.equals("3"));
		//System.out.println("Quick little ancillary lambda test with the obove list" + list1);
		
		Set<String> s = new HashSet<>();
		s.add("lion");
		s.add("tiger");
		s.add("bear");
		//s.forEach(() -> System.out.println());//NOPE, wrong number of arguments/signature mismatch
		//s.forEach((s) -> System.out.println(s));//NOPE, can't redeclare 's'
		//s.forEach(System.out.println(s));//Nope, not a valid Consumer
		//s.forEach(System::out::println);//NOPE, wrong syntax ::
		s.forEach(System.out::println);//OK
		
		//Java 8 merge method practice
		System.out.println("\nJava 8 merge method practice");
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		map.put(1, 10);
		map.put(2, 20);
		map.put(3, null);
		
		map.merge(1, 3, (a,b) -> a + b);
		map.merge(3, 3, (a,b) -> a + b);
		
		System.out.println(map);
		
		List<? super Exception> e1 = new ArrayList<Exception>();
		e1.add(new Exception());//DOES NOT COMPILE
		List<? extends Exception> e2 = new ArrayList<IOException>();
		//e2.add(new Exception());//DOES NOT COMPILE
		
		
	}
	
	public static <T> T identity(T t) {
		return t;
	}
	/**
	 * Generics practice class
	 * 
	 * @author bradleywillard
	 *
	 */
	static class Helper {
		public static <U extends Exception> void printException(U u) {
			System.out.println(u.getMessage());
		}
		
		public static void main(String[] args) {
			Helper.printException(new java.io.FileNotFoundException("A"));
			Helper.printException(new Exception("B"));
			//Helper.<Throwable>printException(new Exception("C"));//Nope, Exception inherits Throwable
			Helper.<NullPointerException>printException(new NullPointerException("D"));
			//Helper.printException(new Throwable("E"));//Nope, Throwable passes the Upper Bound
		}
	}
	
	/**
	 * Wildcard practice class
	 * 
	 * @author bradleywillard
	 *
	 */
	static class Wildcard {
		public void showSize(List<?> list) {
			System.out.println(list.size());
		}
		
		public static void main(String[] args) {
			Wildcard card = new Wildcard();
			//ArrayDeque<?> list = new ArrayDeque<String>();//NOPE, ArrayDeque is not a List
			//ArrayList<? super Date> list = new ArrayList<Date>();//OK
			//List<?> list = new ArrayList<?>();//NOPE, can't instantiate with ? on right side, concrete type needed
			//List<Exception> list = new Vector<java.io.IOException>();//NOPE, declared and instantiated types must match exactly, except if using wildcard or generic types
			Vector<? extends Number> list = new Vector<Integer>();//OK, Vector is a legacy List
			card.showSize(list);
		}
	}
	
	/**
	 * Tricky class implements both Comparable and Comparator
	 * 
	 * @author bradleywillard
	 *
	 */
	static class Sorted implements Comparable<Sorted>, Comparator<Sorted> {

		private int num;
		private String text;
		
		Sorted(int n, String t) {
			this.num = n;
			this.text = t;
		}
		
		@Override
		public int compare(Sorted o1, Sorted o2) {
			return o1.num - o2.num;
		}

		@Override
		public int compareTo(Sorted o) {
			return text.compareTo(o.text);
		}
		
		public String toString() { return "" + num; }
		
		
		public static void main(String[] args) {
			Sorted s1 = new Sorted(88, "a");
			Sorted s2 = new Sorted(55, "b");
			Set<Sorted> t1 = new TreeSet<>();
			t1.add(s1); 
			t1.add(s2);
			Set<Sorted> t2 = new TreeSet<>(s1);
			t2.add(s1);
			t2.add(s2);
			System.out.println(t1 + " " + t2);
		}
	}
	
	static class Generic<T> {
		
		public static void main(String[] args) {
			Generic<String> g = new Generic<>();
			Generic<Object> g2 = new Generic();
		}
	}

}
