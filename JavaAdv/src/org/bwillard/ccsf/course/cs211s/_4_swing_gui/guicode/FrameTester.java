package org.bwillard.ccsf.course.cs211s._4_swing_gui.guicode;

import java.awt.*;
import javax.swing.*;

public class FrameTester extends JFrame {

	public static final int DEFAULT_WIDTH = 300;
	public static final int DEFAULT_HEIGHT = 300;
	
	private InitialDrawingPanel panel;

	public FrameTester() {
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		setTitle("Boring Window");
		panel = new InitialDrawingPanel();
		Container contentPane = getContentPane();
		contentPane.add(panel);
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(	new Runnable() {
				public void run() {
		FrameTester frame = new FrameTester();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
});}
}
