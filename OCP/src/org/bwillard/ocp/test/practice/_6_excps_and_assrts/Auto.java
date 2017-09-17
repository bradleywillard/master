package org.bwillard.ocp.test.practice._6_excps_and_assrts;

public class Auto implements AutoCloseable {

	int num;
	Auto(int num) {
		this.num = num;
	}
	
	@Override
	public void close() throws Exception {
		System.out.println("Close: " + num);
	}
	 
	public static void main(String[] args) {
		try(Auto a1 = new Auto(1); Auto a2 = new Auto(2)) {
			throw new RuntimeException();
		} catch(Exception e) {
			System.out.println("ex");
		} finally {
			System.out.println("finally");
		}
	}
}
