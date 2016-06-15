package org.bwillard.ccsf.course.cs211s._9_lambdas;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import static org.bwillard.ccsf.course.cs211s._9_lambdas.LineCharacteristic.LineChar;

import java.awt.geom.*;
import java.util.Random;

/**
 * Class that illustrates using Lambdas with Swing GUI, ActionListeners, etc..
 * 		It requires two mouse clicks from the user in the window pane, representing
 * 		two points painted on the screen.  The user may then click on any or all of the
 * 		3 buttons to:
 * 			1) get the distance between the two points
 * 			2) get the midpoint   "      "   "    "
 * 			3) check whether the line between the two points is perfectly vertical or horizontal
 * @author bradleywillard
 *
 */
public class GraphingControls extends JPanel { 

	/**
	 * Class vars
	 */
	private static final long serialVersionUID = 4387512542429408479L;
	private static final String ERR_MSG = "Please click inside the pane to create two points";
	
	/**
	 * Instance data
	 */
	private JLabel coordinateLabel, distanceLabel, midpointLabel, vertHorizLabel;
	private JButton distanceButton, midpointButton, vertHorizButton;
	private Point2D point1, point2;
	private Color color;

	/**
	 * Constructor
	 */
	public GraphingControls () {

		setLayout(new GridLayout(4,1));
		color = Color.CYAN;
		
		JPanel labelPanel = new JPanel();
		labelPanel.setBackground(color);
		coordinateLabel = new JLabel(" ");
		labelPanel.add(coordinateLabel);
		add(labelPanel);
		
		JPanel distancePanel = new JPanel();
		distancePanel.setBackground(color);
		distancePanel.setLayout(new GridLayout(1,2));
		distanceButton = new JButton("Find Distance");
		distanceLabel = new JLabel("");
		distancePanel.add(distanceButton);
		distancePanel.add(distanceLabel);
		// ButtonListener for meausuring the distance between the two points
		distanceButton.addActionListener(e -> {
			String ch = LineChar.DISTANCE.getCharacteristic();
			LineCharacteristic lc = LineCharacteristicFactory.createLineCharacteristic(ch);
			if(point1 == null || point2 == null) {
				JOptionPane.showMessageDialog(null, ERR_MSG, "ERROR", JOptionPane.ERROR_MESSAGE);
			} else {
				distanceLabel.setText(lc.lineCharacteristic(point1, point2));
			}
		});
		add(distancePanel);
		
		
		JPanel midPointPanel = new JPanel();
		midPointPanel.setBackground(color);
		midPointPanel.setLayout(new GridLayout(1,2));
		midpointButton = new JButton("Find Midpoint");
		midpointLabel = new JLabel("");
		midPointPanel.add(midpointButton);
		midPointPanel.add(midpointLabel);
		// ButtonListener for measuring the midpoint
		midpointButton.addActionListener(e -> {
			String ch = LineChar.MIDPOINT.getCharacteristic();
			LineCharacteristic lc = LineCharacteristicFactory.createLineCharacteristic(ch);
			if(point1 == null || point2 == null) {
				JOptionPane.showMessageDialog(null, ERR_MSG, "ERROR", JOptionPane.ERROR_MESSAGE);
			} else {
				midpointLabel.setText(lc.lineCharacteristic(point1, point2));
			}
		});
		add(midPointPanel);
		
		JPanel vertHorizPanel = new JPanel();
		vertHorizPanel.setBackground(color);
		vertHorizPanel.setLayout(new GridLayout(1,2));
		vertHorizButton = new JButton("Vertical/Horizontal");
		vertHorizLabel = new JLabel("");
		vertHorizPanel.add(vertHorizButton);
		vertHorizPanel.add(vertHorizLabel);
		//ButtonListener for checking if the line is vertical or horizontal
		vertHorizButton.addActionListener(e -> {
			String ch = LineChar.VERT_HORT.getCharacteristic();
			LineCharacteristic lc = LineCharacteristicFactory.createLineCharacteristic(ch);
			if(point1 == null || point2 == null) {
				JOptionPane.showMessageDialog(null, ERR_MSG, "ERROR", JOptionPane.ERROR_MESSAGE);
			} else {
				vertHorizLabel.setText(lc.lineCharacteristic(point1, point2));
			}
		});
		add(vertHorizPanel);
	
	}

	
	public void updatePoints(Point2D point1, Point2D point2) {
		this.point1 = point1;
		this.point2 = point2;
		updateLabels();
	}


	private void updateLabels() {
		if(point1!=null && point2!=null) {
			coordinateLabel.setText("("+((int)point1.getX())+", " 
				+ ((int)point1.getY())+") and " 
				+ "("+((int)point2.getX())+", " 
				+ ((int)point2.getY())+") "
				);
		} else {
			coordinateLabel.setText("");
		}
		distanceLabel.setText("");
		midpointLabel.setText("");
		vertHorizLabel.setText("");
	}

	
}