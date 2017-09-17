package org.bwillard.ocp.test.practice._8_io;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;

public class IOStreamStuff {

	private static final String FOLDER = "/Users/bradleywillard/";
	private static final String FILE = "zoo-data.txt";
	
	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		try(BufferedReader br = new BufferedReader(new FileReader(FOLDER + FILE))) {
			System.out.println(br.readLine());
		}
		
		try(ObjectInputStream os = new ObjectInputStream(
				new BufferedInputStream(
				new FileInputStream(FOLDER + FILE)))) {
			System.out.println(os.readObject());
		}

	}

}
