package org.bwillard.ccsf.course.cs211s._5_mvc_swing_gui.guicode2.guis;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import javax.swing.*;
import java.util.*;

public class RandomCircles extends JPanel {
	
	private Random generator;
	private static final int NUM_CIRCLES = 50;
	
	private static final int DEFAULT_WIDTH = 400;
	private static final int DEFAULT_HEIGHT = 400;
	private static final int DEFAULT_DIAMETER = DEFAULT_WIDTH / 4;

	private JButton redrawButton;
	private JRadioButton bwButton, colorButton;
	private JCheckBox filledBox;
	
	private boolean drawInColor, filled;
	
	RandomCircles() {
		setLayout(new BorderLayout());
		
		drawInColor = false;
		filled = false;
		
		generator = new Random();
		setPreferredSize(new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT));
		
		JPanel buttonPanel = new JPanel();
		redrawButton = new JButton("ReDraw");
		redrawButton.addActionListener(new ButtonListener());
		buttonPanel.add(redrawButton);
		add(buttonPanel, BorderLayout.NORTH);
		
		bwButton = new JRadioButton("Black and White", true);
		bwButton.addActionListener( event -> {
			drawInColor = false;
			repaint();
		});
		
		colorButton = new JRadioButton("Color");
		colorButton.addActionListener(event -> {
			drawInColor = true;
			repaint();
		});
		ButtonGroup group = new ButtonGroup();
		group.add(bwButton);
		group.add(colorButton);
		buttonPanel.add(bwButton);
		buttonPanel.add(colorButton);
		
		filledBox = new JCheckBox("Filled?");
		
		/* two options for the listener- the one commented out below shows one 
		 * listener class in which all the characteristics
		 * are checked when any of the actions happen; the secnod option
		 * currently running in the code has each
		 * source only responds to its own action
		 */
		// filledBox.addActionListener(new ButtonListener());
		// bwButton.addActionListenernew ButtonListener());
		// colorButton.addActionListenernew ButtonListener());
		
	
		filledBox.addActionListener(event -> {
			filled = filledBox.isSelected();
			repaint();
		});
		buttonPanel.add(filledBox);
		
		
		
	}
	
	private class ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			if(bwButton.isSelected()) {
				drawInColor = false;
			}
			if(colorButton.isSelected()) {
				drawInColor = false;
			}
			
			filled = filledBox.isSelected();
			
			repaint();
		}
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		for(int i=0; i<NUM_CIRCLES; i++) {
			
			if(drawInColor) {
				Random generator = new Random();
				Color c = new Color(generator.nextInt(256),
						generator.nextInt(256), generator.nextInt(256));
				g2.setColor(c);
			} else {
				g2.setColor(Color.BLACK);
			}
			
			int x = generator.nextInt(DEFAULT_WIDTH);
			int y = generator.nextInt(DEFAULT_HEIGHT);
			int diameter = generator.nextInt(DEFAULT_DIAMETER);
			Ellipse2D circle = new Ellipse2D.Double(x, y, diameter, diameter);

			if(filled) {
				g2.fill(circle);
			} else {
				g2.draw(circle);
			}
		}
		
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(	new Runnable() {
			public void run() {
				JFrame frame = new JFrame();
				frame.setSize(400, 400);
				frame.setTitle("Random Circles");
				frame.getContentPane().add(new RandomCircles());
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
}
});
	}

}
