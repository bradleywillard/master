import java.nio.charset.Charset;
import java.nio.file.*;
import java.util.*;
import java.util.function.*;
import java.util.stream.*;

public class StreamFun {

	public static void main(String[] args) throws Exception {
		List<Integer> numberList = fillNumberList(1000, 1000);	

		// find the minimum on a Stream<Integer> 
		Optional<Integer> minOnList = numberList.stream()
			.filter(n -> n < 0)	
			.min(Integer::compare);
		int minInt = minOnList.orElse(-1);
		System.out.println(minInt);
	
		// only the even random numbers
	/*	numberList.stream()
			.filter(n -> n%2==0)
			.forEach(System.out::println); */
//			.forEach( n -> System.out.println(n));
	/*	for(Integer n : numberList) {
			if(n%2==0) {
				System.out.println(n);
			}
		} */
		
		// find the maximum by mapping to an IntStream and then invoking max
		numberList.stream()
			.mapToInt(n->n)
		//	.mapToInt(Integer::valueOf) an alternative to the above line
			.max();
	
	
		
		// count how many times a target appears- iterative way vs stream way
		int target = 43;
		long count = 0;
		
		for(Integer i : numberList) {
			if(i==target) {
				count++;
			}
		}
		System.out.println(target + " appears " + count + " times");
		
		count = numberList.stream().filter(n -> n==target).count();
		System.out.println(target + " appears " + count + " times");
		
		
		// infinite stream of random integers
		// transformed to return only the first unique 100 numbers
		// then filter for only the evens then output to a list
		Random generator = new Random();
		List<Integer> randomList = Stream.generate( 
				() -> generator.nextInt())
				.distinct()
				.limit(100)				
				.filter(n -> n%2==0)
				.collect(Collectors.toList());
		
		// infinite stream of odd, positive numbers
		Stream<Integer> oddPositiveStream =
				Stream.iterate(1, n -> n +2);
		
		
		/* read from the file */
		List<String> scrabbleWords = Files.readAllLines(Paths.get("words.txt"), Charset.forName("ISO-8859-1")); 
		
		long twoLetterWordCount = scrabbleWords.stream()
				.filter(word -> word.length()==2)
		//		.filter(word -> word.charAt(0)=='a')
				.count();
		System.out.println("there are " + twoLetterWordCount + " two letter words");
		
		/*
		// map each word to upper case
		scrabbleWords.stream()
			.map(word -> word.toUpperCase())
			.forEach(System.out::println);
		*/
		/*
		// map each word to its last letter
		scrabbleWords.stream()
			.map(word -> word.charAt(word.length()-1))
			.forEach(System.out::println);
		*/
		System.out.println("The average number of vowels is " + 
		scrabbleWords.stream()
			.mapToInt(word -> countVowels(word))
			.average() );
		
		// find if there are words that have a q but no qu
		boolean qWords = scrabbleWords.stream()
			.anyMatch(word ->
				{ return word.indexOf("q")>=0
					&& word.indexOf("qu")<0;
				}
				);
		System.out.println("q's without qu" + qWords);

	// demonstrate laziness
	String[] words = {"apple", "ball", "banana"};
	Stream.of(words)
		.map(s -> {
			System.out.println("in the map with "+ s);
			return s.toUpperCase(); } )
		.forEach(s -> System.out.print("in the forEachwith "+ s));
	}
	
	private static int countVowels(String word) {
		int vowels = 0;
		char[] letters = word.toCharArray();
		for(char c: letters) {
			if(c=='a' || c=='e' || c=='i' || c=='o' || c=='u') {
				vowels++;
			}
		}
		return vowels;
	}
	
	private static List<Integer> fillNumberList(int size, int max) {
		Random generator = new Random();
		List<Integer> numbers = new ArrayList<>();
		for(int i=0; i<size; i++) {
			numbers.add(generator.nextInt(max));
		}
		return numbers;
	}

}
