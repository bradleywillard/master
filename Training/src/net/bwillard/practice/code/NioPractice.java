package net.bwillard.practice.code;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Collectors;

public class NioPractice {

	private static final String PATH = "/Users/bradleywillard/Documents/practice/gorilla/signed-words.txt";
	
	public static void main(String[] args) {
		Path path = Paths.get(PATH);
		
		Files.find(path.getParent(), 10.0, //k1
			(Path p) -> p.toString().endsWith(".txt") && Files.isDirectory(p)) //k2
			.collect(Collectors.toList())
			.forEach(System.out::println);
		
		Files.readAllLines(path) //k3
			.flatMap(p -> Stream.of(p.split(" "))) //k4
			.map(s -> s.toLowerCase())
			.forEach(System.out::println);
	}

}
