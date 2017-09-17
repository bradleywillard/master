package org.bwillard.ocp.test.practice._4_func_prog;

interface Gorilla { String move(); }


public class GorillaFamily {

	String walk = "walk";
	void everyonePlay(boolean baby) {
		String approach = "amble";
		//approach = "run";
		
		play(() -> walk);
		play(() -> baby ? "hitch a ride" : "run");
		play(() -> approach);
		
	}
	
	void play(Gorilla g) {
		System.out.println(g.move());
	}
	
	public static void main(String[] args) {
		GorillaFamily gf = new GorillaFamily();
		gf.everyonePlay(false);
	}
	
	
}
