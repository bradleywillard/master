package org.bwillard.ccsf.course.cs211s._5_mvc_swing_gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.bwillard.ccsf.course.cs211s._4_swing_gui.CircleSquareDrawer;

public class MouseTail extends JPanel {
	
	private static final int NUM_POINTS = 20;
	private List<Point2D> pointList;
	
	public MouseTail() {
		pointList = new LinkedList<Point2D>();
		this.addMouseMotionListener(new MouseTailListener());
	}
	
	private class MouseTailListener implements MouseMotionListener {

		@Override
		public void mouseDragged(MouseEvent e) {}

		@Override
		public void mouseMoved(MouseEvent e) {
			Point2D point = e.getPoint();
			pointList.add(0,point);
			repaint();
		}
		
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g;
		for(int i = 0; i < NUM_POINTS && i < pointList.size(); i++) {
			Point2D point = pointList.get(i);
			Ellipse2D circle = new Ellipse2D.Double(point.getX(), point.getY(), 3, 20);
			g2.draw(circle);
		}
	}
	
	public static void main(String[] args) {
		MouseTail panel = new MouseTail();
		panel.setBackground(Color.ORANGE);
		JFrame frame = new JFrame(panel.getClass().getSimpleName());
		frame.getContentPane().add(panel);
		frame.setSize(400, 400);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
