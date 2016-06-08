package org.bwillard.ccsf.course.cs211s._5_mvc_swing_gui.guicode2.guis;

import java.awt.*;
import java.awt.geom.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class MouseTail extends JPanel {
	
	private static final int DEFAULT_WIDTH = 400;
	private static final int DEFAULT_HEIGHT = 400;
	
	private static final int DEFAULT_DIAMETER = 10;
	private static final int NUMBER_OF_POINTS = 20;
	
	private ArrayList<Point2D> pointList;
	
	public MouseTail() {
		pointList = new ArrayList<Point2D>();
		this.addMouseMotionListener(new MouseTailListener());
	}
	
	public class MouseTailListener implements MouseMotionListener {

		@Override
		public void mouseDragged(MouseEvent arg0) {
		}

		@Override
		public void mouseMoved(MouseEvent event) {
			Point2D point = event.getPoint();
			pointList.add(0, point);
			repaint();
		}
		
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2  = (Graphics2D) g;
		for(int i=0; i<NUMBER_OF_POINTS && i<pointList.size(); i++) {
			Point2D point = pointList.get(i);
			Ellipse2D circle = new Ellipse2D.Double(point.getX(),
					point.getY(), DEFAULT_DIAMETER, DEFAULT_DIAMETER);
			g2.draw(circle);
		}
	}
	
	public static void main(String[] args) {

	EventQueue.invokeLater(	new Runnable() {
		public void run() {
			JFrame frame = new JFrame();
			frame.setSize(DEFAULT_WIDTH,DEFAULT_HEIGHT);
			frame.setTitle("Mouse Tail");
			frame.getContentPane().add(new MouseTail());
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setVisible(true);
		}});
	}
}

