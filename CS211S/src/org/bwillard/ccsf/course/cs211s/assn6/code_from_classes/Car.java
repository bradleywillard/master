package org.bwillard.ccsf.course.cs211s.assn6.code_from_classes;

import java.util.Random;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;

public class Car implements java.io.Serializable {

	private double speed;
	private Point2D location;
	private ImageIcon image;
	private String name; // use to display the winner
	
	private static final int MAX_SPEED = 0; // ??? play around with different max speeds
	
	public Car(Point2D location, ImageIcon image, String name) {
		Random random = new Random();
		speed = random.nextDouble() * MAX_SPEED + 1;
		
		this.location = location;
		this.image = image;
		this.name = name;
		System.out.println(name + " speed is " + speed);
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

	public String toString() {
		return name + "; Speed: " + speed + " at " + location;
	}
	
}
