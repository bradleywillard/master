package net.bwillard.practice.code;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class EssayCreator {
	// Creating varz
	private static String[] lf = { "happy", "sad", "unhappy", "atractive",
			"fast", "lazy" };
	private static String[] op = { "estatic", "melhencohly", "depressed",
			"alluring", "swift", "lackadaisical" };
	private static String pF = "   ";
	private static String temp[];
	private static String conv = "   ";
	private static String comm = ", ";
	private static Random random = new Random();
	private List<String> array = new ArrayList<String>();

	// Bradley D: Don't capitalize method names and don't use nouns.
	// There not class names. Changed Converter to convert. It'd also be good to
	// stipulate what you are converting, i.e. convertMyString to make this a
	// little more intuitive
	public static void convert(String in) {
		/*
		 * Bradley D: First, you are replacing all commas following by a space
		 * with 3 spaces. Be good to know why you doin that?
		 */
		in = in.replace(comm, conv);
		for (int i = 0; i < lf.length; i++) {
			in = in.replace(lf[i], op[i]);
		}
		/*
		 * Bradley D: Now you are replacing the 3 spaces with a comma and a
		 * space again??
		 */
		in = in.replace(conv, comm);

		// Bradley D: Not really sure what you are trying to iterate through
		// here. in.indexOf(pF) is -1
		// for the use case I've created for you with the text below (what did I
		// miss?)...
		// Perhaps you're trying to find the first place in your essay where pF
		// (3 spaces) occurs....
		// but you've already reconverted your 3 spaces back to a comma and
		// single space.

		// I'm getting even more lost here....
		// int rand = random.nextInt(in.indexOf(pF));
		for (int i = 0; i < in.indexOf(pF); i++) {
			/*
			 * Bradley D: What is pF?? It appears to be the same as comm...
			 */
			/*
			 * Where I want to get an exact string of an essay I'd convert pF to
			 * conv, and then remove the paragraph to change the order }
			 */

			// Bradley D: Ok, so finally.... without really knowing what exactly
			// you
			// are trying to accomplish, I will take a wild guess. If you're
			// trying to
			// convert a string which might be longer than a single word (hence
			// my guess
			// at your reasoning for removing the commas), then you can
			System.out.println("pF index:" + i);
		}
		// Bradley D: Commenting this out since it was not included
		// CreateGUI.output.setText(in);
		// Sound.stopSound();
	}

	public static void main(String[] args) {
		EssayCreator ec = new EssayCreator();
		String essay = "Let's see if we find the desired string in here.  "
				+ "Are we happy? Nope, we're not happy.  Who's happy? What does happiness mean anyway? "
				+ "I'd be very happy if this question we're more clear, but let's give it a go anyway. Maybe "
				+ "we're lazy, and that's not attractive, thus rendering us unhappy and lackadasical... jk! "
				+ "So hey man... why are you replacing all of the commas with spaces?  "
				+ "Can you put comments in your code? What is pF? "
				+ "Also you should not capitalize method names.  They should be in camelCase and they should not "
				+ "be nouns like Converter, which makes them look like a constructor.  Methods represent "
				+ "an action taken, so a verb to describe them is standard practice. "
				+ "So use convert, but what are you converting? convertString?? convertWords? "
				+ "Anyway, making your method names intuitive would be helpful to anyone trying to understand "
				+ "the code.";
		ec.convert(essay);
	}
}
