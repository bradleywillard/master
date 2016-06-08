package org.bwillard.ccsf.course.cs211s.assn14.code_from_class;


public class TriangleUtils {
	
	public static boolean isIsoceles(int a, int b, int c) {
		if(a<0 || b<0 || c<0) {
			throw new IllegalArgumentException("\"triangle\" cannot have negative length");
		}
		
		if( (a==b && a!=c) ||
			(a==c && a!=b) ||
			(b==c && a!=b) ) {
			return true;
		} else {
			return false;
		}
	}

}
