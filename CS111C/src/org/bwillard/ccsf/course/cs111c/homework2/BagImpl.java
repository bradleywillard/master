package org.bwillard.ccsf.course.cs111c.homework2;

public class BagImpl<T> implements BagInterface<T> {

	
	public static void main(String[] args) {
		BagInterface<String> myWords = new BagImpl<String>();
		myWords.add("hi");
		myWords.add("hello");
		myWords.add("hi");
		myWords.add("bye");
		myWords.add("hi");
		myWords.add("bye");
		BagInterface<String> tempBag = new BagImpl<String>();
		
		while(!myWords.isEmpty()) {
			String item = myWords.remove();
			if(tempBag.getFrequencyOf(item) == 0) {
			//if(!tempBag.contains(item)) {	ALTERNATE
				tempBag.add(item);
			}
		}
		
		BagInterface<String> letters = new BagImpl<String>();
		letters.add("a");
		letters.add("b");
		letters.add("c");
		letters.add("a");
		BagInterface<String> vowels = new BagImpl<String>();
		while(!letters.isEmpty()) {
			String letter = letters.remove();
			boolean isVowel = 
					"a".equalsIgnoreCase(letter) ||
					"e".equalsIgnoreCase(letter) ||
					"i".equalsIgnoreCase(letter) ||
					"o".equalsIgnoreCase(letter) ||
					"u".equalsIgnoreCase(letter);
			if(isVowel && !vowels.contains(letter)) {
				vowels.add(letter);
 			}
		}
		System.out.println("There were " + vowels.getCurrentSize() + " in the bag.");
		if(!vowels.isEmpty()) {
			System.out.println(vowels.getFrequencyOf("a") + " a's");
			System.out.println(vowels.getFrequencyOf("e") + " e's");
			System.out.println(vowels.getFrequencyOf("i") + " i's");
			System.out.println(vowels.getFrequencyOf("o") + " o's");
			System.out.println(vowels.getFrequencyOf("u") + " u's");
		}
	}

	public String[] toDistinctArray(BagInterface<String> myWords) {
		BagInterface<String> tempBag = new BagImpl<String>();
		String[] myWordsArr = myWords.toArray();
		for(int i = 0; i < myWordsArr.length; i++) {
			if(!tempBag.contains(myWordsArr[i])) {
				tempBag.add(myWordsArr[i]);
			}
		}
		String[] distinctArray = tempBag.toArray();
		
		return null;
	}
	
	
	
	@Override
	public int getCurrentSize() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean add(T newEntry) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public T remove() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean remove(T anEntry) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getFrequencyOf(T anEntry) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean contains(T anEntry) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public T[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
