package org.bwillard.ccsf.course.cs211s._11_threads;

import java.awt.*;
import java.awt.event.*;
import java.io.File;

import javax.swing.*;

import java.util.*;
import java.util.List;

/**
 * Simple threaded GUI game that cycles through a list of images where the objective 
 * is for the user to 'catch the cat' (click on the button when the cat appears)
 * 
 * @author bradleywillard
 *
 */
public class PictureChooser extends JFrame {

	/**
	 * class vars
	 */
	private static final long serialVersionUID = 1L;
	private static final String YOU_CAUGHT_THE_CAT = "YOU CAUGHT THE CAT!";
	private static final String IMG_PATH = "./src/org/bwillard/ccsf/course/cs211s/_11_threads/images";

	/**
	 * instance data
	 */
	private JLabel pictureLabel, resultLabel;
	private JButton guessButton;
	private JRadioButton slow, med, fast;

	private List<ImageIcon> imageList;
	private int currentImageLocation, catImageLocation;

	private Thread imageChanger;

	private Container contentPane;

	private boolean catCaught;
	private int speed = 1250;

	/**
	 * Constructor
	 */
	public PictureChooser() {
		super("Find the Cat!");
		setSize(400, 400);

		imageList = new ArrayList<>();
		loadImages();
		currentImageLocation = 0;

		contentPane = getContentPane();
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new GridLayout(2, 1));
		contentPane.add(mainPanel);

		JPanel picturePanel = new JPanel();
		pictureLabel = new JLabel(imageList.get(currentImageLocation));
		picturePanel.add(pictureLabel);
		mainPanel.add(pictureLabel);

		JPanel bottomPanel = new JPanel();
		bottomPanel.setLayout(new GridLayout(3, 1));
		mainPanel.add(bottomPanel);

		JPanel guessButtonPanel = new JPanel();
		guessButtonPanel.setBackground(Color.WHITE);
		;
		guessButton = new JButton("That's the cat!");
		// LISTENER FOR THE GUESS BUTTON
		guessButtonPanel.add(guessButton);
		bottomPanel.add(guessButtonPanel);
		guessButton.addActionListener(e -> {
			if (currentImageLocation == catImageLocation) {

				System.out.println(YOU_CAUGHT_THE_CAT);
				resultLabel.setText(YOU_CAUGHT_THE_CAT);
				guessButton.setEnabled(false);
				catCaught = true;

			} else {
				resultLabel.setText("NOPE!");
				// TODO: Fade this label out in a separate thread...
			}

		});

		JPanel resultPanel = new JPanel();
		resultPanel.setBackground(Color.WHITE);
		;
		resultLabel = new JLabel("");
		resultPanel.add(resultLabel);
		bottomPanel.add(resultPanel);

		JPanel speedPanel = new JPanel();
		speedPanel.setBackground(Color.WHITE);
		slow = new JRadioButton("Slow", true);
		med = new JRadioButton("Medium");
		fast = new JRadioButton("Fast");
		// ADD A LISTENER FOR EACH RADIO BUTTON
		slow.addActionListener(e -> {
			speedButtonHelper(1250);
		});
		med.addActionListener(e -> {
			speedButtonHelper(875);
		});
		fast.addActionListener(e -> {
			speedButtonHelper(500);
		});

		speedPanel.add(slow);
		speedPanel.add(med);
		speedPanel.add(fast);
		bottomPanel.add(speedPanel);
		ButtonGroup group = new ButtonGroup();
		group.add(slow);
		group.add(med);
		group.add(fast);

		System.out.println("Thread active count: " + Thread.activeCount());
		imageChanger = new ImageChanger();
		imageChanger.start();

	}

	private void speedButtonHelper(int speed) {
		this.speed = speed;
		resultLabel.setText("");
		catCaught = false;
		guessButton.setEnabled(true);
		System.out.println("\nSTATE of imageChanger: "
				+ imageChanger.getState());
		if (imageChanger == null || !imageChanger.isAlive()) {
			System.out
					.print("Cat must have been caught, so spawning new thread.... ");
			imageChanger = new ImageChanger();
			imageChanger.start();
			System.out.println(imageChanger.getName());
		}
	}

	/**
	 * Threaded helper class to cycle through the images until 
	 * the user has clicked on the 
	 * @author bradleywillard
	 *
	 */
	private class ImageChanger extends Thread {
		public void run() {
			// While the user hasn't clicked 'that's the cat' when the image is
			// the cat, just keep cycling through the images
			while (!catCaught && !imageChanger.isInterrupted()) {
				try {
					System.out.println("run() method - " + getName()
							+ " state is " + getState());
					currentImageLocation = new Random().nextInt(imageList
							.size());
					System.out.println("currentImageLocation: "
							+ currentImageLocation + "sleep speed is " + speed
							+ "ms");
					pictureLabel.setIcon(imageList.get(currentImageLocation));
					sleep(speed);
					// wait(1);
				} catch (InterruptedException e) {
					// e.printStackTrace();
					System.out
							.println(e
									+ " caught in run() method.  Exiting Run method...\n");
				}
			}
			System.out.println("run() method finished..."
					+ imageChanger.getName() + " " + imageChanger.getState());

		}
	}

	/**
	 * loads the images into the program
	 */
	private void loadImages() {
		ImageIcon catIcon = null;
		File folder = new File(IMG_PATH);
		File[] arrayOfFiles = folder.listFiles();
		for (File file : arrayOfFiles) {
			if (file.isFile()) {
				ImageIcon icon = new ImageIcon(IMG_PATH + "/" + file.getName());
				imageList.add(icon);
				if (file.getName().indexOf("cat") >= 0) {
					catIcon = icon;
				}
			}
		}
		catImageLocation = imageList.indexOf(catIcon);
	}

	/**
	 * main method
	 * @param args
	 */
	public static void main(String args[]) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				System.out.println("MAIN Action thread count: "
						+ Thread.activeCount());

				PictureChooser frame = new PictureChooser();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
				frame.setResizable(false);
			}
		});

	}
}