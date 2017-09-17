package net.bwillard.practice.code;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Class to merge ranges of numbers
 * 
 * @author bradleywillard
 *
 */
public class RangeMerger {

	/**
	 * Sorts a list of ZipRanges (see helper class ZipRange below).
	 * Merge ranges that overlap.
	 * See comments in code for details
	 * 
	 * @param ranges
	 * @return
	 */
    public static List<ZipRange> merge(List<ZipRange> ranges) {

    	//No need to merge if less than two ZipRanges
        if (ranges == null || ranges.size() < 2) {
            return ranges;
        }

        //Sort using a Lambda to build a comparator on the fly
        //with a little duration wrapper each time to see how long it takes
        long startSort = System.currentTimeMillis();
        Collections.sort(ranges, (i1, i2) -> {
			return i1.front - i2.front;
		});
        long duration = System.currentTimeMillis() - startSort;
        System.out.println("It took " + duration + "ms to sort the ranges");

        ZipRange first = ranges.get(0);
        int front = first.front;
        int back = first.back;

        List<ZipRange> result = new ArrayList<ZipRange>();

        //Iterate through the ranges....
        for (int i = 1; i < ranges.size(); i++) {
        	//Get the 2nd item in the list, since we pivot off the first above,
        	//then advance it down below with each iteration 
            ZipRange current = ranges.get(i);
            //We don't want a range where the start is greater than the end, that makes no sense...
            if(current.front > current.back) {
            	throw new IllegalArgumentException("Invalid Range: " + current.front + " " + current.back);
            } 
            
            //See if the current item's start overlaps with the previous item's end
            //I.E., if current item is [32234, 33219] and the previous item is 
            //[33218, 34981], then the current.start = 33218 and previous end is 33219, then 
            //there's an overlap, so we can merge the two ranges, making them [32234,34981]
            if (current.front <= back) {
            	//Merging happens right here!
            	back = current.back;
            } else {
            	//No merging necessary here, just add the range to the merged list...
                result.add(new ZipRange(front, back));
                //...and advance the start & end up to the current for the next comparison
                //if not the last item in the list
                front = current.front;
                back = current.back;
            }
            
        }

        //This just does the final addition of the the last item to the merged list outside the loop
        result.add(new ZipRange(front, back));

        return result;

    }
}

/**
 * Helper class
 * @author bradleywillard
 *
 */
class ZipRange {
    int front;
    int back;

    ZipRange(int front, int back) {
        this.front = front;
        this.back = back;
    }
    
    @Override
    public String toString() {
    	return new StringBuilder().append(front).append(" ").append(back).append("\n").toString();
    }
}