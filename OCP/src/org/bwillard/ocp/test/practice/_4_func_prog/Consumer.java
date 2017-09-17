package org.bwillard.ocp.test.practice._4_func_prog;

@FunctionalInterface
public interface Consumer<T> {
	void accept(T t);
}
