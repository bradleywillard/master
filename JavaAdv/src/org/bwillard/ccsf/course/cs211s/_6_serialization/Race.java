package org.bwillard.ccsf.course.cs211s._6_serialization;

import java.awt.*;
import javax.swing.*;

/**
 * Class that loads the applet.  Main program runner.
 * 		If in eclipse, right click, Run
 * 		If from command line, type java Race
 * 
 * @author bradleywillard
 *
 */
public class Race {

		public static void main(String[] args) {
		
			EventQueue.invokeLater(	new Runnable() {
				public void run() {
					JFrame frame = new JFrame("RaceTrack");
					ControlPanel controlPanel = new ControlPanel();
					RacePanel racePanel = new RacePanel();
					controlPanel.setRacePanel(racePanel);
					racePanel.setControlPanel(controlPanel);
					frame.getContentPane().add(racePanel, BorderLayout.NORTH);
					frame.getContentPane().add(controlPanel,  BorderLayout.SOUTH);
					frame.setSize(500, 420);
					frame.setVisible(true);
					frame.setResizable(false);
					frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					
					
				}});
		}



}
