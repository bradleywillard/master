package org.bwillard.ccsf.course.cs211s.assn4;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class CircleSquareDrawer extends JPanel {
	
	private static final int INITIAL_Y = 50;
	private static final int INITIAL_X = 100;
	/**
	 * Static data
	 */
	private static int counter = 0;
	private static final int DEFAULT_WIDTH = 600;
	private static final int DEFAULT_HEIGHT = 600;
	private static final int DEFAULT_SIZE = 100;
	
	/**
	 * Instance data
	 */
	private JButton redrawButton;
	private JTextField sizeField;
	private String buttonText = "Draw Square";
	private int size;
	
	/**
	 * Constructor
	 */
	public CircleSquareDrawer() {
		setPreferredSize(new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT));
		
		redrawButton = new JButton(buttonText);
		redrawButton.addActionListener(new ButtonListener());
		add(redrawButton);
		
		addSizeInput();
	}
	
	private void addSizeInput() {
		JLabel label = new JLabel("Enter a size:");
		add(label);
		sizeField = new JTextField(10);
		sizeField.addActionListener(new InputListener());
		add(sizeField);
	}
	
	/**
	 * InputListener for input fields like numInput
	 */
	public class InputListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			String userInput = sizeField.getText();
			sizeField.setText("");
			try{
				size = Integer.parseInt(userInput);
			} catch(NumberFormatException e) {
				System.out.println(e.getStackTrace());
			}
		}
		
	}
	
	/**
	 * ButtonListener inner class
	 *
	 */
	private class ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			repaint();
			counter++;
		}
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		buttonText = counter % 2 == 0 ? "Draw Square" : "Draw Circle";
		size = sizeTheShape();
		redrawButton.setText(buttonText);
		Graphics2D g2 = (Graphics2D) g;
		if(counter % 2 == 0) {
			Ellipse2D circle = new Ellipse2D.Double(INITIAL_X, INITIAL_Y, size, size);
			g2.draw(circle);
			g2.setColor(Color.GREEN);
			g2.fillOval(INITIAL_X + 1, INITIAL_Y + 1, size - 2, size - 2);
		} else {
			Rectangle2D rect = new Rectangle2D.Double(INITIAL_X, INITIAL_Y, size, size);
			g2.draw(rect);
			g2.setColor(Color.RED);
			g2.fillRect(INITIAL_X + 1, INITIAL_Y + 1, size - 1, size - 1);
		}
	}

	/**
	 * Helper method to get the desired size from user input
	 * @return
	 */
	private int sizeTheShape() {
		String sizeStr = sizeField.getText();
		try{
			return "".equals(sizeStr) ? 100 : Integer.parseInt(sizeStr);
		} catch(NumberFormatException e) {
			e.printStackTrace();
			return DEFAULT_SIZE;
		}
	}
	/**
	 * Executor main method
	 * @param args
	 */
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
