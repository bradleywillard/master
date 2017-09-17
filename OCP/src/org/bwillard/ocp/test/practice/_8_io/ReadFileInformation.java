package org.bwillard.ocp.test.practice._8_io;

import java.io.File;

public class ReadFileInformation {

	private static final String FOLDER = "/Users/bradleywillard/Pictures/";
	
	public static void main(String[] args) {
		File file = new File(FOLDER/* + "swirling.gif"*/);
		System.out.println("Absolute Path: " + file.getAbsolutePath());
		System.out.println("Is Directory: " + file.isDirectory());
		System.out.println("Parent Path: " + file.getParent());
		if(file.isFile()) {
			System.out.println("File size: " + file.length());
			System.out.println("File lastModified: " + file.lastModified());
		} else {
			for(File subFile : file.listFiles()) {
				System.out.println("\t" + subFile.getName());
			}
		}

	}

}
