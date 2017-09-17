package org.bwillard.ccsf.course.cs111c.labD_recursion;

import javax.swing.*;

import java.awt.*;
/**
 * 
 * @author Bradley D. Willard
 *
 */
@SuppressWarnings("serial")
public class PolygonJApplet extends JApplet {

	private static final int WINDOW_WIDTH = 800;
	private static final int WINDOW_HEIGHT = 600;
	// MAGIC NUMBERS:
	// 5 Shows a face in the middle
	// 15 is also cool
	// 50 try it with 50 as well
	private static final int MIN_WIDTH = 15;
	private static final int MIN_HEIGHT = 15;
	private static final int INITIAL_X = WINDOW_WIDTH/2;
	private static final int INITIAL_Y = WINDOW_HEIGHT/6;
	// I encourage you to play around with this.
	// Try changing this shrink factor to >= .6 and you can watch the program draw itself.
	// .7 might crash the program. .8 will for sure.
	// .4999999 will only get so close to what .5 does (I think the numbers get rounded in the math).
	private static final double SHRINK_FACTOR = .5;
	private static final Color FILL_COLOR = Color.YELLOW;
	private static final Color DRAW_COLOR = Color.BLUE;
	
	public void init() {
		setPreferredSize(new Dimension(WINDOW_WIDTH,WINDOW_HEIGHT));
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
	}

	public void paint(Graphics pen) {
		
		//Draw the initial polygon...
		pen.setColor(FILL_COLOR);
		int[] xPoints = {INITIAL_X, INITIAL_X * 2/3, INITIAL_X, INITIAL_X * 4/3};
		int[] yPoints = {INITIAL_Y, INITIAL_Y * 4/3, INITIAL_Y * 3, INITIAL_Y * 4/3};
		pen.fillPolygon(xPoints, yPoints, xPoints.length);
		pen.setColor(DRAW_COLOR);
		pen.drawPolygon(xPoints, yPoints, xPoints.length);
		
		//Then call the helper method which makes 4 rectangles with each recursive call...
		drawPolygon(xPoints, yPoints, pen);
	}

	/**
	 * Extracts crosspoints in polygon, then calls helper method which draws 4
	 * polygons on each corner of the current polygon until the base case is reached
	 * 
	 * @param xPoints
	 * @param yPoints
	 * @param pen
	 */
	private void drawPolygon(int[] xPoints, int[] yPoints, Graphics pen) {
		boolean baseCaseNotReached = 
				xPoints[3] - xPoints[1] >= MIN_WIDTH && 
				yPoints[2] - yPoints[0] >= MIN_HEIGHT;
		
		if(baseCaseNotReached) {
			
			//Top polygon
			int[] crossPoint = {xPoints[0], yPoints[0]};
			drawPolygonHelper(xPoints, yPoints, pen, crossPoint, Color.ORANGE, Color.BLACK);
			
			//Left polygon
			int[] crossPointLeft = {xPoints[1], yPoints[1]};
			drawPolygonHelper(xPoints, yPoints, pen, crossPointLeft, Color.BLACK, Color.ORANGE);
			
			//Bottom Polygon
			int[] crossPointBottom = {xPoints[2], yPoints[2]};
			drawPolygonHelper(xPoints, yPoints, pen, crossPointBottom, Color.ORANGE, Color.BLACK);
			
			//Right polygon
			int[] crossPointRight = {xPoints[3], yPoints[3]};
			drawPolygonHelper(xPoints, yPoints, pen, crossPointRight, Color.BLACK, Color.ORANGE);
			
		}
		
	}

	/**
	 * Helper method to draw shapes.  Does the meat and potatoes work for drawing shapes
	 * anywhere on the grid per the crossPoint.
	 * @param xPoints
	 * @param yPoints
	 * @param pen
	 * @param crossPoint
	 * 			Middle of the shape where the two lines cross.  
	 * 			Should always be one of the X,Y points of the previous shape
	 * @param fillColor
	 * 			Color inside the shape
	 * @param drawColor
	 * 			Color of the outline
	 */
	private void drawPolygonHelper(int[] xPoints, int[] yPoints, Graphics pen,
			int[] crossPoint, Color fillColor, Color drawColor) {
		
		float pWidth = Math.round((xPoints[3] - xPoints[1]) * SHRINK_FACTOR);
		float topHeight = Math.round((yPoints[1] - yPoints[0]) * SHRINK_FACTOR);
		float bottomHeight = Math.round((yPoints[2] - yPoints[0]) * SHRINK_FACTOR);
		int xTop 	= crossPoint[0];
		int xLeft	= Math.round(crossPoint[0] - (pWidth/2)); 
		int xBottom = crossPoint[0];
		int xRight 	= Math.round(crossPoint[0] + (pWidth/2)); 
		int yTop 	= Math.round(crossPoint[1] - topHeight); 
		int yLeft	= crossPoint[1];
		int yBottom = Math.round(crossPoint[1] + bottomHeight); 
		int yRight 	= crossPoint[1];
		int[] newXpoints = {xTop,xLeft,xBottom,xRight}; 
		int[] newYpoints = {yTop,yLeft,yBottom,yRight};
		pen.setColor(fillColor);
		pen.fillPolygon(newXpoints, newYpoints, newXpoints.length);
		pen.setColor(drawColor);
		pen.drawPolygon(newXpoints, newYpoints, newXpoints.length);
		
		drawPolygon(newXpoints, newYpoints, pen);
	}

}
