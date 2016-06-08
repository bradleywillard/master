package org.bwillard.ccsf.course.cs211s.assn14.code_from_class;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class TriangleUtilsTest {
	
	private int a, b, c;
	private boolean result;
	
	public TriangleUtilsTest(int a, int b, int c, boolean result) {
		this.a = a;
		this.b = b;
		this.c = c;
		this.result = result;
	}

	@Parameters
	public static Collection<Object[]> setUpTestCases() {
		return Arrays.asList(new Object[][] {
			{3, 3, 3, false},
			{1, 2, 3, false},
			{1, 1, 2, true},
			{1, 2, 1, true},
			{2, 1, 1, true}
			});
	}

	@Test(expected=IllegalArgumentException.class) 
	public void testNegativeLength() {
		TriangleUtils.isIsoceles(-1, 1, 1);
	}
	
	@Test
	public void testIsIsoceles() {
		System.out.println("testing with " + a+b+c);
		assertEquals(result, TriangleUtils.isIsoceles(a, b, c));
	}

}
