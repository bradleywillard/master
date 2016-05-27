package org.bwillard.ccsf.course.cs211s.assn6.code_from_classes;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.Timer;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.util.*;
import java.awt.geom.*;
import java.io.*;

public class ControlPanel extends JPanel {
	
	private JButton raceButton, replayButton, saveButton, loadButton;
	private JLabel winnerLabel;
	private RacePanel racePanel;

	public ControlPanel() {
		setLayout(new GridLayout(2,1));
		
		JPanel buttonPanel = new JPanel();
		raceButton = new JButton("Race!");
		buttonPanel.add(raceButton);
		raceButton.addActionListener(new RaceListener());
		
		replayButton = new JButton("Replay");
		replayButton.setEnabled(false);
		buttonPanel.add(replayButton);
		replayButton.addActionListener(new ReplayListener());
		
		saveButton = new JButton("Save");
		saveButton.setEnabled(false);
		buttonPanel.add(saveButton);
		saveButton.addActionListener(new SaveListener(this));
		
		loadButton = new JButton("Load");
		loadButton.setEnabled(false);
		buttonPanel.add(loadButton);
		loadButton.addActionListener(new LoadListener(this));
		
		add(buttonPanel);
		
		JPanel labelPanel = new JPanel();
		winnerLabel = new JLabel("");
		labelPanel.add(winnerLabel);
		add(labelPanel);
	}
	
	public void setRacePanel(RacePanel racePanel) {
		this.racePanel = racePanel;
	}
		
	public class RaceListener implements ActionListener {
		public void actionPerformed(ActionEvent evt) {
			// ??? your code here!
		}
	}
	public class ReplayListener implements ActionListener {
		public void actionPerformed(ActionEvent evt) {
			// ??? your code here!
		}
	}
	
	public class SaveListener implements ActionListener {
		private ControlPanel cPanel;
		
		/* note that you'll need a copy of the ControlPanel
		 * to use in the chooser.showSaveDialog method invokation,
		 * so I pass it in here
		 */
		public SaveListener(ControlPanel cPanel) {
			this.cPanel = cPanel;
		}
		
		public void actionPerformed(ActionEvent evt) {
			// ??? your code here!
		}
	}
	public class LoadListener implements ActionListener {
		
		private ControlPanel cPanel;
		
		/* note that you'll need a copy of the ControlPanel
		 * to use in the chooser.showOpenDialog method invokation,
		 * so I pass it in here
		 */
		public LoadListener(ControlPanel cPanel) {
			this.cPanel = cPanel;
		}
		public void actionPerformed(ActionEvent evt) {
			// ??? your code here!

		}
	}
}
