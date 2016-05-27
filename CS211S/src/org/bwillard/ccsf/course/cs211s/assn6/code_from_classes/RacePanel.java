package org.bwillard.ccsf.course.cs211s.assn6.code_from_classes;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.Timer;
import javax.swing.border.EtchedBorder;

import java.util.*;
import java.awt.geom.*;

public class RacePanel extends JPanel {
	
	private final static int DEFAULT_WIDTH = 350, DEFAULT_HEIGHT = 300;
	private final static int FAST = 25, SLOW = 100;
	private final static int NUM_CARS = 4;

	private ArrayList<Car> carList;
	private ArrayList<ImageIcon> imageList;
	private ArrayList<String> nameList;
	private int height, width;
	private Timer timer;
	private int speed;
	private ControlPanel controlPanel;

	public RacePanel() {
		setBackground(Color.white);
		width = DEFAULT_WIDTH;
		height = DEFAULT_HEIGHT;
		setPreferredSize(new Dimension(width, height));
		
		this.setBorder(BorderFactory.createLineBorder(Color.BLACK));

		imageList = new ArrayList<ImageIcon>();
		imageList.add(new ImageIcon("car1.png"));
		imageList.add(new ImageIcon("car2.png"));
		imageList.add(new ImageIcon("car3.png"));
		imageList.add(new ImageIcon("car4.png"));
		
		nameList = new ArrayList<String>();
		nameList.add("Bus");
		nameList.add("Firetruck");
		nameList.add("Train");
		nameList.add("Tow Truck");
		
		timer = new Timer(speed, new TimerListener());
		timer.start();
	}
	
	
	
	public void startRace() {
		carList = new ArrayList<Car>();
		for(int i=0; i< NUM_CARS; i++) {
			Point2D p = new Point(0, 20+((int)(height/(NUM_CARS*1.0)*i)));
			carList.add(new Car(p, imageList.get(i), nameList.get(i)));
		}
		// ??? you might have more code that goes here!
		repaint();
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		
		g2.setColor(Color.blue);
		for(Car car : carList) {
			Point2D p = car.getLocation();
			g2.drawImage(car.getImage().getImage(), (int) p.getX(), (int) p.getY(), this);
		}
	}

	private class TimerListener implements ActionListener {
		public void actionPerformed(ActionEvent ev) {
			// ??? your code here!
			// what happens when the timer fires?
			// you might have different kinds of action- some when the
			// race is running and some when there is a winner
			repaint();
		}
	}

	public void setControlPanel(ControlPanel controlPanel) {
		this.controlPanel = controlPanel;
	}
	/*
	 * note that in my serialization, this is what I serialized- the carList
	 * you can choose to serialize this or another object that enapsulates the race
	 */
	public ArrayList<Car> getCarList() {
		return carList;
	}
	public void setCarList(ArrayList<Car> carList) {
		this.carList = carList;
	}
}
