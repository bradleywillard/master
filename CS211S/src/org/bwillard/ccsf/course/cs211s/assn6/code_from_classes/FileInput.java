package org.bwillard.ccsf.course.cs211s.assn6.code_from_classes;

import java.util.*;
import java.io.*;

public class FileInput {

	public static void main(String[] args) throws IOException {

		try {
			ObjectInputStream in = new ObjectInputStream(new FileInputStream("responseList.ser"));
			ArrayList<Response> responseList = (ArrayList<Response>) in.readObject();

			for(Response response : responseList) {
				System.out.println(response);
			}
			
			in.close();
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		}

		/*
		 * System.out.println("Input file?"); Scanner scan = new
		 * Scanner(System.in); String fileName = scan.nextLine();
		 * System.out.println("Output file?"); String outFileName =
		 * scan.nextLine();
		 * 
		 * Scanner fileScan= new Scanner( new FileReader( new File(fileName)));
		 * 
		 * PrintWriter out = new PrintWriter( new BufferedWriter( new
		 * FileWriter(outFileName)));
		 * 
		 * int total = 0; while(fileScan.hasNext()) { String line =
		 * fileScan.next();
		 * 
		 * Scanner lineScan = new Scanner(line); lineScan.useDelimiter(",|\t");
		 * 
		 * while(lineScan.hasNext()) { String textPiece = lineScan.next();
		 * System.out.println(textPiece);
		 * 
		 * try { int number = Integer.parseInt(textPiece); total += number; }
		 * catch(NumberFormatException ex) { textPiece =
		 * textPiece.toUpperCase(); out.println(textPiece); } }
		 * 
		 * //System.out.println(line); } out.println("The total is " + total);
		 * out.close();
		 */
	}
}
