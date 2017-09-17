package net.bwillard.practice.code;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CountHello {

	static String testcase1 = "HELLO! Hellohello";// "Hello! hello! how are you";

	public static void main(String args[]) {
		CountHello testInstance = new CountHello();
		int result = testInstance.count(testcase1);
		System.out.println(result);
	}

	public int count(String str){
        String str1=str.toLowerCase();
        String str2="hello";
        String str3="";
        int len1= str1.length();
        int len2=str2.length();
        int max=len1-len2;
        int c=0;
        int count=0;
        while(c<=max){
            for(int i=c;i<len2;i++)
            {
                str3=str3+str1.charAt(i);
            }
            if(str3.equals(str2)){
                count++;
            }
            c=c+1;
            len2++;
            str3="";

        }

        return count;


    }
	/*public int count(String str) {
		String searchStr = "hello";
        Pattern pattern = Pattern.compile(searchStr, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(str);
        int count = 0;
        while (matcher.find()) {
            count++;
        }
        return count;
	}*/
}
