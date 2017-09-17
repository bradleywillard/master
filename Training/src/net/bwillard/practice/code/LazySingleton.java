package net.bwillard.practice.code;

public class LazySingleton {

	private static volatile LazySingleton instance;
	
	private LazySingleton() {}
	
	public static LazySingleton getInstance() {
		if(instance == null) {
			synchronized(instance) {
				instance = new LazySingleton();
			}
		}
		return instance;
	}
}
