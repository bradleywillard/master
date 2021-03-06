package org.bwillard.ccsf.course.cs211s._5_mvc_swing_gui.guicode2.layout_demo;

//********************************************************************
//  IntroPanel.java       Authors: Lewis/Loftus
//
//  Represents the introduction panel for the LayoutDemo program.
//********************************************************************

import java.awt.*;
import javax.swing.*;

public class IntroPanel extends JPanel
{
   //-----------------------------------------------------------------
   //  Sets up this panel with two labels.
   //-----------------------------------------------------------------
   public IntroPanel()
   {
      setBackground(Color.green);

      JLabel l1 = new JLabel("Layout Manager Demonstration");
      JLabel l2 = new JLabel("Choose a tab to see an example of " +
                             "a layout manager.");

      add(l1);
      add(l2);
   }
}
