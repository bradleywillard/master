package org.bwillard.ccsf.course.cs211s._9_lambdas;

import java.awt.geom.*;

@FunctionalInterface
public interface LineCharacteristic {

	enum LineChar { 
		DISTANCE("Distance"), MIDPOINT("Midpoint"), VERT_HORT("VertHort");
		private String characteristic;
		
		private LineChar(String characteristic) {
			this.characteristic = characteristic;
		}
		public String getCharacteristic() {
			return characteristic;
		}
	}
	
	String lineCharacteristic(Point2D point1, Point2D point2);
	
}
