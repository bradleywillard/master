package org.bwillard.ccsf.course.cs211s.assn6.classmates;

// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Race.java

import java.awt.Container;
import java.awt.EventQueue;
import javax.swing.JFrame;

public class Race
{

    public Race()
    {
    }

    public static void main(String args[])
    {
        EventQueue.invokeLater(new Runnable() {

            public void run()
            {
                JFrame frame = new JFrame("RaceTrack");
                RacePanel racePanel = new RacePanel();
                ControlPanel controlPanel = new ControlPanel();
                controlPanel.setRacePanel(racePanel);
                frame.getContentPane().add(racePanel, "North");
                frame.getContentPane().add(controlPanel, "South");
                frame.setSize(800, 800);
                frame.setVisible(true);
                frame.setResizable(false);
                frame.setDefaultCloseOperation(3);
            }

        }
);
    }
}
