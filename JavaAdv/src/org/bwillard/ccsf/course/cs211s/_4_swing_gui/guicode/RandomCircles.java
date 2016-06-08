package org.bwillard.ccsf.course.cs211s._4_swing_gui.guicode;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;

import javax.swing.*;

import org.bwillard.ccsf.course.cs211s._4_swing_gui.CircleSquareDrawer;

import java.util.Random;


@SuppressWarnings("serial")
public class RandomCircles extends JPanel {
	
	private Random generator;
	private static final int NUM_CIRCLES = 50;
	
	private static final int DEFAULT_WIDTH = 400;
	private static final int DEFAULT_HEIGHT = 400;
	private static final int DEFAULT_DIAMETER = DEFAULT_WIDTH / 4;

	private JButton redrawButton;
	
	RandomCircles() {
		generator = new Random();
		setPreferredSize(new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT));
		
		redrawButton = new JButton("ReDraw");
		redrawButton.addActionListener(new ButtonListener());
		add(redrawButton);
		
	}
	
	
	private class ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			repaint();
		}
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		for(int i = 0; i < NUM_CIRCLES; i++) {
			int x = generator.nextInt(DEFAULT_WIDTH);
			int y = generator.nextInt(DEFAULT_HEIGHT);
			int diameter = generator.nextInt(DEFAULT_DIAMETER);
			Ellipse2D circle = new Ellipse2D.Double(x, y, diameter, diameter);
			g2.draw(circle);
		}
		
	}
	
	public static void main(String[] args) {
		CircleSquareDrawer panel = new CircleSquareDrawer();
		panel.setBackground(Color.ORANGE);
		JFrame frame = new JFrame(panel.getClass().getSimpleName());
		frame.getContentPane().add(panel);
		frame.setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
