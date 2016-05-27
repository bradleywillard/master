package org.bwillard.ccsf.course.cs211s.assn6.code_from_classes;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.Timer;

public class CountDown extends JPanel {

	private JLabel countLabel;
	private JButton pauseButton, resumeButton;
	private int counter;
	private static final int INITIAL_COUNT = 5;
	private static final int DEFAULT_WIDTH = 250, DEFAULT_HEIGHT = 150;
	
	private Timer timer;
	

	public CountDown() {
		counter = INITIAL_COUNT;
		
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(2,1));
		
		JPanel labelPanel = new JPanel();
		countLabel = new JLabel(Integer.toString(counter));
		countLabel.setFont(new Font("Verdana", Font.BOLD, 36));
		labelPanel.add(countLabel);
		panel.add(labelPanel);
		
		JPanel buttonPanel = new JPanel();
		pauseButton = new JButton("Pause");
		pauseButton.addActionListener(event -> {
			timer.stop();
			resumeButton.setEnabled(true);
			pauseButton.setEnabled(false);
		});
		buttonPanel.add(pauseButton);
		
		resumeButton = new JButton("Resume");
		resumeButton.setEnabled(false);
		resumeButton.addActionListener( event -> {
			timer.restart();
			resumeButton.setEnabled(false);
			pauseButton.setEnabled(true);
		});
		buttonPanel.add(resumeButton);
		
		panel.add(buttonPanel);
		
		add(panel);
		
		timer = new Timer(1000, new TimerListener());
		timer.start();
		
				
	}
	
	public class TimerListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			if(counter > 0) {
				counter--;
			} else {
				counter = INITIAL_COUNT;
			}
			countLabel.setText(Integer.toString(counter));
		}
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(	new Runnable() {
			public void run() {
				JFrame frame = new JFrame("Count Down!");
				frame.setLayout(new FlowLayout());
								
				frame.getContentPane().add(new CountDown());
				
				frame.setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
				frame.setVisible(true);
				frame.setResizable(false);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}});

	}

}
