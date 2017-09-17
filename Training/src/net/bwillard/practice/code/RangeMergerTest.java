package net.bwillard.practice.code;

import static org.junit.Assert.*;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 * Test class for RangeMerger
 * 
 * @author bradleywillard
 *
 */
public class RangeMergerTest {
	
	@Test
	public void testMergeWithoutOverlaps() {
		List<ZipRange> zipRanges = new ArrayList<ZipRange>();
		//Happy Path use case here.  No overlaps, no complexity
		zipRanges.add(new ZipRange(21123, 27235));
		zipRanges.add(new ZipRange(32234, 33219));
		zipRanges.add(new ZipRange(33218, 34981));
		zipRanges.add(new ZipRange(83605, 83706));
		zipRanges.add(new ZipRange(94133, 94133));
		zipRanges.add(new ZipRange(94200, 94299));
		zipRanges.add(new ZipRange(94326, 94399));  

        StringBuilder expected = new StringBuilder()
        	.append("21123 27235").append("\n")
        	.append("32234 34981").append("\n")
        	.append("83605 83706").append("\n")
        	.append("94133 94133").append("\n")
        	.append("94200 94299").append("\n")
        	.append("94326 94399").append("\n");;
        StringBuilder actual = new StringBuilder();
        
        List<ZipRange> mergedRanges = RangeMerger.merge(zipRanges);
        
        for (ZipRange range : mergedRanges) {
        	actual.append(range.toString());
        }
        
        assertEquals(expected.toString(), actual.toString());
	}

	@Test
	public void testMergeWithOverlaps() {
		//A few overlaps in here to test the meat and potatoes 
		List<ZipRange> zipRanges = new ArrayList<ZipRange>();
		zipRanges.add(new ZipRange(21123, 27235));
		zipRanges.add(new ZipRange(32234, 33219));
		zipRanges.add(new ZipRange(33218, 34981));
		zipRanges.add(new ZipRange(83605, 83706));
		zipRanges.add(new ZipRange(83706, 88244));
		zipRanges.add(new ZipRange(94133, 94133));
		zipRanges.add(new ZipRange(94200, 94299));
		zipRanges.add(new ZipRange(94226, 94399));  

        StringBuilder expected = new StringBuilder()
        	.append("21123 27235").append("\n")
        	.append("32234 34981").append("\n")
        	.append("83605 88244").append("\n")
        	.append("94133 94133").append("\n")
        	.append("94200 94399").append("\n");
        StringBuilder actual = new StringBuilder();
        
        List<ZipRange> mergedRanges = RangeMerger.merge(zipRanges);
        
        for (ZipRange range : mergedRanges) {
        	actual.append(range.toString());
        }
        
        assertEquals(expected.toString(), actual.toString());
	}
	
	
	
	@Test(expected=IllegalArgumentException.class)
	public void testThrowException() {
		List<ZipRange> ranges = new ArrayList<ZipRange>();
		ranges.add(new ZipRange(21123, 21115));
		ranges.add(new ZipRange(94103, 94062));
		RangeMerger.merge(ranges);
	}
	
	@Test
	public void testMassiveListForEfficiencyOnly() {
		//All we care about is how long it takes here...
		List<ZipRange> ranges = new ArrayList<ZipRange>();
		//So populate the list with millions of items
		for(int i = 1; i < 9999999; i+=3) {
			ranges.add(new ZipRange(i, i + 2));
		}
		
		long start = System.currentTimeMillis();
		RangeMerger.merge(ranges);
		long end = System.currentTimeMillis();
		
		NumberFormat nf = NumberFormat.getInstance();
		String size = nf.format(ranges.size());
		long duration = end - start;
		String msg = "It took " + duration + "ms to merge the list with " + size + " items.";
		System.out.println(msg);
		//Anything < 2 seconds is a reasonable amount of time
		if(duration > 2000) {
			fail("It took too long " + duration + "ms to run the code.  Look into improving the algorithm");
		}
		
	}
	
	@Test
	public void testMergeEmptyList() {
		List<ZipRange> zipRanges = new ArrayList<ZipRange>();
		//Add no items to zipRanges
		List<ZipRange> mergedRanges = RangeMerger.merge(zipRanges);
	
		for (ZipRange range : mergedRanges) {
        	fail("This shouldn't be reached with an empty list!");
        }
		//That's right!  Empty list or single item lists are designed 
		//to return back the same object that was passed in.
		assertTrue(zipRanges == mergedRanges);
		
	}
	
	@Test
	public void testMergeSingleItemList() {
		List<ZipRange> zipRanges = new ArrayList<ZipRange>();
		zipRanges.add(new ZipRange(21123, 27235));
		List<ZipRange> mergedRanges = RangeMerger.merge(zipRanges);
		
		StringBuilder expected = new StringBuilder("21123 27235\n"), actual = new StringBuilder();
		for (ZipRange range : mergedRanges) {
        	actual.append(range.toString());
        }
		assertEquals(expected.toString(), actual.toString());
		//That's right!  Empty list or single item lists are designed 
		//to return back the same object that was passed in.
		assertTrue(zipRanges == mergedRanges);
		
	}

}
