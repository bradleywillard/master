package org.bwillard.ccsf.course.cs211s._5_mvc_swing_gui.guicode2.layout_demo;

//********************************************************************
//  FlowPanel.java       Authors: Lewis/Loftus
//
//  Solution to Programming Project 7.11
//********************************************************************

import java.awt.*;
import javax.swing.*;

public class FlowPanel extends JPanel
{
   //-----------------------------------------------------------------
   //  Sets up this panel with some buttons to show how flow layout
   //  affects their position.
   //-----------------------------------------------------------------
   public FlowPanel()
   {
      setLayout(new FlowLayout());

      setBackground(Color.green);

      JButton b1 = new JButton("BUTTON 1");
      JButton b2 = new JButton("BUTTON 2");
      JButton b3 = new JButton("BUTTON 3");
      JButton b4 = new JButton("BUTTON 4");
      JButton b5 = new JButton("BUTTON 5");

      add(b1);
      add(b2);
      add(b3);
      add(b4);
      add(b5);
   }
}
