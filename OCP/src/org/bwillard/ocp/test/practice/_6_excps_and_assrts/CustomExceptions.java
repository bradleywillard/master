package org.bwillard.ocp.test.practice._6_excps_and_assrts;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.MissingResourceException;

public class CustomExceptions {

	class CannotSwimException extends Exception{
		public CannotSwimException() {
			super();
		}
		
		public CannotSwimException(Exception e) {
			super(e);
		}
		
		public CannotSwimException(String message) {
			super(message);
		}
		
	}
	class DangerInTheWaterException extends RuntimeException{}
	class SharkInTheWaterException extends DangerInTheWaterException{}
	class Dolphin {
		public void swim() throws CannotSwimException {
			
		}
	}
	
	public static void main(String[] args) {
		try {
			String path = "src/org/bwillard/ocp/test/practice/_6_excps_and_assrts/";
			String readFile = "dolphinsBorn.txt";
			Path readPath = Paths.get(path + readFile);
			String text = new String(Files.readAllBytes(readPath));
			LocalDate date = LocalDate.parse(text);
			System.out.println(date);
			
			Path writePath = Paths.get(path + "overwrite.txt");
			readWrite(readPath, writePath);
			
		} catch(DateTimeParseException | IOException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} 
		try{
			throw new RuntimeException();
		}catch( RuntimeException e) {
			e = new RuntimeException();
		}
	
		
	}
	
	public void doesNotCompile() {
		try{
			mightThrow();
		/*} catch(FileNotFoundException | IllegalStateException e) {
			
		} catch(InputMismatchException e | MissingResourceException e) {
			
		} catch(SQLException | ArrayIndexOutOfBoundsException e) {
			
		} catch(FileNotFoundException | IllegalArgumentException e) {
			
		} catch(IOException e) {*/
			
		} catch(Exception e) {
			
		}
	}
	
	public void mightThrow() throws DateTimeParseException, IOException {}

	
	public static void readWrite(Path path1, Path path2) throws IOException {
		try(BufferedReader in = Files.newBufferedReader(path1); 
			BufferedWriter out = Files.newBufferedWriter(path2)) {
			out.write(in.readLine());
		}
	}
	
	class ExampleOne implements AutoCloseable {
		public void close() throws IllegalStateException {
			throw new IllegalStateException("Cage door does not close");
		}
	}
	
	class ExampleTwo implements AutoCloseable {
		public void close() throws Exception {
			throw new Exception("Cage door does not close");
		}
	}
	
	class ExampleThree implements Closeable {
		int COUNT = 0;
		public void close() throws IllegalStateException {
			COUNT++;
		}
	}
	
	/*static class Turkey {
		public static void main(String[] args) {
			try (Turkey t = new Turkey()) {
				System.out.println(t);
			}
		}

		@Override
		public void close() throws Exception {
			// TODO Auto-generated method stub
			
		}
	}*/
	
	
}
