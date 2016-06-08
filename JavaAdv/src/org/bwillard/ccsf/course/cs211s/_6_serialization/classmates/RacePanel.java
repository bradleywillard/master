package org.bwillard.ccsf.course.cs211s._6_serialization.classmates;

// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   RacePanel.java

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Point2D;
import java.io.PrintStream;
import java.util.*;
import javax.swing.*;

public class RacePanel extends JPanel {
	private class TimerListener implements ActionListener {

		public void actionPerformed(ActionEvent ev) {
			for (int i = 0; i < 8; i++) {
				Car car = (Car) carList.get(i);
				Point2D p = car.getLocation();
				if (p.getX() < (double) (750 - carWidth / 2)) {
					p.setLocation(p.getX() + (double) car.getSpeed(), p.getY());
					car.setLocation(p);
				} else {
					hasFinished[i] = true;
					if (winnerIndex == -1) {
						winnerIndex = i;
						winnerName = car.getName();
					}
				}
			}

			repaint();
			if (checkAllCarsFinishLine())
				timer.stop();
		}

		final RacePanel this$0;

		private TimerListener() {
			this$0 = RacePanel.this;
			super();
		}

		TimerListener(TimerListener timerlistener) {
			this();
		}
	}

	public RacePanel() {
		slowMotionFactor = 1;
		width = 750;
		height = 600;
		setBackground(Color.GRAY);
		setPreferredSize(new Dimension(width, height));
		setBorder(BorderFactory.createLineBorder(Color.BLACK));
		imageList = new ArrayList();
		imageList.add(new ImageIcon("car0.png"));
		imageList.add(new ImageIcon("car1.png"));
		imageList.add(new ImageIcon("car2.png"));
		imageList.add(new ImageIcon("car3.png"));
		imageList.add(new ImageIcon("car4.png"));
		imageList.add(new ImageIcon("car5.png"));
		imageList.add(new ImageIcon("car6.png"));
		imageList.add(new ImageIcon("car7.png"));
		nameList = new ArrayList();
		nameList.add("BLACK");
		nameList.add("BLUE");
		nameList.add("GREEN");
		nameList.add("CYAN");
		nameList.add("RED");
		nameList.add("MAGENTA");
		nameList.add("YELLOW");
		nameList.add("WHITE");
		carWidth = ((ImageIcon) imageList.get(0)).getIconWidth();
		setRace(true);
	}

	public void startRace() {
		setRace(true);
		timer = new Timer(5, new TimerListener(null));
		timer.start();
		printAllCarSpeed(carList);
	}

	public void replayRace() {
		setRace(false);
		timer = new Timer(slowMotionFactor * 5, new TimerListener(null));
		timer.start();
	}

	private void setRace(boolean isNewRace) {
		hasFinished = new boolean[8];
		winnerIndex = -1;
		winnerName = "";
		for (int i = 0; i < 8; i++)
			hasFinished[i] = false;

		if (isNewRace) {
			carList = new ArrayList();
			for (int i = 0; i < 8; i++) {
				Point2D p = new Point(0,
						20 + (int) (((double) height / 8D) * (double) i));
				carList.add(new Car(p, (ImageIcon) imageList.get(i),
						(String) nameList.get(i)));
			}

			setCarSpeed(carList, 4, carList.size() * 10);
		} else {
			for (int i = 0; i < 8; i++) {
				Point2D p = new Point(0,
						20 + (int) (((double) height / 8D) * (double) i));
				((Car) carList.get(i)).setLocation(p);
			}

		}
	}

	public int getWinnerIndex() {
		return winnerIndex;
	}

	public String getWinnerName() {
		return winnerName;
	}

	public boolean checkAllCarsFinishLine() {
		boolean aflag[];
		int j = (aflag = hasFinished).length;
		for (int i = 0; i < j; i++) {
			boolean b = aflag[i];
			if (!b)
				return false;
		}

		return true;
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		Car car;
		Point2D p;
		for (Iterator iterator = carList.iterator(); iterator.hasNext(); g2
				.drawImage(car.getImage().getImage(), (int) p.getX(),
						(int) p.getY(), this)) {
			car = (Car) iterator.next();
			p = car.getLocation();
		}

	}

	public ArrayList getCarList() {
		return carList;
	}

	public void setCarList(ArrayList carList) {
		this.carList = carList;
		printAllCarSpeed(carList);
	}

	private void setCarSpeed(ArrayList carList, int minCarSpeed, int numShuffle) {
		int numCars = carList.size();
		int carSpeedList[] = new int[numCars];
		Random random = new Random();
		for (int i = 0; i < numCars; i++)
			carSpeedList[i] = i + minCarSpeed;

		for (int i = 0; i < numShuffle; i++) {
			int shuffleIndex = i % numCars;
			int swapIndex = random.nextInt(numCars);
			int tempValueHolder = carSpeedList[shuffleIndex];
			carSpeedList[shuffleIndex] = carSpeedList[swapIndex];
			carSpeedList[swapIndex] = tempValueHolder;
		}

		for (int i = 0; i < numCars; i++)
			((Car) carList.get(i)).setSpeed(carSpeedList[i]);

	}

	private void printAllCarSpeed(ArrayList carList) {
		Car car;
		for (Iterator iterator = carList.iterator(); iterator.hasNext(); System.out
				.println(car.toString()))
			car = (Car) iterator.next();

	}

	public void setSlowMotionFactor(int newSlowMotionFactor) {
		if (newSlowMotionFactor == 0)
			slowMotionFactor = 1;
		else
			slowMotionFactor = newSlowMotionFactor;
	}

	private static final long serialVersionUID = 0L;
	private static final int DEFAULT_WIDTH = 750;
	private static final int DEFAULT_HEIGHT = 600;
	private static final int MIN_CAR_SPEED = 4;
	private static final int NUM_CARS = 8;
	private static final int TIME_BETWEEN_REP = 5;
	private ArrayList carList;
	private ArrayList imageList;
	private ArrayList nameList;
	private int slowMotionFactor;
	private int height;
	private int width;
	private int carWidth;
	private Timer timer;
	private boolean hasFinished[];
	private int winnerIndex;
	private String winnerName;

}
