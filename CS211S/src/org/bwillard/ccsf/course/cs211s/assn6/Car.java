package org.bwillard.ccsf.course.cs211s.assn6;

import javax.swing.*;
import java.awt.geom.*;

public class Car implements java.io.Serializable {
	private static final long serialVersionUID = 7064780108335965068L;
	
	private Point2D location;
	private ImageIcon image;
	private String name;
	private double speed;
	private int movingDistance;
	private boolean finished;

	private static final int DEFAULT_SPEED = 5;
	private static final int DEFAULT_INCREMENT = 10;
	
	private Car(CarBuilder cb) {
		this.location = cb.location;
		this.image = cb.image;
		this.name = cb.name;
		this.speed = cb.speed;
		this.movingDistance = cb.movingDistance;
		System.out.println(toString());
	}
	
	public ImageIcon getImage() {
		return image;
	}
	public void setImage(ImageIcon image) {
		this.image = image;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Point2D getLocation() {
		return location;
	}
	public void setLocation(Point2D location) {
		this.location = location;
	}
	public double getSpeed() {
		return speed;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}

	public int getMovingDistance() {
		return movingDistance;
	}

	public void setMovingDistance(int movingDistance) {
		this.movingDistance = movingDistance;
	}

	public boolean isFinished() {
		return finished;
	}

	public void setFinished(boolean finished) {
		this.finished = finished;
	}
	
	public String toString() {
		return name + "; Speed: " + speed + " at " + location;
	}
	
	/**
	 * Builder inner class
	 *
	 */
	public static class CarBuilder {
		private Point2D location;
		private ImageIcon image;
		private String name;
		private int speed;
		private int movingDistance;
		
		public CarBuilder(Point2D location, ImageIcon image, String name) {
			this.location = location;
			this.image = image;
			this.name = name;
			this.speed = DEFAULT_SPEED;
			this.movingDistance = DEFAULT_INCREMENT;
		}
		
		public Car build() {
			if(location == null || image == null || name == null)
				throw new IllegalStateException();
			return new Car(this);
		}
		
		public CarBuilder location(Point2D location) {
			this.location = location;
			return this;
		}
		
		public CarBuilder image(ImageIcon image) {
			this.image = image;
			return this;
		}
		
		public CarBuilder name(String name) {
			this.name = name;
			return this;
		}
		
		public CarBuilder speed(int speed) {
			this.speed = speed;
			return this;
		}
		
		public CarBuilder movingDistance(int movingDistance) {
			this.movingDistance = movingDistance;
			return this;
		}
	}
}
