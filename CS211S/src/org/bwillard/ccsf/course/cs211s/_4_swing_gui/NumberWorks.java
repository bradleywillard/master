package org.bwillard.ccsf.course.cs211s.assn4;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("serial")
public class NumberWorks extends JPanel {

	/**
	 * Static data
	 */
	private static final int DEFAULT_HEIGHT = 400;
	private static final int DEFAULT_WIDTH = 350;
	
	/**
	 * Instance data
	 */
	private JButton avgButton, totButton, minButton, maxButton, clearButton;
	private JTextField numInput;
	private JTextArea displayOutput;
	private JTextArea avgOutput, totOutput, minOutput, maxOutput;
	
	private List<Integer> numberList;
	
	
	/**
	 * Constructor
	 */
	public NumberWorks() {
		
		numberList = new ArrayList<Integer>();
		
		addNumInput();
		displayOutput = new JTextArea(10, 7);
		JScrollPane scrollPane = new JScrollPane(displayOutput);
		displayOutput.setEditable(false);
		add(scrollPane);
		
		addAvgButton();
		addTotButton();
		addMinButton();
		addMaxButton();
		
		//Average of all numbers
		avgOutput = new JTextArea(2, 5); 
		avgOutput.setEditable(false);
		add(avgOutput);
		
		//Total of all numbers
		totOutput = new JTextArea(2, 5); 
		totOutput.setEditable(false);
		add(totOutput);
		
		//Minimum value
		minOutput = new JTextArea(2, 5); 
		minOutput.setEditable(false);
		add(minOutput);
		
		//Maximum value
		maxOutput = new JTextArea(2, 5);
		maxOutput.setEditable(false);
		add(maxOutput);
		
		//Clear values from UI
		addClearButton();
	
	}

	
	/**
	 * Add a clear method to clear any or all output/text fields
	 * Uses Lambda
	 */
	private void addClearButton() {
		clearButton = new JButton("Clear");
		clearButton.addActionListener(event -> {
			numberList.clear();
			displayOutput.setText("");
			avgOutput.setText("");
			totOutput.setText("");
			minOutput.setText("");
			maxOutput.setText("");
			});
		add(clearButton);
	}


	/**
	 * Add button to calculate the total for a list of numbers
	 * Uses Lambda
	 */
	private void addTotButton() {
		totButton = new JButton("Total");
		totButton.addActionListener(event -> {
			totOutput.setText("");
			int tot = 0;
			for(Integer number : numberList) {
				tot += number;
			}
			totOutput.append(tot+"\n");
		});
		add(totButton);
	}

	
	/**
	 * Add button to calculate the maximum in list of numbers
	 * Uses Lambda
	 */
	private void addMaxButton() {
		maxButton = new JButton("Maximum");
		maxButton.addActionListener(event -> {
			maxOutput.setText("");
			int max = numberList != null ? numberList.get(0) : 0;//Initialize with the first
			for(Integer number : numberList) {
				if(number > max)
				max = number;
			}
			maxOutput.append(max+"");
		});
		add(maxButton);
	}
	
	
	/**
	 * Add button to calculate the minimum in list of numbers
	 * Uses Lambda
	 */
	private void addMinButton() {
		minButton = new JButton("Minimum");
		minButton.addActionListener(event -> {
			minOutput.setText("");
			int min = numberList != null ? numberList.get(0) : 0;//Initialize with the first 
			for(Integer number : numberList) {
				if(number < min)
				min = number;
			}
			minOutput.append(min+"");
		});
		add(minButton);
	}

	
	/**
	 * Add button to trigger calculation of average in list of numbers
	 * Uses Lambda
	 */
	private void addAvgButton() {
		avgButton = new JButton("Average");
		avgButton.addActionListener(event -> {
			avgOutput.setText("");
			int avg = 0;
			for(Integer number : numberList) {
				avg += number;
			}
			avg /= numberList.size();
			avgOutput.append(avg+"\n");
		});
		add(avgButton);
	}

	
	/**
	 * Add input field for number inputs
	 */
	private void addNumInput() {
		JLabel label = new JLabel("Enter a number:");
		add(label);
		
		numInput = new JTextField(7);
		numInput.addActionListener(new InputListener());
		add(numInput);
	}
	
	/**
	 * InputListener for input fields like numInput
	 */
	public class InputListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			String userInput = numInput.getText();
			numInput.setText("");
			try{
				int userInputInt = Integer.parseInt(userInput);
				numberList.add(userInputInt);
				displayOutput.append(userInput+"\n");
			} catch(NumberFormatException e) {
				System.out.println(e.getStackTrace());
			}
		}
		
	}
	
	/**
	 * Main executor method
	 * @param args
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(	new Runnable() {
			public void run() {
				JFrame frame = new JFrame();
				frame.setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
				frame.setTitle(this.getClass().getSimpleName());
				frame.getContentPane().add(new NumberWorks());
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}});
		}
	}
