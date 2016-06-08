package org.bwillard.ccsf.course.cs211s.assn6.code_from_classes;

import java.io.*;
import java.util.*;

public class ReadInResponses {

	public static void main(String[] args) throws Exception {
		try {
			ObjectInputStream in = new ObjectInputStream(new FileInputStream(
					"responseList.ser"));
			ArrayList<Response> responses = (ArrayList<Response>) in
					.readObject();
			for (Response r : responses) {
				System.out.println(r);
			}
			in.close();
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		}

	}

}
