package org.bwillard.ccsf.course.cs211s._9_lambdas;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import javax.swing.*;

public class GraphingPanel extends JPanel { 
	
	private Point2D point1, point2;
	private final static int DIAMETER = 10;
	private final Color COLOR = Color.BLUE;
	
	private GraphingControls controlPanel;

	public GraphingPanel (GraphingControls controlPanel) {
		setBackground(Color.white);
		this.addMouseListener(new MouseClickListener());
		this.controlPanel = controlPanel;
	}
	
	@Override
	public void paintComponent(Graphics pen) {
		super.paintComponent(pen);
		Graphics2D g = (Graphics2D) pen;
		g.setColor(COLOR);
		if(point1!=null) {
			g.fill(new Ellipse2D.Double(point1.getX()-DIAMETER/2, point1.getY()-DIAMETER/2, DIAMETER, DIAMETER));
		}
		if(point2!=null) {
			g.fill(new Ellipse2D.Double(point2.getX()-DIAMETER/2, point2.getY()-DIAMETER/2, DIAMETER, DIAMETER));
		}
		if(point1!=null && point2!=null) {
			g.drawLine((int)point1.getX(), (int)point1.getY(), (int)point2.getX(), (int)point2.getY());
		}
	}
	
	private class MouseClickListener extends MouseAdapter {
		public void mouseClicked(MouseEvent ev) {
			if(point1==null) {
				point1 = ev.getPoint();
			} else if(point2==null) {
				point2 = ev.getPoint();
			} else {
				point1 = ev.getPoint();
				point2 = null;
			}
			controlPanel.updatePoints(point1, point2);
			repaint();		
		}
	}

	public static void main(String args[]) {
	
			   EventQueue.invokeLater(new Runnable() {
				public void run() {
					JFrame frame = new JFrame("Line Characteristics");
					frame.setSize(400,400);
					frame.setResizable(false);
					GraphingControls controlPanel = new GraphingControls();
					GraphingPanel graphingPanel = new GraphingPanel(controlPanel);
					frame.getContentPane().add(BorderLayout.CENTER, graphingPanel);
					frame.getContentPane().add(BorderLayout.SOUTH, controlPanel);
					frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					frame.setVisible(true);
				}
			   });
	}
}