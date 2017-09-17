package org.bwillard.ccsf.course.cs211s._14_singleton;

/**
 * A very simple eagerly loaded singleton
 * 
 * @author bradleywillard
 *
 */
public class EagerSingleton {

	/**
	 * Eagerly loaded singleton
	 */
	private static volatile EagerSingleton instance = new EagerSingleton();
	
	/**
	 * private constructor
	 */
	private EagerSingleton() {}
	
	/**
	 * getInstance() method 
	 * 
	 * @return
	 */
	public static EagerSingleton getInstance() {
		return instance;
	}

}
