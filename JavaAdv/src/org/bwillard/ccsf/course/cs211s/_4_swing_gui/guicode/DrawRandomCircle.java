package org.bwillard.ccsf.course.cs211s._4_swing_gui.guicode;

import java.awt.*;
import java.awt.geom.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class DrawRandomCircle extends JPanel{
	
	private static final int DEFAULT_WIDTH = 400;
	private static final int DEFAULT_HEIGHT = 400;
	private static final int MAX_DIAMETER = DEFAULT_WIDTH / 4;
	
	private ArrayList<Ellipse2D> circleList;
	private Random generator;

	public DrawRandomCircle() {
		setPreferredSize(new Dimension(DEFAULT_WIDTH,DEFAULT_HEIGHT));
		circleList = new ArrayList<Ellipse2D>();
		generator = new Random();
		
		// add a listener to the panel itself
		this.addMouseListener(new ClickListener());
		
	}
	
	private class ClickListener extends MouseAdapter {
	
		@Override
		public void mouseClicked(MouseEvent event) {
			Point2D point = event.getPoint();
			int randomDiameter = generator.nextInt(MAX_DIAMETER);
			Ellipse2D circle = new Ellipse2D.Double(point.getX(),
					point.getY(), randomDiameter, randomDiameter);
			circleList.add(circle);
			repaint();
		}
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		for(Ellipse2D circle : circleList) {
			g2.draw(circle);
		}
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(	new Runnable() {
			public void run() {
				JFrame frame = new JFrame();
				frame.setSize(DEFAULT_WIDTH,DEFAULT_HEIGHT);
				frame.setTitle("Name Sorter");
				frame.getContentPane().add(new DrawRandomCircle());
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}});
		}
}
