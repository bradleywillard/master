package org.bwillard.ocp.test.practice._6_excps_and_assrts;

public class EchoInput {

	public static void main(String[] args) {
		String[] args2 = {"hi", "there" };
		if(args2.length <= 3) 
			assert false;
		System.out.println(args2[0] + args[1] + args[2]);
	}

}
