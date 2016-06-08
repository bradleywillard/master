package org.bwillard.ccsf.course.cs211s._11_threads;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class CircleFunThreaded extends JFrame {

	private static final int WIDTH = 300, HEIGHT = 300;
	private static final int MAX_DIAMETER = WIDTH / 2;
	private static final int PAUSE = 100; // milliseconds
	private static final int NUM_CIRCLES = 100;

	private JPanel mainPanel;
	private JButton startButton;

	public CircleFunThreaded() {
		setSize(WIDTH+100, HEIGHT+100);
		setTitle("Circle Fun!");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		mainPanel = new JPanel();
		mainPanel.setBackground(Color.WHITE);
		getContentPane().add(mainPanel, BorderLayout.CENTER);
	
		JPanel buttonPanel = new JPanel();
		buttonPanel.setBackground(Color.WHITE);
		startButton = new JButton("Start");
		buttonPanel.add(startButton);
		this.add(buttonPanel, BorderLayout.SOUTH);
		startButton.addActionListener(e -> {
			Thread drawThread = new ThreadDraw();
			drawThread.start();
		});
		
		setVisible(true);
	}

	private class ThreadDraw extends Thread {
		@Override
		public void run() {
			circleFill();
		}
	}
	
	public void circleFill() {
		Graphics pen = mainPanel.getGraphics();
		Random generator = new Random();
		for (int i = 0; i < NUM_CIRCLES; i++) {

			int x = generator.nextInt(WIDTH);
			int y = generator.nextInt(HEIGHT);
			int diameter = generator.nextInt(MAX_DIAMETER);
			pen.drawOval(x, y, diameter, diameter);
			pen.drawString(Integer.toString(i), x+diameter/2, y+diameter/2);
			try {
				Thread.sleep(PAUSE);
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
				System.exit(0);
			}
		}
	}

	public static void main(String[] args) {
		CircleFunThreaded frame = new CircleFunThreaded();
	}

}
