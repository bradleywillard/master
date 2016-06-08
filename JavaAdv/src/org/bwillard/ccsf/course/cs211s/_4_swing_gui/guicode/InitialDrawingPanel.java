package org.bwillard.ccsf.course.cs211s._4_swing_gui.guicode;

import java.awt.*;
import java.awt.geom.*;

import javax.swing.*;

public class InitialDrawingPanel extends JPanel {
	
	private int count = 0;
	private static final int DEFAULT_WIDTH = 200;
	private static final int DEFAULT_HEIGHT = 200;
	
	private Image image;

	public InitialDrawingPanel() {
		setBackground(Color.PINK);
		image = new ImageIcon("tessie.jpg").getImage();
	}
	
	@Override
	public void paintComponent(Graphics g) {
		count++;
		System.out.println("count is " + count);
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		
		Rectangle2D rect = new Rectangle2D.Double(30, 40, 70, 10);
		g2.draw(rect);
		Ellipse2D circle = new Ellipse2D.Double(90, 120, 120, 120);
		g2.setColor(Color.BLUE);
		g2.fill(circle);
		
		g2.drawString("Hello GUI World",  0,  15);
		
		g2.drawImage(image, 200, 200, null);
	}
	
}
