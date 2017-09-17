package org.bwillard.ocp.test.practice._7_threads;

import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

public abstract class MyTask extends ForkJoinTask<Integer> {

	@Override
	public Integer getRawResult() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected void setRawResult(Integer value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected boolean exec() {
		// TODO Auto-generated method stub
		return false;
	}
}
