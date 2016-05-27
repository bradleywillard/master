package org.bwillard.ccsf.course.cs211s.assn4;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class SwingingJFrame extends JFrame {
	private static final int DEFAULT_WIDTH = 400;
	private static final int DEFAULT_HEIGHT = 400;
	
	public SwingingJFrame() {
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
	}
	

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				SwingingJFrame panel = new SwingingJFrame();
				panel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				panel.setVisible(true);
			}
		});
	}
}
