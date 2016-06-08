package org.bwillard.ccsf.course.cs211s.assn6.code_from_classes;


import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import javax.swing.*;
import java.util.*;

public class RandomCircles extends JPanel {

	private Random generator;
	
	private static final int DEFAULT_WIDTH = 500;
	private static final int DEFAULT_HEIGHT = 500;
	private static final int DEFAULT_DIAMETER = DEFAULT_WIDTH / 4;

	private JButton redrawButton;
	private JRadioButton bwButton, colorButton;
	private JCheckBox filledBox;

	private boolean drawInColor, filled;

	private Color singleColor;
	private int numCircles;

	RandomCircles(int numCircles) {
		setLayout(new BorderLayout());

		drawInColor = false;
		filled = false;
		singleColor = Color.BLACK;
		this.numCircles = numCircles;
		
		generator = new Random();
		setPreferredSize(new Dimension((int)(DEFAULT_WIDTH*.75), (int)(DEFAULT_HEIGHT*.75)));
		setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		JPanel buttonPanel = new JPanel();
		redrawButton = new JButton("ReDraw");
		redrawButton.addActionListener(event -> {
			repaint();
		});
		buttonPanel.add(redrawButton);
		add(buttonPanel, BorderLayout.NORTH);

		bwButton = new JRadioButton("Black and White", true);
		bwButton.addActionListener(event -> {
			Color color = JColorChooser.showDialog(this, "Pick a Circle Color", Color.BLACK);
			singleColor = color;
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

		filledBox.addActionListener(event -> {
			filled = filledBox.isSelected();
			repaint();
		});
		buttonPanel.add(filledBox);

	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		for (int i = 0; i < numCircles; i++) {
			if (drawInColor) {
				Random generator = new Random();
				Color c = new Color(generator.nextInt(256), generator.nextInt(256), generator.nextInt(256));
				g2.setColor(c);
			} else {
				g2.setColor(singleColor);
			}

			int x = generator.nextInt(DEFAULT_WIDTH);
			int y = generator.nextInt(DEFAULT_HEIGHT);
			int diameter = generator.nextInt(DEFAULT_DIAMETER);
			Ellipse2D circle = new Ellipse2D.Double(x, y, diameter, diameter);

			if (filled) {
				g2.fill(circle);
			} else {
				g2.draw(circle);
			}
		}

	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
			
				JFrame frame = new JFrame();
				frame.setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
				frame.setTitle("Random Circles");
				String userInput = JOptionPane.showInputDialog("How many circles?");
				int numC = Integer.parseInt(userInput);
				frame.getContentPane().add(new RandomCircles(numC));
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
		});
	}

}
