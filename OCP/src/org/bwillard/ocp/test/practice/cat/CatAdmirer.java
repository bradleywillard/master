package org.bwillard.ocp.test.practice.cat;

import org.bwillard.ocp.test.practice.cat.species.Lynx;

public class CatAdmirer {

	public static void main(String[] args) {
		BigCat cat = new Lynx();
		System.out.println(cat.name);
		System.out.println(cat.hasFur);
		System.out.println(cat.hasPaws);
		System.out.println(cat.id);
	}

}
