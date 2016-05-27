package org.bwillard.ccsf.course.cs211s.assn9;

import java.awt.geom.Point2D;

import static org.bwillard.ccsf.course.cs211s.assn9.LineCharacteristic.LineChar;

public class LineCharacteristicFactory {
	
	public static LineCharacteristic createLineCharacteristic(String type) {
		LineCharacteristic lc = (Point2D p1, Point2D p2) -> {
			if(type.equals(LineChar.DISTANCE.getCharacteristic())) {
				double distance = Math.abs(p1.getX() - p2.getX()) + Math.abs(p1.getY() - p2.getY());
				return String.valueOf(distance);
			} else if(type.equals(LineChar.MIDPOINT.getCharacteristic())) {
				double midpoint = ((p1.getX() + p2.getX()) / 2) + ((p1.getY() + p2.getY()) / 2);
				return String.valueOf(midpoint);
			} else if(type.equals(LineChar.VERT_HORT.getCharacteristic())) {		
				boolean vertical = false, horizontal = false;
				if(p1.getX() == p2.getX()) vertical = true;
				if(p1.getY() == p2.getY()) horizontal = true;
				StringBuilder sb = new StringBuilder("Vertical:");
				if(vertical) sb.append("YES");
				else sb.append("NO");
				sb.append(", Horizontal:");
				if(horizontal) sb.append("YES");
				else sb.append("NO");
				return sb.toString();		
			} else {		
				return "DEFAULT MESSAGE: If you're seeing this, you did not pass in the correct line characteristic.";
			}
		};
		return lc;
	}
}
