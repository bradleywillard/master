package net.bwillard.practice.code;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordNet {

	private final Map<String, List<Integer>> words;
	private final static String LEXICAL_UNITS_FILE = "src/net/bwillard/practice/code/wn_s.csv";

	/**
	 * 
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public WordNet() throws FileNotFoundException, IOException {
		words = new HashMap<>();
		readLexicalUnitsFile();
	}

	/**
	 * 
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	private void readLexicalUnitsFile() throws FileNotFoundException, IOException {

		BufferedReader in = new BufferedReader(new FileReader(LEXICAL_UNITS_FILE));
		String line;

		while ((line = in.readLine()) != null) {
			String columns[] = line.split("\t");
			String key = columns[0];
			int valueInt;
			List<Integer> valueList;
			
			try {
				valueInt = Integer.parseInt(columns[1]);
			} catch (NumberFormatException e) {
				System.out.println(e);
				continue;
			}
			
			if (words.containsKey(key)) {
				valueList = words.get(key);
			} else {
				valueList = new ArrayList<>();
				words.put(key, valueList);
			}
			
			valueList.add(valueInt);
		}
		
		in.close();
	}

	//You can test this file by running it as a standalone app....
	public static void main(String[] args) {
		try {
			WordNet wn = new WordNet();
			for (String k : wn.words.keySet()) {
				System.out.println(k + " " + wn.words.get(k));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
