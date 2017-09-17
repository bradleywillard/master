package org.bwillard.ocp.test.practice.cat;

public abstract class BigCat {

	public String name = "cat";
	protected boolean hasFur = true;
	boolean hasPaws = true;
	private int id;
	
	public abstract void doSomething();
	
	public static void main(String[] args) {
		/*BigCat cat = new BigCat();
		System.out.println(cat.name);
		System.out.println(cat.hasFur);
		System.out.println(cat.hasPaws);
		System.out.println(cat.id);*/
	}
	
	public void findDen(){}
	public void findDen(boolean b) {}
	public int findden() throws Exception { return 0;}

}
