package org.bwillard.ccsf.course.cs111c.homework6;

public class CountCharacters {

	public static void main(String[] args) {
		String s = "hello";
		System.out.println(countCharsWrong(s, 'l'));
		System.out.println(countChars1(s, 'l'));
		System.out.println(countChars2(s, 'l'));
		System.out.println(countChars3(s, 'l'));
	}
	public static int countCharsWrong(String s, char c) {
		int count = 0;
		if(s.length()>0) {
			if(s.charAt(0)==c) {
				count = 1;
			} else {
				count = 0;
			}
			countCharsWrong(s.substring(1), c);
		}
		return count;
	}
	public static int countChars1(String s, char c) {
		if(s.length()>0) {
			if(s.charAt(0)==c) {
				return 1 + countChars1(s.substring(1), c);
			} else {
				return countChars1(s.substring(1), c);
			}
		} else {
			return 0;
		}
	}
	public static int countChars2(String s, char c) {
		int count = 0;
		if(s.length()>0) {
			if(s.charAt(0)==c) {
				count = 1 + countChars2(s.substring(1), c);
			} else {
				count = countChars2(s.substring(1), c);
			}
		} 
		return count;
	}
	public static int countChars3(String s, char c) {
		if(s.length()>=0) 
			return countChars3Helper(s, c, 0, s.length()-1);
		else return 0;
	}
	private static int countChars3Helper(String s, char c, int start, int end) {
		if(start==end) {
			if(s.charAt(start)==c) 
				return 1;
			else 
				return 0;
		} else {
			if(s.charAt(start)==c) 
				return 1 + countChars3Helper(s, c, start+1, end);
			else
				return countChars3Helper(s, c, start+1, end);
		}
	}
}