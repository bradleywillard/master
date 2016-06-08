package org.bwillard.ccsf.course.cs211s._6_serialization.classmates;

// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Car.java

import java.awt.geom.Point2D;
import java.io.Serializable;
import javax.swing.ImageIcon;

public class Car
    implements Serializable
{

    public Car(Point2D location, ImageIcon image, String name)
    {
        speed = 1;
        this.location = location;
        this.image = image;
        this.name = name;
    }

    public ImageIcon getImage()
    {
        return image;
    }

    public void setImage(ImageIcon image)
    {
        this.image = image;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public Point2D getLocation()
    {
        return location;
    }

    public void setLocation(Point2D location)
    {
        this.location = location;
    }

    public int getSpeed()
    {
        return speed;
    }

    public void setSpeed(int speed)
    {
        this.speed = speed;
    }

    public String toString()
    {
        return (new StringBuilder(String.valueOf(name))).append(" has ").append(speed).append(" speed and ").append(location).append(" location.").toString();
    }

    private static final long serialVersionUID = 0L;
    private int speed;
    private Point2D location;
    private ImageIcon image;
    private String name;
    private static final int DEFAULT_SPEED = 1;
}
