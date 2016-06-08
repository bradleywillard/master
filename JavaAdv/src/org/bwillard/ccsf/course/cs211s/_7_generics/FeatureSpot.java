package org.bwillard.ccsf.course.cs211s._7_generics;

import java.time.*;

public class FeatureSpot<T extends Item >  {
	
	private T item;
	private LocalTime start, end;
	private int featuredItemCount;
	
	public FeatureSpot(T item, int numberMinutes) {
		this.featuredItemCount = 0;
		featureItem(item, numberMinutes);

	}
	
	public boolean isFeatured() {
		LocalTime now = LocalTime.now();
		if(start.isBefore(now) &&
				now.isBefore(end) ) {
			return true;
		} else {
			return false;
		}
	}

	public void featureItem(T item, int numberOfMinutes) {
		featuredItemCount++;
		this.item = item;
		this.start = LocalTime.now();	
		this.end = this.start.plusMinutes(numberOfMinutes);
	}
	
	public T getItem() {
		return item;
	}

	public LocalTime getStart() {
		return start;
	}

	public LocalTime getEnd() {
		return end;
	}

	@Override
	public String toString() {
		if(!isFeatured()) {
			return "There is no featured item at this time." +
					"\n\tThere have been " + featuredItemCount + " items featured.";
		} else {
			return "Featured Item!\n" + item.toString() + "\nThis item will be featured until " + end +
					"\nThere have been " + featuredItemCount + " items featured.\n";
		}
	}
	
	

	

}
