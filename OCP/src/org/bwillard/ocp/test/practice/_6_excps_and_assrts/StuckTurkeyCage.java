package org.bwillard.ocp.test.practice._6_excps_and_assrts;

public class StuckTurkeyCage implements AutoCloseable {

	@Override
	public void close() throws Exception {
		throw new Exception("Cage door does not close");
	}
	
	public static void main(String[] args) throws Exception {
		try (StuckTurkeyCage t = new StuckTurkeyCage()) {
			System.out.println("put turkeys in");
		}
	}

}
