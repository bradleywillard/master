package org.bwillard.ccsf.course.cs111c.labD_recursion; 

import java.awt.*;

import javax.swing.*;

/**
 * 
 * @author Bradley D. Willard using template from Jessica Masters
 *
 */
@SuppressWarnings("serial")
public class RectangleJPanel extends JPanel {

	private static final int WINDOW_WIDTH = 500;
	private static final int WINDOW_HEIGHT = 500;
	private static final int MAX_WIDTH = 200;
	private static final int MAX_HEIGHT = 200;
	private static final int MIN_WIDTH = 12;
	private static final int MIN_HEIGHT = 12;	
	private static final int SHRINK_FACTOR = 2;//must be at least 2 to work
	private static final int MIDPOINT_X = WINDOW_WIDTH/2;
	private static final int MIDPOINT_Y = WINDOW_HEIGHT/2;
	private static final Color FILL_COLOR = Color.GRAY;
	private static final Color DRAW_COLOR = Color.BLACK;
	
	public RectangleJPanel() {
		super();
		setPreferredSize(new Dimension(WINDOW_WIDTH,WINDOW_HEIGHT));
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
	}
	
	public void paintComponent(Graphics pen) {
		super.paintComponent(pen);
		//First set of coordinates for to draw the first square with
		int initialX = MIDPOINT_X - (MAX_WIDTH/2);
		int initialY = MIDPOINT_Y - (MAX_HEIGHT/2);
		
		//Draw the first square/rectangle...
		pen.setColor(FILL_COLOR);
		pen.fillRect(initialX, initialY, MAX_WIDTH, MAX_HEIGHT);
		pen.setColor(DRAW_COLOR);
		pen.drawRect(initialX, initialY, MAX_WIDTH, MAX_HEIGHT);
		//Then call the helper method which makes rectangles recursively...
		drawSquare(initialX, initialY, MAX_WIDTH, MAX_HEIGHT, pen);
	}
	
	private void drawSquare(int x, int y, int width, int height, Graphics pen) {
		if(width >= MIN_WIDTH && height >= MIN_HEIGHT) {
			int newWidth = width/SHRINK_FACTOR;
			int newHeight = height/SHRINK_FACTOR;
			
			int newXLeftTop = x - (width/(SHRINK_FACTOR * 2));
			int newYLeftTop = y - (width/(SHRINK_FACTOR * 2));
			pen.setColor(FILL_COLOR);
			pen.fillRect(newXLeftTop, newYLeftTop, newWidth, newHeight);
			pen.setColor(DRAW_COLOR);
			pen.drawRect(newXLeftTop, newYLeftTop, newWidth, newHeight);
			
			
			int newXRightTop = newXLeftTop + width;
			int newYRightTop = newYLeftTop;
			pen.setColor(FILL_COLOR);
			pen.fillRect(newXRightTop, newYRightTop, newWidth, newHeight);
			pen.setColor(DRAW_COLOR);
			pen.drawRect(newXRightTop, newYRightTop, newWidth, newHeight);
			
			int newXRightBottom = newXRightTop;
			int newYRightBottom = newYRightTop + height;
			pen.setColor(FILL_COLOR);
			pen.fillRect(newXRightBottom, newYRightBottom, newWidth, newHeight);
			pen.setColor(DRAW_COLOR);
			pen.drawRect(newXRightBottom, newYRightBottom, newWidth, newHeight);
			
			int newXLeftBottom = newXLeftTop;
			int newYLeftBottom = newYLeftTop + height;
			pen.setColor(FILL_COLOR);
			pen.fillRect(newXLeftBottom, newYLeftBottom, newWidth, newHeight);
			pen.setColor(DRAW_COLOR);
			pen.drawRect(newXLeftBottom, newYLeftBottom, newWidth, newHeight);
			
			drawSquare(newXLeftTop, newYLeftTop, newWidth, newHeight, pen);
			drawSquare(newXRightTop, newYRightTop, newWidth, newHeight, pen);
			drawSquare(newXRightBottom, newYRightBottom, newWidth, newHeight, pen);
			drawSquare(newXLeftBottom, newYLeftBottom, newWidth, newHeight, pen);
			
		}
	}
	
	
	public static void main(String[] args) {
		RectangleJPanel panel = new RectangleJPanel();
		JFrame frame = new JFrame("Brad's Recursive Squares");
		frame.getContentPane().add(panel);
		frame.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
}
