package org.bwillard.ccsf.course.cs111c.homework3;

public class BagExample {

	public static void main(String[] args) {
		BagInterface<String> animalBag = new ArrayBag();

		System.out.println(animalBag.isEmpty());
		animalBag.add("alligator");
		animalBag.add("bear");
		animalBag.add("bear");
		animalBag.add("cat");
		animalBag.add("dog");
		animalBag.add("elephant");
		System.out.println(animalBag.isEmpty());
		animalBag.add("cat");
		animalBag.add("cat");
		System.out.println(animalBag.getCurrentSize());
		System.out.println(animalBag.remove("bear"));
		System.out.println(animalBag.getCurrentSize());
		System.out.println(animalBag.remove("cat"));
		System.out.println(animalBag.remove("cat"));
		animalBag.add("cat");
		System.out.println(animalBag.remove("gorilla"));
		System.out.println(animalBag.getCurrentSize());
		System.out.println(animalBag.getFrequencyOf("cat"));
		System.out.println(animalBag.contains("gorilla"));
		System.out.println(animalBag.getFrequencyOf("gorilla"));
		animalBag.clear();
		System.out.println(animalBag.getCurrentSize());
		System.out.println(animalBag.remove());

		ListInterface<String> animalList = new AList<String>();

		
		
		
		
		
		
		
		
		System.out.println(animalList.isEmpty());
		animalList.add("alligator");
		animalList.add("bear");
		animalList.add("cat");
		animalList.add("dog");
		animalList.add("lemur");
		animalList.add(3, "elephant");
		animalList.add(1, "koala");
		animalList.add("dog");		
		System.out.println(animalList.isEmpty());
		System.out.println(animalList.getLength());
		System.out.println(animalList.remove(1));
		System.out.println(animalList.getEntry(2));
		System.out.println(animalList.remove(2));
		System.out.println(animalList.getLength());
		System.out.println(animalList.replace(1, "monkey"));
		System.out.println(animalList.getEntry(1));
		System.out.println(animalList.getEntry(2));
		animalList.clear();
		System.out.println(animalList.getLength());

		
		
		
		
		
		
		
		
		
		
		
	}
}
