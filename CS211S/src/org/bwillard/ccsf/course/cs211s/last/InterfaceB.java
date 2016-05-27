package org.bwillard.ccsf.course.cs211s.last;

public interface InterfaceB {
	void bMethod();
	default void method() {
		System.out.println("interB");
	}

}
