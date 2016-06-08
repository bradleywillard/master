package org.bwillard.ccsf.course.cs211s.assn4;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class ShapesTextImage extends JPanel {

	private static final int DEFAULT_WIDTH = 400;
	private static final int DEFAULT_HEIGHT = 400;
	private static final int INITIAL_X = 50;
	private static final int INITIAL_Y = 50;
	
	private static final String LOGO_ACRONYM = "GEP";
	private static final String CAPTION_TEXT = "GOLDEN EYED PUMA";
	private static final String IMAGE_FILE_NAME = "puma_gold_eyes.jpg";
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D)g;
		Image image = new ImageIcon(IMAGE_FILE_NAME).getImage();
		g2d.drawImage(image, 50, 50, null);
		
		//Black rectangle...
		g2d.setColor(Color.BLACK);
		Rectangle2D rect = new Rectangle2D.Double(50, 240, INITIAL_X + 100, INITIAL_Y / 2);
		g2d.draw(rect);
		g2d.setColor(Color.YELLOW);
		g2d.fillRect(51, 241, INITIAL_X + 99, (INITIAL_Y / 2) - 1);
		
		//Text in black rectangle...
		g2d.setColor(Color.BLACK);
		g2d.drawString(CAPTION_TEXT, 60, 257);
		
		//Orange rectangles...
		g2d.setColor(Color.ORANGE);
		Rectangle2D rect2 = new Rectangle2D.Double(210, 240, INITIAL_X + 65, INITIAL_Y);
		g2d.fill(rect2);
		Rectangle2D rect3 = new Rectangle2D.Double(50, 275, INITIAL_X + 225, INITIAL_Y);
		g2d.fill(rect3);
		
		g2d.setColor(Color.BLACK);
		Ellipse2D circle = new Ellipse2D.Double(240, 255, INITIAL_X, INITIAL_Y);
		g2d.fill(circle);
		g2d.setColor(Color.WHITE);
		g2d.drawString(LOGO_ACRONYM, 253, 285);
		
	}
	
	public static void main(String[] args) {
		ShapesTextImage panel = new ShapesTextImage();
		panel.setBackground(Color.WHITE);
		JFrame frame = new JFrame(panel.getClass().getSimpleName());
		frame.getContentPane().add(panel);
		frame.setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
