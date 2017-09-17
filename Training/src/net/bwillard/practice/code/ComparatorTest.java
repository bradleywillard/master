package net.bwillard.practice.code;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ComparatorTest {
	
	public static void main(String[] args) {
		List<Double> dArr = Arrays.asList(40.0, null, null, 10.0, 20.0, 50.0, 30.0, null, 70.0, null, 60.0);
		//(1) Old school Anonymous class style sort
		dArr.sort(new Comparator<Double>() {
			@Override
			public int compare(Double o1, Double o2) {
				if(o1 == null && o2 == null) return 0;
				else if(o1 == null) return -1;
				else if(o2 == null) return 1;
				else return o1.compareTo(o2);
			}
		});
		System.out.println(dArr);
		
		// (2) An even better Java 8 Lambda sort approach
		dArr.sort((o1, o2) -> {
			if(o1 == null && o2 == null) return 0;
			else if(o1 == null) return -1;
			else if(o2 == null) return 1;
			else return Double.compare(o1, o2); 
		});	
		System.out.println(dArr);
		
		// (3) Returning a custom comparator with one single line!
		Comparator<Double> dComp = Comparator.nullsFirst(Comparator.naturalOrder());
		dArr.sort(dComp);
		
		System.out.print(dArr);
	}
	
}
