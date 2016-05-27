package org.bwillard.ccsf.course.cs211s.last;

public interface InterfaceA {
	void aMethod();
	default void method() {
		System.out.println("interA");
	}
}
