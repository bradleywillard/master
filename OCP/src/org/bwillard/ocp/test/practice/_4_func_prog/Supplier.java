package org.bwillard.ocp.test.practice._4_func_prog;

@FunctionalInterface public interface Supplier<T> {
	public T get();
}