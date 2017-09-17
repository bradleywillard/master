package org.bwillard.ccsf.course.cs111c.labD_recursion;

import javax.swing.*;

import java.awt.*;

public class RoundRectangleJApplet extends JApplet {

	private static final int WINDOW_WIDTH = 500;
	private static final int WINDOW_HEIGHT = 500;
	private static final int MAX_WIDTH = 200;
	private static final int MAX_HEIGHT = 200;
	private static final int MIN_WIDTH = 10;
	private static final int MIN_HEIGHT = 10;
	private static final int ARC_WIDTH = 5;
	private static final int ARC_HEIGHT = 5;
	private static final int SHRINK_FACTOR = 2;//must be at least 2 to work
	private static final int MIDPOINT_X = WINDOW_WIDTH / 2;
	private static final int MIDPOINT_Y = WINDOW_HEIGHT / 2;
	private static final Color FILL_COLOR = Color.GRAY;
	private static final Color DRAW_COLOR = Color.BLACK;
	
	public void init() {
		setPreferredSize(new Dimension(WINDOW_WIDTH,WINDOW_HEIGHT));
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
	}

	public void paint(Graphics pen) {
		//First set of coordinates for to draw the first square with
		int initialX = MIDPOINT_X - (MAX_WIDTH/2);
		int initialY = MIDPOINT_Y - (MAX_HEIGHT/2);
		
		//Draw the first square/rectangle...
		pen.setColor(FILL_COLOR);
		pen.fillRoundRect(initialX, initialY, MAX_WIDTH, MAX_HEIGHT, ARC_WIDTH, ARC_HEIGHT);
		pen.setColor(DRAW_COLOR);
		pen.drawRoundRect(initialX, initialY, MAX_WIDTH, MAX_HEIGHT, ARC_WIDTH, ARC_HEIGHT);
		//Then call the helper method which makes rectangles recursively...
		drawSquare(initialX, initialY, MAX_WIDTH, MAX_HEIGHT, pen);
	}

	private void drawSquare(int x, int y, int width, int height, Graphics pen) {
		if(width >= MIN_WIDTH && height >= MIN_HEIGHT) {
			int newWidth = width/SHRINK_FACTOR;
			int newHeight = height/SHRINK_FACTOR;
			
			int newXLeftTop = x-(width/(SHRINK_FACTOR * 2));
			int newYLeftTop = y-(width/(SHRINK_FACTOR * 2));
			int newArcWidth = ARC_WIDTH;
			int newArcHeight = ARC_WIDTH;
			pen.setColor(FILL_COLOR);
			pen.fillRoundRect(newXLeftTop, newYLeftTop, newWidth, newHeight, newArcWidth, newArcHeight);
			pen.setColor(DRAW_COLOR);
			pen.drawRoundRect(newXLeftTop, newYLeftTop, newWidth, newHeight, newArcWidth, newArcHeight);
			
			int newXRightTop = newXLeftTop + width;
			int newYRightTop = newYLeftTop;
			pen.setColor(FILL_COLOR);
			pen.fillRoundRect(newXRightTop, newYRightTop, newWidth, newHeight, newArcWidth, newArcHeight);
			pen.setColor(DRAW_COLOR);
			pen.drawRoundRect(newXRightTop, newYRightTop, newWidth, newHeight, newArcWidth, newArcHeight);
			
			int newXRightBottom = newXRightTop;
			int newYRightBottom = newYRightTop + height;
			pen.setColor(FILL_COLOR);
			pen.fillRoundRect(newXRightBottom, newYRightBottom, newWidth, newHeight,  newArcWidth, newArcHeight);
			pen.setColor(DRAW_COLOR);
			pen.drawRoundRect(newXRightBottom, newYRightBottom, newWidth, newHeight,  newArcWidth, newArcHeight);
			
			int newXLeftBottom = newXLeftTop;
			int newYLeftBottom = newYLeftTop + height;
			pen.setColor(FILL_COLOR);
			pen.fillRoundRect(newXLeftBottom, newYLeftBottom, newWidth, newHeight,  newArcWidth, newArcHeight);
			pen.setColor(DRAW_COLOR);
			pen.drawRoundRect(newXLeftBottom, newYLeftBottom, newWidth, newHeight, newArcWidth, newArcHeight);
			
			drawSquare(newXLeftTop, newYLeftTop, newWidth, newHeight, pen);
			drawSquare(newXRightTop, newYRightTop, newWidth, newHeight, pen);
			drawSquare(newXRightBottom, newYRightBottom, newWidth, newHeight, pen);
			drawSquare(newXLeftBottom, newYLeftBottom, newWidth, newHeight, pen);
			
		}
	}

}
