/**
 * 
 */
package org.bwillard.ccsf.course.cs211s.assn14;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assume;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

/**
 * @author bradleywillard
 *
 */
@RunWith(value = Parameterized.class)
public class NumberUtilTest {

	enum Type {SUM, SUM_EXCEPTION, MAX, MAX_EXCEPTION};
	
	List<Integer> intList;
	NumberUtil nu;
	int expected;
	Type type;
	
	//parameters pass via this constructor
	public NumberUtilTest(Type type, List<Integer> list, int expected) {
		this.type = type;
		this.intList = list;
		this.expected = expected;
	}

	//Declares parameters here
	@Parameters
	public static Iterable<Object[]> getInputs() {
		List<Integer> list1 = new ArrayList<Integer>();
		list1.add(60);
		list1.add(200);
		list1.add(80);
		list1.add(2);
		list1.add(900);
		int expectedSum1 = getSum(list1);
		int expectedMax1 = 900;
		
		List<Integer> list2 = new ArrayList<Integer>();
		list2.add(160);
		list2.add(90);
		list2.add(80);
		list2.add(20);
		list2.add(45);
		int expectedSum2 = getSum(list2);
		int expectedMax2 = 160;
		
		List<Integer> list3 = new ArrayList<Integer>();
		list3.add(234567);
		list3.add(909872);
		list3.add(8980);
		list3.add(205);
		list3.add(45999);
		int expectedSum3 = getSum(list3);
		int expectedMax3 = 909872;
		
		List<Integer> signedList = new ArrayList<Integer>();
		signedList.add(-234567);
		signedList.add(-909872);
		signedList.add(-8980);
		signedList.add(-205);
		signedList.add(-45999);
		int expectedSignedSum = getSum(signedList);
		int expectedSignedMax = -205;
		
		List<Integer> mixedList = new ArrayList<Integer>();
		mixedList.add(-234567);
		mixedList.add(-909872);
		mixedList.add(8980);
		mixedList.add(205);
		mixedList.add(-45999);
		mixedList.add(-67);
		int expectedMixedSum = getSum(mixedList);
		int expectedMixedMax = 8980;
		
		List<Integer> endPointsList = new ArrayList<Integer>();
		endPointsList.add(-909872);
		endPointsList.add(8980);
		endPointsList.add(205);
		endPointsList.add(-234567);
		endPointsList.add(-45999);
		endPointsList.add(876543);//largest number at the end
		int expEndPointsSum = getSum(endPointsList);
		int expEndPointsMax = 876543;
		
		List<Integer> begPointsList = new ArrayList<Integer>();
		begPointsList.add(909872);//largest number at the beginning
		begPointsList.add(8980);
		begPointsList.add(205);
		begPointsList.add(-234567);
		begPointsList.add(-45999);
		begPointsList.add(876543);
		int expBegPointsSum = getSum(begPointsList);
		int expBegPointsMax = 909872;
		
		List<Integer> emptyList = new ArrayList<Integer>();
		
		return Arrays.asList(new Object[][] { 
			{ Type.SUM, list1, expectedSum1 },
			{ Type.MAX, list1, expectedMax1 },
			{ Type.SUM, list2, expectedSum2 },
			{ Type.MAX, list2, expectedMax2 },
			{ Type.SUM, list3, expectedSum3 },
			{ Type.MAX, list3, expectedMax3 },
			{ Type.SUM, signedList, expectedSignedSum },
			{ Type.MAX, signedList, expectedSignedMax },
			{ Type.SUM, mixedList, expectedMixedSum },
			{ Type.MAX, mixedList, expectedMixedMax },
			{ Type.SUM, endPointsList, expEndPointsSum },
			{ Type.MAX, endPointsList, expEndPointsMax },
			{ Type.SUM, begPointsList, expBegPointsSum },
			{ Type.MAX, begPointsList, expBegPointsMax },
			{ Type.SUM_EXCEPTION, emptyList, 0 },
			{ Type.MAX_EXCEPTION, emptyList, 0 }
			
		});
	}
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		nu = new NumberUtil(intList);
		System.out.println("In setUp with " + intList);
	}

	@Test
	public void testMax() {
		Assume.assumeTrue(type == Type.MAX);
		System.out.println("In testMax with " + intList);
		int actual = nu.max();
		assertEquals(expected, actual);
		System.out.println("Max expected: " + expected + ", actual: " + actual + "\n");

	}
	
	@Test(expected = IllegalStateException.class) 
	public void testExceptionForMax() {
		Assume.assumeTrue(type == Type.MAX_EXCEPTION);
		intList.clear();
		System.out.println("Int testExceptionForMax with empty " + intList);
		nu.max();
	}
	
	@Test
	public void testSum() {
		Assume.assumeTrue(type == Type.SUM);
		System.out.println("In testSum with " + intList);
		int actual = nu.sum();
		assertEquals(expected, actual);
		System.out.println("Sum expected: " + expected + ", actual: " + actual + "\n");
	}

	@Test(expected = IllegalStateException.class) 
	public void testExceptionForSum() {
		Assume.assumeTrue(type == Type.SUM_EXCEPTION);
		intList.clear();
		System.out.println("Int testExceptionForSum with empty " + intList);
		nu.sum();
	}

	/**
	 * Get max from the list in the old fashioned way to make this
	 * test more portable and scalable in the future.  Could just look 
	 * at the biggest number, but then the getSum method below would
	 * be a lonely helper method.
	 * 
	 * @param list
	 * @return
	 */
	private static int getMax(List<Integer> list) {
		int max = list.get(0);
		for(Integer i : list) {
			if(i > max) {
				max = i;
			}
		}
		return max;
	}
	
	/**
	 * Not about to sum up the big numbers in the list manually
	 * so why not use this helper method.
	 * 
	 * @param list
	 * @return
	 */
	private static int getSum(List<Integer> list) {
		int sum = 0;
		for(Integer i : list) {
			sum += i;
		}
		return sum;
	}
}
