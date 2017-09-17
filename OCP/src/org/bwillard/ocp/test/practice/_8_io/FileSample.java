package org.bwillard.ocp.test.practice._8_io;

import java.io.File;

public class FileSample {

	private static final String FOLDER = "/Users/bradleywillard/Pictures/";
	
	public static void main(String[] args) {
		File file = new File(FOLDER + "swirling.gif");
		System.out.println("File exists: " + file.exists());
		System.out.println("System.getProperty(\"file.separator\")' " + System.getProperty("file.separator"));
		System.out.println("java.io.File.separator: " + java.io.File.separator);
		
		File parent = new File(FOLDER);
		File child = new File(parent, "SeattlePhoenixTrip-08-2016/IMG_5358.JPG");
		File invalid = new File("/Users/bradleywillard/invalid");
		File rename = new File("/Users/bradleywillard/rename");
		
		System.out.println("Parent: " + parent.getName() + ", exists: " +  parent.exists());
		System.out.println("Child: " + child.getName() + ", exists: " +  child.exists());
		System.out.println("Invalid: " + invalid.getName() + ", exists: " +  invalid.exists());
		System.out.println("Invalid getAbsolutePath(): " + invalid.getAbsolutePath());
		System.out.println("Invalid isDirectory(): " + invalid.isDirectory());
		System.out.println("Invalid isFile(): " + invalid.isFile());
		System.out.println("Invalid length(): " + invalid.length());
		System.out.println("Invalid lastModified(): " + invalid.lastModified());
		
		System.out.println("Invalid renameTo(): " + invalid.renameTo(rename));
		System.out.println("Invalid mkdir(): " + invalid.mkdir());
		System.out.println("Invalid mkdirs(): " + invalid.mkdirs());
		System.out.println("Invalid getParent(): " + invalid.getParent());
		System.out.println("Invalid listFiles(): " + invalid.listFiles());
		System.out.println("Invalid delete(): " + invalid.delete());
		
	}

}
