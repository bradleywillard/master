package org.bwillard.ccsf.course.cs211s._14_singleton;

/**
 * Lazily loaded singleton
 * 
 * @author bradleywillard
 *
 */
public class LazySingleton {

	/**
	 * Lazy so we don't instantiate it until runtime...
	 */
	private static volatile LazySingleton instance;
	
	/**
	 * private constructor
	 */
	private LazySingleton() { }
	
	/**
	 * getInstance() method loads the instance carefully, taking care to only
	 * synchronize as little as is needed to avoid both slow code & race conditions
	 * 
	 * @return
	 */
	public static LazySingleton getInstance() {
		if(instance == null) {
			synchronized(instance) {
				instance = new LazySingleton();
			}
		}
		
		return instance;
	}

}
