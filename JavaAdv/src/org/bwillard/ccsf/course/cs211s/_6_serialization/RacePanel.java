package org.bwillard.ccsf.course.cs211s._6_serialization;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;

import javax.swing.*;

import java.util.List;
import java.util.ArrayList;
import java.util.Random;

/**
 * This file represents a race panel, where n number of cars will race at random speeds each time
 * a new race is started.  Each race creates a serialized file containing the race speeds for each
 * car which can be reloaded and reran.
 * 
 * @author bradleywillard
 *
 */
public class RacePanel extends JPanel {
	
	/**
	 * Class vars
	 */
	private static final long serialVersionUID = 1L;
	private final static int DEFAULT_WIDTH = 450, DEFAULT_HEIGHT = 300;
	private final static int NUM_CARS = 4, MAX_INCREMENT = 10, TIMER_DELAY = 10, OFFSET = 3;
	public static final String FILE_PATH = "src/org/bwillard/ccsf/course/cs211s/_6_serialization/";
	
	/**
	 * Instance data
	 */
	private List<Car> carList;
	private Car winner;
	private Timer timer;
	private ControlPanel controlPanel;
	private int trackHeight, trackWidth, carLength;
	private boolean allDone;
	private int initX, initY; 


	/**
	 * Constructor
	 */
	public RacePanel() {
		setBackground(Color.WHITE);
		
		trackWidth = DEFAULT_WIDTH; 
		trackHeight = DEFAULT_HEIGHT;
		
		initX = OFFSET;
		initY = (trackHeight / (NUM_CARS * 1));
		
		setPreferredSize(new Dimension(trackWidth, trackHeight));
		setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		timer = new Timer(TIMER_DELAY, new TimerListener());
		
		allDone = false;
		
		buildCars();
				
	}
	
	/**
	 * Build Cars
	 */
	void buildCars() {
		carList = new ArrayList<Car>();
		List<String> nameList = new ArrayList<String>();
		nameList.add("Bus");
		nameList.add("Firetruck");
		nameList.add("Train");
		nameList.add("Tow Truck");
		
		for(int i = 0; i < NUM_CARS; i++) {
			Point2D p = new Point(initX, 20 + (initY * i));
			String pathToFile = FILE_PATH + "car" + (i + 1) + ".png";
			Random random = new Random();
			int movingDistance = random.nextInt(MAX_INCREMENT) + 1;
			ImageIcon image = new ImageIcon(pathToFile);
			Car car = new Car.CarBuilder(p, image, nameList.get(i))
				.movingDistance(movingDistance)
				.build();
			carList.add(car);
		}
	}
	
	/**
	 * Start Race
	 */
	public void startRace(boolean replay) {
		if(replay) 
			timer.restart();
		else {
			allDone = false;
			buildCars();
			timer.start();
			
		}
	}
	
	/**
	 * Replay Race
	 */
	public void replayRace() {
		allDone = false;
		for(Car car : carList) {
			car.setFinished(false);
			int i = carList.indexOf(car);
			int x = initX, y = 20 + (initY * i);
			Point2D p = new Point(x, y);
			car.setLocation(p);
			repaint();
		}
		startRace(true);
	}
	
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(Color.BLUE);		
		
		for(Car car : carList) {
			Point2D p = car.getLocation();
			g2.drawImage(car.getImage().getImage(), (int) p.getX(), (int) p.getY(), this);
		}
		g2.setColor(Color.BLACK);
	}

	/**
	 * TimerListener
	 *     ActionListener
	 */
	private class TimerListener implements ActionListener {
		public void actionPerformed(ActionEvent ev) {
			for(Car car : carList) {
				Point2D p = car.getLocation();
				double currentX = p.getX();
				double currentY = p.getY();
				carLength = car.getImage().getIconWidth();
				if(currentX + (carLength/4) <  trackWidth) {
					currentX += car.getMovingDistance();
					p.setLocation(currentX, currentY);
				} else {
					car.setFinished(true);
				}
				repaint();
			}
			allDone = true;
			for(Car car : carList) {
				if(!car.isFinished()) {
					allDone = false;
					break;
				} 
			}
			if(allDone) {
				timer.stop();
				determineWinner();
				displayWinner();
				controlPanel.getSaveButton().setEnabled(true);
			}
		}

		/**
		 * Determine Winner
		 */
		private void determineWinner() {
			int maxDistance = 0;
			for(Car car : carList) {
				if(car.getMovingDistance() > maxDistance) {
					maxDistance = car.getMovingDistance();
					winner = car;
				}
			}
		}
		
		/**
		 * Display Winner
		 */
		private void displayWinner() {
			for(Car car : carList) {
				if(car == winner) {
					StringBuilder winnerText = new StringBuilder()
						.append("And the winner is.... ")
						.append(winner.getName().toUpperCase())
						.append("!!");
					System.out.println(winnerText);
					controlPanel.setWinnerLabel(winnerText.toString());
				} 
			}
		}
	}

	public Car getWinner() {
		return winner;
	}

	public List<Car> getCarList() {
		return carList;
	}
	
	public void setCarList(List<Car> carList) {
		this.carList = carList;
	}
	
	public void setControlPanel(ControlPanel panel) {
		this.controlPanel = panel;
	}
}
