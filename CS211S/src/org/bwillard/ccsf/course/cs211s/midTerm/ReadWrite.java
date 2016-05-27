package org.bwillard.ccsf.course.cs211s.midTerm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class ReadWrite {

	private static final String FILE_PATH = "src/org/bwillard/ccsf/course/cs211s/assn8/";
	private static final String FILE_NAME = "Eviction_Notices.csv";
	
	public ReadWrite() {
		// TODO Auto-generated constructor stub
	}
	
	public static void methodA() {
		try{
			System.out.println("Statement1");
			methodB();
			System.out.println("Statement2");
			ObjectInputStream in = new ObjectInputStream(new FileInputStream("input.txt"));
			Object o = in.readObject();
		} catch (IOException e) {
			System.out.println("IOException in methodA: " + e.getMessage());
		} catch (ClassNotFoundException e) {
			System.out.println("ClassNotFoundException in methodA: " + e.getMessage());
		} finally {
			System.out.println("Finally clause in methodA");
		}
	}
	
	public static void methodB() {
		try{
			//System.out.println("Statment6");
			//throw new NullPointerException();
			//ObjectInputStream in = new ObjectInputStream(new FileInputStream("input.txt"));
			//Object o = in.readObject();
			//throw new IOException();
			throw new FileNotFoundException();
		} catch(FileNotFoundException e) {
			System.out.println("FileNotFoundException in methodB");
		//} catch(ClassNotFoundException e) {
			//System.out.println("ClassNotFoundException in methodB");
		} catch (IOException e) {
			System.out.println("IOException in methodB");
			e.printStackTrace();
		} finally {
			System.out.println("Finally block in methodB");
		}
		//System.out.println("Outside of try/catch in methodB");
	}
	
	public static Object readSerialzationAnimal(String fileName) throws FileNotFoundException, IOException, ClassNotFoundException {
		ObjectInputStream in = new ObjectInputStream(new FileInputStream("input.txt"));
		Object o = in.readObject();
		List<Cat> sL = new ArrayList<>();
		methodE(sL);
		
		return o;
		
	}
	
	static void methodE(List<? super Cat> animalList) {
		
	}
	class Animal {
		
	}
	
	public void birthdayUpdates(HashMap<String, Animal> animals, List<String> nameList) {
		for(String mapName : animals.keySet()) {
			if(nameList.contains(mapName)) {
				Animal a = animals.get(mapName);
				//a.setAge(a.getAge() + 1)
			}
		}
	}
	class Cat extends Animal {} 
	class Horse extends Animal {}
	
	
	public static void main(String[] args) {
		methodA();
		/*try(InputStream is = new FileInputStream(new File(FILE_PATH + FILE_NAME));
			Reader r = new InputStreamReader(is, "UTF-8");
			BufferedReader br = new BufferedReader(r);
			OutputStream os = new FileOutputStream(new File(FILE_PATH + "output.txt"));
			Writer w = new OutputStreamWriter(os, "UTF-8");
			BufferedWriter bw = new BufferedWriter(w);
			){
			String line;
			while((line = br.readLine()) != null) {
				bw.write(line);
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}*/
		
	}

}
