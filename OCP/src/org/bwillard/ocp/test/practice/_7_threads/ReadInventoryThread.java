package org.bwillard.ocp.test.practice._7_threads;

public class ReadInventoryThread extends Thread {

	public ReadInventoryThread() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void run() {
		System.out.println("Printing zoo inventory");

	}

	public static void main(String[] args) {
		System.out.println("Begin");
		new ReadInventoryThread().start();
		new Thread(new PrintData()).start();
		new ReadInventoryThread().start();
		System.out.println("End");
	}

}
