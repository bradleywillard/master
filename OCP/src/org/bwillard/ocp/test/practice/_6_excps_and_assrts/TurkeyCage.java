package org.bwillard.ocp.test.practice._6_excps_and_assrts;


public class TurkeyCage implements AutoCloseable {

	@Override
	public void close()  {
		System.out.println("Close gate");
	}
	
	public static void main(String[] args)  {
		try (TurkeyCage t = new TurkeyCage()) {
			System.out.println("put turkeys in");
		}
	}
	
}