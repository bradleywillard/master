package org.bwillard.ccsf.course.cs211s._7_generics;

/**
 * This class is an example of backward compatibility of non-generic type instances
 * with generic types
 * 
 * @author bradleywillard
 *
 * @param <T>
 */
public class Hello<T> {
	T t;
	public Hello(T t) { this.t = t;}
	public String toString() { return t.toString(); }
	public static void main(String[] args) {
		System.out.println(new Hello<String>("hi"));
		System.out.println(new Hello("there"));
	}
	
}