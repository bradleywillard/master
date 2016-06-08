package org.bwillard.ccsf.course.cs211s.assn4;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;


@SuppressWarnings("serial")
public class MouseClickCounter extends JPanel{

	/**
	 * Static class data
	 */
	private static final int FONT_SIZE = 100;
	private static final int DEFAULT_WIDTH = 250;
	private static final int DEFAULT_HEIGHT = 250;
	
	private static int numClicks = 0;
	
	private static Color[] colArr = {
		Color.BLUE, Color.RED, Color.GREEN, Color.WHITE, Color.BLACK,
		Color.PINK, Color.CYAN, Color.DARK_GRAY, Color.MAGENTA, 
		Color.ORANGE, Color.YELLOW, Color.GRAY, Color.LIGHT_GRAY
	};
	
	/**
	 * Instance variables
	 */
	private JButton redrawButton;
	private JTextArea numClicksOutput;
	
	/**
	 * Constructor
	 */
	public MouseClickCounter() {
		setPreferredSize(new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT));
		redrawButton = new JButton("Redraw");
		redrawButton.addActionListener(new ButtonListener());
		add(redrawButton);
		
		numClicksOutput = new JTextArea(2, 3);
		Font font = new Font(Font.SERIF, Font.BOLD, FONT_SIZE);
		numClicksOutput.setFont(font);
		numClicksOutput.setEditable(false);
		numClicksOutput.append(numClicks+"");
		add(numClicksOutput);
		
	}
	
	/**
	 * ButtonListener
	 */
	private class ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			numClicks++;
			Random rand = new Random();
			int next = rand.nextInt(colArr.length);
			Color color = colArr[next];
			setBackground(color);
			boolean isDark = 
					Color.BLACK == color || 
					Color.DARK_GRAY == color || 
					Color.BLUE == color || 
					Color.GRAY == color;
			if(isDark) {
				numClicksOutput.setForeground(Color.WHITE);
			} else {
				numClicksOutput.setForeground(Color.BLACK);
			}
			numClicksOutput.setText("");
			numClicksOutput.setBackground(color);
			numClicksOutput.append(numClicks+"");
		}
	}
	
	/**
	 * Execute main method
	 * @param args
	 */
	public static void main(String[] args) {
		MouseClickCounter panel = new MouseClickCounter();
		panel.setBackground(Color.WHITE);
		JFrame frame = new JFrame(panel.getClass().getSimpleName());
		frame.getContentPane().add(panel);
		frame.setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
