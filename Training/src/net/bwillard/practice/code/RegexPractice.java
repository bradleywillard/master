package net.bwillard.practice.code;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexPractice {

	public static void main(String[] args) {
		
		String divStr = "<div>It's my party bruh</div>\n<div>It's my party sish</div>";
		String pattern = "^\\<div\\>";
		
		System.out.println("matched: " + matched(pattern, divStr));
		
	}
	
	static int matched(String pattern, String str) {
		int count = 0;
		Pattern p = Pattern.compile(pattern);
		Matcher m = p.matcher(str);
		while(m.find()) {
			count++;
		}
		return count;
	}
}
