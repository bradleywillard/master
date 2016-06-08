package org.bwillard.ccsf.course.cs211s._6_serialization.code_from_classes;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import javax.swing.*;
import javax.swing.Timer;
import java.util.*;

public class Rebound extends JPanel {
	
	private static final int DEFAULT_WIDTH = 300, DEFAULT_HEIGHT = 400;

	private Point2D movingPoint;
	private int height, width;
	private int movingDistanceX, movingDistanceY;
	private int pointDiameter;
	private Timer timer;
	private int speed;

	public Rebound() {
		setBackground(Color.pink);
		height = DEFAULT_HEIGHT;
		width = DEFAULT_WIDTH;
		setPreferredSize(new Dimension(width, height));
		setBorder(BorderFactory.createLineBorder(Color.BLUE));

		Random generator = new Random();
		int initialX = generator.nextInt(width);
		int initialY = generator.nextInt(height);
		movingPoint = new Point(initialX, initialY);
		movingDistanceX = 1;
		movingDistanceY = 1;
		pointDiameter = 10;

		speed = 30;
		timer = new Timer(speed, new TimerListener());
		timer.start();

	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;

		g2.setColor(Color.blue);
		g2.fillOval((int)movingPoint.getX(), (int)movingPoint.getY(), pointDiameter, pointDiameter);
	}


	private class TimerListener implements ActionListener {
		public void actionPerformed(ActionEvent ev) {
			double currentX = movingPoint.getX();
			double currentY = movingPoint.getY();
			if((currentX+pointDiameter) > width || currentX < 0) {
				movingDistanceX = movingDistanceX*-1;
			}
			if((currentY+pointDiameter) > height || currentY < 0) {
				movingDistanceY *= -1;
			}
			movingPoint.setLocation(currentX+movingDistanceX, currentY+movingDistanceY);
			
			repaint();
		}
	}

	public static void main(String[] args) {
	
		EventQueue.invokeLater(	new Runnable() {
			public void run() {
				JFrame frame = new JFrame("Rebound");
				frame.setLayout(new FlowLayout());							
				frame.getContentPane().add(new Rebound());			
				frame.setSize(DEFAULT_WIDTH+50, DEFAULT_HEIGHT+50);
				frame.setVisible(true);
				frame.setResizable(false);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}});
	}
}
